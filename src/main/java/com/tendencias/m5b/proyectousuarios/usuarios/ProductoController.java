/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.m5b.proyectousuarios.usuarios;

import com.tendencias.m5b.proyectousuarios.model.Persona;
import com.tendencias.m5b.proyectousuarios.model.Producto;
import com.tendencias.m5b.proyectousuarios.model.Usuario;
import com.tendencias.m5b.proyectousuarios.service.PersonaServiceImpl;
import com.tendencias.m5b.proyectousuarios.service.ProductoServiceImpl;
import com.tendencias.m5b.proyectousuarios.service.UsuarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    ProductoServiceImpl productoService;

    @Operation(summary = "Se obtiene la lista de Productsos")
    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listaProducto() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de la Producto")
    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto u) {
        return new ResponseEntity<>(productoService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto u) {
        Producto producto = productoService.findById(id);
        if (producto != null) {
            try {
                
             
               producto.setNombre_pro(u.getNombre_pro());
               producto.setDescripcion_pro(u.getDescripcion_pro());
               producto.setCategoria_pro(u.getCategoria_pro());
               producto.setPrecio_emprendedor(u.getPrecio_emprendedor());
               producto.setImagenes_pro(u.getImagenes_pro());
               
                
                return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Producto> elimiarProducto(@PathVariable Integer id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
