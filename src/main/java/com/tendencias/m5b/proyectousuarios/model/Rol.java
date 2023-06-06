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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;

/**
 *
 * @author HP
 */

@Data
@Entity

public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_rol")
    private int id_rol;
    
    @Size(min = 5, max = 50, message = "El nombre del rol debe tener entre 5 y 50 caracteres")
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre_rol")
    private String nombre_rol;
    
     @NotBlank(message = "La descripcion no puede estar en blanco")
    @Column(name = "descripcion_rol")
    private String descripcion_rol;
    
      @NotBlank(message = "Elestado no puede estar en blanco")
    @Column(name = "estado_rol")
    private String estado_rol;
    
    @JsonIgnore
    @OneToMany(mappedBy="rol")
    private List<Usuario> listaUsuario;
    
    
}
