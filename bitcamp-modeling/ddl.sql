-- ������û
DROP TABLE IF EXISTS APPL RESTRICT;

-- ����
DROP TABLE IF EXISTS TCHR RESTRICT;

-- �����
DROP TABLE IF EXISTS MGR RESTRICT;

-- ����
DROP TABLE IF EXISTS CLS_RM RESTRICT;

-- �Խ���
DROP TABLE IF EXISTS BOARD RESTRICT;

-- ����
DROP TABLE IF EXISTS LECT RESTRICT;

-- �������
DROP TABLE IF EXISTS TCHR_PHOT RESTRICT;

-- ���ǻ���
DROP TABLE IF EXISTS CLS_PHOT RESTRICT;

-- �л�
DROP TABLE IF EXISTS STUD RESTRICT;

-- �ּ�
DROP TABLE IF EXISTS ADDR RESTRICT;

-- �������
DROP TABLE IF EXISTS LECT_TCHR RESTRICT;

-- �����
DROP TABLE IF EXISTS USER RESTRICT;

-- ������û
CREATE TABLE APPL (
	ANO      INTEGER      NOT NULL COMMENT '������û��ȣ', -- ������û��ȣ
	LNO      INTEGER      NOT NULL COMMENT '���¹�ȣ', -- ���¹�ȣ
	RDT      DATE         NOT NULL COMMENT '������û��', -- ������û��
	RSLT     VARCHAR(10)  NULL     COMMENT '��û���', -- ��û���
	RSLT_MSG VARCHAR(255) NULL     COMMENT '��û�������', -- ��û�������
	SNO      INTEGER      NULL     COMMENT '������û�ڹ�ȣ' -- ������û�ڹ�ȣ
)
COMMENT '������û';

-- ������û
ALTER TABLE APPL
	ADD CONSTRAINT PK_APPL -- ������û �⺻Ű
		PRIMARY KEY (
			ANO -- ������û��ȣ
		);

ALTER TABLE APPL
	MODIFY COLUMN ANO INTEGER NOT NULL AUTO_INCREMENT COMMENT '������û��ȣ';

-- ����
CREATE TABLE TCHR (
	TNO INTEGER NOT NULL COMMENT '�����ȣ', -- �����ȣ
	COL INTEGER NULL     COMMENT '�ð���' -- �ð���
)
COMMENT '����';

-- ����
ALTER TABLE TCHR
	ADD CONSTRAINT PK_TCHR -- ���� �⺻Ű
		PRIMARY KEY (
			TNO -- �����ȣ
		);

ALTER TABLE TCHR
	MODIFY COLUMN TNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '�����ȣ';

-- �����
CREATE TABLE MGR (
	MNO  INTEGER      NOT NULL COMMENT '����ڹ�ȣ', -- ����ڹ�ȣ
	COL4 VARCHAR(255) NULL     COMMENT '����' -- ����
)
COMMENT '�����';

-- �����
ALTER TABLE MGR
	ADD CONSTRAINT PK_MGR -- ����� �⺻Ű
		PRIMARY KEY (
			MNO -- ����ڹ�ȣ
		);

-- ����
CREATE TABLE CLS_RM (
	CRNO INTEGER     NOT NULL COMMENT '���ǹ�ȣ', -- ���ǹ�ȣ
	LOC  VARCHAR(50) NOT NULL COMMENT '����', -- ����
	TITL VARCHAR(50) NOT NULL COMMENT '���Ǹ�', -- ���Ǹ�
	CAPA INTEGER     NOT NULL COMMENT '�ִ�����ο�' -- �ִ�����ο�
)
COMMENT '����';

-- ����
ALTER TABLE CLS_RM
	ADD CONSTRAINT PK_CLS_RM -- ���� �⺻Ű
		PRIMARY KEY (
			CRNO -- ���ǹ�ȣ
		);

