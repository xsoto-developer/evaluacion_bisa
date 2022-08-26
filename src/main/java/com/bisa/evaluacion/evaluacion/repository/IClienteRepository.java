package com.bisa.evaluacion.evaluacion.repository;

import com.bisa.evaluacion.evaluacion.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {



}
