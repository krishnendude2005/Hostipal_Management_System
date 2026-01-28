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
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        insuranceService.assignInsuranceToPatient(insurance,2L);
    }

    @Test
    public void testRemoveInsurance() {
        insuranceService.removeInsuranceFromPatient(2L);
    }
}
