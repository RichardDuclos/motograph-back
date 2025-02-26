package com.richard.motographback.model;

import com.richard.motographback.brand.Brand;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModelDto {

    @NotBlank
    private String name;

    @NotBlank
    private Brand brand;
}
