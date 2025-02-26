package com.richard.motographback.model_generation;

import com.richard.motographback.model.ModelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.richard.motographback.model_generation.ModelGenerationSpecification.*;

@RestController
@RequestMapping("/model_generations")
@CrossOrigin(origins = "http://localhost:4200")
public class ModelGenerationController {
    public ModelGenerationController(ModelMapper modelMapper, ModelGenerationRepository modelGenerationRepository, ModelRepository modelRepository) {
        this.modelMapper = modelMapper;
        this.modelGenerationRepository = modelGenerationRepository;
        this.modelRepository = modelRepository;
    }

    private final ModelMapper modelMapper;
    private final ModelGenerationRepository modelGenerationRepository;
    private final ModelRepository modelRepository;

    @GetMapping("")
    public List<ModelGeneration> findAll(
            @RequestParam(required = false) Long brandId,
            @RequestParam(required = false) Long modelId,
            @RequestParam(required = false) Integer endYear

    ) {
        Specification<ModelGeneration> filter = Specification.where(modelId == null ? null :  isModel(modelId))
                .and(brandId == null ? null : belongsToBrand(brandId));
        return modelGenerationRepository.findAll(filter);
    }

    @PostMapping(value = "")
    public ResponseEntity<ModelGeneration> create(@RequestBody @Validated ModelGenerationDto modelGenerationDto) {
        ModelGeneration modelGeneration = modelMapper.map(modelGenerationDto, ModelGeneration.class);
        if(!modelRepository.existsById(modelGeneration.getModel().getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        modelGeneration = modelGenerationRepository.saveAndFlush(modelGeneration);
        return ResponseEntity.status(HttpStatus.OK).body(modelGeneration);
    }
}
