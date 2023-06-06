/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.m5b.proyectousuarios.repository;

import com.tendencias.m5b.proyectousuarios.model.Persona;
import com.tendencias.m5b.proyectousuarios.model.Rol;
import com.tendencias.m5b.proyectousuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HP
 */
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
    @Query(value = "Select * from persona u where u.nombre_per = :nombre_per", nativeQuery = true)
    public Persona buscarPersona(String nombre_per);
    
    
}
