package dz.cut.springdatamapping.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private boolean sick;
    @OneToMany(mappedBy = "patient", fetch=FetchType.LAZY)
    private List<Appointment> appointment;
}
