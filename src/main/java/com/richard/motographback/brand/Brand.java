package com.richard.motographback.brand;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.richard.motographback.model.Model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Table(name = "BRAND")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Brand {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @JsonIgnoreProperties({"brand"})
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
    private Set<Model> models;
}
