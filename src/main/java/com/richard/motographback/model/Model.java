package com.richard.motographback.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.richard.motographback.brand.Brand;
import com.richard.motographback.model_generation.ModelGeneration;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MODEL")

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<ModelGeneration> getModelGenerations() {
        return modelGenerations;
    }

    public void setModelGenerations(Set<ModelGeneration> modelGenerations) {
        this.modelGenerations = modelGenerations;
    }
}
