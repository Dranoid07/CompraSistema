package com.controller;

import com.controller.util.MobilePageController;
import com.entity.UnidadesDeMedida;
import com.facade.UnidadesDeMedidaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "unidadesDeMedidaController")
@ViewScoped
public class UnidadesDeMedidaController extends AbstractController<UnidadesDeMedida> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isArticulosCollectionEmpty;
    private boolean isOrdenesDeCompraCollectionEmpty;
    private boolean isSolicitudesDeArticulosCollectionEmpty;

    public UnidadesDeMedidaController() {
        // Inform the Abstract parent controller of the concrete UnidadesDeMedida Entity
        super(UnidadesDeMedida.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsArticulosCollectionEmpty();
        this.setIsOrdenesDeCompraCollectionEmpty();
        this.setIsSolicitudesDeArticulosCollectionEmpty();
    }

    public boolean getIsArticulosCollectionEmpty() {
        return this.isArticulosCollectionEmpty;
    }

    private void setIsArticulosCollectionEmpty() {
        UnidadesDeMedida selected = this.getSelected();
        if (selected != null) {
            UnidadesDeMedidaFacade ejbFacade = (UnidadesDeMedidaFacade) this.getFacade();
            this.isArticulosCollectionEmpty = ejbFacade.isArticulosCollectionEmpty(selected);
        } else {
            this.isArticulosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Articulos entities that
     * are retrieved from UnidadesDeMedida?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Articulos page
     */
    public String navigateArticulosCollection() {
        UnidadesDeMedida selected = this.getSelected();
        if (selected != null) {
            UnidadesDeMedidaFacade ejbFacade = (UnidadesDeMedidaFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Articulos_items", ejbFacade.findArticulosCollection(selected));
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/articulos/index";
    }

    public boolean getIsOrdenesDeCompraCollectionEmpty() {
        return this.isOrdenesDeCompraCollectionEmpty;
    }

    private void setIsOrdenesDeCompraCollectionEmpty() {
        UnidadesDeMedida selected = this.getSelected();
        if (selected != null) {
            UnidadesDeMedidaFacade ejbFacade = (UnidadesDeMedidaFacade) this.getFacade();
            this.isOrdenesDeCompraCollectionEmpty = ejbFacade.isOrdenesDeCompraCollectionEmpty(selected);
        } else {
            this.isOrdenesDeCompraCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of OrdenesDeCompra entities
     * that are retrieved from UnidadesDeMedida?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for OrdenesDeCompra page
     */
    public String navigateOrdenesDeCompraCollection() {
        UnidadesDeMedida selected = this.getSelected();
        if (selected != null) {
            UnidadesDeMedidaFacade ejbFacade = (UnidadesDeMedidaFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("OrdenesDeCompra_items", ejbFacade.findOrdenesDeCompraCollection(selected));
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/ordenesDeCompra/index";
    }

    public boolean getIsSolicitudesDeArticulosCollectionEmpty() {
        return this.isSolicitudesDeArticulosCollectionEmpty;
    }

    private void setIsSolicitudesDeArticulosCollectionEmpty() {
        UnidadesDeMedida selected = this.getSelected();
        if (selected != null) {
            UnidadesDeMedidaFacade ejbFacade = (UnidadesDeMedidaFacade) this.getFacade();
            this.isSolicitudesDeArticulosCollectionEmpty = ejbFacade.isSolicitudesDeArticulosCollectionEmpty(selected);
        } else {
            this.isSolicitudesDeArticulosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of SolicitudesDeArticulos
     * entities that are retrieved from UnidadesDeMedida?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for SolicitudesDeArticulos page
     */
    public String navigateSolicitudesDeArticulosCollection() {
        UnidadesDeMedida selected = this.getSelected();
        if (selected != null) {
            UnidadesDeMedidaFacade ejbFacade = (UnidadesDeMedidaFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SolicitudesDeArticulos_items", ejbFacade.findSolicitudesDeArticulosCollection(selected));
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/solicitudesDeArticulos/index";
    }

}
