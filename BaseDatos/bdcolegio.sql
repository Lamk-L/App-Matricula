CREATE DATABASE bdcolegio;
USE bdcolegio ;

ALTER USER 'root'@'localhost' 
IDENTIFIED WITH mysql_native_password 
BY 'LamkSword';
flush privileges;

-- DROP DATABASE bdcolegio;

CREATE TABLE apoderado (
  idapoderado CHAR(15) NOT NULL,
  nombresp VARCHAR(20) NOT NULL,
  apellidosp VARCHAR(20) NOT NULL,
  telefono CHAR(9) NOT NULL,
  direccion VARCHAR(50) NOT NULL,
  estadoCivil VARCHAR(20) NOT NULL,
  PRIMARY KEY(idapoderado)
);

CREATE TABLE alumno (
  idalumno CHAR(15) NOT NULL,
  nombres VARCHAR(20) NOT NULL,
  apellidos VARCHAR(20) NOT NULL,
  sexo VARCHAR(20) NOT NULL,
  telefono CHAR(9) NOT NULL,
  direccion VARCHAR(50) NOT NULL,
  fechaNacimiento DATE NOT NULL,
  idapoderado CHAR(15) NOT NULL,
  PRIMARY KEY(idalumno),
  FOREIGN KEY (idapoderado) REFERENCES apoderado(idapoderado)
);

CREATE TABLE docente (
  iddocente CHAR(15) NOT NULL,
  dni CHAR(8) NOT NULL,
  apellidosd VARCHAR(30) NOT NULL,
  nombresd VARCHAR(20) NOT NULL,
  telefono CHAR(9) NOT NULL,
  direccion CHAR(50) NOT NULL,
  PRIMARY KEY(iddocente)
);

CREATE TABLE docente_alumno(
	iddocente CHAR(15) NOT NULL,
    idalumno CHAR(15) NOT NULL,
    PRIMARY KEY(iddocente, idalumno),
	FOREIGN KEY (iddocente) REFERENCES docente(iddocente),
	FOREIGN KEY (idalumno) REFERENCES alumno(idalumno)
);

CREATE TABLE curso (
  idcurso CHAR(15) NOT NULL,
  nombre VARCHAR(30) NOT NULL,
  iddocente CHAR(15) NOT NULL,
  PRIMARY KEY(idcurso),
  FOREIGN KEY (iddocente) REFERENCES docente(iddocente)
);

CREATE TABLE aula (
  idaula CHAR(15) NOT NULL,
  numeroAula INT NOT NULL,
  capacidad INT NOT NULL,
  PRIMARY KEY(idaula)
);

CREATE TABLE horario (
  idhorario CHAR(15) NOT NULL,
  grado VARCHAR(20) NOT NULL,
  turno VARCHAR(20) NOT NULL,
  fechaInicio DATE NOT NULL,
  horaEntrada VARCHAR(20) NOT NULL,
  horaSalida VARCHAR(20) NOT NULL,
  PRIMARY KEY(idhorario)
);

CREATE TABLE programacion (
  idprogramacion CHAR(15) NOT NULL,
  idhorario CHAR(15) NOT NULL,
  idaula CHAR(15) NOT NULL,
  PRIMARY KEY(idprogramacion),
  FOREIGN KEY (idhorario) REFERENCES horario(idhorario),
  FOREIGN KEY (idaula) REFERENCES aula(idaula)
);

CREATE TABLE matricula (
  idmatricula CHAR(15) NOT NULL,
  fecha DATE NOT NULL,
  idalumno CHAR(15) NOT NULL,
  idprogramacion CHAR(15) NOT NULL,
  PRIMARY KEY(idmatricula),
  FOREIGN KEY (idalumno) REFERENCES alumno(idalumno),
  FOREIGN KEY (idprogramacion) REFERENCES programacion(idprogramacion)
);

CREATE TABLE matricula_curso (
  idmatricula CHAR(15) NOT NULL,
  idcurso CHAR(15) NOT NULL,
  PRIMARY KEY(idmatricula, idcurso),
  FOREIGN KEY (idmatricula) REFERENCES matricula(idmatricula),
  FOREIGN KEY (idcurso) REFERENCES curso(idcurso)
);

