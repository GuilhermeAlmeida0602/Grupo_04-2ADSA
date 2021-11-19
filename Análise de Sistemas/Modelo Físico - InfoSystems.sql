create database InfoSystems;
#drop database InfoSystems;
use InfoSystems;

-- Tabelas de dados estáticos

CREATE TABLE Empresa (
  idEmpresa INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nomeEmpresa VARCHAR(45) NOT NULL,
  cnpj CHAR(14) NOT NULL,
  nomeResponsavel VARCHAR(45) NOT NULL,
  telResponsavel VARCHAR(11) NOT NULL,
  emailEmpresa VARCHAR(70) NOT NULL,
  senhaEmpresa VARCHAR(70) NOT NULL,
  cepEmpresa CHAR(8) NOT NULL,
  logradouroEmpresa VARCHAR(45) NOT NULL,
  numeroEmpresa INT NOT NULL,
  complementoEmpresa VARCHAR(15),
  bairroEmpresa VARCHAR(60) NOT NULL,
  cidadeEmpresa VARCHAR(60) NOT NULL,
  ufEmpresa CHAR(2) NOT NULL
  );
  
CREATE TABLE Usuario (
  idUsuario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  fkEmpresa INT NOT NULL,
  priNome VARCHAR(70) NOT NULL,
  ultNome VARCHAR(70) NOT NULL,
  telCelUsuario CHAR(11) NOT NULL,
  telFixUsuario CHAR(10) NOT NULL,
  emailUsuario VARCHAR(50) NOT NULL UNIQUE,
  senhaUsuario VARCHAR(50) NOT NULL,
  foreign key (fkEmpresa) references Empresa(idEmpresa)
  ) AUTO_INCREMENT = 40;
  
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
  dataDeRegistro DATETIME,
  foreign key (fkEmpresa) references Empresa(idEmpresa)
  );
  
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
  dataDeRegistro DATETIME NOT NULL,
  foreign key (fkMaquina) references Empresa(idEmpresa)
  );
  
  -- Tabelas de dados dinâmicos
  
CREATE TABLE dadosDisco (
  idDadosDisco INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  fkDisco INT NOT NULL,
  discoDisponivelHD INT NOT NULL,
  dataRegistroDados DATETIME NOT NULL,
  foreign key (fkDisco) references Disco(idDisco)
  );
  
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
  dataRegistro DATETIME NOT NULL,
  foreign key (fkMaquina) references Maquina(idMaquina)
  );
  
CREATE TABLE processosMaquina (
  idprocessoMaquina INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  fkMaquina INT NOT NULL,
  processo VARCHAR(100) NOT NULL,
  pid INT NOT NULL,
  usoCPU INT NOT NULL,
  usoMemoria FLOAT NOT NULL,
  encerrarProcessos BIT NOT NULL,
  dataProcesso DATETIME NOT NULL,
  foreign key (fkMaquina) references Maquina(idMaquina)
  );
    
CREATE TABLE StatusMaquina (
  fkMaquina INT NOT NULL UNIQUE,
  fkEmpresa INT NOT NULL UNIQUE,
  statusMaq VARCHAR(45) NOT NULL,
  dataStatus DATETIME NOT NULL,
  PRIMARY KEY(fkMaquina, fkEmpresa),
  foreign key (fkMaquina) references Maquina(idMaquina)
  );
  
  -- Empresa fictícia
  
  insert into Empresa values (null, 'ChickenFood', '14961289000110', 'contato@chickenfood.com.br',
	'food123', 'Rua Sumaré', 638, null, 'Jardim São Francisco(Zona Sul)', 'SP', '04918300', 
    'Renato Oliveira', '1135936259');
    
insert into Empresa values (null, "SETIS", "46838302000134", "Guilherme Fonseca", "11980992290", "gui@setis.com", "guisetis123", "03801010", "Professor Jose de Sousa", "118", "B", "Parque Boturussu", "São Paulo" , "SP");
    
  #insert into Usuario values (null, 1,'Armando', 'Fontes', 'armando.fontes@chickenfood.com.br', 
  #'tortaLaranja123', '11997353581', '1128379572');
  
  insert into Usuario values (null, 1, "Guilherme", "Fonseca", "11980992222", "1125454541", "guifonseca@setis.com", "guifonseca123");
  
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
 
 select fkEmpresa, emailUsuario, senhaUsuario from usuario where emailUsuario='guifonseca@setis.com' and senhaUsuario='guifonseca123';

## select idMaquina from Maquina where hostname = ?;

## select idDisco from Disco where montagem = ? and fkMaquina = ?;

-- update Maquina set reiniciar=1 where idMaquina=1;

-- TRUNCATE TABLE processosMaquina;

-- update processosMaquina set encerrarprocessos=1 where fkMaquina=1 and idprocessoMaquina=38;
  
 ## select * from Usuario where login='armando.fontes@chickenfood.com.br' and senha='tortaLaranja123';
 
 ##select * from statusmaquina where fkEmpresa = 1;
  