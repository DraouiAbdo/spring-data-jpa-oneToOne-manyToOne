package dz.cut.springdatamapping.repositories;

import dz.cut.springdatamapping.entities.Consultation;
import dz.cut.springdatamapping.entities.Doctor;
import dz.cut.springdatamapping.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Doctor findDoctorByName(String name);
}
