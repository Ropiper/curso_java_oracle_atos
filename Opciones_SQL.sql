/* DROP TABLE USUARIO; /* elimina la tabla completa */
/* TRUNCATE TABLE USUARIO; DELETE TABLE USUARIO /* elimina los registros de la tabla. TRUNCATE es más rápido pero no hace copia de seguridad */

UPDATE USUARIO SET EDAD = EDAD + 1;
SELECT * FROM USUARIO WHERE EDAD >= 20 AND EDAD < 30;
SELECT NOMBRE||': <'||EMAIL||'> TIENE '||EDAD||' AÑOS' FROM USUARIO;

/* CAMPOS CALCULADOS */
SELECT NOMBRE, 2019 - EDAD AS AÑO_NACIMIENTO FROM USUARIO;
SELECT 'HOLA, MUY BUENAS' AS TEXTO FROM DUAL; /* TEXTO */
SELECT LOWER('HOLA, MUY BUENAS') AS TEXTO FROM DUAL;
SELECT INITCAP(NOMBRE) AS NOMBRE_INITCAP FROM USUARIO;
select trim(descripcion) from usuario /* quita espacios, puede ser rtrim o ltrim para derecha o izquierda */
select replace(descripcion, 'todos', 'cualquiera') from usuario /* calbiar datos */

select SUBSTR(descripcion,3,4), LENGTH(descripcion) from usuario;
select INSTRB(descripcion,'vago') from usuario;
select translate(descripcion, 'aeiou', '43012') from usuario;

alter table usuario add nota number(4,2) default 0;
update usuario set nota = dbms_random.value(1,10);

select nota, ceil(nota), floor(nota), round(nota, 1) from usuario;

update usuario set fecha_registro = add_months(fecha_registro, -1 + round(dbms_random.value(1,11)));
update usuario set fecha_registro = fecha_registro - 27 + round(dbms_random.value(1,20));
select nombre, fecha_registro from usuario where fecha_registro between '1/1/2019' and '1/4/2019';
select nombre, fecha_registro, NEXT_DAY(fecha_registro, 'LUNES') from usuario;

select to_date('05-SEP-2018 10:33 AM', 'DD-MM-YYYY HH:MI AM') from dual;
select fecha_registro, to_char(fecha_registro) from usuario;

select * from usuario where nota = (
    select min(nota) from usuario where nota>=5)
	
create view usuarios_programadores as select (u.nombre||' '||u.apellidos) as nombre_apell, edad, email, fecha_registro from usuario u 
	join usu_dept ud on u.id = ud.id_usu join departamento d on ud.id_dept = d.id where d.nombre = 'Programación'