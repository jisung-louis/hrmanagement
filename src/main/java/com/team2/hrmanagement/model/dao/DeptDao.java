package com.team2.hrmanagement.model.dao;


import com.team2.hrmanagement.model.dto.DeptDto;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component //빈 등록
public class DeptDao {

    public DeptDao() {
        connent();
    }

    //=============DB연동==========//
    //1.연동할 DB정보
    private String url = "jdbc:mysql://localhost:3306/hrmanagement";
    private String user = "root";
    private String pw = "1234";

    //2.연동 인터페이스 선언

    private Connection conn;

    //연동 함수 정의

    private void connent() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pw);
            System.out.println("db 연동 성공");
        } catch (Exception e) {
            System.out.println(e);
        }

    } //connent end


    //1.부서 전체 조회
    public ArrayList<DeptDto> findAllDept() {
        ArrayList<DeptDto> list = new ArrayList<>();
        try {
            String sql = "select * from dept";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DeptDto deptDto = new DeptDto(rs.getInt("dno"),
                        rs.getString("name"));
                list.add(deptDto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    } //class end


    //2.부서 추가
    public boolean deptPost(DeptDto deptDto) {
        try {
            String sql = "insert into dept(dno,name) values(?,?)"; //1.sql 작성
            PreparedStatement ps = conn.prepareStatement(sql); //2.sql 등록
            ps.setInt(1, deptDto.getDno()); ///3.첫번째 매개변수 값에 대입
            ps.setString(2, deptDto.getName());  ///3.두번째 매개변수 값에 대입
            int count = ps.executeUpdate(); //sql 실행하고 반영한 레코드 수를 저장한다.
            if (count == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    } //

    //3.부서 수정
    public boolean deptUpdate(DeptDto deptDto) {
        try {
            String sql = "update dept set name=? where dno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, deptDto.getName());
            ps.setInt(2, deptDto.getDno());
            int count = ps.executeUpdate(); //sql 실행하고 반영한 레코드 수를 저장한다.
            if (count == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    //4.부서 삭제
    //4.부서 삭제
    public boolean deptDelete (DeptDto deptDto){
        try{
            String sql="delete from dept where dno=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,deptDto.getDno());
            int count=ps.executeUpdate();
            if(count==1){
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    } //func end

}//class end