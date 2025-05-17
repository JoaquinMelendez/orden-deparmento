package com.digital_minds.cl.orden_deparmento.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(unique=true, nullable=false)
    private String correo;

    @JsonIgnore
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

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Reserva> reservas;
}
