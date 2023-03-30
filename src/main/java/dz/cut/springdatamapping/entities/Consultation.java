package dz.cut.springdatamapping.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date consultationDate;
    private String consultationReport;
    private double consultationPrice;
    @OneToOne
    // Write Only to avoid cyclic dependency
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Appointment appointment;
}
