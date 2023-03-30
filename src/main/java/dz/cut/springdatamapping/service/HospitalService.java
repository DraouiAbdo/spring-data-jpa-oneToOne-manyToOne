package dz.cut.springdatamapping.service;

import dz.cut.springdatamapping.entities.Appointment;
import dz.cut.springdatamapping.entities.Consultation;
import dz.cut.springdatamapping.entities.Doctor;
import dz.cut.springdatamapping.entities.Patient;

import dz.cut.springdatamapping.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class HospitalService implements IHospitalService{

    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;
    private AppointmentRepository appointmentRepository;
    private ConsultationRepository consultationRepository;

    public HospitalService(PatientRepository patientRepository,
                           DoctorRepository doctorRepository,
                           AppointmentRepository appointmentRepository,
                           ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient p) {
        // do some processing
        return patientRepository.save(p);
    }

    @Override
    public Doctor saveDoctor(Doctor d) {
        return doctorRepository.save(d);
    }

    @Override
    public Doctor findDoctorById(Long Id) {
        return doctorRepository.findById(Id).orElse(null);
    }

    @Override
    public Doctor findDoctorByName(String name) {
        return doctorRepository.findDoctorByName(name);
    }


    @Override
    public Appointment saveAppointment(Appointment ap) {
        //ap.setId(UUID.randomUUID().toString()); have to set id as string first
//        Appointment ap = appointmentRepository.findAll().get(0); how to search by id in case id is string
        return appointmentRepository.save(ap);
    }

    @Override
    public Consultation saveConsultation(Consultation c) {
        return consultationRepository.save(c);
    }
}
