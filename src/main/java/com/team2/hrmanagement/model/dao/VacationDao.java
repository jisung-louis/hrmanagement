package com.team2.hrmanagement.model.dao;

import com.team2.hrmanagement.model.dto.EmpDto;
import com.team2.hrmanagement.model.dto.VacationDto;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

@Component
public class VacationDao {
    public VacationDao(){ connect(); } // 스프링이 빈 등록을 할 때 (객체 생성을 하면서 생성자 내부 코드가 발동되므로) connect() 함수 실행됨.

    // ====== 데이터베이스 연동 =======
    // 1) 연동할 DB서버의 정보
    private String url = "jdbc:mysql://localhost:3306/hrmanagement";
    private String user = "root";
    private String password = "1234";
    // 2) 연동 인터페이스 선언
    private Connection conn;

    // 3) 연동 함수 선언 , dao에 생성자에서 함수 실행(dao 싱글톤이 생성되면서 db 연동 실행)
    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("**** 데이터베이스 연동 성공 ****");
        } catch (ClassNotFoundException e) {
            System.out.printf("[경고] MySQL 드라이버를 못 찾았어요.\n%s\n", e);
        } catch (SQLException e) {
            System.out.printf("[경고] DB랑 통신하다가 문제가 생겼어요.\n%s\n", e);
        }
    }
    // ====== 데이터베이스 연동 끝 ======

    // 1. 모든 휴가신청목록 조회
    public ArrayList<VacationDto> findAll(){
        ArrayList<VacationDto> list = new ArrayList<>();
        try{
            String sql = "select * from vacation";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int vno = rs.getInt("vno");
                int eno = rs.getInt("eno");
                String startDate = rs.getString("start_date");
                String endDate = rs.getString("end_date");
                String reason = rs.getString("reason");
                VacationDto vacationDto = new VacationDto(vno, eno, startDate, endDate, reason);
                list.add(vacationDto);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        return list;
    }

    // 2. 휴가 신청
    public boolean create(VacationDto vacationDto){
        try{
            String sql = "insert into vacation(eno, start_date, end_date, reason) values(?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, vacationDto.getEno());
            ps.setString(2, vacationDto.getStartDate());
            ps.setString(3, vacationDto.getEndDate());
            ps.setString(4, vacationDto.getReason());
            int count = ps.executeUpdate(); // 반영된 레코드 수 반환
            if( count == 1 ) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // 3. 휴가 신청 취소
    public boolean delete(int vno){
        try{
            String sql = "delete from vacation where vno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, vno);
            int count = ps.executeUpdate(); // 반영된 레코드 수 반환
            if( count == 1 ) return true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
