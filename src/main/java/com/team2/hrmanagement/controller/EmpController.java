package com.team2.hrmanagement.controller;

import com.team2.hrmanagement.model.dao.EmpDao;
import com.team2.hrmanagement.model.dto.EmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/emp")
public class EmpController {
    // 1. Dao 의존성 주입
    @Autowired
    EmpDao empDao;

    // 2. 컨트롤러 함수 (API 명세서 대로)
    // TODO : 서비스 로직 (유효성 검사 등) 넣기
    @GetMapping
    public ArrayList<EmpDto> getEmpAll(){
        return empDao.findAll();
    }

    @PostMapping
    public boolean registerEmp(@RequestBody EmpDto empDto){
        return empDao.create(empDto);
    }

    @PutMapping
    public boolean updateEmp(@RequestBody EmpDto empDto){
        return empDao.update(empDto);
    }

    @DeleteMapping
    public boolean deleteEmp(@RequestParam int eno){
        return empDao.delete(eno);
    }
}
