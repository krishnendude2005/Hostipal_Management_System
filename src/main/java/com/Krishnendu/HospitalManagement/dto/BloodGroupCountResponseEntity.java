package com.Krishnendu.HospitalManagement.dto;

import com.Krishnendu.HospitalManagement.enums.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodGroupCountResponseEntity {

    private BloodGroup bloodGroup;
    private long count;
}
