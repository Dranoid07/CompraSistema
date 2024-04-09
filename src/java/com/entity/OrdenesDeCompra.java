/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manuelito
 */
@Entity
@Table(name = "ordenes_de_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesDeCompra.findAll", query = "SELECT o FROM OrdenesDeCompra o")
    , @NamedQuery(name = "OrdenesDeCompra.findByNumeroOrden", query = "SELECT o FROM OrdenesDeCompra o WHERE o.numeroOrden = :numeroOrden")
    , @NamedQuery(name = "OrdenesDeCompra.findByFechaOrden", query = "SELECT o FROM OrdenesDeCompra o WHERE o.fechaOrden = :fechaOrden")
    , @NamedQuery(name = "OrdenesDeCompra.findByEstado", query = "SELECT o FROM OrdenesDeCompra o WHERE o.estado = :estado")
    , @NamedQuery(name = "OrdenesDeCompra.findByCantidad", query = "SELECT o FROM OrdenesDeCompra o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "OrdenesDeCompra.findByCostoUnitario", query = "SELECT o FROM OrdenesDeCompra o WHERE o.costoUnitario = :costoUnitario")})
public class OrdenesDeCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero_orden")
    private Integer numeroOrden;
    @Column(name = "fecha_orden")
    @Temporal(TemporalType.DATE)
    private Date fechaOrden;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_unitario")
    private BigDecimal costoUnitario;
    @JoinColumn(name = "articulo_id", referencedColumnName = "id")
    @ManyToOne
    private Articulos articuloId;
    @JoinColumn(name = "marca_id", referencedColumnName = "id")
    @ManyToOne
    private Marcas marcaId;
    @JoinColumn(name = "solicitud_id", referencedColumnName = "id")
    @ManyToOne
    private SolicitudesDeArticulos solicitudId;
    @JoinColumn(name = "unidad_de_medida_id", referencedColumnName = "id")
    @ManyToOne
    private UnidadesDeMedida unidadDeMedidaId;

    public OrdenesDeCompra() {
    }

    public OrdenesDeCompra(Integer numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public Integer getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(Integer numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(BigDecimal costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public Articulos getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(Articulos articuloId) {
        this.articuloId = articuloId;
    }

    public Marcas getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Marcas marcaId) {
        this.marcaId = marcaId;
    }

    public SolicitudesDeArticulos getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(SolicitudesDeArticulos solicitudId) {
        this.solicitudId = solicitudId;
    }

    public UnidadesDeMedida getUnidadDeMedidaId() {
        return unidadDeMedidaId;
    }

    public void setUnidadDeMedidaId(UnidadesDeMedida unidadDeMedidaId) {
        this.unidadDeMedidaId = unidadDeMedidaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroOrden != null ? numeroOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesDeCompra)) {
            return false;
        }
        OrdenesDeCompra other = (OrdenesDeCompra) object;
        if ((this.numeroOrden == null && other.numeroOrden != null) || (this.numeroOrden != null && !this.numeroOrden.equals(other.numeroOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.OrdenesDeCompra[ numeroOrden=" + numeroOrden + " ]";
    }
    
}
