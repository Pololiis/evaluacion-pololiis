package com.evaluacion.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Agregar anotación para campo único
    private String name;

    @OneToMany(mappedBy = "category_id") // corroborar
    private List<Visitor> visitors;
}
