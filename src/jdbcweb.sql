Create database jdbcweb;

use jdbcweb;

CREATE TABLE Administrador (
       chrAdmCodigo         char(5) NOT NULL,
       chrAdmLogin          char(10) NULL,
       chrAdmPassword       char(10) NULL,
       vchAdmNombres        varchar(50) NULL,
       vchAdmApellidos      varchar(50) NULL
);

ALTER TABLE Administrador
       ADD PRIMARY KEY (chrAdmCodigo);

insert Administrador values('1','admin','admin','Raúl','Romani Flores');
insert Administrador values('2','user','user','Maria','Castillo');

select * from Administrador;


CREATE TABLE Alumno (
       intAluCodigo         int(10) unsigned NOT NULL AUTO_INCREMENT,
       vchAluNombre        varchar(50) NULL,
       vchAluPromedio      integer NULL,
       dtmAluFechaNac       datetime NULL,
       chrAluSexo           char(1) NULL,
       PRIMARY KEY (intAluCodigo)
       
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

insert alumno values(1,'Raúl Romaní Flores',20,null,'M');


CREATE TABLE Curso(
       chrCurCodigo         char(3) NOT NULL,
       vchCurNombre       varchar(50) NULL,
       intCurCredito         integer NULL
);


ALTER TABLE Curso
       ADD PRIMARY KEY (chrCurCodigo);


insert Curso values('1','Java',5);
insert Curso values('2','PHP',5);
insert Curso values('3','PERL',5);

