package com.controller;

import com.controller.util.MobilePageController;
import com.entity.Articulos;
import com.facade.ArticulosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "articulosController")
@ViewScoped
public class ArticulosController extends AbstractController<Articulos> {

    @Inject
    private MarcasController marcaIdController;
    @Inject
    private UnidadesDeMedidaController unidadDeMedidaIdController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isOrdenesDeCompraCollectionEmpty;
    private boolean isSolicitudesDeArticulosCollectionEmpty;

    public ArticulosController() {
        // Inform the Abstract parent controller of the concrete Articulos Entity
        super(Articulos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        marcaIdController.setSelected(null);
        unidadDeMedidaIdController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsOrdenesDeCompraCollectionEmpty();
        this.setIsSolicitudesDeArticulosCollectionEmpty();
    }

    /**
     * Sets the "selected" attribute of the Marcas controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMarcaId(ActionEvent event) {
        Articulos selected = this.getSelected();
        if (selected != null && marcaIdController.getSelected() == null) {
            marcaIdController.setSelected(selected.getMarcaId());
        }
    }

    /**
     * Sets the "selected" attribute of the UnidadesDeMedida controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUnidadDeMedidaId(ActionEvent event) {
        Articulos selected = this.getSelected();
        if (selected != null && unidadDeMedidaIdController.getSelected() == null) {
            unidadDeMedidaIdController.setSelected(selected.getUnidadDeMedidaId());
        }
    }

    public boolean getIsOrdenesDeCompraCollectionEmpty() {
        return this.isOrdenesDeCompraCollectionEmpty;
    }

    private void setIsOrdenesDeCompraCollectionEmpty() {
        Articulos selected = this.getSelected();
        if (selected != null) {
            ArticulosFacade ejbFacade = (ArticulosFacade) this.getFacade();
            this.isOrdenesDeCompraCollectionEmpty = ejbFacade.isOrdenesDeCompraCollectionEmpty(selected);
        } else {
            this.isOrdenesDeCompraCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of OrdenesDeCompra entities
     * that are retrieved from Articulos?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for OrdenesDeCompra page
     */
    public String navigateOrdenesDeCompraCollection() {
        Articulos selected = this.getSelected();
        if (selected != null) {
            ArticulosFacade ejbFacade = (ArticulosFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("OrdenesDeCompra_items", ejbFacade.findOrdenesDeCompraCollection(selected));
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/ordenesDeCompra/index";
    }

    public boolean getIsSolicitudesDeArticulosCollectionEmpty() {
        return this.isSolicitudesDeArticulosCollectionEmpty;
    }

    private void setIsSolicitudesDeArticulosCollectionEmpty() {
        Articulos selected = this.getSelected();
        if (selected != null) {
            ArticulosFacade ejbFacade = (ArticulosFacade) this.getFacade();
            this.isSolicitudesDeArticulosCollectionEmpty = ejbFacade.isSolicitudesDeArticulosCollectionEmpty(selected);
        } else {
            this.isSolicitudesDeArticulosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of SolicitudesDeArticulos
     * entities that are retrieved from Articulos?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for SolicitudesDeArticulos page
     */
    public String navigateSolicitudesDeArticulosCollection() {
        Articulos selected = this.getSelected();
        if (selected != null) {
            ArticulosFacade ejbFacade = (ArticulosFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SolicitudesDeArticulos_items", ejbFacade.findSolicitudesDeArticulosCollection(selected));
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/solicitudesDeArticulos/index";
    }

}
