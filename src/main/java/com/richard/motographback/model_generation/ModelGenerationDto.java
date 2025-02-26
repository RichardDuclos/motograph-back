package com.richard.motographback.model_generation;

import com.richard.motographback.model.Model;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModelGenerationDto {
    private String name; //optional

    @NotNull
    private Integer startYear;

    private Integer endYear;

    @NotNull
    private Integer engineCc;

    @NotNull
    private Integer horsePower;

    @NotNull
    private Integer torque;

    private Integer weight;

    @NotNull
    private Integer topSpeed;

    @NotNull
    private Integer price;

    @NotNull
    private Model model;
}
