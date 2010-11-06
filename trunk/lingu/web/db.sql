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

CREATE TABLE `dbmc536b16`.`Usuario` (
`ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`Nome` VARCHAR( 60 ) NOT NULL ,
`Tipo` INT NOT NULL ,
`Pais` VARCHAR( 60 ) NOT NULL ,
`Lingua` VARCHAR( 30 ) NOT NULL ,
`Email` VARCHAR( 60 ) NOT NULL ,
`Senha` VARCHAR( 12 ) NOT NULL ,
`IDRede` INT NOT NULL
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_unicode_ci;




