package com.Krishnendu.HospitalManagement;

import com.Krishnendu.HospitalManagement.dto.BloodGroupCountResponseEntity;
import com.Krishnendu.HospitalManagement.enums.BloodGroup;
import com.Krishnendu.HospitalManagement.model.Patient;
import com.Krishnendu.HospitalManagement.repository.PatientRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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
        patient.setBirthDate(LocalDate.of(2002, 7, 15));
        patient.setEmail("krishnendu.de@gmail.com");

        patientRepo.save(patient);
    }
    @Test
    public void testFindByName() {
        List<Patient> patient = patientRepo.findByFirstNameOrLastName("Krishnendu", "De");
        System.out.println(patient);
    }

    @Test
    public void testFindByBloodGroup() {
        List<Patient> patients = patientRepo.findByBloodGroup("Male",BloodGroup.AB_POSITIVE);
        System.out.println(patients);
    }

    @Test
    public void testFindByBirthDateAfterDate() {
        List<Patient> patientList = patientRepo.findByBirthdateAfterDate(LocalDate.ofEpochDay(2002- 7 -15));
        System.out.println(patientList);
    }

    @Test
    public void testCountByBloodGroup() {
        List<BloodGroupCountResponseEntity> countDetails = patientRepo.countEachBloodGroupType();
        for (var row : countDetails) {
            System.out.println(row.getBloodGroup() + " -> " + row.getCount());
        }
    }

    @Test
    public void testFindALlPatient() {
//        System.out.println(patientRepo.findAllPatient(PageRequest.ofSize(2)));

        int page = 0;
        int pageSize = 2;

        Page<Patient> result = null;

        do {
            result = patientRepo.findAllPatient(PageRequest.of(page, pageSize));
            System.out.println(result.getContent());
            page++;
        } while (!result.isLast());
    }

    @Test
    public void testUpdatePatient() {
        int updated = patientRepo.updateFirstNameWithId("Krishnenduu", 2L);
        System.out.println(updated);
    }
}
