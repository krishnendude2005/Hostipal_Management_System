package com.Krishnendu.HospitalManagement.service;

import com.Krishnendu.HospitalManagement.model.Insurance;
import com.Krishnendu.HospitalManagement.model.Patient;
import com.Krishnendu.HospitalManagement.repository.InsuranceRepo;
import com.Krishnendu.HospitalManagement.repository.PatientRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {

    public InsuranceService(InsuranceRepo insuranceRepo, PatientRepo patientRepo) {
        this.insuranceRepo = insuranceRepo;
        this.patientRepo = patientRepo;
    }

    private final InsuranceRepo insuranceRepo;
    private final PatientRepo patientRepo;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + patientId));


        patient.setInsurance(insurance);

        return patient;
    }
}
