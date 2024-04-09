/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.entity.Empleados;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.entity.Empleados_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.entity.Departamentos;
import com.entity.SolicitudesDeArticulos;
import java.util.Collection;

/**
 *
 * @author manuelito
 */
@Stateless
public class EmpleadosFacade extends AbstractFacade<Empleados> {

    @PersistenceContext(unitName = "WebApplication3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadosFacade() {
        super(Empleados.class);
    }

    public boolean isDepartamentoIdEmpty(Empleados entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Empleados> empleados = cq.from(Empleados.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(empleados, entity), cb.isNotNull(empleados.get(Empleados_.departamentoId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Departamentos findDepartamentoId(Empleados entity) {
        return this.getMergedEntity(entity).getDepartamentoId();
    }

    public boolean isSolicitudesDeArticulosCollectionEmpty(Empleados entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Empleados> empleados = cq.from(Empleados.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(empleados, entity), cb.isNotEmpty(empleados.get(Empleados_.solicitudesDeArticulosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<SolicitudesDeArticulos> findSolicitudesDeArticulosCollection(Empleados entity) {
        return this.getMergedEntity(entity).getSolicitudesDeArticulosCollection();
    }
    
}
