package com.digital_minds.cl.orden_deparmento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital_minds.cl.orden_deparmento.model.Habitacion;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{


}
