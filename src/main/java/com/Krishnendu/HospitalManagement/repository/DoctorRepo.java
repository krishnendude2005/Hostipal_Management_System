package com.Krishnendu.HospitalManagement.repository;

import com.Krishnendu.HospitalManagement.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {
}
