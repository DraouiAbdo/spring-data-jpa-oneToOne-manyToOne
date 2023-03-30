package dz.cut.springdatamapping;


import dz.cut.springdatamapping.entities.*;
import dz.cut.springdatamapping.repositories.AppointmentRepository;
import dz.cut.springdatamapping.repositories.ConsultationRepository;
import dz.cut.springdatamapping.repositories.DoctorRepository;
import dz.cut.springdatamapping.repositories.PatientRepository;
import dz.cut.springdatamapping.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataMappingApplication3 {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {

        SpringApplication.run(SpringDataMappingApplication3.class, args);
    }


    @Bean
    CommandLineRunner start(IHospitalService hospitalService){
        return args -> {

//      dummy data creation in Patients table

        Stream.of("Khaled","Amine")
                .forEach(name -> {
                    Patient p = new Patient();
                    p.setName(name);
                    p.setEmail(name+"@hotmail.com");
                    p.setBirthDate(new Date());
                    p.setSick(Math.random()>0.5?false:true);
                    hospitalService.savePatient(p);
                });
        // dummy data creation in Patients table
        Stream.of("Mahrez","Messi")
                .forEach(name -> {
                    Doctor d = new Doctor();
                    d.setName(name);
                    d.setEmail(name+"@gmail.com");
                    d.setSpeciality(Math.random()>0.5?"Dentist":"Cardio");
                    hospitalService.saveDoctor(d);
                });

        // Appointment Creation
        Appointment ap1 = new Appointment();

        Patient p = patientRepository.findById(2L).orElse(null);
        ap1.setPatient(p);

        Doctor d = hospitalService.findDoctorById(1L);
        ap1.setDoctor(d);

        ap1.setAppointmentDate(new Date());
        ap1.setStatus(AppointmentStatus.PENDING);
        hospitalService.saveAppointment(ap1);

        // Consultation Creation
        Consultation c1 = new Consultation();
        c1.setAppointment(ap1);
        c1.setConsultationDate(new Date());
        c1.setConsultationReport("will die soon !");
        c1.setConsultationPrice(100.5);
        hospitalService.saveConsultation(c1);

        // if there are multiple persons with same name will through an error
        Doctor d3 = hospitalService.findDoctorByName("Messi");
        System.out.println("Doctor name : "+d3.getName());

        
        };




    }








}
