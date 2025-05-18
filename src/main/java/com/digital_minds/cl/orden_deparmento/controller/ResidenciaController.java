package com.digital_minds.cl.orden_deparmento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital_minds.cl.orden_deparmento.model.Residencia;
import com.digital_minds.cl.orden_deparmento.service.ResidenciaService;

@RestController
@RequestMapping("/api/v1/residencias")
public class ResidenciaController {

    @Autowired
    private ResidenciaService residenciaService;
    
     @GetMapping
     public ResponseEntity<List<Residencia>> listar() {
        List<Residencia> residencias = residenciaService.findAll();
        if (residencias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(residencias);
    }

     @GetMapping("/{id}")
    public ResponseEntity<Residencia> obtenerPorId(@PathVariable Integer id) {
        Residencia residencia = residenciaService.findById(id);
        if (residencia != null){
            return ResponseEntity.ok(residencia);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Residencia> guardar(@RequestBody Residencia residencia) {
        Residencia residenciaNueva = residenciaService.save(residencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(residenciaNueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Residencia> actualizar(@PathVariable Integer id, @RequestBody Residencia residencia) {
       Residencia residenciaActualizada = residenciaService.patchResidencia(id, residencia);
       if (residenciaActualizada != null){
        return ResponseEntity.ok(residenciaActualizada);
       }
       return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Residencia> actualizarParcial(@PathVariable Integer id, @RequestBody Residencia parcialResidencia) {
        Residencia residenciaActualizado = residenciaService.patchResidencia(id, parcialResidencia);
        if (residenciaActualizado != null) {
            return ResponseEntity.ok(residenciaActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarResidencia(@PathVariable Integer id) {
        try {
            residenciaService.delete( id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/porTipoResidencia/{tipoId}")
    public ResponseEntity<List<Residencia>> getResidenciasPorTipo(@PathVariable("tipoId") Integer tipoResidenciaId) {
        List<Residencia> residencias = residenciaService.obtenerResidenciasPorTipo(tipoResidenciaId);
        
        if (residencias.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(residencias);
        }
    }

}


   



