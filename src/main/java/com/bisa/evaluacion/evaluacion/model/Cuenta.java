package com.bisa.evaluacion.evaluacion.model;

import javax.persistence.*;

@Entity
@Table(name = "cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdCuenta;

    @Column(name = "nro_cuenta")
    private Integer nrocuenta;

    @Column(name = "id_cliente")
    private Integer idcliente;

    @Column(name = "saldo")
    private Double saldo;
////
    @Column(name = "moneda")
    private String moneda;

    @Column(name = "estado")
    private String estado;

    @Transient
    private Transaccion transaccion;


    public Integer getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        IdCuenta = idCuenta;
    }

    public Integer getNrocuenta() {
        return nrocuenta;
    }

    public void setNrocuenta(Integer nrocuenta) {
        this.nrocuenta = nrocuenta;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }
}
