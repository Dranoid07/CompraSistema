/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.entity.UnidadesDeMedida;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.entity.UnidadesDeMedida_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.entity.Articulos;
import com.entity.OrdenesDeCompra;
import com.entity.SolicitudesDeArticulos;
import java.util.Collection;

/**
 *
 * @author manuelito
 */
@Stateless
public class UnidadesDeMedidaFacade extends AbstractFacade<UnidadesDeMedida> {

    @PersistenceContext(unitName = "WebApplication3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadesDeMedidaFacade() {
        super(UnidadesDeMedida.class);
    }

    public boolean isArticulosCollectionEmpty(UnidadesDeMedida entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UnidadesDeMedida> unidadesDeMedida = cq.from(UnidadesDeMedida.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(unidadesDeMedida, entity), cb.isNotEmpty(unidadesDeMedida.get(UnidadesDeMedida_.articulosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Articulos> findArticulosCollection(UnidadesDeMedida entity) {
        return this.getMergedEntity(entity).getArticulosCollection();
    }

    public boolean isOrdenesDeCompraCollectionEmpty(UnidadesDeMedida entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UnidadesDeMedida> unidadesDeMedida = cq.from(UnidadesDeMedida.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(unidadesDeMedida, entity), cb.isNotEmpty(unidadesDeMedida.get(UnidadesDeMedida_.ordenesDeCompraCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<OrdenesDeCompra> findOrdenesDeCompraCollection(UnidadesDeMedida entity) {
        return this.getMergedEntity(entity).getOrdenesDeCompraCollection();
    }

    public boolean isSolicitudesDeArticulosCollectionEmpty(UnidadesDeMedida entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UnidadesDeMedida> unidadesDeMedida = cq.from(UnidadesDeMedida.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(unidadesDeMedida, entity), cb.isNotEmpty(unidadesDeMedida.get(UnidadesDeMedida_.solicitudesDeArticulosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<SolicitudesDeArticulos> findSolicitudesDeArticulosCollection(UnidadesDeMedida entity) {
        return this.getMergedEntity(entity).getSolicitudesDeArticulosCollection();
    }
    
}
