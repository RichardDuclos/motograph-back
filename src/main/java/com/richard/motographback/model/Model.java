package com.richard.motographback.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.richard.motographback.brand.Brand;
import com.richard.motographback.model_generation.ModelGeneration;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Table(name = "MODEL")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @JsonIgnoreProperties({"models"})
    @ManyToOne
    @JoinColumn(nullable = false)
    private Brand brand;

    @JsonIgnoreProperties({"model"})
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "model")
    private Set<ModelGeneration> modelGenerations;
}
