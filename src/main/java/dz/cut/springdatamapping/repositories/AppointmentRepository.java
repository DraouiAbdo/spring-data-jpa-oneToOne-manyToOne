package dz.cut.springdatamapping.repositories;

import dz.cut.springdatamapping.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
