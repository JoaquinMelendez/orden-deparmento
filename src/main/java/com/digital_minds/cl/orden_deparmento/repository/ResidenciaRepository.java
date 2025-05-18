package com.digital_minds.cl.orden_deparmento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digital_minds.cl.orden_deparmento.model.Residencia;

@Repository
public interface ResidenciaRepository extends JpaRepository<Residencia, Integer>{

    @Query("SELECT r FROM Residencia r WHERE r.tipoResidencia.id = :idTipoResidencia")
    List<Residencia> buscarPorTipoResidencia(@Param("idTipoResidencia") Integer idTipoResidencia);

}
