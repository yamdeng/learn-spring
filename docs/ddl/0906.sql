-- public.tb_avn_report definition

-- Drop table

-- DROP TABLE public.tb_avn_report;

CREATE TABLE public.tb_avn_report (
	report_id int4 NOT NULL,
	report_docno varchar(20) NULL,
	report_type_cd varchar(50) NOT NULL,
	emp_no varchar(50) NOT NULL,
	subject_nm varchar(200) NULL,
	timezone_cd varchar(50) NOT NULL,
	report_phase_cd varchar(50) NOT NULL,
	report_status_cd varchar(50) NOT NULL,
	reg_dt varchar(8) NOT NULL,
	change_dt varchar(8) NOT NULL,
	del_dt varchar(8) NULL,
	final_submitted_yn varchar(1) DEFAULT 'Y'::character varying NOT NULL,
	final_submitted_dt varchar(8) NULL,
	view_sn int4 NULL,
	occur_dttm date NULL,
	occur_timezone_cd varchar(50) NULL,
	occur_place_nm varchar(200) NULL,
	occur_airport_cd varchar(50) NULL,
	description_txtcn text NULL,
	file_group_seq numeric(4) NULL,
	reg_user_id varchar(20) NOT NULL,
	reg_dttm date NOT NULL,
	upd_user_id varchar(20) NULL,
	upd_dttm date NULL,
	CONSTRAINT tb_avn_report_pkey PRIMARY KEY (report_id)
);

-- public.tb_avn_sm_approval_log definition

-- Drop table

-- DROP TABLE public.tb_avn_sm_approval_log;

CREATE TABLE public.tb_avn_sm_approval_log (
	id serial4 NOT NULL,
	group_id int4 NOT NULL,
	state_type varchar(50) NOT NULL,
	phase varchar(50) NOT NULL,
	step_code varchar(50) NOT NULL,
	emp_no varchar(10) NOT NULL,
	reason varchar(255) NULL,
	timezone varchar(50) NOT NULL,
	reg_dttm timestamp NOT NULL,
	reg_user_id varchar(10) NOT NULL,
	upd_dttm timestamp NOT NULL,
	upd_user_id varchar(10) NOT NULL,
	CONSTRAINT pk_tb_avn_sm_approval_log PRIMARY KEY (id)
);
CREATE UNIQUE INDEX tb_avn_sm_approval_log_id ON public.tb_avn_sm_approval_log USING btree (id);
CREATE INDEX tb_avn_sm_approval_log_report_id_idx ON public.tb_avn_sm_approval_log USING btree (group_id);


-- public.tb_avn_sm_approval_log foreign keys

ALTER TABLE public.tb_avn_sm_approval_log ADD CONSTRAINT fk_tb_sm_group_report_approval_log FOREIGN KEY (group_id) REFERENCES public.tb_avn_sm_group(id);


-- public.tb_avn_sm_report_fr_account definition

-- Drop table

-- DROP TABLE public.tb_avn_sm_report_fr_account;

CREATE TABLE public.tb_avn_sm_report_fr_account (
	group_id int4 NOT NULL,
	account_acnt_id numeric(19) NOT NULL,
	role_type varchar(50) NOT NULL,
	acnt_type varchar(1) NULL,
	CONSTRAINT uk_tb_avn_sm_report_fr_account UNIQUE (group_id, account_acnt_id, role_type)
);
CREATE INDEX ix_tb_avn_sm_report_fr_account_account_acnt_id ON public.tb_avn_sm_report_fr_account USING btree (account_acnt_id);
CREATE INDEX ix_tb_avn_sm_report_fr_account_reports_id ON public.tb_avn_sm_report_fr_account USING btree (group_id);


-- public.tb_avn_sm_report_fr_account foreign keys

ALTER TABLE public.tb_avn_sm_report_fr_account ADD CONSTRAINT fk_tb_avn_sm_report_fr_account FOREIGN KEY (group_id) REFERENCES public.tb_avn_sm_group(id);

