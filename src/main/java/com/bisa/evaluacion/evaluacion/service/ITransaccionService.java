
package com.bisa.evaluacion.evaluacion.service;

//import com.bisa.evaluacion.evaluacion.model.Cliente;

//import com.bisa.evaluacion.evaluacion.model.Cuenta;

import com.bisa.evaluacion.evaluacion.model.Transaccion;

import java.util.List;

public interface ITransaccionService {

    Transaccion crear(Transaccion cliente);

    Transaccion update(Transaccion cliente);

    Transaccion findById( Integer id);

    List<Transaccion> findAll();

    void delete( Integer id);

    Double saldo(Integer idCuenta);

    Transaccion deposito(Transaccion transaccion);

    Transaccion retiro(Transaccion transaccion);

    List<Transaccion> getHistorico(Integer nroCuenta);

    Double getSaldo(Integer nroCuenta);
}
