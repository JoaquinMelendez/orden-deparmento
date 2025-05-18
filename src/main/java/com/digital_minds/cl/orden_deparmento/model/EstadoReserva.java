package com.digital_minds.cl.orden_deparmento.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estadoReserva")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadoReserva;

    @Column(unique = true, nullable = false)
    private String nombreEstadoReserva;

    @OneToMany(mappedBy = "estadoReserva", cascade=CascadeType.ALL)
    @JsonIgnoreProperties("estadoReserva")
    private List<Reserva> reservas;

}
