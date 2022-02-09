package com.divisas.controllers;
import com.divisas.entities.Moneda;
import com.divisas.services.ServicesImpl.MonedaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping( value = "api/divisa/moneda", produces = MediaType.APPLICATION_JSON_VALUE)
public class MonedaController {

    private MonedaServiceImpl monedaServiceImpl;

    public MonedaController(MonedaServiceImpl monedaServiceImpl){
        this.monedaServiceImpl = monedaServiceImpl;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(monedaServiceImpl.findAll());
        }catch( Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try{
            Moneda moneda = monedaServiceImpl.findById( id );
            return new ResponseEntity<>(moneda, HttpStatus.OK);
        }catch( Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }


    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Moneda entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(monedaServiceImpl.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Moneda entity)  {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(monedaServiceImpl.update(id, entity));
        }catch( Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete( @PathVariable  Long id ){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(monedaServiceImpl.delete(id));
        }catch( Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }
}
