package com.bisa.evaluacion.evaluacion.controller;

import com.bisa.evaluacion.evaluacion.exception.ModelNotFoundException;
//import com.bisa.evaluacion.evaluacion.model.Cliente;
//import com.bisa.evaluacion.evaluacion.service.ClienteService;
//import com.bisa.evaluacion.evaluacion.model.Cliente;
import com.bisa.evaluacion.evaluacion.model.Cuenta;
import com.bisa.evaluacion.evaluacion.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public ResponseEntity<List<Cuenta>> findAll(){
        return new ResponseEntity<>(cuentaService.findAll(), HttpStatus.OK) ;
    }

    @PostMapping
    public  ResponseEntity<Cuenta> create( @RequestBody Cuenta cuenta){
        return  new ResponseEntity<>(cuentaService.crear(cuenta), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update( @RequestBody Cuenta cuenta){
        cuentaService.update(cuenta);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta>  findById(@PathVariable("id") Integer idCliente) {
        Cuenta cliente = cuentaService.findById(idCliente);
        if(cliente == null){
            throw new ModelNotFoundException("Cliente No encontrado");
        }
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")  Integer idCliente) {

        Cuenta cliente = cuentaService.findById(idCliente);
        if(cliente == null){
            throw new ModelNotFoundException("El cliente que desea eliminar NO existe");
        }
        cuentaService.delete(idCliente);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}
