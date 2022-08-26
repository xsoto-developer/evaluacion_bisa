
package com.bisa.evaluacion.evaluacion.service;

//import com.bisa.evaluacion.evaluacion.model.Cliente;
//import com.bisa.evaluacion.evaluacion.model.Cuenta;
import com.bisa.evaluacion.evaluacion.model.Cuenta;
import com.bisa.evaluacion.evaluacion.model.Transaccion;
import com.bisa.evaluacion.evaluacion.repository.ICuentaRepository;
import com.bisa.evaluacion.evaluacion.repository.ITransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransaccionService implements ITransaccionService{

    @Autowired
    private ITransaccionRepository transaccionRepo;
    @Autowired
    private ICuentaRepository cuentaRepo;

    @Override
    public Transaccion crear(Transaccion transaccion) {

//        Double saldo = saldo(transaccion.getIdcuenta());
//        if (saldo>0){
//            transaccionRepo.save(transaccion);
//        }else{
//            Cuenta cuenta = cuentaRepo.getReferenceById(transaccion.getIdcuenta());
//            if(cuenta.getEstado().equals("ACTIVE")){
//
//            }
//
//        }

      return transaccionRepo.save(transaccion);
    }

    @Override
    public Transaccion update(Transaccion cuenta) {
        return transaccionRepo.save(cuenta);
    }

    @Override
    public Transaccion findById(Integer id) {
         Optional<Transaccion> cuentaOptional = transaccionRepo.findById(id);
         return cuentaOptional.orElse(null);
    }

    @Override
    public List<Transaccion> findAll() {
        return transaccionRepo.findAll();
    }

    @Override
    public void delete(Integer id) {
        transaccionRepo.deleteById(id);
    }

    @Override
    public Double saldo(Integer idCuenta) {

        Double totalHaber = 0.0;
        Double totalDebe = 0.0;
        Double saldo = 0.0;
        List<Transaccion> lstHaber = transaccionRepo.getByTipo("H", idCuenta);
        for (Transaccion transaccion: lstHaber) {
            totalHaber = totalHaber + transaccion.getMonto();
        }
        List<Transaccion> lstDebe = transaccionRepo.getByTipo("D", idCuenta);
        for (Transaccion transaccion: lstDebe) {
            totalDebe = totalDebe + transaccion.getMonto();
        }
        saldo = totalHaber - totalDebe;
        return saldo;
    }

    @Override
    public Double getSaldo(Integer nroCuenta) {
        Double totalHaber = 0.0;
        Double totalDebe = 0.0;
        Double saldo = 0.0;
        Cuenta cuenta = cuentaRepo.getSaldo( nroCuenta);
        List<Transaccion> lstHaber = transaccionRepo.getByTipo("D", cuenta.getIdCuenta());
        for (Transaccion transaccion: lstHaber) {
            totalHaber = totalHaber + transaccion.getMonto();
        }
        List<Transaccion> lstDebe = transaccionRepo.getByTipo("D", cuenta.getIdCuenta());
        for (Transaccion transaccion: lstDebe) {
            totalDebe = totalDebe + transaccion.getMonto();
        }
        saldo = totalHaber - totalDebe;
        return saldo;
    }

    @Override
    public Transaccion deposito(Transaccion transaccion) {
        transaccion.setTipo("H");
        transaccion.setFechaHora(new Date());
        String msgResultado = "Operacion Satisfactoria";
        Transaccion resultado = new Transaccion();
        Cuenta cuenta = cuentaRepo.getReferenceById(transaccion.getIdcuenta());
//        cuenta = cuentaRepo.getById(transaccion.getIdcuenta());
        if (transaccion.getMoneda().equals(cuenta.getMoneda())){
            Double saldo = saldo(transaccion.getIdcuenta());
            saldo = saldo + transaccion.getMonto();
            if (saldo >= 0){
                if(cuenta.getEstado().equals("HOLD")){
                    resultado = transaccionRepo.save(transaccion);
                    cuenta.setEstado("ACTIVE");
                    cuentaRepo.save(cuenta);
                    msgResultado = msgResultado + " Monto del depósito es mayor o igual al saldo negativo,";
                    resultado.setMensaje(msgResultado);
                }else{
                    resultado = transaccionRepo.save(transaccion);
                    resultado.setMensaje(msgResultado);
                }
            }else{
                resultado = transaccionRepo.save(transaccion);
                msgResultado = msgResultado + " La cuenta se mantiene en estado HOLD y solo se reduce el saldo negativo";
                resultado.setMensaje(msgResultado);
            }
        }else {
            msgResultado = "Solo se debe hacer retiro en la misma moneda de la cuenta.";
            resultado.setMensaje(msgResultado);
        }
        return resultado;
    }

    @Override
    public Transaccion retiro(Transaccion transaccion) {
        transaccion.setTipo("D");
        transaccion.setFechaHora(new Date());
        String msgResultado = "Operacion Satisfactoria";
        Transaccion resultado = new Transaccion();

        Cuenta cuenta = cuentaRepo.getReferenceById(transaccion.getIdcuenta());
        if (transaccion.getMoneda().equals(cuenta.getMoneda())){

            Double saldo = saldo(transaccion.getIdcuenta());
            saldo = saldo - transaccion.getMonto();
            if (saldo<0){
                if(cuenta.getEstado().equals("ACTIVE")){
                    resultado = transaccionRepo.save(transaccion);
                    cuenta.setEstado("HOLD");
                    cuentaRepo.save(cuenta);
                    msgResultado = msgResultado + " Monto superior a saldo por única vez,";
                    resultado.setMensaje(msgResultado);
                }else{
                    msgResultado = "No se puede realizar retiros de cuentas en estado HOLD";
                    resultado.setMensaje(msgResultado);
                }
            }else{
                resultado = transaccionRepo.save(transaccion);
                resultado.setMensaje(msgResultado);
            }
        }else {
            msgResultado = "Solo se debe hacer retiro en la misma moneda de la cuenta.";
            resultado.setMensaje(msgResultado);
        }
        return resultado;
    }

    @Override
    public List<Transaccion>  getHistorico(Integer nroCuenta) {
        List<Transaccion> lstHistorico = transaccionRepo.getHistorico(nroCuenta);
        return lstHistorico;
    }
}
