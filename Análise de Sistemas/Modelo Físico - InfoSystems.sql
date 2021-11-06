create database InfoSystems;

## drop database InfoSystems;
use InfoSystems;

CREATE TABLE Empresa (
  idEmpresa INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nomeEmpresa VARCHAR(45) NOT NULL,
  CNPJ CHAR(14) NOT NULL,
  email VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  logradouro VARCHAR(45) NOT NULL,
  numero INT NOT NULL,
  complemento VARCHAR(15),
  bairro VARCHAR(60) NOT NULL,
  UF CHAR(2) NOT NULL,
  CEP CHAR(8) NOT NULL,
  nomeResponsavel VARCHAR(45) NOT NULL,
  telResponsavel VARCHAR(11) NOT NULL);

CREATE TABLE Usuario (
  idUsuario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nomeUsuario VARCHAR(45) NOT NULL,
  sobrenomeUsuario VARCHAR(45) NOT NULL,
  login VARCHAR(35) NOT NULL,
  senha VARCHAR(35) NOT NULL,
  telefoneCelular CHAR(11) NOT NULL,
  telefoneFixo CHAR(10) NOT NULL,
  fkEmpresa INT NOT NULL) AUTO_INCREMENT = 40;
  
  CREATE TABLE Maquina (
  idMaquina INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  fkEmpresa INT NOT NULL,
  sistemaOperacionalSO VARCHAR(45) NOT NULL,
  arquiteturaSO INT NOT NULL,
  fabricanteCPU VARCHAR(60) NOT NULL,
  nomeCPU VARCHAR(60) NOT NULL,
  identificadorCPU VARCHAR(60) NOT NULL,
  microArquiteturaCPU VARCHAR(60) NOT NULL,
  frequenciaCPU FLOAT,
  pacotesFisicosCPU INT NOT NULL,  
  cpuFisicosCPU INT NOT NULL,
  cpuLogicosCPU INT NOT NULL,
  uuid varchar(100)NOT NULL);
  
  -- Referência 
  
 ## ALTER TABLE Usuario ADD CONSTRAINT fkEmpresa FOREIGN KEY (fkEmpresa)
 ##   REFERENCES Empresa (idEmpresa);
  
  -- Empresa fictícia
  
  insert into Empresa values (null, 'ChickenFood', '14961289000110', 'contato@chickenfood.com.br',
	'food123', 'Rua Sumaré', 638, null, 'Jardim São Francisco(Zona Sul)', 'SP', '04918300', 
    'Renato Oliveira', '1135936259');
    
  insert into Usuario values (null, 'Guilherme', 'Almeida', 'gui.almeida@chickenfood.com.br', 
  'Guigui11097', '11997353581', '1128379572', 1);
  
  select login from usuario where login = "gui.almeida@chickenfood.com.br";
  
  select * from empresa;
  select * from usuario;
  select * from maquina;
  
  select *  from usuario inner join empresa on idEmpresa = (fkempresa);
  
##  describe maquina;
  
##select uuid from maquina where uuid='e4f03440-fe49-4a1a-815f-8eb447596398';
 
##select fkEmpresa, login, senha from usuario where login='armando.fontes@chickenfood.com.br' and senha='tortaLaranja123';
  