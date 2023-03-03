create database consultorio;

use consultorio;


CREATE TABLE IF NOT EXISTS paciente (
id int NOT NULL AUTO_INCREMENT,
nome varchar(255) NOT NULL,
cpf varchar(45) NOT NULL,
nascimento DATE NOT NULL,
PRIMARY KEY (id)
);


 CREATE TABLE endereco (
  id INT NOT NULL AUTO_INCREMENT,
  logradouro VARCHAR(255) NOT NULL,
  cep VARCHAR(15) NULL,
  id_paciente INT NOT NULL,
  numero INT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_endereco_paciente
    FOREIGN KEY (id_paciente)
    REFERENCES paciente (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
select * from paciente;
select * from endereco;
 
