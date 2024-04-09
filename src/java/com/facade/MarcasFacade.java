/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.entity.Marcas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.entity.Marcas_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.entity.Articulos;
import com.entity.OrdenesDeCompra;
import java.util.Collection;

/**
 *
 * @author manuelito
 */
@Stateless
public class MarcasFacade extends AbstractFacade<Marcas> {

    @PersistenceContext(unitName = "WebApplication3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarcasFacade() {
        super(Marcas.class);
    }

    public boolean isArticulosCollectionEmpty(Marcas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Marcas> marcas = cq.from(Marcas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(marcas, entity), cb.isNotEmpty(marcas.get(Marcas_.articulosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Articulos> findArticulosCollection(Marcas entity) {
        return this.getMergedEntity(entity).getArticulosCollection();
    }

    public boolean isOrdenesDeCompraCollectionEmpty(Marcas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Marcas> marcas = cq.from(Marcas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(marcas, entity), cb.isNotEmpty(marcas.get(Marcas_.ordenesDeCompraCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<OrdenesDeCompra> findOrdenesDeCompraCollection(Marcas entity) {
        return this.getMergedEntity(entity).getOrdenesDeCompraCollection();
    }
    
}
