package com.digital_minds.cl.orden_deparmento.model;

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
@Table(name = "residencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Residencia {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_residencia;

    @Column(nullable=false)
    private String nombre_residencia;

    @Column(unique=true, nullable=false)
    private int direccion;

    @Column(unique=true, length=11, nullable=false)
    private int telefono;

    @Column(nullable=false)
    private String correo;

    @Column(nullable=false)
    private String sitio_web;

}
