/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.m5b.proyectousuarios.service;


import com.tendencias.m5b.proyectousuarios.model.Compra;
import com.tendencias.m5b.proyectousuarios.model.Usuario;
import com.tendencias.m5b.proyectousuarios.repository.CompraRepository;
import com.tendencias.m5b.proyectousuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author 59398
 */
@Service
public class CompraServiceImpl extends GenericServiceImpl<Compra, Integer> implements GenericService<Compra, Integer> {

    @Autowired
    CompraRepository compraRepository;

    @Override
    public CrudRepository<Compra, Integer> getDao() {
        return compraRepository;
    }


}
