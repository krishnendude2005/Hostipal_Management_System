package com.Krishnendu.HospitalManagement.model;

import com.Krishnendu.HospitalManagement.enums.BloodGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "patient_email_birthdate",
                        columnNames = {"email", "birth_date"}
                )
        },
        indexes = {
                @Index(name = "idx_patient_name", columnList = "first_name, last_name")
        }

)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    @ToString.Exclude
    private LocalDate birthDate;
    private String email;
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "patient_insurance_id") // owning side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<Appointment> appointments;

}
