package com.jaipro.demo.repository;


import com.jaipro.demo.entities.Empleado;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmpRepository extends JpaRepository<Empleado, Integer>{
}
