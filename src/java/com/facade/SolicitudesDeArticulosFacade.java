/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.entity.SolicitudesDeArticulos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.entity.SolicitudesDeArticulos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.entity.OrdenesDeCompra;
import com.entity.Articulos;
import com.entity.Empleados;
import com.entity.UnidadesDeMedida;
import java.util.Collection;

/**
 *
 * @author manuelito
 */
@Stateless
public class SolicitudesDeArticulosFacade extends AbstractFacade<SolicitudesDeArticulos> {

    @PersistenceContext(unitName = "WebApplication3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudesDeArticulosFacade() {
        super(SolicitudesDeArticulos.class);
    }

    public boolean isOrdenesDeCompraCollectionEmpty(SolicitudesDeArticulos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolicitudesDeArticulos> solicitudesDeArticulos = cq.from(SolicitudesDeArticulos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solicitudesDeArticulos, entity), cb.isNotEmpty(solicitudesDeArticulos.get(SolicitudesDeArticulos_.ordenesDeCompraCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<OrdenesDeCompra> findOrdenesDeCompraCollection(SolicitudesDeArticulos entity) {
        return this.getMergedEntity(entity).getOrdenesDeCompraCollection();
    }

    public boolean isArticuloIdEmpty(SolicitudesDeArticulos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolicitudesDeArticulos> solicitudesDeArticulos = cq.from(SolicitudesDeArticulos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solicitudesDeArticulos, entity), cb.isNotNull(solicitudesDeArticulos.get(SolicitudesDeArticulos_.articuloId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Articulos findArticuloId(SolicitudesDeArticulos entity) {
        return this.getMergedEntity(entity).getArticuloId();
    }

    public boolean isEmpleadoSolicitanteEmpty(SolicitudesDeArticulos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolicitudesDeArticulos> solicitudesDeArticulos = cq.from(SolicitudesDeArticulos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solicitudesDeArticulos, entity), cb.isNotNull(solicitudesDeArticulos.get(SolicitudesDeArticulos_.empleadoSolicitante)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Empleados findEmpleadoSolicitante(SolicitudesDeArticulos entity) {
        return this.getMergedEntity(entity).getEmpleadoSolicitante();
    }

    public boolean isUnidadDeMedidaIdEmpty(SolicitudesDeArticulos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolicitudesDeArticulos> solicitudesDeArticulos = cq.from(SolicitudesDeArticulos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solicitudesDeArticulos, entity), cb.isNotNull(solicitudesDeArticulos.get(SolicitudesDeArticulos_.unidadDeMedidaId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UnidadesDeMedida findUnidadDeMedidaId(SolicitudesDeArticulos entity) {
        return this.getMergedEntity(entity).getUnidadDeMedidaId();
    }
    
}
