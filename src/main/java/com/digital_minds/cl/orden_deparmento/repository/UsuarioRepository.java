package com.digital_minds.cl.orden_deparmento.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital_minds.cl.orden_deparmento.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer >{

    Optional<Usuario> findByCorreo(String Correo);

    Optional<Usuario> findByRun(String run);

    List<Usuario> findByApellidoMaterno(String apellidoMaterno);

    List<Usuario> findByApellidoPaterno(String apellidoPaterno);

    List<Usuario> findByFechaNacimiento(Date fechaNacimiento);

    Optional<Usuario> findById(Long id);



}    

