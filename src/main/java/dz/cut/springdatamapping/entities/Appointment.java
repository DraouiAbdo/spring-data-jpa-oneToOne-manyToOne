package dz.cut.springdatamapping.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private String id; for showing UUID use
    @Temporal(TemporalType.DATE)
    private Date appointmentDate;

    // @Enumerated(EnumType.STRING) to save enumration value as string not as integer
    @Enumerated(EnumType.STRING)
    private  AppointmentStatus status;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @OneToOne(mappedBy = "appointment")

    // Write Only to avoid cyclic dependency
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Consultation consultation;
}
