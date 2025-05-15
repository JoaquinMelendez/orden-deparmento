package com.digital_minds.cl.orden_deparmento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital_minds.cl.orden_deparmento.model.Region;
import com.digital_minds.cl.orden_deparmento.model.Residencia;
import com.digital_minds.cl.orden_deparmento.service.RegionService;
import com.digital_minds.cl.orden_deparmento.service.ResidenciaService;

@RestController
@RequestMapping("/api/v1/regiones")
public class RegionController {

    @Autowired
    private RegionService regionService;
    
     @GetMapping
     public ResponseEntity<List<Region>> listar() {
        List<Region> regiones = regionService.findAll();
        if (regiones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regiones);
    }

     @GetMapping("/{id}")
    public ResponseEntity<Region> obtenerPorId(@PathVariable Integer id) {
        Region region = regionService.findById(id);
        if (region != null){
            return ResponseEntity.ok(region);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Region> guardar(@RequestBody Region region) {
        Region regionNueva = regionService.save(region);
        return ResponseEntity.status(HttpStatus.CREATED).body(regionNueva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRegion(@PathVariable Integer id) {
        try {
            regionService.delete( id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
