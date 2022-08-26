package com.bisa.evaluacion.evaluacion.model;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;

//    @Column(name = "nombres", nullable = false, length = 70)
    @Column(name = "nombre")
    private String nombre;

//    @Column(name = "apellidos", nullable = false, length = 150)
    @Column(name = "apellido")
    private String apellido;

////    @Column(name = "direccion", nullable = true, length = 150)
//    @Column(name = "direccion")
//    private String direccion;
////
////    @Column(name = "telefono", nullable = true, length = 9)
//    @Column(name = "telefono")
//    private String telefono;
//
////    @Column(name = "email", nullable = true, length = 55)
//    @Column(name = "email")
//    private String email;

//    @Column(name = "nrodocumento", nullable = true, length = 10)
    @Column(name = "nro_documento")
    private String nrodocumento;

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    //    public Integer getIdCliente() {
//        return IdCliente;
//    }
//
//    public void setIdCliente(Integer idCliente) {
//        IdCliente = idCliente;
//    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
//
//    public String getDireccion() {
//        return direccion;
//    }
//
//    public void setDireccion(String direccion) {
//        this.direccion = direccion;
//    }
//
//    public String getTelefono() {
//        return telefono;
//    }
//
//    public void setTelefono(String telefono) {
//        this.telefono = telefono;
//    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getNrodocumento() {
        return nrodocumento;
    }

    public void setNrodocumento(String nrodocumento) {
        this.nrodocumento = nrodocumento;
    }

}
