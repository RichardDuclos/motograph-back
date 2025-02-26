package com.richard.motographback.model_generation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.richard.motographback.model.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MODEL_GENERATION")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ModelGeneration {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String name; //optional

    @Column(nullable = false)
    private Integer startYear;

    @Column(nullable = true) //if null, model is still being produced
    private Integer endYear;

    @Column
    private Integer engineCc;
    @Column
    private Integer horsePower;

    @Column
    private Integer torque;

    @Column
    private Integer weight;

    @Column
    private Integer topSpeed;

    @Column
    private Integer price;

    @JsonIgnoreProperties({"modelGenerations"})
    @ManyToOne
    @JoinColumn(nullable = false)
    private Model model;
}
