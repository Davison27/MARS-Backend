package com.david.citasMedicas.repository;

import com.david.citasMedicas.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, String> {
}
