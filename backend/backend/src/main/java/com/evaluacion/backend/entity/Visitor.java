package com.evaluacion.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.ReadOnlyProperty;

@Entity
@Table(name = "Visitors")
@Data
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "visitor_ip")
    @ReadOnlyProperty
    private String ip;

    @Column(name = "connection_date")
    @ReadOnlyProperty
    private String date;

    @Column(name = "connection_hour")
    @ReadOnlyProperty
    private String hour;

    @Column(name = "is_blocked")
    private Boolean isBlocked = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private String comment = "";
}