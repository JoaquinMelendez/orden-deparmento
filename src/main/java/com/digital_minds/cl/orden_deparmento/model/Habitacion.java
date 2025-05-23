package com.digital_minds.cl.orden_deparmento.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "habitacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHabitacion;

    @Column
    private String nombreHabitacion;

    @Column(nullable = false)
    private Integer cantCamas;

    @Column(nullable = false)
    private Integer cantPiezas;

    @OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "reservas-habitacion")
    private List<Reserva> reservas;

    @ManyToOne
    @JoinColumn(name = "idResidencia")
    @JsonBackReference(value = "habitaciones-residencia")
    private Residencia residencia;
}
