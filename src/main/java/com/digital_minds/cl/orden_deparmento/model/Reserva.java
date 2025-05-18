package com.digital_minds.cl.orden_deparmento.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    @Column(nullable = false)
    private Date fechaInicio;

    @Column(nullable = false)
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "idHabitacion")
    @JsonBackReference(value = "reservas-habitacion")
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    @JsonBackReference(value = "usuario-reserva")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "idEstadoReserva")
    @JsonIgnoreProperties("reservas")
    private EstadoReserva estadoReserva;
}