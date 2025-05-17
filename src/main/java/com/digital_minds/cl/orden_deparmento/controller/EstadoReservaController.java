package com.digital_minds.cl.orden_deparmento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.digital_minds.cl.orden_deparmento.model.EstadoReserva;
import com.digital_minds.cl.orden_deparmento.service.EstadoReservaService;

@Controller
@RequestMapping("/api/v1/estadosReserva")
public class EstadoReservaController {

    @Autowired
    private EstadoReservaService estadoReservaService;
    
     @GetMapping
     public ResponseEntity<List<EstadoReserva>> listar() {
        List<EstadoReserva> estadosReserva =  estadoReservaService.buscarTodos();
        if (estadosReserva.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estadosReserva);
    }

     @GetMapping("/{id}")
    public ResponseEntity<EstadoReserva> obtenerPorId(@PathVariable Integer id) {
        EstadoReserva estadoReserva = estadoReservaService.buscarPorId(id);
        if (estadoReserva != null){
            return ResponseEntity.ok(estadoReserva);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EstadoReserva> guardar(@RequestBody EstadoReserva estadoReserva) {
        EstadoReserva nuevoEstadoReserva = estadoReservaService.agregarEstadoReserva(estadoReserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstadoReserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstadoReserva(@PathVariable Integer id) {
        try {
            estadoReservaService.eliminarEstadoReserva(id);;
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoReserva> actualizar(@PathVariable Integer id, @RequestBody EstadoReserva estadoReserva) {
       EstadoReserva estadoReservaActualizada = estadoReservaService.patchEstadoReserva(id, estadoReserva);
       if (estadoReservaActualizada != null){
        return ResponseEntity.ok(estadoReservaActualizada);
       }
       return ResponseEntity.notFound().build();
    }


    @PatchMapping("/{id}")
    public ResponseEntity<EstadoReserva> actualizarParcial(@PathVariable Integer id, @RequestBody EstadoReserva parcialEstadoReserva) {
        EstadoReserva estadoReservaActualizada = estadoReservaService.patchEstadoReserva(id, parcialEstadoReserva);
        if (estadoReservaActualizada != null){
            return ResponseEntity.ok(estadoReservaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
