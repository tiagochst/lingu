drop table USUARIO;
drop table PARTICIPANTE;
drop table PALESTRANTE;
drop table PALESTRA;
drop table PARTICIPANTE;
drop table AvaliaArtigo;
drop table AvaliaPos;
drop table TRABALHO;
drop table FeedbackPalestra;
drop table FeedbackPalestrante;
drop table PositivosPalestra;
drop table PositivosPalestrante;
drop table PositivosConferencia;
drop table FeedbackConferencia;
drop table FOTO; 

CREATE TABLE USUARIO (
    ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(60) not null,
    SENHA VARCHAR(10) not null,
    TIPO VARCHAR(20) not null,
    EMAIL VARCHAR(60),
    RG VARCHAR(15),
    NASCIMENTO DATE,
    PAIS VARCHAR(60)
);

CREATE TABLE PALESTRA (
    ID INTEGER not null primary key AUTO_INCREMENT  ,
    AREA VARCHAR(60) not null,
    NOME VARCHAR(60) not null,
    PALESTRANTEID INTEGER REFERENCES PALESTRANTE(ID)
  );

CREATE TABLE TRABALHO (
    ID INTEGER not null primary key AUTO_INCREMENT,
    ESTADO VARCHAR(60) not null,
    NOTA FLOAT 
 );


CREATE TABLE AvaliaArtigo (
    ID INTEGER not null primary key AUTO_INCREMENT,
    COMENTARIO VARCHAR(500) not null,
    NOTA INTEGER,
    DENOVO INTEGER
 )TYPE=INNODB;
CREATE TABLE ArtigoPos (
   IDAval INTEGER ,
   Positivo VARCHAR(20),
   INDEX INDVal (IDAval),
   FOREIGN KEY (IDAval) REFERENCES AvaliaArtigo(ID)
   ON DELETE SET NULL
 ) TYPE=INNODB;

CREATE TABLE FeedbackPalestra (
    ID INTEGER not null primary key AUTO_INCREMENT,
    COMENTARIO VARCHAR(500) not null,
    NOTA INTEGER,
    DENOVO INTEGER,
    IDPal INTEGER not null
 )TYPE=INNODB;
CREATE TABLE PositivosPalestra (
   IDAval INTEGER ,
   Positivo VARCHAR(20),
   INDEX INDVal (IDAval),
   FOREIGN KEY (IDAval) REFERENCES FeedbackPalestra(ID)
   ON DELETE SET NULL
 ) TYPE=INNODB;

CREATE TABLE FeedbackPalestrante (
    ID INTEGER not null primary key AUTO_INCREMENT,
    COMENTARIO VARCHAR(500) not null,
    NOTA INTEGER,
    DENOVO INTEGER,
    IDPalestrante INTEGER not null
 )TYPE=INNODB;
CREATE TABLE PositivosPalestrante (
   IDFdbkPal INTEGER ,
   Positivo VARCHAR(20),
   INDEX INDVal (IDFdbkPal),
   FOREIGN KEY (IDFdbkPal) REFERENCES FeedbackPalestra(ID)
   ON DELETE SET NULL
 ) TYPE=INNODB;


CREATE TABLE FeedbackConferencia (
    ID INTEGER not null primary key AUTO_INCREMENT,
    COMENTARIO VARCHAR(500) not null,
    NOTA INTEGER,
    DENOVO INTEGER
 )TYPE=INNODB;
CREATE TABLE PositivosConferencia (
   IDFdbkConf INTEGER ,
   Positivo VARCHAR(20),
   INDEX INDVal (IDFdbkConf),
   FOREIGN KEY (IDFdbkConf) REFERENCES FeedbackPalestra(ID)
   ON DELETE SET NULL
 ) TYPE=INNODB;

CREATE TABLE FOTO (
    ID INTEGER not null primary key AUTO_INCREMENT,
    DATA DATE,
    DESCRICAO VARCHAR(120)
 );

INSERT INTO USUARIO values(NULL,"Tiago","Tiago","Participante","tiagochst@gmail.com","00000000-0",'1990-05-04',"Brasil");
INSERT INTO USUARIO values(NULL,"Mari","Mari","Palestrante","mari@mari.com","00000000-0",'1988-09-04',"Brasil");
INSERT INTO USUARIO values(NULL,"Murilo","Murilo","Palestrante","fake@murilo.com","11111111-0",'1989-10-10',"Brasil");
INSERT INTO USUARIO values(NULL,"Plinio","Plinio","Palestrante","plinio@plinio.com","11111111-0",'1989-10-10',"Brasil");
INSERT INTO USUARIO values(NULL,"Raquel","Raquel","Palestrante","rmk@rmk.com","11111111-0",'1989-10-10',"Coreia");
INSERT INTO USUARIO values(NULL,"Tiago","Tiago","Palestrante","tcs@tcs.com","11111111-0",'1989-10-10',"Brasil");


INSERT INTO PALESTRA values(NULL,"Compiladores","Palestra da Mari",2);
INSERT INTO PALESTRA values(NULL,"Sistemas Embarcados","Palestra do Murilo",3);
INSERT INTO PALESTRA values(NULL,"IA","Palestra do plinio",4);
INSERT INTO PALESTRA values(NULL,"Linux","Palestra da Raquel",5);
INSERT INTO PALESTRA values(NULL,"Microsoft","Palestra do Tiago",6);

INSERT INTO FOTO values(NULL,'1989-10-10',"Foto do IC");
INSERT INTO FOTO values(NULL,'1999-10-10',"Foto da Unicamp");


