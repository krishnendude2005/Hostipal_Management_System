package com.Krishnendu.HospitalManagement.repository;

import com.Krishnendu.HospitalManagement.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
}
