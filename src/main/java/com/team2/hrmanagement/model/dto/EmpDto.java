package com.team2.hrmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpDto {
    private Integer eno;
    private String ename;
    private String clsf; // 직급 (CLaSs oF position)
    private Integer dno;
}
