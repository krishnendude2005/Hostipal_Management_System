package com.Krishnendu.HospitalManagement.service;

import com.Krishnendu.HospitalManagement.model.Appointment;
import com.Krishnendu.HospitalManagement.model.Doctor;
import com.Krishnendu.HospitalManagement.model.Patient;
import com.Krishnendu.HospitalManagement.repository.AppointmentRepo;
import com.Krishnendu.HospitalManagement.repository.DoctorRepo;
import com.Krishnendu.HospitalManagement.repository.PatientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepo appointmentRepo;
    private final DoctorRepo doctorRepo;
    private final PatientRepo patientRepo;

    @Transactional
    public void createNewAppointment(Appointment appointment, Long doctorID, Long patientID){
        Doctor doctor = doctorRepo.findById(doctorID).orElseThrow();
        Patient patient = patientRepo.findById(patientID).orElseThrow();

        // check among these 3 which one owns the relationship --- then we have to set in that element
        // here --- appointment(JoinColumn) owns the relationship , so we have to set in the appointment

        if(appointment.getId() != null) throw  new IllegalArgumentException("New appointment cannot exist in the database previously");

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        // bi-directional consistency
        doctor.getAppointments().add(appointment);
        patient.getAppointments().add(appointment);

        appointmentRepo.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointment(Long appointmentID, Long newDoctorID){
        Appointment appointment = appointmentRepo.findById(appointmentID).orElseThrow();
        Doctor newDoctor = doctorRepo.findById(newDoctorID).orElseThrow();

        // who owns the relationship ? => Appointment
        appointment.setDoctor(newDoctor);
        newDoctor.getAppointments().add(appointment);

        return appointment;
    }
}
