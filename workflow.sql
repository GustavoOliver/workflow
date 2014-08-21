CREATE TABLE Cargo (
  idCargo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Descricao TEXT NOT NULL,
  PRIMARY KEY(idCargo)
);

CREATE TABLE Cliente (
  idCliente INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  telefone Varchar(45) NULL,
  email VARCHAR(255) NULL,
  senha VARCHAR(255) NOT NULL,
  PRIMARY KEY(idCliente)
);

CREATE TABLE Endereco (
  idEndereco INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  rua VARCHAR(255) NULL,
  numero INTEGER UNSIGNED NULL,
  bairro VARCHAR(255) NULL,
  PRIMARY KEY(idEndereco)
);

CREATE TABLE Endereco_Cliente (
  idEndereco_Cliente INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Endereco_idEndereco INTEGER UNSIGNED NOT NULL,
  Cliente_idCliente INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idEndereco_Cliente),
  INDEX Endereco_Cliente_FKIndex1(Cliente_idCliente),
  INDEX Endereco_Cliente_FKIndex2(Endereco_idEndereco)
);

CREATE TABLE Endereco_Func (
  idEndereco_Func INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Endereco_idEndereco INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idEndereco_Func),
  INDEX Endereco_Func_FKIndex1(Endereco_idEndereco)
);

CREATE TABLE Estado (
  idStatus INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  descricao TEXT NOT NULL,
  PRIMARY KEY(idStatus)
);

CREATE TABLE Etapa (
  idEtapa INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Processo_id INTEGER UNSIGNED NOT NULL,
  Estado_idStatus INTEGER UNSIGNED NOT NULL,
  descricao TEXT NOT NULL,
  PRIMARY KEY(idEtapa, Processo_id),
  INDEX Etapa_FKIndex1(Estado_idStatus),
  INDEX Etapa_FKIndex2(Processo_id)
);

CREATE TABLE Etapa_E_OS (
  Etapa_Processo_id INTEGER UNSIGNED NOT NULL,
  Etapa_idEtapa INTEGER UNSIGNED NOT NULL,
  OS_idOS INTEGER UNSIGNED NOT NULL,
  dataEtapa DATE NOT NULL,
  dataFimEtapa DATE NULL,
  PRIMARY KEY(Etapa_Processo_id, Etapa_idEtapa, OS_idOS),
  INDEX Etapa_has_OS_FKIndex1(Etapa_idEtapa, Etapa_Processo_id),
  INDEX Etapa_has_OS_FKIndex2(OS_idOS)
);

CREATE TABLE Funcionario (
  idFuncionario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Endereco_Func_idEndereco_Func INTEGER UNSIGNED NOT NULL,
  Cargo_idCargo INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(255) NOT NULL,
  sobrenome VARCHAR(255) NOT NULL,
  rg VARCHAR(50) NOT NULL,
  cpf VARCHAR(50) NOT NULL,
  email VARCHAR(255) NOT NULL,
  senha BLOB NOT NULL,
  PRIMARY KEY(idFuncionario),
  INDEX Funcionario_FKIndex1(Cargo_idCargo),
  INDEX Funcionario_FKIndex2(Endereco_Func_idEndereco_Func)
);

CREATE TABLE Maquina (
  idMaquina INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Cliente_idCliente INTEGER UNSIGNED NOT NULL,
  Descricao TEXT NULL,
  PRIMARY KEY(idMaquina),
  INDEX Maquina_FKIndex1(Cliente_idCliente)
);

CREATE TABLE OS (
  idOS INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Funcionario_idFuncionario INTEGER UNSIGNED NOT NULL,
  Cliente_idCliente INTEGER UNSIGNED NOT NULL,
  Maquina_idMaquina INTEGER UNSIGNED NOT NULL,
  dataOS DATE NOT NULL,
  DataFimOS DATE NULL,
  PRIMARY KEY(idOS),
  INDEX OS_FKIndex1(Maquina_idMaquina),
  INDEX OS_FKIndex2(Cliente_idCliente),
  INDEX OS_FKIndex3(Funcionario_idFuncionario)
);

CREATE TABLE OS_E_Processo (
  OS_idOS INTEGER UNSIGNED NOT NULL,
  Processo_id INTEGER UNSIGNED NOT NULL,
  dataProc DATE NULL,
  dataFimProc DATE NULL,
  PRIMARY KEY(OS_idOS, Processo_id),
  INDEX OS_has_Processo_FKIndex1(OS_idOS),
  INDEX OS_has_Processo_FKIndex2(Processo_id)
);

CREATE TABLE Processo (
  id INTEGER UNSIGNED NOT NULL,
  Funcionario_idFuncionario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  descricao TEXT NOT NULL,
  idProcesso INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY(id),
  INDEX Processo_FKIndex2(Funcionario_idFuncionario)
);

CREATE TABLE Tipo_Cliente (
  idTipo_Cliente INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Cliente_idCliente INTEGER UNSIGNED NOT NULL,
  juridico BOOL NULL,
  fisico BOOL NULL,
  documento Varchar(255) NOT NULL,
  PRIMARY KEY(idTipo_Cliente),
  INDEX Tipo_Cliente_FKIndex1(Cliente_idCliente)
);


