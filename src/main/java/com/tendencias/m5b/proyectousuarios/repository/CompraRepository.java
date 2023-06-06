/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.m5b.proyectousuarios.repository;

import com.tendencias.m5b.proyectousuarios.model.Compra;
import com.tendencias.m5b.proyectousuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HP
 */
public interface CompraRepository extends JpaRepository<Compra, Integer>{
    @Query(value = "Select * from compra u where u.id_compra = :id_compra", nativeQuery = true)
    public Compra buscarCompra(String id_compra);
    
}
