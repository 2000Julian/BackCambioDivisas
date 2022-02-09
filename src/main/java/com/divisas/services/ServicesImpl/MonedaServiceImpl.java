package com.divisas.services.ServicesImpl;
import com.divisas.entities.Moneda;
import com.divisas.repositories.MonedaRepository;
import com.divisas.services.BaseService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MonedaServiceImpl implements BaseService<Moneda> {

    private MonedaRepository monedaRepository;

    public MonedaServiceImpl( MonedaRepository monedaRepository){
        this.monedaRepository = monedaRepository;
    }


    @Override
    @Transactional
    public List<Moneda> findAll() throws  Exception{
        try{
            List<Moneda> entities = monedaRepository.findAll();
            return entities;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Moneda findById(Long id) throws Exception{
        try{
            Optional<Moneda> entityOptional = monedaRepository.findById(id);
            return entityOptional.get();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Moneda save(Moneda entity) throws Exception {
        try{
            entity = monedaRepository.save(entity);
            return entity;
        }catch( Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Moneda update(Long id, Moneda entity) throws Exception{
        try{
            Optional<Moneda> entityOptional = monedaRepository.findById(id);
            Moneda moneda = entityOptional.get();
            moneda = monedaRepository.save(moneda);
            return moneda;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws  Exception {
        try{
            if(monedaRepository.existsById(id)){
                monedaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
