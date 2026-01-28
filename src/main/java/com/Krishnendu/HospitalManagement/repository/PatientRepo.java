package com.Krishnendu.HospitalManagement.repository;

import com.Krishnendu.HospitalManagement.dto.BloodGroupCountResponseEntity;
import com.Krishnendu.HospitalManagement.enums.BloodGroup;
import com.Krishnendu.HospitalManagement.model.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
    List<Patient> findByFirstNameOrLastName(String firstName, String lastName);

    @Query("SELECT p FROM Patient p where p.gender = ?1 AND p.bloodGroup = ?2")
    List<Patient> findByBloodGroup(@Param("gender") String gender, @Param("bloodGroup") BloodGroup bloodGroup);

    @Query("SELECT p FROM Patient p WHERE p.birthDate > :birthDateParam")
    List<Patient> findByBirthdateAfterDate(@Param("birthDateParam")LocalDate birthDate);

    @Query("SELECT new com.Krishnendu.HospitalManagement.dto.BloodGroupCountResponseEntity (p.bloodGroup , count(p)) " +
            "from Patient p group by p.bloodGroup")
    //List<Object[]> countEachBloodGroupType();
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> findAllPatient(Pageable pageable); // example of using RAW sql query - table name here should be same as DB

    @Transactional // adding this because of testing . No need in this flow => controller--->service--->repository
    @Modifying // we have to mention this here for queries which will update the DB
    @Query("UPDATE Patient p set p.firstName = :firstName where p.id = :id")
    int updateFirstNameWithId(@Param("firstName") String firstName, @Param("id") Long id);


    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN FETCH a.doctor")
    List<Patient> findAllPatientWithAppointment();
}
