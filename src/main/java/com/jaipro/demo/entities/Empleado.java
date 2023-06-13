package com.jaipro.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
@Table(name = "empleado")
public class Empleado implements Serializable {
    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    @Column(name = "nombre")
    String nombre;

    @Column(name = "apellido")
    String apellido;

    @Column(name= "direccion")
    String direccion;

    @Column(name= "telefono")
    String telefono;

    @Column(name= "estado")
    Boolean estado;

    @Column(name= "sueldo")
    Double sueldo;

    @Column(name = "tipo_empleado")
    String tipoEmpleado;

}
