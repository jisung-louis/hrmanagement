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
    public int deptPost(@RequestBody DeptDto deptDto){
        // 유효성 검사 (중복 체크)
        ArrayList<DeptDto> allDept = deptDao.findAllDept();
        for (int i = 0; i < allDept.size(); i++) {
            String dname = allDept.get(i).getDname(); // DB에서 가져온 부서 중 하나의 부서명 값
            String input = deptDto.getDname(); // 사용자로부터 입력 받은 부서명 값
            if(dname.equals(input)){
                return 3;
            }
        }

        // 유효성 검사(공백값이 들어왔는지 체크)
        if(deptDto.getDname()==""){
            return 2;
        }
        System.out.println("입력 deptDto = " + deptDto);
        boolean result=deptDao.deptPost(deptDto);
        return result ? 1 : 0;

    }


    //3.부서명 수정

    //모든 부서명 받아와서
    //부서명 배열
    @PutMapping
    public boolean deptUpdate(@RequestBody DeptDto deptDto){

        boolean result=deptDao.deptUpdate(deptDto);
        return result;
    }

    //4.부서 삭제
    @DeleteMapping
    public boolean deptDelete(@RequestParam int dno){
        boolean result=deptDao.deptDelete(dno);
        return result;
    }

    //4.부서 삭제

}
