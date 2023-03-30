package dz.cut.springdatamapping.service;

import dz.cut.springdatamapping.entities.Appointment;
import dz.cut.springdatamapping.entities.Consultation;
import dz.cut.springdatamapping.entities.Doctor;
import dz.cut.springdatamapping.entities.Patient;

public interface IHospitalService {
    Patient savePatient(Patient p);
    Doctor saveDoctor(Doctor d);
    Doctor findDoctorById(Long Id);
    Doctor findDoctorByName(String name);
    Appointment saveAppointment(Appointment ap);
    Consultation saveConsultation(Consultation c);
}
