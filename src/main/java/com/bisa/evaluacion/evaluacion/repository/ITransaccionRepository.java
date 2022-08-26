package com.bisa.evaluacion.evaluacion.repository;


//import com.bisa.evaluacion.evaluacion.model.Cuenta;
import com.bisa.evaluacion.evaluacion.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITransaccionRepository extends JpaRepository<Transaccion, Integer> {
    @Query(value="select * from transaccion t where t.tipo= :tipo and t.id_cuenta= :idcuenta" , nativeQuery=true)
    List<Transaccion> getByTipo(String tipo, Integer idcuenta);

    @Query(value="select t.* from public.transaccion t inner join cuenta c on t.id_cuenta = c.id_cuenta where c.nro_cuenta = :nrocuenta" , nativeQuery=true)
    List<Transaccion> getHistorico(Integer nrocuenta);

}
