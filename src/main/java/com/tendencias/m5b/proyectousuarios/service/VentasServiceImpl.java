/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.m5b.proyectousuarios.service;


import com.tendencias.m5b.proyectousuarios.model.Usuario;
import com.tendencias.m5b.proyectousuarios.model.Ventas;
import com.tendencias.m5b.proyectousuarios.repository.UsuarioRepository;
import com.tendencias.m5b.proyectousuarios.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author 59398
 */
@Service
public class VentasServiceImpl extends GenericServiceImpl<Ventas, Integer> implements GenericService<Ventas, Integer> {

    @Autowired
    VentasRepository ventasRepository;

    @Override
    public CrudRepository<Ventas, Integer> getDao() {
        return ventasRepository;
    }


}