CREATE TABLE usuarios (
  usuario CHAR(15) NOT NULL,
  clave CHAR(15) NOT NULL,
  PRIMARY KEY(usuario)
);

-- PROCEDIMIENTOS ALMACENADOS PARA LA TABLA APODERADO

DELIMITER $$
CREATE PROCEDURE insertar_apoderado(IN idap CHAR(15), IN nom VARCHAR(20),
 IN aap VARCHAR(20), IN tel CHAR(9), IN dic VARCHAR(50), IN ec VARCHAR(20))
BEGIN
	INSERT INTO apoderado(idapoderado,nombresp,apellidosp,telefono,direccion,estadoCivil) 
    VALUES (idap,nom,aap,tel,dic,ec);
END$$

DELIMITER $$
CREATE PROCEDURE buscar_apoderado(IN idap CHAR(15))
BEGIN
	SELECT * FROM apoderado WHERE idapoderado = idap;
END$$

DELIMITER $$
CREATE PROCEDURE modificar_apoderado(IN idap CHAR(15), IN nom VARCHAR(20), 
IN aap VARCHAR(20), IN tel CHAR(9), IN dic VARCHAR(50), IN ec VARCHAR(20))
BEGIN
	UPDATE apoderado SET nombresp=nom, apellidosp=aap, telefono=tel, direccion=dic, estadoCivil=ec
    WHERE idapoderado=idap;
END$$

DELIMITER $$
CREATE PROCEDURE eliminar_apoderado(IN idap CHAR(15))
BEGIN
	DELETE FROM apoderado WHERE idapoderado=idap;
END$$

DELIMITER $$
CREATE PROCEDURE numero_apoderados()
BEGIN
	SELECT COUNT(*) AS num FROM apoderado;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarApoderados()
BEGIN
	SELECT * FROM apoderado;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarApoderados_PorIdApoderado(IN idap CHAR(15))
BEGIN
    SELECT * FROM apoderado where idapoderado like "idap%";
END$$

DELIMITER $$
CREATE PROCEDURE mostrarApoderadosNomAsc()
BEGIN
    SELECT * FROM apoderado
	ORDER BY  nombresp ASC;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarApoderadosApeAsc()
BEGIN
    SELECT * FROM apoderado
	ORDER BY  apellidosp ASC;
END$$

-- PROCEDIMIENTOS ALMACENADOS PARA LA TABLA ALUMNO

DELIMITER $$
CREATE PROCEDURE insertar_alumno(IN idal CHAR(15), IN nom VARCHAR(20), IN aap VARCHAR(20),
 IN sx VARCHAR(20), IN tel CHAR(9), IN dic VARCHAR(50), IN fn DATE, IN idap CHAR(15))
BEGIN
	INSERT INTO alumno(idalumno,nombres,apellidos,sexo,telefono,direccion,fechaNacimiento,idapoderado) 
    VALUES (idal,nom,aap,sx,tel,dic,fn,idap);
END$$

DELIMITER $$
CREATE PROCEDURE buscar_alumno(IN idal CHAR(15))
BEGIN
	SELECT * FROM alumno WHERE idalumno = idal;
END$$

DELIMITER $$
CREATE PROCEDURE modificar_alumno(IN idal CHAR(15), IN nom VARCHAR(20), IN aap VARCHAR(20),
 IN sx VARCHAR(20), IN tel CHAR(9), IN dic VARCHAR(50), IN fn DATE, IN idap CHAR(15))
BEGIN
	UPDATE alumno SET nombres=nom, apellidos=aap, sexo=sx, telefono=tel, direccion=dic, 
    fechaNacimiento=fn, idapoderado=idap
    WHERE idalumno=idal;
END$$

DELIMITER $$
CREATE PROCEDURE eliminar_alumno(IN idal CHAR(15))
BEGIN
	DELETE FROM alumno WHERE idalumno=idal;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarAlumnos()
BEGIN
	SELECT * FROM alumno;
END$$

