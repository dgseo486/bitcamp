# 실습에 필요한 테이블 생성

##mysql 로그인 및 유저 등록, 사용자 권한 주기
mysql -u root -p
root1234!@#$

CREATE USER 'java106'@'localhost' identified by '1111';

show databases;

use mysql

show tables;

desc mysql.user;

select Host, User from mysql.user;

CREATE DATABASE java106db DEFAULT character set utf8
    default collate utf8_general_ci;
    
GRANT ALL ON java106db.* TO 'java106'@'localhost';

quit

## 게시판 테이블 생성
create table ex_board (
    bno int not null,
    titl varchar(255) not null,
    cont text,
    rdt datetime not null
);

## 테이블의 주키(primary key; PK) 컬럼을 설정
alter table ex_board
    add constraint ex_board_pk primary key (bno);
    
## PK 컬럼 'bno'의 값을 자동으로 증가하도록 설정
주의! primary key 컬럼인 경우에만 자동 증가를 설정할 수 있다. 일반 컬럼은 안된다.

alter table ex_board
    modify column bno int not null auto_increment;
    
## ex_board의 설정 상태 보기
describe ex_board; or desc ex_board;

## 데이터 입력
insert into ex_board(titl, cont, rdt) values('subject1', 'contents1', now());
insert into ex_board(titl, cont, rdt) values('subject2', 'contents2', now());
insert into ex_board(titl, cont, rdt) values('subject3', 'contents3', now());
insert into ex_board(titl, cont, rdt) values('subject4', 'contents4', now());
insert into ex_board(titl, cont, rdt) values('subject5', 'contents5', now());
insert into ex_board(titl, cont, rdt) values('subject6', 'contents6', now());
insert into ex_board(titl, cont, rdt) values('subject7', 'contents7', now());
insert into ex_board(titl, cont, rdt) values('subject8', 'contents8', now());
insert into ex_board(titl, cont, rdt) values('subject9', 'contents9', now());
insert into ex_board(titl, cont, rdt) values('subject10', 'contents10', now());

## 데이터 조회
select * from ex_board; or select bno, titl, cont, rdt from ex_board;

## 데이터 변경
update ex_board set titl='okok' where bno=7;

## 데이터 삭제
delete from ex_board where bno=8;
