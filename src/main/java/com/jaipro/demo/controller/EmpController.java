package com.jaipro.demo.controller;

import com.jaipro.demo.entities.Empleado;
import com.jaipro.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpController {
    @Autowired
    EmpService empService;

    @PostMapping("/empleado")
    public ResponseEntity<?> save(@RequestBody Empleado entity){

        try{
            empService.save(entity);
            return new ResponseEntity<>("Empleado agregado", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/empleados")
    public ResponseEntity<List<Empleado>> findAll(){
        try {
            List<Empleado> empleados = empService.findByAll();
            return new ResponseEntity<>(empleados, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findId(@PathVariable Integer id){
        try{
            Empleado empleado = empService.findById(id);
            if (empleado == null){
                return new ResponseEntity<>("Empleado no encontrado", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Empleado entity){
        try {
            Empleado empleado = empService.update(id, entity);
            if (empleado == null){
                return new ResponseEntity<>("Empleado no encontrado" , HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Empleado actualizado", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try{
            Empleado empleado = empService.findById(id);
            if (empleado == null){
                return new ResponseEntity<>("Empleado no encontrado" , HttpStatus.NOT_FOUND);
            }
            empService.delete(id);

            return new ResponseEntity<>("Empleado eliminado", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Empleado no encontrado",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
