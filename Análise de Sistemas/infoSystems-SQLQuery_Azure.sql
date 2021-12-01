
use infoSystems;

-- Tabelas de dados estáticos

CREATE TABLE Empresa
(
  idEmpresa INT PRIMARY KEY IDENTITY(500, 1),
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


CREATE TABLE Usuario
(
  idUsuario INT PRIMARY KEY NOT NULL IDENTITY(101, 1),
  fkEmpresa INT NOT NULL,
  priNome VARCHAR(70) NOT NULL,
  ultNome VARCHAR(70) NOT NULL,
  telCelUsuario CHAR(11) NOT NULL,
  telFixUsuario CHAR(10) NOT NULL,
  emailUsuario VARCHAR(50) NOT NULL UNIQUE,
  senhaUsuario VARCHAR(50) NOT NULL,
);

CREATE TABLE Maquina
(
  idMaquina INT PRIMARY KEY IDENTITY NOT NULL,
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
  dataDeRegistro SMALLDATETIME
);

CREATE TABLE Disco
(
  idDisco INT PRIMARY KEY IDENTITY NOT NULL ,
  fkMaquina INT NOT NULL,
  nome VARCHAR(45) NOT NULL,
  modelo VARCHAR(80) NOT NULL,
  tamanho VARCHAR(15) NOT NULL,
  qtdLeitura VARCHAR(15) NOT NULL,
  bytesLeitura VARCHAR(15) NOT NULL,
  qtdEscritas VARCHAR(15) NOT NULL,
  tipo VARCHAR(45) NOT NULL,
  montagem VARCHAR(45) NOT NULL,
  dataDeRegistro DATETIME NOT NULL
);

-- Tabelas de dados dinâmicos

CREATE TABLE DadosDisco
(
  idDadosDisco INT PRIMARY KEY IDENTITY NOT NULL,
  fkDisco INT NOT NULL,
  discoDisponivelHD INT NOT NULL,
  dataRegistroDados DATETIME NOT NULL
);

CREATE TABLE DadosMaquina
(
  idDadosMaquina INT PRIMARY KEY IDENTITY NOT NULL,
  fkMaquina INT NOT NULL,
  inicializadoSO VARCHAR(30) NOT NULL,
  tempoDeAtividadeSO VARCHAR(25) NOT NULL,
  usuarioSO VARCHAR(30) NOT NULL,
  emUsoCPU INT NOT NULL,
  emUsoMEM INT NOT NULL,
  disponivelMEM INT NOT NULL,
  totalMEM VARCHAR(10) NOT NULL,
  dataRegistro DATETIME NOT NULL
);

CREATE TABLE ProcessosMaquina
(
  idprocessoMaquina INT PRIMARY KEY IDENTITY NOT NULL,
  fkMaquina INT NOT NULL,
  processo VARCHAR(100) NOT NULL,
  pid INT NOT NULL,
  usoCPU INT NOT NULL,
  usoMemoria FLOAT NOT NULL,
  encerrarProcessos BIT NOT NULL,
  dataProcesso DATETIME NOT NULL
);

CREATE TABLE StatusMaquina
(
  fkMaquina INT PRIMARY KEY  NOT NULL,
  statusMaq VARCHAR(45) NOT NULL,
  dataStatus DATETIME NOT NULL
);

-- drop table StatusMaquina;
-- drop table ProcessosMaquina;
-- drop table DadosMaquina;
-- drop table DadosDisco;
-- drop table Disco; 
-- drop table Maquina;
-- drop table Usuario;
-- drop table Empresa;

-- Referência 

ALTER TABLE Maquina ADD FOREIGN KEY (fkEmpresa)
  REFERENCES Empresa (idEmpresa);

ALTER TABLE Disco ADD FOREIGN KEY (fkMaquina)
  REFERENCES Maquina (idMaquina);

ALTER TABLE DadosDisco ADD FOREIGN KEY (fkDisco)
  REFERENCES Disco (idDisco);

ALTER TABLE DadosMaquina ADD FOREIGN KEY (fkMaquina)
  REFERENCES Maquina (idMaquina);

ALTER TABLE ProcessosMaquina ADD FOREIGN KEY (fkMaquina)
  REFERENCES Maquina (idMaquina);

ALTER TABLE StatusMaquina ADD FOREIGN KEY (fkMaquina)
  REFERENCES Maquina (idMaquina);

-- ALTER TABLE StatusMaquina ADD FOREIGN KEY (fkEmpresa)
--   REFERENCES Empresa (idEmpresa);

-- Empresa fictícia

-- insert into Empresa
--   (nomeEmpresa, cnpj, email, senha, logradouro, numero,
--   bairro, uf, cep, nomeResponsavel, telResponsavel)
-- values
--   ('ChickenFood',
--     '14961289000110', 'contato@chickenfood.com.br', 'food123', 'Rua Sumaré', 638,
--     'Jardim São Francisco(Zona Sul)', 'SP', '04918300', 'Renato Oliveira', '1135936259');

-- insert into Usuario
--   (fkEmpresa, nomeUsuario, sobrenomeUsuario, [login], senha,
--   telefoneCelular, telefoneFixo)
-- values
--   (1, 'Armando', 'Fontes',
--     'armando.fontes@chickenfood.com.br', 'tortaLaranja123', '11997353581', '1128379572');

--  insert into Maquina (fkEmpresa, sistemaOperacionalSO, arquiteturaSO, fabricanteCPU, nomeCPU,
--  identificadorCPU, microArquiteturaCPU, frequenciaCPU, pacotesFisicosCPU, cpuFisicosCPU, cpuLogicosCPU, 
--  uuid) values (?,?,?,?,?,?,?,?,?,?,?,?);

insert into Empresa 
(nomeEmpresa, cnpj, nomeResponsavel, telResponsavel, emailEmpresa, senhaEmpresa, cepEmpresa, logradouroEmpresa, numeroEmpresa, complementoEmpresa, bairroEmpresa, cidadeEmpresa, ufEmpresa)
 values ('SETIS', '46838302000134', 'Guilherme Fonseca', '11980992290', 'gui@setis.com', 'guisetis123', '03801010', 'Professor Jose de Sousa', '118', 'B', 'Parque Boturussu', 'São Paulo' , 'SP');

insert into Usuario (fkEmpresa, priNome, ultNome, telCelUsuario, telFixUsuario, emailUsuario, senhaUsuario)
 values (500, 'Guilherme', 'Fonseca', '11980992222', '1125454541', 'guifonseca@setis.com', 'guifonseca123');


-- update Maquina set reiniciar =1 where idMaquina=3;

select * from StatusMaquina;
select * from ProcessosMaquina;
select * from DadosMaquina;
select * from DadosDisco;
select * from Disco; 
select * from Maquina;
select * from Usuario;
select * from Empresa;

select * from Usuario where emailUsuario='guifonseca@setis.com' and senhaUsuario='guifonseca123'

SELECT TOP 6 emUsoCPU, dataRegistro FROM dadosMaquina WHERE fkMaquina = 1 ORDER BY idDadosMaquina DESC;
