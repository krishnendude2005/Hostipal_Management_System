package com.Krishnendu.HospitalManagement;

import com.Krishnendu.HospitalManagement.model.Insurance;
import com.Krishnendu.HospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testInsurance() {
        Insurance insurance1 = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030,12,12))
                .build();
        Insurance insurance2 = Insurance.builder()
                .policyNumber("HDFC2_1234")
                .provider("HDFC2")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        Insurance insurance3 = Insurance.builder()
                .policyNumber("HDFC3_1234")
                .provider("HDFC3")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        insuranceService.assignInsuranceToPatient(insurance1,2L);
        insuranceService.assignInsuranceToPatient(insurance2,2L);
        insuranceService.assignInsuranceToPatient(insurance3,2L);
    }

    @Test
    public void testRemoveInsurance() {
        insuranceService.removeInsuranceFromPatient(2L);
    }
}
