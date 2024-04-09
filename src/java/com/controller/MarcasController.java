package com.controller;

import com.controller.util.MobilePageController;
import com.entity.Marcas;
import com.facade.MarcasFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "marcasController")
@ViewScoped
public class MarcasController extends AbstractController<Marcas> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isArticulosCollectionEmpty;
    private boolean isOrdenesDeCompraCollectionEmpty;

    public MarcasController() {
        // Inform the Abstract parent controller of the concrete Marcas Entity
        super(Marcas.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsArticulosCollectionEmpty();
        this.setIsOrdenesDeCompraCollectionEmpty();
    }

    public boolean getIsArticulosCollectionEmpty() {
        return this.isArticulosCollectionEmpty;
    }

    private void setIsArticulosCollectionEmpty() {
        Marcas selected = this.getSelected();
        if (selected != null) {
            MarcasFacade ejbFacade = (MarcasFacade) this.getFacade();
            this.isArticulosCollectionEmpty = ejbFacade.isArticulosCollectionEmpty(selected);
        } else {
            this.isArticulosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Articulos entities that
     * are retrieved from Marcas?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Articulos page
     */
    public String navigateArticulosCollection() {
        Marcas selected = this.getSelected();
        if (selected != null) {
            MarcasFacade ejbFacade = (MarcasFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Articulos_items", ejbFacade.findArticulosCollection(selected));
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/articulos/index";
    }

    public boolean getIsOrdenesDeCompraCollectionEmpty() {
        return this.isOrdenesDeCompraCollectionEmpty;
    }

    private void setIsOrdenesDeCompraCollectionEmpty() {
        Marcas selected = this.getSelected();
        if (selected != null) {
            MarcasFacade ejbFacade = (MarcasFacade) this.getFacade();
            this.isOrdenesDeCompraCollectionEmpty = ejbFacade.isOrdenesDeCompraCollectionEmpty(selected);
        } else {
            this.isOrdenesDeCompraCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of OrdenesDeCompra entities
     * that are retrieved from Marcas?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for OrdenesDeCompra page
     */
    public String navigateOrdenesDeCompraCollection() {
        Marcas selected = this.getSelected();
        if (selected != null) {
            MarcasFacade ejbFacade = (MarcasFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("OrdenesDeCompra_items", ejbFacade.findOrdenesDeCompraCollection(selected));
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/ordenesDeCompra/index";
    }

}
