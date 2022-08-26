package com.bisa.evaluacion.evaluacion.repository;


import com.bisa.evaluacion.evaluacion.model.Cuenta;
import com.bisa.evaluacion.evaluacion.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICuentaRepository extends JpaRepository<Cuenta, Integer> {
    @Query(value="select * from cuenta where nro_cuenta = :nrocuenta" , nativeQuery=true)
    Cuenta getSaldo(Integer nrocuenta);


}
