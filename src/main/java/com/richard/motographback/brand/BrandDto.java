package com.richard.motographback.brand;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandDto {
    @NotBlank
    private String name;

}
