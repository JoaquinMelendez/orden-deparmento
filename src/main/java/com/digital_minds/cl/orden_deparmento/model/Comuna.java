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
@Table(name = "comuna")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Comuna {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idComuna;

    @Column
    private String nombreComuna;

    @ManyToOne
    @JoinColumn(name = "idCiudad")
    @JsonBackReference(value = "ciudad-comuna")
    private Ciudad ciudad;

    @OneToMany(mappedBy="comuna", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "comuna-residencias")
    private List<Residencia> residencias;
}
