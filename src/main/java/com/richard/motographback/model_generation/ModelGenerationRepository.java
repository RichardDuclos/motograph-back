package com.richard.motographback.model_generation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelGenerationRepository extends JpaRepository<ModelGeneration, Long>, JpaSpecificationExecutor<ModelGeneration> {

}
