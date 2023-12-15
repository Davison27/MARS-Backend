package com.david.citasMedicas.repository;

import com.david.citasMedicas.entity.Diagnosis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends CrudRepository<Diagnosis, String> {
}