DELIMITER $$
CREATE PROCEDURE numero_alumnos()
BEGIN
	SELECT COUNT(*) AS num FROM alumno;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarAlumnos_PorIdAlumno(IN idal CHAR(15))
BEGIN
    SELECT * FROM alumno WHERE idalumno like "idal%";
END$$

DELIMITER $$
CREATE PROCEDURE mostrarAlumnosNomAsc()
BEGIN
    SELECT * FROM alumno
	ORDER BY  nombres ASC;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarAlumnosApeAsc()
BEGIN
    SELECT * FROM alumno
	ORDER BY  apellidos ASC;
END$$


-- PROCEDIMIENTOS ALMACENADOS PARA LA TABLA DOCENTE
DELIMITER $$
CREATE PROCEDURE insertar_docente(IN iddo CHAR(15), IN d CHAR(8), IN aap VARCHAR(20), 
IN nom VARCHAR(20), IN tel CHAR(9), IN dic VARCHAR(50))
BEGIN
	INSERT INTO docente(iddocente,dni,apellidosd,nombresd,telefono,direccion) 
    VALUES (iddo,d,aap,nom,tel,dic);
END$$

DELIMITER $$
CREATE PROCEDURE buscar_docente(IN iddo CHAR(15))
BEGIN
	SELECT * FROM docente WHERE iddocente = iddo;
END$$

DELIMITER $$
CREATE PROCEDURE modificar_docente(IN iddo CHAR(15), IN d CHAR(8), IN aap VARCHAR(20), 
IN nom VARCHAR(20), IN tel CHAR(9), IN dic VARCHAR(50))
BEGIN
	UPDATE docente SET dni=d, apellidosd=aap, nombresd=nom, telefono=tel, direccion=dic
    WHERE iddocente=iddo;
END$$

DELIMITER $$
CREATE PROCEDURE eliminar_docente(IN iddo CHAR(15))
BEGIN
	DELETE FROM docente WHERE iddocente=iddo;
END$$

DELIMITER $$
CREATE PROCEDURE numero_docentes()
BEGIN
	SELECT COUNT(*) AS num FROM docente;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarDocentes()
BEGIN
	SELECT * FROM docente;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarDocentesNomAsc()
BEGIN
    SELECT * FROM docente
	ORDER BY  nombresd ASC;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarDocentesApeAsc()
BEGIN
    SELECT * FROM docente
	ORDER BY  apellidosd ASC;
END$$

-- PROCEDIMIENTOS ALMACENADOS PARA LA TABLA CURSO

DELIMITER $$
CREATE PROCEDURE insertar_curso(IN idcu CHAR(15), IN nom VARCHAR(20), IN iddo CHAR(15))
BEGIN
	INSERT INTO curso(idcurso,nombre,iddocente) 
    VALUES (idcu,nom,iddo);
END$$

DELIMITER $$
CREATE PROCEDURE buscar_curso(IN idcu CHAR(15))
BEGIN
	SELECT * FROM curso WHERE idcurso = idcu;
END$$

DELIMITER $$
CREATE PROCEDURE modificar_curso(IN idcu CHAR(15), IN nom VARCHAR(20), IN iddo CHAR(15))
BEGIN
	UPDATE curso SET nombre=nom, iddocente=iddo
    WHERE idcurso=idcu;
END$$

DELIMITER $$
CREATE PROCEDURE numero_cursos()
BEGIN
	SELECT COUNT(*) AS num FROM curso;
END$$

DELIMITER $$
CREATE PROCEDURE eliminar_curso(IN idcu CHAR(15))
BEGIN
	DELETE FROM curso WHERE idcurso=idcu;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarCursos()
BEGIN
	SELECT * FROM curso;
END$$

-- PROCEDIMIENTOS ALMACENADOS PARA LA TABLA AULA

DELIMITER $$
CREATE PROCEDURE insertar_aula(IN idau CHAR(15), IN na INT, IN cap INT)
BEGIN
	INSERT INTO aula(idaula,numeroAula,capacidad) 
    VALUES (idau,na,cap);
END$$

