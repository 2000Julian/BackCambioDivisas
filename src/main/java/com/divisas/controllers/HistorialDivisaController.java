package com.divisas.controllers;
import com.divisas.entities.HistorialDivisa;
import com.divisas.services.ServicesImpl.HistorialDivisaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping( value = "api/divisa/historial", produces = MediaType.APPLICATION_JSON_VALUE)

public class HistorialDivisaController {

    private HistorialDivisaServiceImpl historialDivisaServiceImpl;

    public HistorialDivisaController(HistorialDivisaServiceImpl historialDivisaServiceImpl){
        this.historialDivisaServiceImpl = historialDivisaServiceImpl;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(historialDivisaServiceImpl.findAll());
        }catch( Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try{
            HistorialDivisa historialDivisa = historialDivisaServiceImpl.findById( id );
            return new ResponseEntity<>(historialDivisa, HttpStatus.OK);
        }catch( Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }


    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody HistorialDivisa entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(historialDivisaServiceImpl.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody HistorialDivisa entity)  {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(historialDivisaServiceImpl.update(id, entity));
        }catch( Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete( @PathVariable  Long id ){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(historialDivisaServiceImpl.delete(id));
        }catch( Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }
}
