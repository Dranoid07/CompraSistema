package com.controller;

import com.controller.util.MobilePageController;
import com.entity.SolicitudesDeArticulos;
import com.facade.SolicitudesDeArticulosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "solicitudesDeArticulosController")
@ViewScoped
public class SolicitudesDeArticulosController extends AbstractController<SolicitudesDeArticulos> {

    @Inject
    private ArticulosController articuloIdController;
    @Inject
    private EmpleadosController empleadoSolicitanteController;
    @Inject
    private UnidadesDeMedidaController unidadDeMedidaIdController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isOrdenesDeCompraCollectionEmpty;

    public SolicitudesDeArticulosController() {
        // Inform the Abstract parent controller of the concrete SolicitudesDeArticulos Entity
        super(SolicitudesDeArticulos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        articuloIdController.setSelected(null);
        empleadoSolicitanteController.setSelected(null);
        unidadDeMedidaIdController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsOrdenesDeCompraCollectionEmpty();
    }

    public boolean getIsOrdenesDeCompraCollectionEmpty() {
        return this.isOrdenesDeCompraCollectionEmpty;
    }

    private void setIsOrdenesDeCompraCollectionEmpty() {
        SolicitudesDeArticulos selected = this.getSelected();
        if (selected != null) {
            SolicitudesDeArticulosFacade ejbFacade = (SolicitudesDeArticulosFacade) this.getFacade();
            this.isOrdenesDeCompraCollectionEmpty = ejbFacade.isOrdenesDeCompraCollectionEmpty(selected);
        } else {
            this.isOrdenesDeCompraCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of OrdenesDeCompra entities
     * that are retrieved from SolicitudesDeArticulos?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for OrdenesDeCompra page
     */
    public String navigateOrdenesDeCompraCollection() {
        SolicitudesDeArticulos selected = this.getSelected();
        if (selected != null) {
            SolicitudesDeArticulosFacade ejbFacade = (SolicitudesDeArticulosFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("OrdenesDeCompra_items", ejbFacade.findOrdenesDeCompraCollection(selected));
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/ordenesDeCompra/index";
    }

    /**
     * Sets the "selected" attribute of the Articulos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareArticuloId(ActionEvent event) {
        SolicitudesDeArticulos selected = this.getSelected();
        if (selected != null && articuloIdController.getSelected() == null) {
            articuloIdController.setSelected(selected.getArticuloId());
        }
    }

    /**
     * Sets the "selected" attribute of the Empleados controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareEmpleadoSolicitante(ActionEvent event) {
        SolicitudesDeArticulos selected = this.getSelected();
        if (selected != null && empleadoSolicitanteController.getSelected() == null) {
            empleadoSolicitanteController.setSelected(selected.getEmpleadoSolicitante());
        }
    }

    /**
     * Sets the "selected" attribute of the UnidadesDeMedida controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUnidadDeMedidaId(ActionEvent event) {
        SolicitudesDeArticulos selected = this.getSelected();
        if (selected != null && unidadDeMedidaIdController.getSelected() == null) {
            unidadDeMedidaIdController.setSelected(selected.getUnidadDeMedidaId());
        }
    }

}