DELIMITER $$
CREATE PROCEDURE buscar_aula(IN idau CHAR(15))
BEGIN
	SELECT * FROM aula WHERE idaula = idau;
END$$

DELIMITER $$
CREATE PROCEDURE modificar_aula(IN idau CHAR(15), IN na INT, IN cap INT)
BEGIN
	UPDATE aula SET numeroAula=na, capacidad=cap
    WHERE idaula=idau;
END$$

DELIMITER $$
CREATE PROCEDURE eliminar_aula(IN idau CHAR(15))
BEGIN
	DELETE FROM aula WHERE idaula=idau;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarAulas()
BEGIN
	SELECT * FROM aula;
END$$

-- PROCEDIMIENTOS ALMACENADOS PARA LA TABLA HORARIO

DELIMITER $$
CREATE PROCEDURE insertar_horario(IN idho CHAR(15), IN gr VARCHAR(20), IN tr VARCHAR(20),
IN fi DATE, IN he VARCHAR(20), IN hs VARCHAR(20))
BEGIN
	INSERT INTO horario(idhorario,grado,turno,fechaInicio,horaEntrada,horaSalida) 
    VALUES (idho,gr,tr,fi,he,hs);
END$$

DELIMITER $$
CREATE PROCEDURE buscar_horario(IN idho CHAR(15))
BEGIN
	SELECT * FROM horario WHERE idhorario = idho;
END$$

DELIMITER $$
CREATE PROCEDURE modificar_horario(IN idho CHAR(15), IN gr VARCHAR(20), IN tr VARCHAR(20),
IN fi DATE, IN he VARCHAR(20), IN hs VARCHAR(20))
BEGIN
	UPDATE horario SET grado=gr, turno=tr, fechaInicio=fi, horaEntrada=he, horaSalida=hs
    WHERE idhorario=idho;
END$$

DELIMITER $$
CREATE PROCEDURE eliminar_horario(IN idho CHAR(15))
BEGIN
	DELETE FROM horario WHERE idhorario=idho;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarHorarios()
BEGIN
	SELECT * FROM horario;
END$$

-- PROCEDIMIENTOS ALMACENADOS PARA LA TABLA PROGRAMACION

DELIMITER $$
CREATE PROCEDURE insertar_programacion(IN idpr CHAR(15), IN idho CHAR(15), IN idau CHAR(15))
BEGIN
	INSERT INTO programacion(idprogramacion,idhorario,idaula) 
    VALUES (idpr,idho,idau);
END$$

DELIMITER $$
CREATE PROCEDURE buscar_programacion(IN idpr CHAR(15))
BEGIN
	SELECT * FROM programacion WHERE idprogramacion = idpr;
END$$

DELIMITER $$
CREATE PROCEDURE modificar_programacion(IN idpr CHAR(15), IN idho CHAR(15), IN idau CHAR(15))
BEGIN
	UPDATE programacion SET idhorario=idho, idaula=idau
    WHERE idprogramacion=idpr;
END$$

DELIMITER $$
CREATE PROCEDURE eliminar_programacion(IN idpr CHAR(15))
BEGIN
	DELETE FROM programacion WHERE idprogramacion=idpr;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarProgramacion()
BEGIN
	SELECT * FROM programacion;
END$$

-- PROCEDIMIENTOS ALMACENADOS PARA LA TABLA MATRICULA

DELIMITER $$
CREATE PROCEDURE insertar_matricula(IN idma CHAR(15), IN f DATE,  IN idal CHAR(15), IN idpr CHAR(15))
BEGIN
	INSERT INTO matricula(idmatricula,fecha,idalumno,idprogramacion) 
    VALUES (idma,f,idal,idpr);
END$$

DELIMITER $$
CREATE PROCEDURE buscar_matricula(IN idma CHAR(15))
BEGIN
	SELECT * FROM matricula WHERE idmatricula = idma;
END$$

DELIMITER $$
CREATE PROCEDURE modificar_matricula(IN idma CHAR(15), IN f DATE,  IN idal CHAR(15), IN idpr CHAR(15))
BEGIN
	UPDATE matricula SET fecha=f,idalumno=idal,idprogramacion=idpr
    WHERE idmatricula=idma;
