package com.bisa.evaluacion.evaluacion.controller;

import com.bisa.evaluacion.evaluacion.exception.ModelNotFoundException;
//import com.bisa.evaluacion.evaluacion.model.Cuenta;
import com.bisa.evaluacion.evaluacion.model.Transaccion;
import com.bisa.evaluacion.evaluacion.service.CuentaService;
import com.bisa.evaluacion.evaluacion.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import com.bisa.evaluacion.evaluacion.model.Cliente;
//import com.bisa.evaluacion.evaluacion.service.ClienteService;
//import com.bisa.evaluacion.evaluacion.model.Cliente;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/balance")
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;

    @GetMapping
    public ResponseEntity<List<Transaccion>> findAll(){
        return new ResponseEntity<>(transaccionService.findAll(), HttpStatus.OK) ;
    }

    @PostMapping
    public  ResponseEntity<Transaccion> create( @RequestBody Transaccion transaccion){
        return  new ResponseEntity<>(transaccionService.crear(transaccion), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update( @RequestBody Transaccion transaccion){



        transaccionService.update(transaccion);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaccion>  findById(@PathVariable("id") Integer idTransaccion) {
        Transaccion transaccion = transaccionService.findById(idTransaccion);
        if(transaccion == null){
            throw new ModelNotFoundException("Cliente No encontrado");
        }
        return new ResponseEntity<>(transaccion, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")  Integer idTransaccion) {

        Transaccion transaccion = transaccionService.findById(idTransaccion);
        if(transaccion == null){
            throw new ModelNotFoundException("El cliente que desea eliminar NO existe");
        }

        transaccionService.delete(idTransaccion);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
//@GetMapping("/users/")
    @PostMapping("/retiro")
    public  ResponseEntity<Transaccion> retiro( @RequestBody Transaccion transaccion){
        return  new ResponseEntity<>(transaccionService.retiro(transaccion), HttpStatus.CREATED);
    }

    @PostMapping("/deposito")
    public  ResponseEntity<Transaccion> deposito( @RequestBody Transaccion transaccion){
        return  new ResponseEntity<>(transaccionService.deposito(transaccion), HttpStatus.CREATED);
    }

    @GetMapping("/historico/{nrocuenta}")
    public ResponseEntity<List<Transaccion>> gethistorico(@PathVariable("nrocuenta") Integer nrocuenta){
        return new ResponseEntity<>(transaccionService.getHistorico(nrocuenta), HttpStatus.OK) ;
    }

    @GetMapping("/saldo/{nrocuenta}")
    public  ResponseEntity<Double>  getSaldo(@PathVariable("nrocuenta") Integer nrocuenta){
        return new ResponseEntity<>(transaccionService.getSaldo(nrocuenta), HttpStatus.OK) ;
    }


}
