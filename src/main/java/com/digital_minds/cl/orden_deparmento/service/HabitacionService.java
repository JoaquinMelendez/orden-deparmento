package com.digital_minds.cl.orden_deparmento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital_minds.cl.orden_deparmento.model.Habitacion;
import com.digital_minds.cl.orden_deparmento.repository.HabitacionRepository;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    public Habitacion agregarHabitacion(Habitacion habitacion){
        return habitacionRepository.save(habitacion);
    }

    public void eliminarHabitacion(Integer id){
        habitacionRepository.deleteById(id);
    }

    public List<Habitacion> buscarTodos(){
        return habitacionRepository.findAll();
    }

    public Habitacion buscarPorId(Integer id){
        return habitacionRepository.findById(id).get();
    }
}
