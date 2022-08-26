package com.bisa.evaluacion.evaluacion.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaccion")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_transaccion;

    @Column(name = "id_cuenta")
    private Integer idcuenta;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "moneda")
    private String moneda;

    @Basic(optional = false)
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    @Transient
    private String mensaje;





    public Integer getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(Integer id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public Integer getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
}
