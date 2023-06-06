/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.m5b.proyectousuarios.usuarios;

import com.tendencias.m5b.proyectousuarios.model.Usuario;
import com.tendencias.m5b.proyectousuarios.model.Ventas;
import com.tendencias.m5b.proyectousuarios.service.UsuarioServiceImpl;
import com.tendencias.m5b.proyectousuarios.service.VentasServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.HashSet;
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
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    VentasServiceImpl ventasService;

    @Operation(summary = "Se obtiene la lista de ventas")
    @GetMapping("/listar")
    public ResponseEntity<List<Ventas>> listaVentas() {
        return new ResponseEntity<>(ventasService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar ventas")
    @PostMapping("/crear")
    public ResponseEntity<Ventas> crearVentas(@RequestBody Ventas u) {
        return new ResponseEntity<>(ventasService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Ventas> actualizarVentas(@PathVariable Integer id, @RequestBody Ventas u) {
        Ventas ventas = ventasService.findById(id);
        if (ventas != null) {
            try {
                
                ventas.setCantidad_venta(u.getCantidad_venta());
                ventas.setVenta_fecha(u.getVenta_fecha());
                ventas.setUsuario(u.getUsuario());
                ventas.setProductos(u.getProductos());
                
                return new ResponseEntity<>(ventasService.save(ventas), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Ventas> elimiarVentas(@PathVariable Integer id) {
        ventasService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
