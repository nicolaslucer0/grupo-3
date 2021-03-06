USE efc;

DROP TABLE IF EXISTS alumnos;

CREATE TABLE alumnos(
DNI INT(8) NOT NULL,
APY_NOM VARCHAR(20) NOT NULL,
FEC_NAC DATE,
CANT_MAT_APROB int,
PROMEDIO DOUBLE,
FEC_ING DATE,
SEXO CHAR,
ESTADO CHAR,
CONSTRAINT DNI_PK PRIMARY KEY (DNI)
);

INSERT INTO alumnos VALUES(28947563, 'PEREZ Juana Ana', '1975-09-24',16,7.6, '2019-03-29','f','A');
INSERT INTO alumnos VALUES(31968467, 'Ferrari Gerardo',	'1986-09-01',14,8.4, '2019-03-29','m','A');
INSERT INTO alumnos VALUES(24367890, 'GIMENEZ Susana', 	'1975-11-05',12,9.6, '2019-03-29','m','A');
INSERT INTO alumnos VALUES(28574658, 'GIMENEZ Jonathan','1988-06-03',11,10.0,'2019-03-29','m','A');
INSERT INTO alumnos VALUES(33768767, 'CERETO Sebastian','1984-10-10',8,	5.5, '2020-03-28','m','A');
INSERT INTO alumnos VALUES(29495121, 'GIOVANNI Lorenzo','1971-11-11',14,7.5, '2020-03-28','f','A');
INSERT INTO alumnos VALUES(26447564, 'RUFFA Natalia',	'1987-03-01',13,8.5, '2020-03-28','f','A');


