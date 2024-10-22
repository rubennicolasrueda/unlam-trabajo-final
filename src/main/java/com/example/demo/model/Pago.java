package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long pago;
    private LocalDateTime fechaDePago;
    private String metodoDePago;



}
