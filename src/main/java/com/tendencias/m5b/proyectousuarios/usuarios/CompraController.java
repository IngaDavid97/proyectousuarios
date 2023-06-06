/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.m5b.proyectousuarios.usuarios;

import com.tendencias.m5b.proyectousuarios.model.Compra;
import com.tendencias.m5b.proyectousuarios.model.Usuario;
import com.tendencias.m5b.proyectousuarios.service.CompraServiceImpl;
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
@RequestMapping("/compra")
public class CompraController {
    @Autowired
    CompraServiceImpl compraService;

    @Operation(summary = "Se obtiene la lista")
    @GetMapping("/listar")
    public ResponseEntity<List<Compra>> listaCompra() {
        return new ResponseEntity<>(compraService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos")
    @PostMapping("/crear")
    public ResponseEntity<Compra> crearCompra(@RequestBody Compra u) {
        return new ResponseEntity<>(compraService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Compra> actualizarCompra(@PathVariable Integer id, @RequestBody Compra u) {
       Compra compra = compraService.findById(id);
        if (compra != null) {
            try {
                
                compra.setDescripcion_compra(u.getDescripcion_compra());
                compra.setCompra_fecha(u.getCompra_fecha());
                compra.setUsuario(u.getUsuario());
                compra.setProducto(u.getProducto());
                
                
                
                return new ResponseEntity<>(compraService.save(compra), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Compra> elimiarCompra(@PathVariable Integer id) {
        compraService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
