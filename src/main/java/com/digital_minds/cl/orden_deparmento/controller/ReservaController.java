package com.digital_minds.cl.orden_deparmento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
                reserva.getHabitacion().getId(),
                reserva.getUsuario().getId(),
                reserva.getFechaInicio(),
                reserva.getFechaFin()
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
}