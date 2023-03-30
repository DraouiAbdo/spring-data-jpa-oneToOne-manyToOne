package dz.cut.springdatamapping.repositories;

import dz.cut.springdatamapping.entities.Appointment;
import dz.cut.springdatamapping.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