ALTER TABLE CLS_RM
	MODIFY COLUMN CRNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '���ǹ�ȣ';

-- �Խ���
CREATE TABLE BOARD (
	BNO   INTEGER      NOT NULL COMMENT '�Խù���ȣ', -- �Խù���ȣ
	TITL  VARCHAR(255) NOT NULL COMMENT '����', -- ����
	CONTS TEXT         NOT NULL COMMENT '����', -- ����
	CDT   DATETIME     NOT NULL COMMENT '�����', -- �����
	VWCNT INTEGER      NULL     COMMENT '��ȸ��', -- ��ȸ��
	PWD   VARCHAR(150) NULL     COMMENT '��ȣ' -- ��ȣ
)
COMMENT '�Խ���';

-- �Խ���
ALTER TABLE BOARD
	ADD CONSTRAINT PK_BOARD -- �Խ��� �⺻Ű
		PRIMARY KEY (
			BNO -- �Խù���ȣ
		);

ALTER TABLE BOARD
	MODIFY COLUMN BNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '�Խù���ȣ';

-- ����
CREATE TABLE LECT (
	LNO   INTEGER      NOT NULL COMMENT '���¹�ȣ', -- ���¹�ȣ
	TITL  VARCHAR(255) NOT NULL COMMENT '���Ǹ�', -- ���Ǹ�
	CONTS TEXT         NOT NULL COMMENT '����', -- ����
	SDT   DATE         NOT NULL COMMENT '������', -- ������
	EDT   DATE         NOT NULL COMMENT '������', -- ������
	CAPA  INTEGER      NOT NULL COMMENT '����', -- ����
	CRNO  INTEGER      NULL     COMMENT '���ǹ�ȣ', -- ���ǹ�ȣ
	id    INTEGER      NULL     COMMENT '����ڹ�ȣ' -- ����ڹ�ȣ
)
COMMENT '����';

-- ����
ALTER TABLE LECT
	ADD CONSTRAINT PK_LECT -- ���� �⺻Ű
		PRIMARY KEY (
			LNO -- ���¹�ȣ
		);

-- ���� �ε���
CREATE INDEX IX_LECT
	ON LECT( -- ����
		TITL ASC -- ���Ǹ�
	);

ALTER TABLE LECT
	MODIFY COLUMN LNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '���¹�ȣ';

-- �������
CREATE TABLE TCHR_PHOT (
	TPNO INTEGER      NOT NULL COMMENT '���������ȣ', -- ���������ȣ
	PATH VARCHAR(255) NOT NULL COMMENT '����', -- ����
	TNO  INTEGER      NOT NULL COMMENT '�����ȣ' -- �����ȣ
)
COMMENT '�������';

-- �������
ALTER TABLE TCHR_PHOT
	ADD CONSTRAINT PK_TCHR_PHOT -- ������� �⺻Ű
		PRIMARY KEY (
			TPNO -- ���������ȣ
		);

ALTER TABLE TCHR_PHOT
	MODIFY COLUMN TPNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '���������ȣ';

-- ���ǻ���
CREATE TABLE CLS_PHOT (
	CPNO <������ Ÿ�� ����> NOT NULL COMMENT '���ǻ�����ȣ', -- ���ǻ�����ȣ
	PATH <������ Ÿ�� ����> NOT NULL COMMENT '����', -- ����
	CRNO INTEGER            NOT NULL COMMENT '���ǹ�ȣ' -- ���ǹ�ȣ
)
COMMENT '���ǻ���';

-- ���ǻ���
ALTER TABLE CLS_PHOT
	ADD CONSTRAINT PK_CLS_PHOT -- ���ǻ��� �⺻Ű
		PRIMARY KEY (
			CPNO -- ���ǻ�����ȣ
		);

ALTER TABLE CLS_PHOT
	MODIFY COLUMN CPNO <������ Ÿ�� ����> NOT NULL AUTO_INCREMENT COMMENT '���ǻ�����ȣ';

