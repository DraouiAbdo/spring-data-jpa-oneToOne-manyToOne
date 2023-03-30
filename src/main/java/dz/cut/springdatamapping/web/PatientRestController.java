package dz.cut.springdatamapping.web;

import dz.cut.springdatamapping.entities.Patient;
import dz.cut.springdatamapping.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> showAllPatients(){
        return patientRepository.findAll();
    }

}
