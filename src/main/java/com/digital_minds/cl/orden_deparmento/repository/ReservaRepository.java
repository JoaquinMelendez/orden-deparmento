package com.digital_minds.cl.orden_deparmento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital_minds.cl.orden_deparmento.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

    List<Reserva> findByHabitacionId(Integer habitacionId);
 
}
