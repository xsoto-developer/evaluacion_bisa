
package com.bisa.evaluacion.evaluacion.service;

//import com.bisa.evaluacion.evaluacion.model.Cliente;

import com.bisa.evaluacion.evaluacion.model.Cuenta;

import java.util.List;

public interface ICuentaService {

    Cuenta crear(Cuenta cliente);

    Cuenta update(Cuenta cliente);

    Cuenta findById( Integer id);

    List<Cuenta> findAll();

    void delete( Integer id);

}
