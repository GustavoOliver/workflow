-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.21-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema workflow
--

CREATE DATABASE IF NOT EXISTS workflow;
USE workflow;

--
-- Definition of table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
CREATE TABLE `cargo` (
  `idCargo` int(10) unsigned NOT NULL auto_increment,
  `Descricao` varchar(255) NOT NULL,
  `funcao` text NOT NULL,
  PRIMARY KEY  (`idCargo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cargo`
--

/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` (`idCargo`,`Descricao`,`funcao`) VALUES 
 (1,'Atendente','Cadastros e Relatórios'),
 (2,'Técnico','Responsável por realizar manutenção nas máquinas');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;


--
-- Definition of table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `idCliente` int(10) unsigned NOT NULL auto_increment,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(45) default NULL,
  `email` varchar(255) default NULL,
  `senha` blob NOT NULL,
  PRIMARY KEY  (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cliente`
--

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`idCliente`,`nome`,`telefone`,`email`,`senha`) VALUES 
 (1,'Marlon Silva','(19) 7070-7070','marlon2009@globomail.com',0x31323334),
 (2,'Ícaro Mendes','(19) 6060-6060','icaromendes@icaro.com',0x34333231),
 (3,'Giovani Giacomeli','(19) 6666-666','giovani@hel.net',0x36363636);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


--
-- Definition of table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
CREATE TABLE `endereco` (
  `idEndereco` int(10) unsigned NOT NULL auto_increment,
  `rua` varchar(255) default NULL,
  `numero` int(10) unsigned default NULL,
  `bairro` varchar(255) default NULL,
  PRIMARY KEY  (`idEndereco`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `endereco`
--

/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;


--
-- Definition of table `endereco_cliente`
--

DROP TABLE IF EXISTS `endereco_cliente`;
CREATE TABLE `endereco_cliente` (
  `idEndereco_Cliente` int(10) unsigned NOT NULL auto_increment,
  `Endereco_idEndereco` int(10) unsigned NOT NULL,
  `Cliente_idCliente` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`idEndereco_Cliente`),
  KEY `Endereco_Cliente_FKIndex1` (`Cliente_idCliente`),
  KEY `Endereco_Cliente_FKIndex2` (`Endereco_idEndereco`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `endereco_cliente`
--

/*!40000 ALTER TABLE `endereco_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereco_cliente` ENABLE KEYS */;


--
-- Definition of table `endereco_func`
--

DROP TABLE IF EXISTS `endereco_func`;
CREATE TABLE `endereco_func` (
  `idEndereco_Func` int(10) unsigned NOT NULL auto_increment,
  `Endereco_idEndereco` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`idEndereco_Func`),
  KEY `Endereco_Func_FKIndex1` (`Endereco_idEndereco`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `endereco_func`
--

/*!40000 ALTER TABLE `endereco_func` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereco_func` ENABLE KEYS */;


--
-- Definition of table `estado`
--

DROP TABLE IF EXISTS `estado`;
CREATE TABLE `estado` (
  `idStatus` int(10) unsigned NOT NULL auto_increment,
  `descricao` text NOT NULL,
  PRIMARY KEY  (`idStatus`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `estado`
--

/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` (`idStatus`,`descricao`) VALUES 
 (1,'Aprovado'),
 (2,'Reprovado'),
 (3,'Finalizado'),
 (4,'Em Analise'),
 (5,'Recusado'),
 (6,'Em espera');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;


--
-- Definition of table `etapa`
--

DROP TABLE IF EXISTS `etapa`;
CREATE TABLE `etapa` (
  `idEtapa` int(10) unsigned NOT NULL auto_increment,
  `Processo_idProcesso` int(10) unsigned NOT NULL,
  `Estado_idStatus` int(10) unsigned NOT NULL,
  `descricao` text NOT NULL,
  `data` date NOT NULL,
  PRIMARY KEY  USING BTREE (`idEtapa`),
  KEY `Etapa_FKIndex1` (`Estado_idStatus`),
  KEY `Etapa_FKIndex2` (`Processo_idProcesso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `etapa`
--

/*!40000 ALTER TABLE `etapa` DISABLE KEYS */;
/*!40000 ALTER TABLE `etapa` ENABLE KEYS */;


--
-- Definition of table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE `funcionario` (
  `idFuncionario` int(10) unsigned NOT NULL auto_increment,
  `Cargo_idCargo` int(10) unsigned NOT NULL,
  `nome` varchar(255) NOT NULL,
  `sobrenome` varchar(255) NOT NULL,
  `rg` varchar(50) NOT NULL,
  `cpf` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `senha` blob NOT NULL,
  PRIMARY KEY  (`idFuncionario`),
  KEY `Funcionario_FKIndex1` (`Cargo_idCargo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `funcionario`
--

/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`idFuncionario`,`Cargo_idCargo`,`nome`,`sobrenome`,`rg`,`cpf`,`email`,`senha`) VALUES 
 (1,2,'Lucas','Vinicius','4587556','564646','lucas-vini@alpha.com.br',0x313432353336),
 (2,1,'Alberth','Skivolanky','54643','365483435','albertSK@alpha.com.br',0x30);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;


--
-- Definition of table `maquina`
--

DROP TABLE IF EXISTS `maquina`;
CREATE TABLE `maquina` (
  `idMaquina` int(10) unsigned NOT NULL auto_increment,
  `Cliente_idCliente` int(10) unsigned NOT NULL,
  `Descricao` text,
  PRIMARY KEY  (`idMaquina`),
  KEY `Maquina_FKIndex1` (`Cliente_idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `maquina`
--

/*!40000 ALTER TABLE `maquina` DISABLE KEYS */;
INSERT INTO `maquina` (`idMaquina`,`Cliente_idCliente`,`Descricao`) VALUES 
 (1,1,'Modelo 1'),
 (2,1,'Modelo 2'),
 (3,1,'Modelo 3'),
 (4,2,'Modelo 2'),
 (5,2,'Modelo 3'),
 (6,2,'Modelo 4'),
 (7,3,'Modelo 5'),
 (8,3,'Modelo 6'),
 (9,3,'Modelo 7');
/*!40000 ALTER TABLE `maquina` ENABLE KEYS */;


--
-- Definition of table `os`
--

DROP TABLE IF EXISTS `os`;
CREATE TABLE `os` (
  `idOS` int(10) unsigned NOT NULL auto_increment,
  `Processo_idProcesso` int(10) unsigned NOT NULL,
  `Funcionario_idFuncionario` int(10) unsigned NOT NULL,
  `Cliente_idCliente` int(10) unsigned NOT NULL,
  `Maquina_idMaquina` int(10) unsigned NOT NULL,
  `dateOS` date NOT NULL,
  `idEtapa` int(10) unsigned NOT NULL,
  `data` datetime NOT NULL,
  PRIMARY KEY  (`idOS`),
  KEY `OS_FKIndex1` (`Maquina_idMaquina`),
  KEY `OS_FKIndex2` (`Cliente_idCliente`),
  KEY `OS_FKIndex3` (`Funcionario_idFuncionario`),
  KEY `OS_FKIndex4` (`Processo_idProcesso`),
  KEY `FK_idEtapa` (`idEtapa`),
  CONSTRAINT `FK_idEtapa` FOREIGN KEY (`idEtapa`) REFERENCES `etapa` (`idEtapa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `os`
--

/*!40000 ALTER TABLE `os` DISABLE KEYS */;
/*!40000 ALTER TABLE `os` ENABLE KEYS */;


--
-- Definition of table `processo`
--

DROP TABLE IF EXISTS `processo`;
CREATE TABLE `processo` (
  `idProcesso` int(10) unsigned NOT NULL auto_increment,
  `Funcionario_idFuncionario` int(10) unsigned NOT NULL,
  `descricao` text NOT NULL,
  `dataProc` date default NULL,
  PRIMARY KEY  (`idProcesso`),
  KEY `Processo_FKIndex2` (`Funcionario_idFuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `processo`
--

/*!40000 ALTER TABLE `processo` DISABLE KEYS */;
INSERT INTO `processo` (`idProcesso`,`Funcionario_idFuncionario`,`descricao`,`dataProc`) VALUES 
 (1,1,'Manutenção','0000-00-00'),
 (2,1,'Teste','2000-01-01');
/*!40000 ALTER TABLE `processo` ENABLE KEYS */;


--
-- Definition of table `tipo_cliente`
--

DROP TABLE IF EXISTS `tipo_cliente`;
CREATE TABLE `tipo_cliente` (
  `idTipo_Cliente` int(10) unsigned NOT NULL auto_increment,
  `Cliente_idCliente` int(10) unsigned NOT NULL,
  `juridico` tinyint(1) default NULL,
  `fisico` tinyint(1) default NULL,
  `documento` varchar(255) NOT NULL,
  PRIMARY KEY  (`idTipo_Cliente`),
  KEY `Tipo_Cliente_FKIndex1` (`Cliente_idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_cliente`
--

/*!40000 ALTER TABLE `tipo_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_cliente` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
