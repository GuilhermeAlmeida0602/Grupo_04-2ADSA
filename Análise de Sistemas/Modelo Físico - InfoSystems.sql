create database InfoSystems;

##drop database InfoSystems;
use InfoSystems;

-- Tabelas de dados estáticos

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
  fkEmpresa INT NOT NULL,
  nomeUsuario VARCHAR(45) NOT NULL,
  sobrenomeUsuario VARCHAR(45) NOT NULL,
  login VARCHAR(35) NOT NULL UNIQUE,
  senha VARCHAR(35) NOT NULL,
  telefoneCelular CHAR(11) NOT NULL,
  telefoneFixo CHAR(10) NOT NULL) AUTO_INCREMENT = 40;
  
  CREATE TABLE Maquina (
  idMaquina INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  fkEmpresa INT NOT NULL,
  hostname VARCHAR(70) NOT NULL,
  sistemaOperacionalSO VARCHAR(45) NOT NULL,
  arquiteturaSO INT NOT NULL,
  fabricanteCPU VARCHAR(60) NOT NULL,
  nomeCPU VARCHAR(60) NOT NULL,
  identificadorCPU VARCHAR(60) NOT NULL,
  microArquiteturaCPU VARCHAR(60) NOT NULL,
  frequenciaCPU VARCHAR(35) NOT NULL,
  pacotesFisicosCPU INT NOT NULL,  
  cpuFisicosCPU INT NOT NULL,
  cpuLogicosCPU INT NOT NULL,
  ip VARCHAR(35) NOT NULL,
  reiniciar BIT NOT NULL,
  limpezaDeCache BIT NOT NULL,
  dataDeRegistro DATETIME);
  
  CREATE TABLE Disco (
  idDisco INT PRIMARY KEY AUTO_INCREMENT NOT NULL ,
  fkMaquina INT NOT NULL,
  nome VARCHAR(45) NOT NULL,
  modelo VARCHAR(80) NOT NULL,
  tamanho VARCHAR(15) NOT NULL,
  qtdLeitura VARCHAR(15) NOT NULL,
  bytesLeitura VARCHAR(15) NOT NULL,
  qtdEscritas VARCHAR(15) NOT NULL,
  tipo VARCHAR(45) NOT NULL,
  montagem VARCHAR(45) NOT NULL,
  dataDeRegistro DATETIME NOT NULL);
  
  -- Tabelas de dados dinâmicos
  
  CREATE TABLE dadosDisco (
  idDadosDisco INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  fkDisco INT NOT NULL,
  discoDisponivelHD INT NOT NULL,
  dataRegistroDados DATETIME NOT NULL);
  
  CREATE TABLE dadosMaquina (
  idDadosMaquina INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  fkMaquina INT NOT NULL,
  inicializadoSO VARCHAR(30) NOT NULL,
  tempoDeAtividadeSO INT NOT NULL,
  usuarioSO VARCHAR(30) NOT NULL,
  emUsoCPU INT NOT NULL,
  emUsoMEM INT NOT NULL,
  disponivelMEM INT NOT NULL,
  totalMEM VARCHAR(10) NOT NULL,
  dataRegistro DATETIME NOT NULL);
  
  CREATE TABLE processosMaquina (
  idprocessoMaquina INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  fkMaquina INT NOT NULL,
  processo VARCHAR(100) NOT NULL,
  pid INT NOT NULL,
  usoCPU INT NOT NULL,
  usoMemoria FLOAT NOT NULL,
  encerrarProcessos BIT NOT NULL,
  dataProcesso DATETIME NOT NULL);
    
  CREATE TABLE StatusMaquina (
  fkMaquina INT PRIMARY KEY NOT NULL UNIQUE,
  statusMaq VARCHAR(45) NOT NULL,
  dataStatus DATETIME NOT NULL);
  
  
  -- Referência 
ALTER TABLE Maquina ADD FOREIGN KEY (fkEmpresa)
  REFERENCES Empresa (idEmpresa);

ALTER TABLE Disco ADD FOREIGN KEY (fkMaquina)
  REFERENCES Maquina (idMaquina);

ALTER TABLE dadosDisco ADD FOREIGN KEY (fkDisco)
  REFERENCES Disco (idDisco);

ALTER TABLE dadosMaquina ADD FOREIGN KEY (fkMaquina)
  REFERENCES Maquina (idMaquina);

ALTER TABLE processosMaquina ADD FOREIGN KEY (fkMaquina)
  REFERENCES Maquina (idMaquina);

 ALTER TABLE StatusMaquina ADD FOREIGN KEY (fkMaquina)
  REFERENCES Maquina (idMaquina);
  
  -- Empresa fictícia
  
  insert into Empresa values (null, 'ChickenFood', '14961289000110', 'contato@chickenfood.com.br',
	'food123', 'Rua Sumaré', 638, null, 'Jardim São Francisco(Zona Sul)', 'SP', '04918300', 
    'Renato Oliveira', '1135936259');
    
  insert into Usuario values (null, 1,'Armando', 'Fontes', 'armando.fontes@chickenfood.com.br', 
  'tortaLaranja123', '11997353581', '1128379572');
  
  ##select * from empresa;
  ##select * from usuario;
  select * from maquina;
  select * from disco;
  select * from dadosdisco;
  select * from dadosMaquina;
  select * from processosMaquina;
  select * from statusmaquina;
  
--  select processo from processosMaquina where encerrarProcessos = 1 and fkMaquina = 1;
  
##  select *  from usuario inner join empresa on idEmpresa = (fkempresa);
  
## select uuid from maquina where uuid='e4f03440-fe49-4a1a-815f-8eb447596398';
 
## select fkEmpresa, login, senha from usuario where login='armando.fontes@chickenfood.com.br' and senha='tortaLaranja123';

## select idMaquina from Maquina where hostname = ?;

## select idDisco from Disco where montagem = ? and fkMaquina = ?;

-- update Maquina set reiniciar=1 where idMaquina=1;

-- TRUNCATE TABLE processosMaquina;

-- update processosMaquina set encerrarprocessos=1 where fkMaquina=1 and idprocessoMaquina=38;
  
  