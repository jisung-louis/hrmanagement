#[1] 데이터베이스 생성 
drop database if exists hrmanagement;
create database hrmanagement;
use hrmanagement;

#[2] 테이블 생성 
create table dept(
	dno int auto_increment,
    constraint primary key(dno),
    dname varchar(30) not null
);
create table emp(
	eno int auto_increment,
    constraint primary key(eno),
    ename varchar(30) not null,
    clsf varchar(20),
    dno int,
    constraint foreign key(dno) references dept(dno)
);
create table vacation(
	vno int auto_increment,
    constraint primary key(vno),
    eno int,
    constraint foreign key(eno) references emp(eno),
    start_date datetime,
    end_date datetime,
    reason varchar(30)
);

#[3] 테이블 샘플 데이터 10개 ( AI 활용 ) 
insert into dept(dname) values
('인사팀'),
('총무팀'),
('개발1팀'),
('개발2팀'),
('마케팅팀'),
('영업팀'),
('재무팀'),
('기획팀'),
('디자인팀'),
('품질관리팀');
insert into emp(ename, clsf, dno) values
('김민수', '사원', 1),
('이영희', '대리', 2),
('박지훈', '과장', 3),
('최수진', '차장', 4),
('정우성', '부장', 5),
('한지민', '사원', 6),
('오세훈', '대리', 7),
('윤아름', '과장', 8),
('강동원', '차장', 9),
('신예은', '사원', 10);
insert into vacation(eno, start_date, end_date, reason) values
(1, '2026-03-01 09:00:00', '2026-03-03 18:00:00', '가족여행'),
(2, '2026-04-10 09:00:00', '2026-04-12 18:00:00', '개인사정'),
(3, '2026-05-15 09:00:00', '2026-05-18 18:00:00', '병가'),
(4, '2026-06-01 09:00:00', '2026-06-02 18:00:00', '연차'),
(5, '2026-07-20 09:00:00', '2026-07-25 18:00:00', '해외여행'),
(6, '2026-08-05 09:00:00', '2026-08-07 18:00:00', '교육참석'),
(7, '2026-09-10 09:00:00', '2026-09-12 18:00:00', '병가'),
(8, '2026-10-03 09:00:00', '2026-10-04 18:00:00', '가족행사'),
(9, '2026-11-15 09:00:00', '2026-11-20 18:00:00', '연차'),
(10,'2026-12-01 09:00:00', '2026-12-03 18:00:00', '개인사정');

#[4] 확인
select * from dept;
select * from emp;
select * from vacation;
