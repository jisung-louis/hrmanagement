package com.team2.hrmanagement.controller;

import com.team2.hrmanagement.model.dao.VacationDao;
import com.team2.hrmanagement.model.dto.EmpDto;
import com.team2.hrmanagement.model.dto.VacationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/vacation")
public class VacationController {
    // 1. Dao 의존성 주입
    @Autowired
    VacationDao vacationDao;

    // 2. 컨트롤러 함수 (API 명세서 대로)
    // TODO : 서비스 로직 (유효성 검사 등) 넣기
    @GetMapping
    public ArrayList<VacationDto> getEmpAll(){
        return vacationDao.findAll();
    }

    @PostMapping
    public boolean registerEmp(@RequestBody VacationDto vacationDto){
        return vacationDao.create(vacationDto);
    }

    @DeleteMapping
    public boolean deleteEmp(@RequestParam int vno){
        return vacationDao.delete(vno);
    }
}
