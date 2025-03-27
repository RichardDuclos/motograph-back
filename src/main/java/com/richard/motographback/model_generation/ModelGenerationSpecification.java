package com.richard.motographback.model_generation;

import com.richard.motographback.brand.Brand;
import com.richard.motographback.model.Model;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class ModelGenerationSpecification {
    public ModelGenerationSpecification() {}

    public static Specification<ModelGeneration> endYearBefore(Integer endYear) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("endYear"), endYear);
    }
    public static Specification<ModelGeneration> isModel(Long modelId) {
        return (root, query, criteriaBuilder) -> {
            Join<Model, ModelGeneration> model = root.join("model");
            return criteriaBuilder.equal(model.get("id"), modelId);
        };
    }

    public static Specification<ModelGeneration> belongsToBrand(Long brandId) {
        return (root, query, criteriaBuilder) -> {
            Join<Model, ModelGeneration> model = root.join("model");
            Join<Brand, ModelGeneration> brand = model.join("brand");
            return criteriaBuilder.equal(brand.get("id"), brandId);
        };
    }
    public static Specification<ModelGeneration> engineCcBetween(Integer minCyl, Integer maxCyl) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.between(root.get("engineCc"), minCyl, maxCyl);
        };
    }
}
