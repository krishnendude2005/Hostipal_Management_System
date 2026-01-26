package com.Krishnendu.HospitalManagement;

import com.Krishnendu.HospitalManagement.model.Patient;
import com.Krishnendu.HospitalManagement.repository.PatientRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepo patientRepo;

    @Test
    public void testPatientRepository() {
        List<Patient> patients = patientRepo.findAll();
        System.out.println(patients);
    }

    @Test
    public void testSavePatient() {
        Patient patient = new Patient();
        patient.setFirstName("Krishnendu");
        patient.setLastName("De");
        patient.setGender("Male");
        patient.setBirthDate(LocalDate.of(2003, 7, 15));
        patient.setEmail("krishnendu.de@gmail.com");

        patientRepo.save(patient);
    }
    @Test
    public void testFindByName() {
        Patient patient = patientRepo.findByFirstNameOrLastName("Krishnendu", "De");
        System.out.println(patient);
    }
}
