package com.richard.motographback.model;

import com.richard.motographback.brand.BrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
@CrossOrigin(origins = "http://localhost:4200")
public class ModelController {
    public ModelController(ModelMapper modelMapper, BrandRepository brandRepository, ModelRepository modelRepository) {
        this.modelMapper = modelMapper;
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
    }

    private final ModelMapper modelMapper;
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;

    @GetMapping("")
    public List<Model> findAll() {
        return modelRepository.findAll();
    }


    @PostMapping(value = "")
    public ResponseEntity<Model> create(@RequestBody ModelDto modelDto) {
        Model model = modelMapper.map(modelDto, Model.class);
        if(!brandRepository.existsById(model.getBrand().getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        model = modelRepository.saveAndFlush(model);
        return ResponseEntity.status(HttpStatus.OK).body(model);
    }
}
