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
@Table(name = "region")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idRegion;

    @Column
    private String nombreRegion;

    @OneToMany(mappedBy="region", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "region-ciudad")
    private List<Ciudad> ciudades;
}
