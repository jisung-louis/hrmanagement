package com.team2.hrmanagement.controller;


import com.team2.hrmanagement.model.dao.DeptDao;
import com.team2.hrmanagement.model.dto.DeptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController { //부서컨트롤러

    @Autowired //의존성 주입 등록된 deptdao객체 가져오기
    private DeptDao deptDao;


    //1.모든 부서 조회기능
    @GetMapping
    public ArrayList<DeptDto> findAllDept(){
        ArrayList<DeptDto> result=deptDao.findAllDept();
        return result;
    }




    //2.부서 추가
    @PostMapping
    public boolean deptPost(DeptDto deptDto){
        boolean result=deptDao.deptPost(deptDto);
        return result;
    }


    //3.부서명 수정

    @PutMapping
    public boolean deptUpdate(DeptDto deptDto){
        boolean result=deptDao.deptUpdate(deptDto);
        return result;
    }

    //4.부서 삭제
    @DeleteMapping
    public boolean deptDelete(DeptDto deptDto){
        boolean result=deptDao.deptDelete(deptDto);
        return result;
    }

    //4.부서 삭제

}
