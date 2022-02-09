package com.divisas.controllers;

import com.divisas.entities.Cliente;
import com.divisas.services.ServicesImpl.ClienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping( value = "api/divisa/cliente", produces = MediaType.APPLICATION_JSON_VALUE)

public class ClienteController {

    private ClienteServiceImpl clienteServiceImpl;

    public ClienteController(ClienteServiceImpl clienteServiceImpl){
        this.clienteServiceImpl = clienteServiceImpl;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(clienteServiceImpl.findAll());
        }catch( Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try{
            Cliente cliente = clienteServiceImpl.findById( id );
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }catch( Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }


    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Cliente entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clienteServiceImpl.save(entity));
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Cliente entity)  {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(clienteServiceImpl.update(id, entity));
        }catch( Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete( @PathVariable  Long id ){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(clienteServiceImpl.delete(id));
        }catch( Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }
}
