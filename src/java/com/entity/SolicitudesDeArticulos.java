/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manuelito
 */
@Entity
@Table(name = "solicitudes_de_articulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudesDeArticulos.findAll", query = "SELECT s FROM SolicitudesDeArticulos s")
    , @NamedQuery(name = "SolicitudesDeArticulos.findById", query = "SELECT s FROM SolicitudesDeArticulos s WHERE s.id = :id")
    , @NamedQuery(name = "SolicitudesDeArticulos.findByFechaSolicitud", query = "SELECT s FROM SolicitudesDeArticulos s WHERE s.fechaSolicitud = :fechaSolicitud")
    , @NamedQuery(name = "SolicitudesDeArticulos.findByCantidad", query = "SELECT s FROM SolicitudesDeArticulos s WHERE s.cantidad = :cantidad")
    , @NamedQuery(name = "SolicitudesDeArticulos.findByEstado", query = "SELECT s FROM SolicitudesDeArticulos s WHERE s.estado = :estado")})
public class SolicitudesDeArticulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "solicitudId")
    private Collection<OrdenesDeCompra> ordenesDeCompraCollection;
    @JoinColumn(name = "articulo_id", referencedColumnName = "id")
    @ManyToOne
    private Articulos articuloId;
    @JoinColumn(name = "empleado_solicitante", referencedColumnName = "id")
    @ManyToOne
    private Empleados empleadoSolicitante;
    @JoinColumn(name = "unidad_de_medida_id", referencedColumnName = "id")
    @ManyToOne
    private UnidadesDeMedida unidadDeMedidaId;

    public SolicitudesDeArticulos() {
    }

    public SolicitudesDeArticulos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<OrdenesDeCompra> getOrdenesDeCompraCollection() {
        return ordenesDeCompraCollection;
    }

    public void setOrdenesDeCompraCollection(Collection<OrdenesDeCompra> ordenesDeCompraCollection) {
        this.ordenesDeCompraCollection = ordenesDeCompraCollection;
    }

    public Articulos getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(Articulos articuloId) {
        this.articuloId = articuloId;
    }

    public Empleados getEmpleadoSolicitante() {
        return empleadoSolicitante;
    }

    public void setEmpleadoSolicitante(Empleados empleadoSolicitante) {
        this.empleadoSolicitante = empleadoSolicitante;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudesDeArticulos)) {
            return false;
        }
        SolicitudesDeArticulos other = (SolicitudesDeArticulos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.SolicitudesDeArticulos[ id=" + id + " ]";
    }
    
}
