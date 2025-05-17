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

import com.digital_minds.cl.orden_deparmento.model.Region;
import com.digital_minds.cl.orden_deparmento.service.RegionService;

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

    @PutMapping("/{id}")
    public ResponseEntity<Region> actualizar(@PathVariable Integer id, @RequestBody Region region) {
       Region regionActualizada = regionService.patchRegion(id, region);
       if (regionActualizada != null){
        return ResponseEntity.ok(regionActualizada);
       }
       return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Region> actualizarParcial(@PathVariable Integer id, @RequestBody Region parcialRegion) {
        Region regionActualizada = regionService.patchRegion(id, parcialRegion);
        if (regionActualizada != null){
            return ResponseEntity.ok(regionActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
