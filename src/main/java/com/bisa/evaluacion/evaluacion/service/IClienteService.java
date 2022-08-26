
package com.bisa.evaluacion.evaluacion.service;

import com.bisa.evaluacion.evaluacion.model.Cliente;

import java.util.List;

public interface IClienteService {

    Cliente crear(Cliente cliente);

    Cliente update(Cliente cliente);

    Cliente findById( Integer id);

    List<Cliente> findAll();

    void delete( Integer id);

}
