/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.entity.Articulos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.entity.Articulos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.entity.Marcas;
import com.entity.UnidadesDeMedida;
import com.entity.OrdenesDeCompra;
import com.entity.SolicitudesDeArticulos;
import java.util.Collection;

/**
 *
 * @author manuelito
 */
@Stateless
public class ArticulosFacade extends AbstractFacade<Articulos> {

    @PersistenceContext(unitName = "WebApplication3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticulosFacade() {
        super(Articulos.class);
    }

    public boolean isMarcaIdEmpty(Articulos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Articulos> articulos = cq.from(Articulos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(articulos, entity), cb.isNotNull(articulos.get(Articulos_.marcaId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Marcas findMarcaId(Articulos entity) {
        return this.getMergedEntity(entity).getMarcaId();
    }

    public boolean isUnidadDeMedidaIdEmpty(Articulos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Articulos> articulos = cq.from(Articulos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(articulos, entity), cb.isNotNull(articulos.get(Articulos_.unidadDeMedidaId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UnidadesDeMedida findUnidadDeMedidaId(Articulos entity) {
        return this.getMergedEntity(entity).getUnidadDeMedidaId();
    }

    public boolean isOrdenesDeCompraCollectionEmpty(Articulos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Articulos> articulos = cq.from(Articulos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(articulos, entity), cb.isNotEmpty(articulos.get(Articulos_.ordenesDeCompraCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<OrdenesDeCompra> findOrdenesDeCompraCollection(Articulos entity) {
        return this.getMergedEntity(entity).getOrdenesDeCompraCollection();
    }

    public boolean isSolicitudesDeArticulosCollectionEmpty(Articulos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Articulos> articulos = cq.from(Articulos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(articulos, entity), cb.isNotEmpty(articulos.get(Articulos_.solicitudesDeArticulosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<SolicitudesDeArticulos> findSolicitudesDeArticulosCollection(Articulos entity) {
        return this.getMergedEntity(entity).getSolicitudesDeArticulosCollection();
    }
    
}
