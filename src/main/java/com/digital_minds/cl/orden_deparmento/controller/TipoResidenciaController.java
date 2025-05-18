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

import com.digital_minds.cl.orden_deparmento.model.TipoResidencia;
import com.digital_minds.cl.orden_deparmento.service.TipoResidenciaService;

@RestController
@RequestMapping("/api/v1/tiposResidencia")
public class TipoResidenciaController {

    @Autowired
    private TipoResidenciaService tipoResidenciaService;
    
     @GetMapping
     public ResponseEntity<List<TipoResidencia>> listar() {
        List<TipoResidencia> tipoResidencias = tipoResidenciaService.findAll();
        if (tipoResidencias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tipoResidencias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoResidencia> obtenerPorId(@PathVariable Integer id) {
        TipoResidencia tipoResidencia = tipoResidenciaService.findById(id);
        if (tipoResidencia != null){
            return ResponseEntity.ok(tipoResidencia);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TipoResidencia> guardar(@RequestBody TipoResidencia tipoResidencia) {
        TipoResidencia tipoResidenciaNueva = tipoResidenciaService.save(tipoResidencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoResidenciaNueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoResidencia> actualizar(@PathVariable Integer id, @RequestBody TipoResidencia tipoResidencia) {
       TipoResidencia tipoResidenciaActualizada = tipoResidenciaService.patchTipoResidencia(id, tipoResidencia);
       if (tipoResidenciaActualizada != null){
        return ResponseEntity.ok(tipoResidenciaActualizada);
       }
       return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TipoResidencia> actualizarParcial(@PathVariable Integer id, @RequestBody TipoResidencia parcialTipoResidencia) {
        TipoResidencia tipoResidenciaActualizado = tipoResidenciaService.patchTipoResidencia(id, parcialTipoResidencia);
        if (tipoResidenciaActualizado != null) {
            return ResponseEntity.ok(tipoResidenciaActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTipoResidencia(@PathVariable Integer id) {
        try {
            tipoResidenciaService.delete( id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
