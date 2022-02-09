
package com.divisas.services.ServicesImpl;
import com.divisas.entities.Cuenta;
import com.divisas.repositories.CuentaRepository;
import com.divisas.services.BaseService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImpl implements BaseService<Cuenta> {

    private CuentaRepository cuentaRepository;

    public CuentaServiceImpl( CuentaRepository cuentaRepository){
        this.cuentaRepository = cuentaRepository;
    }


    @Override
    @Transactional
    public List<Cuenta> findAll() throws  Exception{
        try{
            List<Cuenta> entities = cuentaRepository.findAll();
            return entities;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cuenta findById(Long id) throws Exception{
        try{
            Optional<Cuenta> entityOptional = cuentaRepository.findById(id);
            return entityOptional.get();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cuenta save(Cuenta entity) throws Exception {
        try{
            entity = cuentaRepository.save(entity);
            return entity;
        }catch( Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cuenta update(Long id, Cuenta entity) throws Exception{
        try{
            Optional<Cuenta> entityOptional = cuentaRepository.findById(id);
            Cuenta cuenta = entityOptional.get();
            cuenta = cuentaRepository.save(cuenta);
            return cuenta;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws  Exception {
        try{
            if(cuentaRepository.existsById(id)){
                cuentaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
