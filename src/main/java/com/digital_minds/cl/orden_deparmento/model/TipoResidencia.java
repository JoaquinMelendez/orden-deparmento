package com.digital_minds.cl.orden_deparmento.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "tipoResidencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoResidencia {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idTipoResidencia;

    @Column(unique = true, nullable = false)
    private String nombreTipoResidencia;

    @OneToMany(mappedBy="tipoResidencia", cascade= CascadeType.ALL)
    @JsonManagedReference(value = "residencia-tiporesidencia")
    private List<Residencia> residencias;
}
