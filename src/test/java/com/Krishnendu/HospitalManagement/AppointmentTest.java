package com.Krishnendu.HospitalManagement;

import com.Krishnendu.HospitalManagement.model.Appointment;
import com.Krishnendu.HospitalManagement.repository.AppointmentRepo;
import com.Krishnendu.HospitalManagement.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {


    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private AppointmentRepo appointmentRepo;

    @Test
    public void testCreateNewAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 12, 1, 14, 20, 20))
                .reason("Headache")
                .build();


        appointmentService.createNewAppointment(appointment, 2L, 2L);

    }

    @Test
    public void testReassignAppointment() {
        Appointment app = appointmentService.reAssignAppointment(1L, 2L);
        System.out.println(app.getAppointmentTime());
    }
}
