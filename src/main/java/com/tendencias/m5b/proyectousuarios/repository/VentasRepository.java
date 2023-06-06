/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.m5b.proyectousuarios.repository;

import com.tendencias.m5b.proyectousuarios.model.Usuario;
import com.tendencias.m5b.proyectousuarios.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HP
 */
public interface VentasRepository extends JpaRepository<Ventas, Integer>{
    @Query(value = "Select * from ventas u where u.id_ventas = :id_ventas", nativeQuery = true)
    public Ventas buscarVenta(String id_ventas);
    
}
