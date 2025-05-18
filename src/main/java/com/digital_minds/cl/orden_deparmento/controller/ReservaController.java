package com.digital_minds.cl.orden_deparmento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital_minds.cl.orden_deparmento.model.Reserva;
import com.digital_minds.cl.orden_deparmento.service.ReservaService;


@RestController
@RequestMapping("/api/v1/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    //Reserva
    @PostMapping
    public ResponseEntity<?> reservar(@RequestBody Reserva reserva) {
        try{
            Reserva nuevaReserva = reservaService.hacerReserva(
                reserva.getHabitacion().getIdHabitacion(),
                reserva.getUsuario().getIdUsuario(),
                reserva.getFechaInicio(),
                reserva.getFechaFin(),
                reserva.getEstadoReserva().getIdEstadoReserva()
                );
                return ResponseEntity.ok(nuevaReserva);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }    

    //Devolver todas las reservas
    @GetMapping
    public ResponseEntity<List<Reserva>> listar(){
        List<Reserva> usuarios = reservaService.buscarTodos();
        if (usuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    //Buscar reserva por id
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtenerPorId(@PathVariable Integer id) {
        Reserva reserva = reservaService.findById(id);
        if (reserva != null){
            return ResponseEntity.ok(reserva);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizar(@PathVariable Integer id, @RequestBody Reserva reserva) {
       Reserva reservaActualizada = reservaService.patchReserva(id, reserva);
       if (reservaActualizada != null){
        return ResponseEntity.ok(reservaActualizada);
       }
       return ResponseEntity.notFound().build();
    }

    //Eliminar reserva
    @PatchMapping("/{id}")
    public ResponseEntity<Reserva> actualizarParcial(@PathVariable Integer id, @RequestBody Reserva parcialReserva) {
        Reserva reservaActualizada = reservaService.patchReserva(id, parcialReserva);
        if (reservaActualizada != null){
            return ResponseEntity.ok(reservaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Buscar reservas por habitación
    @GetMapping("/habitacion/{habitacionId}")
    public List<Reserva> obtenerReservasPorHabitacion(@PathVariable Integer habitacionId) {
        return reservaService.obtenerReservasPorHabitacion(habitacionId);
    }
}