-- �л�
CREATE TABLE STUD (
	SNO     INTEGER     NOT NULL COMMENT '������û�ڹ�ȣ', -- ������û�ڹ�ȣ
	SCH_LVL VARCHAR(50) NOT NULL COMMENT '��û���з�', -- ��û���з�
	WORK    CHAR(1)     NOT NULL COMMENT '��û����������', -- ��û����������
	BANK    VARCHAR(50) NULL     COMMENT '�����', -- �����
	ACCT    VARCHAR(20) NULL     COMMENT '�����ȣ', -- �����ȣ
	MAJ     VARCHAR(50) NOT NULL COMMENT '����' -- ����
)
COMMENT '�л�';

-- �л�
ALTER TABLE STUD
	ADD CONSTRAINT PK_STUD -- �л� �⺻Ű
		PRIMARY KEY (
			SNO -- ������û�ڹ�ȣ
		);

-- �л� ����ũ �ε���
CREATE UNIQUE INDEX UIX_STUD
	ON STUD ( -- �л�
		BANK ASC, -- �����
		ACCT ASC  -- �����ȣ
	);

-- �ּ�
CREATE TABLE ADDR (
	ADNO     INTEGER      NOT NULL COMMENT '�ּҹ�ȣ', -- �ּҹ�ȣ
	PSTNO    CHAR(5)      NOT NULL COMMENT '�����ȣ', -- �����ȣ
	BAS_ADDR VARCHAR(100) NOT NULL COMMENT '�⺻�ּ�' -- �⺻�ּ�
)
COMMENT '�ּ�';

-- �ּ�
ALTER TABLE ADDR
	ADD CONSTRAINT PK_ADDR -- �ּ� �⺻Ű
		PRIMARY KEY (
			ADNO -- �ּҹ�ȣ
		);

-- �ּ� �ε���
CREATE INDEX IX_ADDR
	ON ADDR( -- �ּ�
		PSTNO ASC -- �����ȣ
	);

ALTER TABLE ADDR
	MODIFY COLUMN ADNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '�ּҹ�ȣ';

-- �������
CREATE TABLE LECT_TCHR (
	LNO INTEGER NOT NULL COMMENT '���¹�ȣ', -- ���¹�ȣ
	TNO INTEGER NOT NULL COMMENT '�����ȣ' -- �����ȣ
)
COMMENT '�������';

-- �������
ALTER TABLE LECT_TCHR
	ADD CONSTRAINT PK_LECT_TCHR -- ������� �⺻Ű
		PRIMARY KEY (
			LNO, -- ���¹�ȣ
			TNO  -- �����ȣ
		);

-- �����
CREATE TABLE USER (
	UNO      INTEGER      NOT NULL COMMENT '����ڹ�ȣ', -- ����ڹ�ȣ
	NAME     VARCHAR(50)  NOT NULL COMMENT '�̸�', -- �̸�
	EMAIL    VARCHAR(40)  NOT NULL COMMENT '�̸���', -- �̸���
	PWD      VARCHAR(150) NOT NULL COMMENT '��ȣ', -- ��ȣ
	TEL      VARCHAR(30)  NOT NULL COMMENT '��ȭ', -- ��ȭ
	ADNO     INTEGER      NULL     COMMENT '�ּҹ�ȣ', -- �ּҹ�ȣ
	DET_ADDR VARCHAR(100) NULL     COMMENT '���ּ�' -- ���ּ�
)
COMMENT '�����';

-- �����
ALTER TABLE USER
	ADD CONSTRAINT PK_USER -- ����� �⺻Ű
		PRIMARY KEY (
			UNO -- ����ڹ�ȣ
		);

-- ����� ����ũ �ε���
CREATE UNIQUE INDEX UIX_USER
	ON USER ( -- �����
		EMAIL ASC -- �̸���
	);

ALTER TABLE USER
	MODIFY COLUMN UNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '����ڹ�ȣ';

