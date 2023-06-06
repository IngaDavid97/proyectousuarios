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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
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
public class Producto {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;

    @Size(min = 3, max = 10, message = "El producto debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "El producto no puede estar en blanco")
    @Column(name = "nombre_pro")
    private String nombre_pro;
    
    @NotBlank(message = "La descripcion no puede estar en blanco")
    @Column(name = "descripcion_pro")
    private String descripcion_pro;
   
    @Column(name = "categoria_pro")
    private String categoria_pro;
    
    
    
    @Column(name = "precio_emprendedor")
    private int precio_emprendedor ;
    
    
     @Column(name = "imagenes_pro")
    private String imagenes_pro;
     
     //////////////////////////////////////////////////////
     
      @ManyToMany(mappedBy = "productos")
    private List<Ventas> ventas;
      
   @OneToMany(mappedBy = "producto")
    private List<Compra> compras;
    
}
