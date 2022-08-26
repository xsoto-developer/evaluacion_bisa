
package com.bisa.evaluacion.evaluacion.service;

//import com.bisa.evaluacion.evaluacion.model.Cliente;
import com.bisa.evaluacion.evaluacion.model.Cuenta;
import com.bisa.evaluacion.evaluacion.model.Transaccion;
import com.bisa.evaluacion.evaluacion.repository.IClienteRepository;
import com.bisa.evaluacion.evaluacion.repository.ICuentaRepository;
import com.bisa.evaluacion.evaluacion.repository.ITransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaService implements ICuentaService{

    @Autowired
    private ICuentaRepository cuentaRepo;


    @Autowired
    private ITransaccionRepository transaccionRepo;

    @Override
    public Cuenta crear(Cuenta cuenta) {
        String nroCta = new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime());
        cuenta.setNrocuenta(Integer.parseInt(nroCta));
        cuenta = cuentaRepo.save(cuenta);
        Transaccion transaccion = new Transaccion();
        transaccion.setIdcuenta(cuenta.getIdCuenta());
        transaccion.setMonto(cuenta.getSaldo());
        transaccion.setTipo("H");
        transaccion.setMoneda("BOB");
        transaccion.setFechaHora(new Date());
        transaccion.setMensaje("Transaccion realizada con exito");
        transaccion = transaccionRepo.save(transaccion);
        cuenta.setTransaccion(transaccion);
        return cuenta;
    }

    @Override
    public Cuenta update(Cuenta cuenta) {
        return cuentaRepo.save(cuenta);
    }

    @Override
    public Cuenta findById(Integer id) {
         Optional<Cuenta> cuentaOptional = cuentaRepo.findById(id);
         return cuentaOptional.orElse(null);
    }

    @Override
    public List<Cuenta> findAll() {
        return cuentaRepo.findAll();
    }

    @Override
    public void delete(Integer id) {
        cuentaRepo.deleteById(id);
    }
}
