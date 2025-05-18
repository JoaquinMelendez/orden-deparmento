package com.digital_minds.cl.orden_deparmento.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital_minds.cl.orden_deparmento.model.EstadoReserva;
import com.digital_minds.cl.orden_deparmento.model.Habitacion;
import com.digital_minds.cl.orden_deparmento.model.Reserva;
import com.digital_minds.cl.orden_deparmento.model.Usuario;
import com.digital_minds.cl.orden_deparmento.repository.EstadoReservaRepository;
import com.digital_minds.cl.orden_deparmento.repository.HabitacionRepository;
import com.digital_minds.cl.orden_deparmento.repository.ReservaRepository;
import com.digital_minds.cl.orden_deparmento.repository.UsuarioRepository;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstadoReservaRepository estadoReservaRepository;

    public Reserva hacerReserva(Integer habitacionId, Integer usuarioId, Date fechaInicio, Date fechaFin, Integer estadoReservaId){
        //Disponibilidad
        List<Reserva> reservas = reservaRepository.buscarPorHabitacion(habitacionId);

        boolean ocupada = reservas.stream().anyMatch(r ->
            !r.getFechaFin().before(fechaInicio) && !r.getFechaInicio().after(fechaFin)
        );

        if(ocupada){
            throw new RuntimeException("La habitación está reservada en esas fechas");
        }
        
        //Reserva
        Habitacion habitacion = habitacionRepository.findById(habitacionId)
        .orElseThrow(() -> new RuntimeException("Habitacion no encontrada"));

        Usuario usuario = usuarioRepository.findById(usuarioId)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        EstadoReserva estadoReserva = estadoReservaRepository.findById(estadoReservaId)
                .orElseThrow(() -> new RuntimeException("Estado de reserva no encontrado"));


        Reserva nuevaReserva = new Reserva();

        nuevaReserva.setHabitacion(habitacion);
        nuevaReserva.setUsuario(usuario);
        nuevaReserva.setFechaInicio(fechaInicio);
        nuevaReserva.setFechaFin(fechaFin);
        nuevaReserva.setEstadoReserva(estadoReserva);

        return reservaRepository.save(nuevaReserva);

    }

    //Lista Reservas
    public List<Reserva> buscarTodos(){
        return reservaRepository.findAll();
    }

    //Buscar Reserva por id
    public Reserva findById(Integer id){
        return reservaRepository.findById(id).orElse(null);
    }

    //Eliminar Reserva
    public void delete(Integer id){
        reservaRepository.deleteById(id);
    }

    //Actualizar reserva
    public Reserva patchReserva(Integer id, Reserva parcialReserva){
        Optional<Reserva> reservaOptional = reservaRepository.findById(id);
        if (reservaOptional.isPresent()) {
            
            Reserva reservaToUpdate = reservaOptional.get();
            
            if (parcialReserva.getFechaInicio() != null) {
                reservaToUpdate.setFechaInicio(parcialReserva.getFechaInicio());   
            }
            if (parcialReserva.getFechaFin() != null) {
                reservaToUpdate.setFechaFin(parcialReserva.getFechaFin());   
            }
            if (parcialReserva.getEstadoReserva() != null) {
                reservaToUpdate.setEstadoReserva(parcialReserva.getEstadoReserva());   
            }
            if (parcialReserva.getHabitacion() != null) {
                reservaToUpdate.setHabitacion(parcialReserva.getHabitacion());   
            }
            return reservaRepository.save(reservaToUpdate);
        } else {
            return null; 
        }
    }

    public List<Reserva> obtenerReservasPorHabitacion(Integer habitacionId) {
        return reservaRepository.buscarPorHabitacion(habitacionId);
    }
}