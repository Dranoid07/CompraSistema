package com.controller;

import com.controller.util.MobilePageController;
import com.entity.Empleados;
import com.facade.EmpleadosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "empleadosController")
@ViewScoped
public class EmpleadosController extends AbstractController<Empleados> {

    @Inject
    private DepartamentosController departamentoIdController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isSolicitudesDeArticulosCollectionEmpty;

    public EmpleadosController() {
        // Inform the Abstract parent controller of the concrete Empleados Entity
        super(Empleados.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        departamentoIdController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsSolicitudesDeArticulosCollectionEmpty();
    }

    /**
     * Sets the "selected" attribute of the Departamentos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDepartamentoId(ActionEvent event) {
        Empleados selected = this.getSelected();
        if (selected != null && departamentoIdController.getSelected() == null) {
            departamentoIdController.setSelected(selected.getDepartamentoId());
        }
    }

    public boolean getIsSolicitudesDeArticulosCollectionEmpty() {
        return this.isSolicitudesDeArticulosCollectionEmpty;
    }

    private void setIsSolicitudesDeArticulosCollectionEmpty() {
        Empleados selected = this.getSelected();
        if (selected != null) {
            EmpleadosFacade ejbFacade = (EmpleadosFacade) this.getFacade();
            this.isSolicitudesDeArticulosCollectionEmpty = ejbFacade.isSolicitudesDeArticulosCollectionEmpty(selected);
        } else {
            this.isSolicitudesDeArticulosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of SolicitudesDeArticulos
     * entities that are retrieved from Empleados?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for SolicitudesDeArticulos page
     */
    public String navigateSolicitudesDeArticulosCollection() {
        Empleados selected = this.getSelected();
        if (selected != null) {
            EmpleadosFacade ejbFacade = (EmpleadosFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SolicitudesDeArticulos_items", ejbFacade.findSolicitudesDeArticulosCollection(selected));
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/solicitudesDeArticulos/index";
    }

}
