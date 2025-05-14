package com.digital_minds.cl.orden_deparmento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital_minds.cl.orden_deparmento.model.Habitacion;
import com.digital_minds.cl.orden_deparmento.service.HabitacionService;

@RestController
@RequestMapping("/api/v1/habitaciones")
public class HabitacionController {
    
    @Autowired
    private HabitacionService habitacionService;

    //Devolver todas las Habitaciones
    @GetMapping
    public ResponseEntity<List<Habitacion>> listar(){
        List<Habitacion> habitaciones = habitacionService.buscarTodos();
        if (habitaciones.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(habitaciones);
    }

    //buscar Habitacion por ID
    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> habitacionPorId(@PathVariable Integer id){
        Habitacion habitacionBuscado = habitacionService.buscarPorId(id);
        return ResponseEntity.ok(habitacionBuscado);
    }

    //Agregar nueva habitacion
    @PostMapping
    public ResponseEntity<Habitacion> agregarHabitacion(@RequestBody Habitacion habitacion) {
        Habitacion nuevaHabitacion = habitacionService.agregarHabitacion(habitacion);
        return ResponseEntity.ok(nuevaHabitacion);
    }

    //Quitar habitacion
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> quitarHabitacion(@PathVariable Integer id){
        habitacionService.eliminarHabitacion(id);
        return ResponseEntity.noContent().build(); //AGREGAR RESTRICCIONES TRY CATCH
    }

    //Actualizar Habitacion
    
}
