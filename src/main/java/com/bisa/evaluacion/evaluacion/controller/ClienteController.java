package com.bisa.evaluacion.evaluacion.controller;

import com.bisa.evaluacion.evaluacion.exception.ModelNotFoundException;
import com.bisa.evaluacion.evaluacion.model.Cliente;
import com.bisa.evaluacion.evaluacion.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK) ;
    }

    @PostMapping
    public  ResponseEntity<Cliente> create( @RequestBody Cliente cliente){
        return  new ResponseEntity<>(clienteService.crear(cliente), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update( @RequestBody Cliente cliente){
        clienteService.update(cliente);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente>  findById(@PathVariable("id") Integer idCliente) {
        Cliente cliente = clienteService.findById(idCliente);
        if(cliente == null){
            throw new ModelNotFoundException("Cliente No encontrado");
        }
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")  Integer idCliente) {

        Cliente cliente = clienteService.findById(idCliente);
        if(cliente == null){
            throw new ModelNotFoundException("El cliente que desea eliminar NO existe");
        }

        clienteService.delete(idCliente);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}
