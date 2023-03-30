package dz.cut.springdatamapping.repositories;

import dz.cut.springdatamapping.entities.Consultation;
import dz.cut.springdatamapping.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findPatientByName(String name);
}
