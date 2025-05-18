package com.digital_minds.cl.orden_deparmento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digital_minds.cl.orden_deparmento.model.Habitacion;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{

    @Query("SELECT h FROM Habitacion h WHERE h.residencia.id = :idResidencia")
    List<Habitacion> buscarPorResidencia(@Param("idResidencia") Integer idResidencia);
}



