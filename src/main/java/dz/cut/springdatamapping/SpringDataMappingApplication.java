package dz.cut.springdatamapping;


import dz.cut.springdatamapping.entities.*;
import dz.cut.springdatamapping.repositories.AppointmentRepository;
import dz.cut.springdatamapping.repositories.ConsultationRepository;
import dz.cut.springdatamapping.repositories.DoctorRepository;
import dz.cut.springdatamapping.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class SpringDataMappingApplication   {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {

        SpringApplication.run(SpringDataMappingApplication.class, args);
    }


    // @Bean
    CommandLineRunner start(PatientRepository patientRepository,
                            DoctorRepository doctorRepository,
                            AppointmentRepository appointmentRepository,
                            ConsultationRepository consultationRepository){
        return args -> {

//        patientRepository.save(new Patient(null,"Ahmed","ahmed@hotmail.com",true,null));

//      to avoid inserting null in constructor
        Patient p1 = new Patient();
        p1.setName("khaled");
        p1.setEmail("khaled@hotmail.com");
        p1.setBirthDate(new Date());
        p1.setSick(true);
        patientRepository.save(p1);

        Patient p2 = new Patient();
        p2.setName("Amine");
        p2.setEmail("amine@hotmail.com");
        p2.setBirthDate(new Date());
        p2.setSick(false);
        patientRepository.save(p2);

        // Creating two records in Doctors table
        Doctor d1 = new Doctor();
        d1.setName("Mahrez");
        d1.setEmail("mahrez@gmail.com");
        d1.setSpeciality("Cardio");
        doctorRepository.save(d1);

        Doctor d2 = new Doctor();
        d2.setName("Messi");
        d2.setEmail("messi@gmail.com");
        d2.setSpeciality("Dentist");
        doctorRepository.save(d2);

        // Appointment Creation
        Appointment ap1 = new Appointment();
        ap1.setPatient(p1);
        ap1.setDoctor(d1);
        ap1.setAppointmentDate(new Date());
        ap1.setStatus(AppointmentStatus.PENDING);
        appointmentRepository.save(ap1);

        // Consultation Creation
        Consultation c1 = new Consultation();
        c1.setAppointment(ap1);
        c1.setConsultationDate(new Date());
        c1.setConsultationReport("will die soon !");
        c1.setConsultationPrice(100.5);
        consultationRepository.save(c1);

        Doctor d3 = doctorRepository.findById(1L).orElse(null);
        System.out.println("Doctor name : "+d3.getName());


        };




    }








}
