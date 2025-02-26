package com.richard.motographback.brand;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@CrossOrigin(origins = "http://localhost:4200")
public class BrandController {

    @Autowired
    public BrandController(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    @GetMapping("")
    public List<Brand> findAll() {
        System.out.println("yo");
        return brandRepository.findAll();
    }

    @GetMapping("/search")
    public List<Brand> findAllByName(@RequestParam String name) {
        return brandRepository.findAllByNameContainingIgnoreCase(name);
    }
    @PostMapping(value = "")
    public ResponseEntity<Brand> create(@RequestBody BrandDto brandDto) {
        Brand brand = modelMapper.map(brandDto, Brand.class);
        try {
            brandRepository.saveAndFlush(brand);
            return ResponseEntity.status(HttpStatus.CREATED).body(brand);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}