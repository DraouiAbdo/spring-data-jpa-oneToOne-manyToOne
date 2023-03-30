package dz.cut.springdatamapping.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private String email;
    private String speciality;

    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY)
    // Write Only to avoid cyclic dependency
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Appointment> appointment;
}
