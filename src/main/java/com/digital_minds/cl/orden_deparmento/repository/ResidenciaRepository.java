package com.digital_minds.cl.orden_deparmento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital_minds.cl.orden_deparmento.model.Residencia;

@Repository
public interface ResidenciaRepository extends JpaRepository<Residencia, Integer>{

}
