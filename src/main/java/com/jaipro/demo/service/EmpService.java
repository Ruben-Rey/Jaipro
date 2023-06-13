package com.jaipro.demo.service;

import com.jaipro.demo.entities.Empleado;
import com.jaipro.demo.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService implements GenericDAO<Empleado> {

    @Autowired
    EmpRepository empRepository;

    @Override
    public List<Empleado> findByAll() throws Exception {
        try{
            return empRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Empleado findById(Integer id) throws Exception {

        try{
            Optional<Empleado> entityOptional = empRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Empleado save(Empleado empleado) throws Exception{
        try{
            return empRepository.save(empleado);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Empleado update(Integer id, Empleado entity) throws Exception {

        try{
            Optional<Empleado> entityOptional = empRepository.findById(id);
            Empleado empleado = entityOptional.get();
            empleado.setNombre(entity.getNombre());
            empleado.setApellido(entity.getApellido());
            empleado.setDireccion(entity.getDireccion());
            empleado.setTelefono(entity.getTelefono());
            empleado.setEstado(entity.getEstado());
            empleado.setSueldo(entity.getSueldo());

            empleado = empRepository.save(empleado);

            return empleado;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void delete(Integer id) throws Exception {

        try{
            if(empRepository.existsById(id)){
                empRepository.deleteById(id);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
