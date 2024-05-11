package com.evaluacion.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Visitors")
@Data
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "visitor_ip")
    private String ip;

    @Column(name = "connection_date")
    private String date;

    @Column(name = "connection_hour")
    private String hour;
}