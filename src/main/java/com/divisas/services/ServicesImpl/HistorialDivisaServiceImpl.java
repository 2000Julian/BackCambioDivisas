package com.divisas.services.ServicesImpl;

import com.divisas.entities.Cliente;
import com.divisas.entities.HistorialDivisa;
import com.divisas.repositories.HistorialDivisaRepository;
import com.divisas.services.BaseService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HistorialDivisaServiceImpl implements BaseService<HistorialDivisa> {


    private HistorialDivisaRepository historialDivisaRepository;

    public HistorialDivisaServiceImpl( HistorialDivisaRepository historialDivisaRepository){

        this.historialDivisaRepository = historialDivisaRepository;
    }


    @Override
    @Transactional
    public List<HistorialDivisa> findAll() throws  Exception{
        try{
            List<HistorialDivisa> entities = historialDivisaRepository.findAll();
            return entities;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public HistorialDivisa findById(Long id) throws Exception{
        try{
            Optional<HistorialDivisa> entityOptional = historialDivisaRepository.findById(id);
            return entityOptional.get();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public HistorialDivisa save(HistorialDivisa entity) throws Exception {
        try{
            entity = historialDivisaRepository.save(entity);
            return entity;
        }catch( Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public HistorialDivisa update(Long id, HistorialDivisa entity) throws Exception{
        try{
            Optional<HistorialDivisa> entityOptional = historialDivisaRepository.findById(id);
            HistorialDivisa historialDivisa = entityOptional.get();
            historialDivisa = historialDivisaRepository.save(historialDivisa);
            return historialDivisa;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws  Exception {
        try{
            if(historialDivisaRepository.existsById(id)){
                historialDivisaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