-- ������û
ALTER TABLE APPL
	ADD CONSTRAINT FK_LECT_TO_APPL -- ���� -> ������û
		FOREIGN KEY (
			LNO -- ���¹�ȣ
		)
		REFERENCES LECT ( -- ����
			LNO -- ���¹�ȣ
		);

-- ������û
ALTER TABLE APPL
	ADD CONSTRAINT FK_STUD_TO_APPL -- �л� -> ������û
		FOREIGN KEY (
			SNO -- ������û�ڹ�ȣ
		)
		REFERENCES STUD ( -- �л�
			SNO -- ������û�ڹ�ȣ
		);

-- ����
ALTER TABLE TCHR
	ADD CONSTRAINT FK_USER_TO_TCHR -- ����� -> ����
		FOREIGN KEY (
			TNO -- �����ȣ
		)
		REFERENCES USER ( -- �����
			UNO -- ����ڹ�ȣ
		);

-- �����
ALTER TABLE MGR
	ADD CONSTRAINT FK_USER_TO_MGR -- ����� -> �����
		FOREIGN KEY (
			MNO -- ����ڹ�ȣ
		)
		REFERENCES USER ( -- �����
			UNO -- ����ڹ�ȣ
		);

-- ����
ALTER TABLE LECT
	ADD CONSTRAINT FK_MGR_TO_LECT -- ����� -> ����
		FOREIGN KEY (
			id -- ����ڹ�ȣ
		)
		REFERENCES MGR ( -- �����
			MNO -- ����ڹ�ȣ
		);

-- ����
ALTER TABLE LECT
	ADD CONSTRAINT FK_CLS_RM_TO_LECT -- ���� -> ����
		FOREIGN KEY (
			CRNO -- ���ǹ�ȣ
		)
		REFERENCES CLS_RM ( -- ����
			CRNO -- ���ǹ�ȣ
		);

-- �������
ALTER TABLE TCHR_PHOT
	ADD CONSTRAINT FK_TCHR_TO_TCHR_PHOT -- ���� -> �������
		FOREIGN KEY (
			TNO -- �����ȣ
		)
		REFERENCES TCHR ( -- ����
			TNO -- �����ȣ
		);

-- ���ǻ���
ALTER TABLE CLS_PHOT
	ADD CONSTRAINT FK_CLS_RM_TO_CLS_PHOT -- ���� -> ���ǻ���
		FOREIGN KEY (
			CRNO -- ���ǹ�ȣ
		)
		REFERENCES CLS_RM ( -- ����
			CRNO -- ���ǹ�ȣ
		);

-- �л�
ALTER TABLE STUD
	ADD CONSTRAINT FK_USER_TO_STUD -- ����� -> �л�
		FOREIGN KEY (
			SNO -- ������û�ڹ�ȣ
		)
		REFERENCES USER ( -- �����
			UNO -- ����ڹ�ȣ
		);

-- �������
ALTER TABLE LECT_TCHR
	ADD CONSTRAINT FK_LECT_TO_LECT_TCHR -- ���� -> �������
		FOREIGN KEY (
			LNO -- ���¹�ȣ
		)
		REFERENCES LECT ( -- ����
			LNO -- ���¹�ȣ
		);

-- �������
ALTER TABLE LECT_TCHR
	ADD CONSTRAINT FK_TCHR_TO_LECT_TCHR -- ���� -> �������
		FOREIGN KEY (
			TNO -- �����ȣ
		)
		REFERENCES TCHR ( -- ����
			TNO -- �����ȣ
		);

-- �����
ALTER TABLE USER
	ADD CONSTRAINT FK_ADDR_TO_USER -- �ּ� -> �����
		FOREIGN KEY (
			ADNO -- �ּҹ�ȣ
		)
		REFERENCES ADDR ( -- �ּ�
			ADNO -- �ּҹ�ȣ
		);