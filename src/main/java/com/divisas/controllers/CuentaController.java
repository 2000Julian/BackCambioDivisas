package com.divisas.controllers;

import com.divisas.entities.Cuenta;
import com.divisas.services.ServicesImpl.CuentaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping( value = "api/divisa/cuenta", produces = MediaType.APPLICATION_JSON_VALUE)
public class CuentaController {

    private CuentaServiceImpl cuentaServiceImpl;

    public CuentaController(CuentaServiceImpl cuentaServiceImpl){
        this.cuentaServiceImpl = cuentaServiceImpl;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(cuentaServiceImpl.findAll());
        }catch( Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try{
            Cuenta cuenta = cuentaServiceImpl.findById( id );
            return new ResponseEntity<>(cuenta, HttpStatus.OK);
        }catch( Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }


    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Cuenta entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cuentaServiceImpl.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Cuenta entity)  {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(cuentaServiceImpl.update(id, entity));
        }catch( Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete( @PathVariable  Long id ){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(cuentaServiceImpl.delete(id));
        }catch( Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

}
