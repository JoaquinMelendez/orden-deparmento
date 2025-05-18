package com.digital_minds.cl.orden_deparmento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital_minds.cl.orden_deparmento.model.TipoResidencia;

@Repository
public interface TipoResidenciaRepository extends JpaRepository<TipoResidencia, Integer>{

}