-- public.tb_avn_post definition

-- Drop table

-- DROP TABLE public.tb_avn_post;

CREATE TABLE public.tb_avn_post (
	post_id serial4 NOT NULL,
	system_type varchar(50) DEFAULT 'other'::character varying NOT NULL,
	post_type varchar(50) NOT NULL,
	"content" text NULL,
	CONSTRAINT pk_tb_avn_post PRIMARY KEY (post_id)
);

-- public.tb_avn_sm_hazard_approval_log definition

-- Drop table

-- DROP TABLE public.tb_avn_sm_hazard_approval_log;

CREATE TABLE public.tb_avn_sm_hazard_approval_log (
	id serial4 NOT NULL,
	hazard_id int4 DEFAULT '-1'::integer NOT NULL,
	state_type varchar(50) NOT NULL,
	phase varchar(50) NOT NULL,
	step_code varchar(50) NOT NULL,
	emp_no varchar(10) NOT NULL,
	reason varchar(255) NULL,
	timezone varchar(50) NOT NULL,
	notes varchar(1000) NULL,
	reg_dttm timestamp NOT NULL,
	reg_user_id varchar(10) NOT NULL,
	upd_dttm timestamp NOT NULL,
	upd_user_id varchar(10) NOT NULL,
	CONSTRAINT pk_tb_avn_sm_hazard_approval_log PRIMARY KEY (id)
);
CREATE INDEX tb_avn_sm_hazard_approval_log_hazard_id_idx ON public.tb_avn_sm_hazard_approval_log USING btree (hazard_id);


-- public.tb_avn_sm_hazard_approval_log foreign keys

ALTER TABLE public.tb_avn_sm_hazard_approval_log ADD CONSTRAINT fk_tb_avn_sm_report_hazarad_approval_log FOREIGN KEY (hazard_id) REFERENCES public.tb_avn_sm_report_hazard(id);

-- public.tb_avn_sm_reception definition

-- Drop table

-- DROP TABLE public.tb_avn_sm_reception;

CREATE TABLE public.tb_avn_sm_reception (
	id serial4 NOT NULL,
	group_id int4 NOT NULL,
	emp_no varchar(10) NOT NULL,
	ata_adapter_type varchar(50) DEFAULT ''::character varying NULL,
	event_followup text NULL,
	control_dept_type varchar(20) NULL,
	event_summary text NULL,
	classification varchar(50) DEFAULT ''::character varying NULL,
	is_spi varchar(1) DEFAULT 'N'::character varying NULL,
	deleted_at timestamp(6) NULL,
	timezone varchar(50) NOT NULL,
	receipted_at timestamp NULL,
	is_receipted varchar(1) DEFAULT 'N'::character varying NULL,
	is_asmr varchar(1) DEFAULT 'N'::character varying NULL,
	sector varchar(10) DEFAULT ''::character varying NULL,
	due_date varchar(10) NULL,
	add_category varchar(50) NULL,
	is_ground_accident varchar(1) NULL,
	reg_dttm timestamp NOT NULL,
	reg_user_id varchar(10) NOT NULL,
	upd_dttm timestamp NOT NULL,
	upd_user_id varchar(10) NOT NULL,
	file_group_seq int4 NULL,
	CONSTRAINT pk_tb_avn_sm_reception PRIMARY KEY (id),
	CONSTRAINT tb_avn_sm_reception_un UNIQUE (group_id)
);
CREATE UNIQUE INDEX tb_avn_sm_reception_id ON public.tb_avn_sm_reception USING btree (id);


-- public.tb_avn_sm_reception foreign keys

ALTER TABLE public.tb_avn_sm_reception ADD CONSTRAINT fk_tb_avn_sm_report_reception FOREIGN KEY (group_id) REFERENCES public.tb_avn_sm_group(id);