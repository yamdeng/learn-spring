-- comment list

select concat('comment on column ', upper(a.table_name), '.', upper(a.column_name), ' is ', '''', '''', ';')
from information_schema.columns a
left outer join (
		SELECT
			PS.RELNAME AS TABLE_NAME,
			PA.ATTNAME AS COLUMN_NAME,
			PD.DESCRIPTION AS COLUMN_COMMENT
		FROM PG_STAT_ALL_TABLES PS, PG_DESCRIPTION PD, PG_ATTRIBUTE PA
		WHERE PD.OBJSUBID<>0
			AND PS.RELID=PD.OBJOID
			AND PD.OBJOID=PA.ATTRELID
			AND PD.OBJSUBID=PA.ATTNUM
			AND PS.RELNAME= lower('app_user') ) b
		on a.column_name = b.column_name
where a.table_name = lower('app_user')
and a.column_name not in(
	lower('ID'),
	lower('CREATE_DATE'),
	lower('UPDATE_DATE'),
	lower('CREATE_USER_ID'),
	lower('UPDATE_USER_ID'),
	lower('IS_DELETE')
);

--drop table list

drop table APP_USER;
drop table APP_DEPT;
drop table APP_AIRPLANE;
drop table APP_FLIGHT;
drop table APP_RESERVATION;
drop table APP_MENU;
drop table APP_CODE_GROUP;
drop table APP_CODE_DETAIL;
drop table APP_MESSAGE;


CREATE TABLE BASIC
(
  ID SERIAL PRIMARY KEY,
  CREATE_USER_ID INT,
  UPDATE_USER_ID INT,
  CREATE_DATE TIMESTAMP DEFAULT NOW(),
  UPDATE_DATE TIMESTAMP DEFAULT NOW(),
  IS_DELETE BOOLEAN DEFAULT false
);

comment on column BASIC.ID is 'ID';
comment on column BASIC.CREATE_USER_ID is '등록자 ID';
comment on column BASIC.UPDATE_USER_ID is '수정자 ID';
comment on column BASIC.CREATE_DATE is '등록일';
comment on column BASIC.UPDATE_DATE is '수정일';
comment on column BASIC.IS_DELETE is '삭제 여부';

-- APP_USER : 사용자정보
CREATE TABLE APP_USER
(
  ID SERIAL PRIMARY KEY,
  CREATE_USER_ID INT,
  UPDATE_USER_ID INT,
  CREATE_DATE TIMESTAMP DEFAULT NOW(),
  UPDATE_DATE TIMESTAMP DEFAULT NOW(),
  IS_DELETE BOOLEAN DEFAULT false,
  LOGIN_ID VARCHAR(255),
  NAME VARCHAR(255),
  NAME_EN VARCHAR(255),
  SABUN VARCHAR(255),
  DEPT_ID INT,
  POSITION_TITLE VARCHAR(255),
  POSITION_TITLE_EN VARCHAR(255),
  PHONE_NUMBER VARCHAR(255),
  COMPANY_TEL VARCHAR(255),
  EMAIL VARCHAR(255),
  ADDRESS VARCHAR(255),
  ADDRESS_DETAIL VARCHAR(255),
  ZIP_CODE VARCHAR(255),
  JOIN_DATE DATE,
  STATUS CHAR(1)
);

comment on column APP_USER.ID is 'ID';
comment on column APP_USER.CREATE_USER_ID is '등록자 ID';
comment on column APP_USER.UPDATE_USER_ID is '수정자 ID';
comment on column APP_USER.CREATE_DATE is '등록일';
comment on column APP_USER.UPDATE_DATE is '수정일';
comment on column APP_USER.IS_DELETE is '삭제 여부';

comment on column APP_USER.LOGIN_ID is '로그인ID';
comment on column APP_USER.NAME is '이름';
comment on column APP_USER.NAME_EN is '이름영문명';
comment on column APP_USER.SABUN is '사번';
comment on column APP_USER.DEPT_ID is '부서ID';
comment on column APP_USER.POSITION_TITLE is '사용자직책명';
comment on column APP_USER.POSITION_TITLE_EN is '사용자직책영문명';
comment on column APP_USER.PHONE_NUMBER is '핸드폰번호';
comment on column APP_USER.COMPANY_TEL is '회사전화번호';
comment on column APP_USER.EMAIL is '이메일';
comment on column APP_USER.ADDRESS is '주소';
comment on column APP_USER.ADDRESS_DETAIL is '주소상세';
comment on column APP_USER.ZIP_CODE is '우편변호';
comment on column APP_USER.JOIN_DATE is '입사일';
comment on column APP_USER.STATUS is '사용자상태';

-- APP_DEPT : 부서정보
CREATE TABLE APP_DEPT
(
  ID SERIAL PRIMARY KEY,
  CREATE_USER_ID INT,
  UPDATE_USER_ID INT,
  CREATE_DATE TIMESTAMP DEFAULT NOW(),
  UPDATE_DATE TIMESTAMP DEFAULT NOW(),
  IS_DELETE BOOLEAN DEFAULT false,
  NAME VARCHAR(255),
  NAME_EN VARCHAR(255),
  DEPT_KEY VARCHAR(255),
  DEPT_UPPER_KEY VARCHAR(255),
  STATUS CHAR(1)
);

comment on column APP_DEPT.ID is 'ID';
comment on column APP_DEPT.CREATE_USER_ID is '등록자 ID';
comment on column APP_DEPT.UPDATE_USER_ID is '수정자 ID';
comment on column APP_DEPT.CREATE_DATE is '등록일';
comment on column APP_DEPT.UPDATE_DATE is '수정일';
comment on column APP_DEPT.IS_DELETE is '삭제 여부';

comment on column APP_DEPT.NAME is '부서명';
comment on column APP_DEPT.NAME_EN is '부서영문명';
comment on column APP_DEPT.DEPT_KEY is '부서키';
comment on column APP_DEPT.DEPT_UPPER_KEY is '부서상위키';
comment on column APP_DEPT.STATUS is '부서상태';

-- APP_AIRPLANE : 비행기정보
CREATE TABLE APP_AIRPLANE
(
  ID SERIAL PRIMARY KEY,
  CREATE_USER_ID INT,
  UPDATE_USER_ID INT,
  CREATE_DATE TIMESTAMP DEFAULT NOW(),
  UPDATE_DATE TIMESTAMP DEFAULT NOW(),
  IS_DELETE BOOLEAN DEFAULT false,
  NAME VARCHAR(255),
  NAME_EN VARCHAR(255),
  AIR_CODE VARCHAR(255),
  COUNTRY_CODE VARCHAR(255),
  LAST_PAIN_DATE TIMESTAMP,
  LAST_FIX_DATE TIMESTAMP,
  SIZE NUMERIC(5, 1)
);

comment on column APP_AIRPLANE.ID is 'ID';
comment on column APP_AIRPLANE.CREATE_USER_ID is '등록자 ID';
comment on column APP_AIRPLANE.UPDATE_USER_ID is '수정자 ID';
comment on column APP_AIRPLANE.CREATE_DATE is '등록일';
comment on column APP_AIRPLANE.UPDATE_DATE is '수정일';
comment on column APP_AIRPLANE.IS_DELETE is '삭제 여부';
comment on column APP_AIRPLANE.NAME is '비행기이름';
comment on column APP_AIRPLANE.NAME_EN is '비행기영문명';
comment on column APP_AIRPLANE.AIR_CODE is '비행기코드';
comment on column APP_AIRPLANE.COUNTRY_CODE is '국가코드';
comment on column APP_AIRPLANE.LAST_PAIN_DATE is '최종비행시간';
comment on column APP_AIRPLANE.LAST_FIX_DATE is '최종수리시간';
comment on column APP_AIRPLANE.SIZE is '크기';

-- APP_FLIGHT : 항공편
CREATE TABLE APP_FLIGHT
(
  ID SERIAL PRIMARY KEY,
  CREATE_USER_ID INT,
  UPDATE_USER_ID INT,
  CREATE_DATE TIMESTAMP DEFAULT NOW(),
  UPDATE_DATE TIMESTAMP DEFAULT NOW(),
  IS_DELETE BOOLEAN DEFAULT false,
  AIRPLANE_ID INT,
  NAME VARCHAR(255),
  NAME_EN VARCHAR(255),
  AIR_CODE VARCHAR(255),
  START_IATA_CODE VARCHAR(255),
  END_IATA_CODE VARCHAR(255),
  CAPTAIN_ID INT,
  START_DATE TIMESTAMP,
  END_DATE TIMESTAMP
);

comment on column APP_FLIGHT.ID is 'ID';
comment on column APP_FLIGHT.CREATE_USER_ID is '등록자 ID';
comment on column APP_FLIGHT.UPDATE_USER_ID is '수정자 ID';
comment on column APP_FLIGHT.CREATE_DATE is '등록일';
comment on column APP_FLIGHT.UPDATE_DATE is '수정일';
comment on column APP_FLIGHT.IS_DELETE is '삭제 여부';
comment on column APP_FLIGHT.AIRPLANE_ID is '비행기ID';
comment on column APP_FLIGHT.NAME is '항공편이름';
comment on column APP_FLIGHT.NAME_EN is '항공편영문명';
comment on column APP_FLIGHT.AIR_CODE is '비행기코드';
comment on column APP_FLIGHT.START_IATA_CODE is '출발공항코드';
comment on column APP_FLIGHT.END_IATA_CODE is '도착공항코드';
comment on column APP_FLIGHT.CAPTAIN_ID is '기장ID';
comment on column APP_FLIGHT.START_DATE is '출발일시';
comment on column APP_FLIGHT.END_DATE is '도착일시';

-- APP_RESERVATION : 사용자 항공편 예약 정보
CREATE TABLE APP_RESERVATION
(
  ID SERIAL PRIMARY KEY,
  CREATE_USER_ID INT,
  UPDATE_USER_ID INT,
  CREATE_DATE TIMESTAMP DEFAULT NOW(),
  UPDATE_DATE TIMESTAMP DEFAULT NOW(),
  IS_DELETE BOOLEAN DEFAULT false,
  TITLE VARCHAR(255),
  USER_ID INT,
  RESERVATION_DATE TIMESTAMP,
  FLIGHT_ID INT,
  COMMENT_MESSAGE VARCHAR(4000)
);

comment on column APP_RESERVATION.ID is 'ID';
comment on column APP_RESERVATION.CREATE_USER_ID is '등록자 ID';
comment on column APP_RESERVATION.UPDATE_USER_ID is '수정자 ID';
comment on column APP_RESERVATION.CREATE_DATE is '등록일';
comment on column APP_RESERVATION.UPDATE_DATE is '수정일';
comment on column APP_RESERVATION.IS_DELETE is '삭제 여부';
comment on column APP_RESERVATION.TITLE is '예약명';
comment on column APP_RESERVATION.USER_ID is '사용자ID';
comment on column APP_RESERVATION.RESERVATION_DATE is '예약일시';
comment on column APP_RESERVATION.FLIGHT_ID is '항공편ID';
comment on column APP_RESERVATION.COMMENT_MESSAGE is '설명';

-- APP_MENU : 메뉴
CREATE TABLE APP_MENU
(
  ID SERIAL PRIMARY KEY,
  CREATE_USER_ID INT,
  UPDATE_USER_ID INT,
  CREATE_DATE TIMESTAMP DEFAULT NOW(),
  UPDATE_DATE TIMESTAMP DEFAULT NOW(),
  IS_DELETE BOOLEAN DEFAULT false,
  NAME VARCHAR(255),
  NAME_EN VARCHAR(255),
  MODULE_TYPE VARCHAR(30),
  MENU_KEY VARCHAR(255),
  MENU_UPPER_KEY VARCHAR(255),
  MENU_URL VARCHAR(4000)
);

comment on column APP_MENU.ID is 'ID';
comment on column APP_MENU.CREATE_USER_ID is '등록자 ID';
comment on column APP_MENU.UPDATE_USER_ID is '수정자 ID';
comment on column APP_MENU.CREATE_DATE is '등록일';
comment on column APP_MENU.UPDATE_DATE is '수정일';
comment on column APP_MENU.IS_DELETE is '삭제 여부';
comment on column APP_MENU.NAME is '메뉴명';
comment on column APP_MENU.NAME_EN is '메뉴영문명';
comment on column APP_MENU.MODULE_TYPE is '모듈타입';
comment on column APP_MENU.MENU_KEY is '메뉴키';
comment on column APP_MENU.MENU_UPPER_KEY is '상위메뉴키';
comment on column APP_MENU.MENU_URL is '메뉴URL';

-- APP_CODE_GROUP : 그룹코드
CREATE TABLE APP_CODE_GROUP
(
  ID SERIAL PRIMARY KEY,
  CREATE_USER_ID INT,
  UPDATE_USER_ID INT,
  CREATE_DATE TIMESTAMP DEFAULT NOW(),
  UPDATE_DATE TIMESTAMP DEFAULT NOW(),
  IS_DELETE BOOLEAN DEFAULT false,
  NAME VARCHAR(255),
  GROUP_CODE VARCHAR(255),
  ETC VARCHAR(4000)
);

comment on column APP_CODE_GROUP.ID is 'ID';
comment on column APP_CODE_GROUP.CREATE_USER_ID is '등록자 ID';
comment on column APP_CODE_GROUP.UPDATE_USER_ID is '수정자 ID';
comment on column APP_CODE_GROUP.CREATE_DATE is '등록일';
comment on column APP_CODE_GROUP.UPDATE_DATE is '수정일';
comment on column APP_CODE_GROUP.IS_DELETE is '삭제 여부';
comment on column APP_CODE_GROUP.NAME is '그룹코드명';
comment on column APP_CODE_GROUP.GROUP_CODE is '그룹코드';
comment on column APP_CODE_GROUP.ETC is '설명';

-- APP_CODE_DETAIL : 코드상세
CREATE TABLE APP_CODE_DETAIL
(
  ID SERIAL PRIMARY KEY,
  CREATE_USER_ID INT,
  UPDATE_USER_ID INT,
  CREATE_DATE TIMESTAMP DEFAULT NOW(),
  UPDATE_DATE TIMESTAMP DEFAULT NOW(),
  IS_DELETE BOOLEAN DEFAULT false,
  NAME VARCHAR(255),
  NAME_EN VARCHAR(255),
  GROUP_CODE VARCHAR(255),
  CODE VARCHAR(255),
  ETC VARCHAR(4000)
);

comment on column APP_CODE_DETAIL.ID is 'ID';
comment on column APP_CODE_DETAIL.CREATE_USER_ID is '등록자 ID';
comment on column APP_CODE_DETAIL.UPDATE_USER_ID is '수정자 ID';
comment on column APP_CODE_DETAIL.CREATE_DATE is '등록일';
comment on column APP_CODE_DETAIL.UPDATE_DATE is '수정일';
comment on column APP_CODE_DETAIL.IS_DELETE is '삭제 여부';
comment on column APP_CODE_DETAIL.NAME is '코드명';
comment on column APP_CODE_DETAIL.NAME_EN is '코드영문명';
comment on column APP_CODE_DETAIL.GROUP_CODE is '그룹코드';
comment on column APP_CODE_DETAIL.CODE is '코드';
comment on column APP_CODE_DETAIL.ETC is '설명';

-- APP_MESSAGE :메시지
CREATE TABLE APP_MESSAGE
(
  ID SERIAL PRIMARY KEY,
  CREATE_USER_ID INT,
  UPDATE_USER_ID INT,
  CREATE_DATE TIMESTAMP DEFAULT NOW(),
  UPDATE_DATE TIMESTAMP DEFAULT NOW(),
  IS_DELETE BOOLEAN DEFAULT false,
  MESSAGE_KEY VARCHAR(255),
  MESSAGE VARCHAR(4000),
  MESSAGE_EN VARCHAR(4000),
  ETC VARCHAR(4000)
);

comment on column APP_MESSAGE.ID is 'ID';
comment on column APP_MESSAGE.CREATE_USER_ID is '등록자 ID';
comment on column APP_MESSAGE.UPDATE_USER_ID is '수정자 ID';
comment on column APP_MESSAGE.CREATE_DATE is '등록일';
comment on column APP_MESSAGE.UPDATE_DATE is '수정일';
comment on column APP_MESSAGE.IS_DELETE is '삭제 여부';
comment on column APP_MESSAGE.MESSAGE_KEY is '메시지키';
comment on column APP_MESSAGE.MESSAGE is '메시지';
comment on column APP_MESSAGE.MESSAGE_EN is '메시지(영문)';
comment on column APP_MESSAGE.ETC is '설명';
