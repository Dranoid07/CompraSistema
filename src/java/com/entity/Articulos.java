/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manuelito
 */
@Entity
@Table(name = "articulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulos.findAll", query = "SELECT a FROM Articulos a")
    , @NamedQuery(name = "Articulos.findById", query = "SELECT a FROM Articulos a WHERE a.id = :id")
    , @NamedQuery(name = "Articulos.findByDescripcion", query = "SELECT a FROM Articulos a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Articulos.findByExistencia", query = "SELECT a FROM Articulos a WHERE a.existencia = :existencia")
    , @NamedQuery(name = "Articulos.findByEstado", query = "SELECT a FROM Articulos a WHERE a.estado = :estado")})
public class Articulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "existencia")
    private Integer existencia;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "marca_id", referencedColumnName = "id")
    @ManyToOne
    private Marcas marcaId;
    @JoinColumn(name = "unidad_de_medida_id", referencedColumnName = "id")
    @ManyToOne
    private UnidadesDeMedida unidadDeMedidaId;
    @OneToMany(mappedBy = "articuloId")
    private Collection<OrdenesDeCompra> ordenesDeCompraCollection;
    @OneToMany(mappedBy = "articuloId")
    private Collection<SolicitudesDeArticulos> solicitudesDeArticulosCollection;

    public Articulos() {
    }

    public Articulos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Marcas getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Marcas marcaId) {
        this.marcaId = marcaId;
    }

    public UnidadesDeMedida getUnidadDeMedidaId() {
        return unidadDeMedidaId;
    }

    public void setUnidadDeMedidaId(UnidadesDeMedida unidadDeMedidaId) {
        this.unidadDeMedidaId = unidadDeMedidaId;
    }

    @XmlTransient
    public Collection<OrdenesDeCompra> getOrdenesDeCompraCollection() {
        return ordenesDeCompraCollection;
    }

    public void setOrdenesDeCompraCollection(Collection<OrdenesDeCompra> ordenesDeCompraCollection) {
        this.ordenesDeCompraCollection = ordenesDeCompraCollection;
    }

    @XmlTransient
    public Collection<SolicitudesDeArticulos> getSolicitudesDeArticulosCollection() {
        return solicitudesDeArticulosCollection;
    }

    public void setSolicitudesDeArticulosCollection(Collection<SolicitudesDeArticulos> solicitudesDeArticulosCollection) {
        this.solicitudesDeArticulosCollection = solicitudesDeArticulosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulos)) {
            return false;
        }
        Articulos other = (Articulos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Articulos[ id=" + id + " ]";
    }
    
}
