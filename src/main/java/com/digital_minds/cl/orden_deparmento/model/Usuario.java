package com.digital_minds.cl.orden_deparmento.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable=false)
    private String correo;

    @Column(nullable=false, length=20)
    private String contrasenna;

    @Column(unique=true, length= 13, nullable= false)
    private String run;

    @Column(nullable=false, length=20)
    private String nombre;

    @Column(nullable=false, length=20)
    private String apellidoPaterno;

    @Column(nullable=false, length=20)
    private String apellidoMaterno;

    @Column(nullable=false)
    private Date fechaNacimiento;



}
