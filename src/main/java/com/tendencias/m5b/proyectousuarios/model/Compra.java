/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.m5b.proyectousuarios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author HP
 */
@Data
@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private int id_compra;

    
    
    @Column(name = "descripcion_compra")
    private int descripcion_compra;

   
 
     @Column(name = "compra_fecha")
    private String compra_fecha;
     
     
     /////////////////
     @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
     
     
      @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    
    
    
}
