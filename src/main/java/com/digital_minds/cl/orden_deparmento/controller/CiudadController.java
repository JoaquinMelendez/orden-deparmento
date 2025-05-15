package com.digital_minds.cl.orden_deparmento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital_minds.cl.orden_deparmento.model.Ciudad;
import com.digital_minds.cl.orden_deparmento.service.CiudadService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/ciudades")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    @GetMapping
    public ResponseEntity<List<Ciudad>> listar() {
        List<Ciudad> ciudades = ciudadService.findAll();
        if (ciudades.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ciudades);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> obtenerPorId(@PathVariable Integer id) {
        Ciudad ciudad = ciudadService.findById(id);
        if (ciudad != null){
            return ResponseEntity.ok(ciudad);
        }
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<Ciudad> guardar(@RequestBody Ciudad ciudad){
        Ciudad ciudadNueva = ciudadService.save(ciudad);
        return ResponseEntity.status(HttpStatus.CREATED).body(ciudadNueva);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Ciudad> actualizar(@PathVariable Integer id, @RequestBody Ciudad ciudad){
        Ciudad ciudadActualizada = ciudadService.updateCiudad(id, ciudad);
        if (ciudadActualizada != null){
        return ResponseEntity.ok(ciudadActualizada);
        }
        return ResponseEntity.notFound().build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Ciudad> actualizarParcial(@PathVariable Integer id, @RequestBody Ciudad parcialCiudad) {
        Ciudad ciudadActualizada = ciudadService.updateCiudad(id, parcialCiudad);
        if (ciudadActualizada != null){
            return ResponseEntity.ok(ciudadActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCiudad(@PathVariable Integer id) {
        try {
            ciudadService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
    
}
