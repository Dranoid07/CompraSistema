package com.controller;

import com.controller.util.MobilePageController;
import com.entity.OrdenesDeCompra;
import com.facade.OrdenesDeCompraFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ordenesDeCompraController")
@ViewScoped
public class OrdenesDeCompraController extends AbstractController<OrdenesDeCompra> {

    @Inject
    private ArticulosController articuloIdController;
    @Inject
    private MarcasController marcaIdController;
    @Inject
    private SolicitudesDeArticulosController solicitudIdController;
    @Inject
    private UnidadesDeMedidaController unidadDeMedidaIdController;
    @Inject
    private MobilePageController mobilePageController;

    public OrdenesDeCompraController() {
        // Inform the Abstract parent controller of the concrete OrdenesDeCompra Entity
        super(OrdenesDeCompra.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        articuloIdController.setSelected(null);
        marcaIdController.setSelected(null);
        solicitudIdController.setSelected(null);
        unidadDeMedidaIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Articulos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareArticuloId(ActionEvent event) {
        OrdenesDeCompra selected = this.getSelected();
        if (selected != null && articuloIdController.getSelected() == null) {
            articuloIdController.setSelected(selected.getArticuloId());
        }
    }

    /**
     * Sets the "selected" attribute of the Marcas controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMarcaId(ActionEvent event) {
        OrdenesDeCompra selected = this.getSelected();
        if (selected != null && marcaIdController.getSelected() == null) {
            marcaIdController.setSelected(selected.getMarcaId());
        }
    }

    /**
     * Sets the "selected" attribute of the SolicitudesDeArticulos controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSolicitudId(ActionEvent event) {
        OrdenesDeCompra selected = this.getSelected();
        if (selected != null && solicitudIdController.getSelected() == null) {
            solicitudIdController.setSelected(selected.getSolicitudId());
        }
    }

    /**
     * Sets the "selected" attribute of the UnidadesDeMedida controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUnidadDeMedidaId(ActionEvent event) {
        OrdenesDeCompra selected = this.getSelected();
        if (selected != null && unidadDeMedidaIdController.getSelected() == null) {
            unidadDeMedidaIdController.setSelected(selected.getUnidadDeMedidaId());
        }
    }

}
