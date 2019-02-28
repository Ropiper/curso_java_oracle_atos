CREATE TABLE USUARIO(
	ID NUMBER(10) NOT NULL,
	NOMBRE VARCHAR2(100) NOT NULL,
	EMAIL VARCHAR2(255) NOT NULL,
	EDAD NUMBER(3,0) NOT NULL,
	PASSWORD VARCHAR2(50) NOT NULL
);
ALTER TABLE USUARIO ADD(
	CONSTRAINT dept_pk PRIMARY KEY(ID)
);
ALTER TABLE USUARIO ADD
	CONSTRAINT uq_usuario_email UNIQUE(EMAIL)
;
CREATE SEQUENCE dept_seq START WITH 1;
CREATE OR REPLACE TRIGGER dept_bir
	BEFORE INSERT ON USUARIO
	FOR EACH ROW
	
	BEGIN
		SELECT dept_seq.NEXTVAL
		INTO :new.id
		FROM dual;
	END;
	
INSERT INTO usuario (nombre, email, edad, password) VALUES ('Pepe', 'pepe@gmai.com', 19, 'pepe');

ALTER TABLE USUARIO ADD APELLIDOS VARCHAR(50);
ALTER TABLE USUARIO ADD FECHA_REGISTRO DATE;
ALTER TABLE USUARIO ADD DESCRIPCION VARCHAR(100) DEFAULT 'Un vago como todos';

create table departamento(
    id NUMBER(10) not null,
    nombre varchar2(100) not null,
    fecha date not null
    );
alter table departamento add(
    CONSTRAINT departamento_pk PRIMARY KEY(id)
    );
create SEQUENCE departamento_seq start WITH 1;
create or replace TRIGGER departamento_bir
    before insert on departamento
    for each row
    begin
        select departamento_seq.nextval
        into :new.id
        from dual;
    end;
insert into departamento (nombre, fecha) values ('Programación', SYSDATE);  
insert into departamento (nombre, fecha) values ('Diseño', '1/2/2019');
insert into departamento (nombre, fecha) values ('Marketing', '5/1/2019'); 
insert into departamento (nombre, fecha) values ('Direccion', '20/1/2019'); 

