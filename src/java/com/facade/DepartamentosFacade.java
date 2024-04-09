/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.entity.Departamentos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.entity.Departamentos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.entity.Empleados;
import java.util.Collection;

/**
 *
 * @author manuelito
 */
@Stateless
public class DepartamentosFacade extends AbstractFacade<Departamentos> {

    @PersistenceContext(unitName = "WebApplication3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentosFacade() {
        super(Departamentos.class);
    }

    public boolean isEmpleadosCollectionEmpty(Departamentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Departamentos> departamentos = cq.from(Departamentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(departamentos, entity), cb.isNotEmpty(departamentos.get(Departamentos_.empleadosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Empleados> findEmpleadosCollection(Departamentos entity) {
        return this.getMergedEntity(entity).getEmpleadosCollection();
    }
    
}
