package com.divisas.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "historial_divisa")
public class HistorialDivisa implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;


    @Column( name = "monedaOrigen")
    private String monedaOrigen;

    @Column( name = "monedaObjetivo")
    private String monedaObjetivo;

    @Column( name = "monto")
    private Double monto;

    @Column( name = "valorConversion")
    private Double valorConversion;

    @Column( name = "fechaConversion")
    private Date fechaConversion;
}
