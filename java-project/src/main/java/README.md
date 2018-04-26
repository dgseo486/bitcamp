애플리케이션 소스 폴더

drop table pms_board;

create table pms_board(
    bno int not null,
    titl varchar(255) not null,
    cont text,
    cdt datetime not null
);

alter table pms_board
    add constraint pms_board_pk primary key (bno);
    
alter table pms_board
    modify column bno int not null auto_increment;
    


drop table pms_member;

create table pms_member(
    mid varchar(20) not null,
    email varchar(255) not null,
    pwd varchar(100) not null
);

ALTER TABLE pms_member
    ADD CONSTRAINT pms_member_pk PRIMARY KEY (mid);
    
    

DROP TABLE pms_classroom;

create table pms_classroom(
    crno int not null,
    titl varchar(255) not null,
    sdt datetime not null,
    edt datetime not null,
    room varchar(50)
);

ALTER TABLE pms_classroom
    ADD CONSTRAINT pms_classroom_pk PRIMARY KEY(crno);
    
alter table pms_classroom
    modify column crno int not null auto_increment;
    
    
    
DROP TABLE pms_team;

CREATE TABLE pms_team(
    name varchar(100) not null,
    dscrt text,
    max_qty int not null,
    sdt datetime not null,
    edt datetime not null
);

ALTER TABLE pms_team
    ADD CONSTRAINT pms_team_pk PRIMARY KEY (name);
    
    

DROP TABLE pms_task;

CREATE TABLE pms_task(
    tano int not null,
    titl varchar(255) not null,
    sdt datetime not null,
    edt datetime not null,
    stat int default 0,
    mid varchar(20) not null,
    tnm varchar(100) not null
);

ALTER TABLE pms_task
    ADD CONSTRAINT pms_task_pk PRIMARY KEY (tano);
    
ALTER TABLE pms_task
    MODIFY COLUMN tano INT NOT NULL AUTO_INCREMENT;
    
    
    
DROP TABLE pms_team_member;

CREATE TABLE pms_team_member(
    tnm varchar(100) not null,
    mid varchar(20) not null
);

ALTER TABLE pms_team_member
    ADD CONSTRAINT pms_team_member_pk PRIMARY KEY (tnm, mid);