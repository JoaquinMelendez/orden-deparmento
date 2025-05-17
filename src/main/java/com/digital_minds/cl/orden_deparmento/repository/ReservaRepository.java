package com.digital_minds.cl.orden_deparmento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digital_minds.cl.orden_deparmento.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

    @Query("SELECT r FROM Reserva r WHERE r.habitacion.id = :habitacionId")
    List<Reserva> buscarPorHabitacion(@Param("habitacionId") Integer habitacionId);
        List<Reserva> findByHabitacionId(Integer habitacionId);
    
}
