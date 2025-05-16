package com.digital_minds.cl.orden_deparmento.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital_minds.cl.orden_deparmento.model.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Integer>{



}
