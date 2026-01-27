package com.Krishnendu.HospitalManagement.repository;

import com.Krishnendu.HospitalManagement.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
