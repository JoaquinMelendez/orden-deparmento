package com.digital_minds.cl.orden_deparmento.service;

import java.sql.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital_minds.cl.orden_deparmento.model.Habitacion;
import com.digital_minds.cl.orden_deparmento.model.Reserva;
import com.digital_minds.cl.orden_deparmento.model.Usuario;
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

    public Reserva hacerReserva(Integer habitacionId, Integer usuarioId, Date fechaInicio, Date fechaFin){
        //Disponibilidad
        List<Reserva> reservasExistentes = reservaRepository.findByHabitacionIdAndFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(habitacionId, fechaInicio, fechaFin);

        if(!reservasExistentes.isEmpty()){
            throw new RuntimeErrorException(null, "La habitación no está disponible en estas fechas");
        }
        
        //Reserva
        Habitacion habitacion = habitacionRepository.findById(habitacionId)
        .orElseThrow(() -> new RuntimeException("Habitacion no encontrada"));

        Usuario usuario = usuarioRepository.findById(usuarioId)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Reserva nuevaReserva = new Reserva();

        nuevaReserva.setHabitacion(habitacion);
        nuevaReserva.setUsuario(usuario);
        nuevaReserva.setFechaInicio(fechaInicio);
        nuevaReserva.setFechaFin(fechaFin);

        return reservaRepository.save(nuevaReserva);

    }

    public List<Reserva> buscarTodos(){
        return reservaRepository.findAll();
    }

}
