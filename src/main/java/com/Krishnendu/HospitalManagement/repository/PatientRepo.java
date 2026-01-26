package com.Krishnendu.HospitalManagement.repository;

import com.Krishnendu.HospitalManagement.enums.BloodGroup;
import com.Krishnendu.HospitalManagement.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
    Patient findByFirstNameOrLastName(String firstName, String lastName);

    @Query("SELECT p FROM Patient p where p.gender = ?1 AND p.bloodGroup = ?2")
    List<Patient> findByBloodGroup(@Param("gender") String gender, @Param("bloodGroup") BloodGroup bloodGroup);

    @Query("SELECT p FROM Patient p WHERE p.birthDate > :birthDateParam")
    List<Patient> findByBirthdateAfterDate(@Param("birthDateParam")LocalDate birthDate);

    @Query("SELECT p.bloodGroup , count(*) from Patient p group by p.bloodGroup")
    List<Object[]> countEachBloodGroupType();

    @Query(value = "select * from patient", nativeQuery = true)
    public List<Patient> findAllPatient(); // example of using RAW sql query - table name here should be  is same as DB
}
