/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.m5b.proyectousuarios.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 *
 * @author HP
 */

@Data
@Entity

public class Persona {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int id_persona;

    
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre_per")
    private String nombre_per;
    
    @NotBlank(message = "El apellido no puede estar en blanco")
    @Column(name = "apellido_per")
    private String apellido_per;

    @Email(message = "Debe ingresar una dirección de correo válida")
    @Column(name = "correo_per")
    private String correo_per;
    
    
  
   
    @Column(name = "cedula")
    private int cedula;
    
     @NotBlank(message = "La direccion no puede estar en blanco")
    @Column(name = "direccion")
    private String direccion;
     
     
     
      
      
      @NotBlank(message = "El celular no puede estar en blanco")
    @Column(name = "celular_per")
    private String celular_per;
      
      
     
      
   
      
      
      
    @JsonIgnore
    @OneToMany(mappedBy="persona")
    private List<Usuario> listaUsuarios;
    
    
    
    
    
    
}
