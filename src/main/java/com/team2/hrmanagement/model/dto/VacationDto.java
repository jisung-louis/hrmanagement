package com.team2.hrmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VacationDto {
    private int vno;
    private int eno;
    private String startDate;
    private String endDate;
    private String reason;
}
