/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.reto.Model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Cristhian Desposorio
 */
@Data
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	/*para autoincrementable en mysql*/
    @Column(name="id_cliente")
    Integer id_cliente;
    
    
    @Column(name="nombre")
    @NotEmpty()
    String nombre;
    
    @Column(name="apellido")
    @NotEmpty()
    String apellido;
    
    @Column(name="edad")
    @NotEmpty()
    Integer edad;
    
    @Column(name="fecha_nacimiento")
    @NotEmpty()
    LocalDate fecha_nacimiento;
    
}
