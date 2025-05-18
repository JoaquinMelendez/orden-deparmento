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
@Table(name = "ciudad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ciudad {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCiudad;

    @Column
    private String nombreCiudad;

    @ManyToOne
    @JoinColumn(name = "idRegion")
    @JsonBackReference(value = "region-ciudad")
    private Region region;

    @OneToMany(mappedBy="ciudad", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "ciudad-comuna")
    private List<Comuna> comunas;
}