END$$

DELIMITER $$
CREATE PROCEDURE eliminar_matricula(IN idma CHAR(15))
BEGIN
	DELETE FROM matricula WHERE idmatricula=idma;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarMatriculas()
BEGIN
	SELECT * FROM matricula;
END$$

-- PROCEDIMIENTOS ALMACENADOS PARA LA TABLA MATRICULA_CURSO

DELIMITER $$
CREATE PROCEDURE insertar_matricula_curso(IN idma CHAR(15), IN idcu CHAR(15))
BEGIN
	INSERT INTO matricula_curso(idmatricula,idcurso) 
    VALUES (idma,idcu);
END$$

DELIMITER $$
CREATE PROCEDURE buscar_matricula_curso(IN idma CHAR(15))
BEGIN
	SELECT * FROM matricula_curso WHERE idmatricula = idma;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarMatriculas_Cursos()
BEGIN
	SELECT * FROM matricula_curso;
END$$

-- PROCEDIMIENTOS ALMACENADOS PARA LA TABLA DOCENTE_ALUMNO

DELIMITER $$
CREATE PROCEDURE insertar_docente_alumno(IN iddo CHAR(15), IN idal CHAR(15))
BEGIN
	INSERT INTO docente_alumno(iddocente,idalumno) 
    VALUES (iddo,idal);
END$$

DELIMITER $$
CREATE PROCEDURE buscar_docente_alumno(IN iddo CHAR(15))
BEGIN
	SELECT * FROM docente_alumno WHERE iddocente = iddo;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarDocentes_Alumnos()
BEGIN
	SELECT * FROM docente_alumno;
END$$

-- PROCEDIMIENTOS ALMACENADOS PARA LA TABLA USUARIOS

DELIMITER $$
CREATE PROCEDURE insertar_usuario(IN idus CHAR(15), IN cl CHAR(15))
BEGIN
	INSERT INTO usuarios(usuario,clave) 
    VALUES (idus,cl);
END$$

----------------------------------- REPORTES AGRUPADOS -------------------------------------

DELIMITER $$
CREATE PROCEDURE mostrarRelacionAlumno()
BEGIN
	SELECT apoderado.apellidosp, nombresp, 
    alumno.apellidos, nombres 
    FROM alumno
	INNER JOIN apoderado 
    ON apoderado.idapoderado = alumno.idapoderado;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarRelacionDocente_Alumno()
BEGIN
	SELECT docente.apellidosd, nombresd, alumno.apellidos, nombres
    FROM docente_alumno
	INNER JOIN docente 
    ON docente.iddocente = docente_alumno.iddocente
	INNER JOIN alumno 
    ON alumno.idalumno = docente_alumno.idalumno;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarRelacionCurso()
BEGIN
	SELECT curso.nombre, docente.apellidosd, nombresd 
    FROM curso
	INNER JOIN docente 
    ON docente.iddocente = curso.iddocente;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarRelacionProgramacion()
BEGIN
	SELECT programacion.idprogramacion, horario.grado, turno, fechaInicio, 
    aula.numeroAula, capacidad 
    FROM programacion
	INNER JOIN horario 
    ON horario.idhorario = programacion.idhorario
	INNER JOIN aula 
    ON aula.idaula = programacion.idaula;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarRelacionMatricula()
BEGIN
	SELECT matricula.idmatricula, fecha, 
    alumno.apellidos, nombres, programacion.idprogramacion 
    FROM matricula
	INNER JOIN alumno 
    ON alumno.idalumno = matricula.idalumno
	INNER JOIN programacion 
    ON programacion.idprogramacion = matricula.idprogramacion;
END$$

DELIMITER $$
CREATE PROCEDURE mostrarRelacionMatricula_Curso()
BEGIN
	SELECT matricula.idmatricula, fecha, curso.nombre 
    FROM matricula_curso
	INNER JOIN matricula 
    ON matricula.idmatricula = matricula_curso.idmatricula
	INNER JOIN curso 
    ON curso.idcurso = matricula_curso.idcurso;
END$$
