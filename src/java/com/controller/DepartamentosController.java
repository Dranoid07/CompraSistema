package com.controller;

import com.controller.util.MobilePageController;
import com.entity.Departamentos;
import com.facade.DepartamentosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "departamentosController")
@ViewScoped
public class DepartamentosController extends AbstractController<Departamentos> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isEmpleadosCollectionEmpty;

    public DepartamentosController() {
        // Inform the Abstract parent controller of the concrete Departamentos Entity
        super(Departamentos.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsEmpleadosCollectionEmpty();
    }

    public boolean getIsEmpleadosCollectionEmpty() {
        return this.isEmpleadosCollectionEmpty;
    }

    private void setIsEmpleadosCollectionEmpty() {
        Departamentos selected = this.getSelected();
        if (selected != null) {
            DepartamentosFacade ejbFacade = (DepartamentosFacade) this.getFacade();
            this.isEmpleadosCollectionEmpty = ejbFacade.isEmpleadosCollectionEmpty(selected);
        } else {
            this.isEmpleadosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Empleados entities that
     * are retrieved from Departamentos?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Empleados page
     */
    public String navigateEmpleadosCollection() {
        Departamentos selected = this.getSelected();
        if (selected != null) {
            DepartamentosFacade ejbFacade = (DepartamentosFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Empleados_items", ejbFacade.findEmpleadosCollection(selected));
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/empleados/index";
    }

}
