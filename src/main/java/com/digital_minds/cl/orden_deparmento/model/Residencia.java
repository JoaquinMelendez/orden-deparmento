package com.digital_minds.cl.orden_deparmento.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "residencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Residencia {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idResidencia;

    @Column(nullable=false)
    private String nombreResidencia;

    @Column(unique=true, nullable=false)
    private String direccion;

    @Column(unique=true, length=11, nullable=false)
    private Integer telefono;

    @Column(nullable=false)
    private String correo;

    @Column(nullable=false)
    private String sitioWeb;

    @OneToMany(mappedBy="residencia", cascade= CascadeType.ALL)
    @JsonManagedReference(value = "habitaciones-residencia")
    private List<Habitacion> habitaciones;

    @ManyToOne
    @JoinColumn(name = "idComuna")
    @JsonBackReference(value = "comuna-residencias")
    private Comuna comuna;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "idTipoResidencia")
    @JsonBackReference(value = "residencia-tiporesidencia")
    private TipoResidencia tipoResidencia;
}
