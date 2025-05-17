package com.digital_minds.cl.orden_deparmento.service;

import java.util.List;
import java.util.Optional;

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

    public List<Habitacion> obtenerHabitacionesPorResidencia(Integer residenciaId) {
        return habitacionRepository.buscarPorResidencia(residenciaId);
    }
    

    public Habitacion patchHabitacion(Integer id, Habitacion parcialHabitacion){
        Optional<Habitacion> habitacionOptional = habitacionRepository.findById(id);
        if (habitacionOptional.isPresent()) {
            
            Habitacion habitacionToUpdate = habitacionOptional.get();
            
            if (parcialHabitacion.getNombreHabitacion() != null) {
                habitacionToUpdate.setNombreHabitacion(parcialHabitacion.getNombreHabitacion());   
            }
            if (parcialHabitacion.getCantCamas() != null) {
                habitacionToUpdate.setCantCamas(parcialHabitacion.getCantCamas());
            }
            if (parcialHabitacion.getCantPiezas() != null) {
                parcialHabitacion.setCantPiezas(parcialHabitacion.getCantPiezas());
            }

            return habitacionRepository.save(habitacionToUpdate);
        } else {
            return null; 
        }
    }


}
