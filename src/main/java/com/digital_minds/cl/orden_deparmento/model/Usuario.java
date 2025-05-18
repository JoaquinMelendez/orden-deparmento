package com.digital_minds.cl.orden_deparmento.model;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    private Integer idUsuario;

    @Column(unique=true, nullable=false)
    private String correo;

    @Column(nullable=false, length=20)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "usuario-reserva")
    private List<Reserva> reservas;
}
