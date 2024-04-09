/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.entity.OrdenesDeCompra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.entity.OrdenesDeCompra_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.entity.Articulos;
import com.entity.Marcas;
import com.entity.SolicitudesDeArticulos;
import com.entity.UnidadesDeMedida;

/**
 *
 * @author manuelito
 */
@Stateless
public class OrdenesDeCompraFacade extends AbstractFacade<OrdenesDeCompra> {

    @PersistenceContext(unitName = "WebApplication3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenesDeCompraFacade() {
        super(OrdenesDeCompra.class);
    }

    public boolean isArticuloIdEmpty(OrdenesDeCompra entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenesDeCompra> ordenesDeCompra = cq.from(OrdenesDeCompra.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenesDeCompra, entity), cb.isNotNull(ordenesDeCompra.get(OrdenesDeCompra_.articuloId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Articulos findArticuloId(OrdenesDeCompra entity) {
        return this.getMergedEntity(entity).getArticuloId();
    }

    public boolean isMarcaIdEmpty(OrdenesDeCompra entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenesDeCompra> ordenesDeCompra = cq.from(OrdenesDeCompra.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenesDeCompra, entity), cb.isNotNull(ordenesDeCompra.get(OrdenesDeCompra_.marcaId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Marcas findMarcaId(OrdenesDeCompra entity) {
        return this.getMergedEntity(entity).getMarcaId();
    }

    public boolean isSolicitudIdEmpty(OrdenesDeCompra entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenesDeCompra> ordenesDeCompra = cq.from(OrdenesDeCompra.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenesDeCompra, entity), cb.isNotNull(ordenesDeCompra.get(OrdenesDeCompra_.solicitudId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public SolicitudesDeArticulos findSolicitudId(OrdenesDeCompra entity) {
        return this.getMergedEntity(entity).getSolicitudId();
    }

    public boolean isUnidadDeMedidaIdEmpty(OrdenesDeCompra entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenesDeCompra> ordenesDeCompra = cq.from(OrdenesDeCompra.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenesDeCompra, entity), cb.isNotNull(ordenesDeCompra.get(OrdenesDeCompra_.unidadDeMedidaId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UnidadesDeMedida findUnidadDeMedidaId(OrdenesDeCompra entity) {
        return this.getMergedEntity(entity).getUnidadDeMedidaId();
    }
    
}
