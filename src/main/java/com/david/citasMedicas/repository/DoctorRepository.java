package com.david.citasMedicas.repository;

import com.david.citasMedicas.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, String> {
}
