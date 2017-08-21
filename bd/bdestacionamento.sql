CREATE DATABASE  IF NOT EXISTS `bdestacionamento` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bdestacionamento`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bdestacionamento
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id_cliente` int(7) NOT NULL AUTO_INCREMENT,
  `data_inclusao` varchar(8) NOT NULL,
  `data_ultima_alteracao` varchar(8) DEFAULT NULL,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `identidade` varchar(11) DEFAULT NULL,
  `telefone` varchar(10) DEFAULT NULL,
  `celular` varchar(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `data_nascimento` varchar(8) DEFAULT NULL,
  `cep_residencia` varchar(8) DEFAULT NULL,
  `rua_residencia` varchar(45) DEFAULT NULL,
  `numero_residencia` varchar(8) DEFAULT NULL,
  `complemento_residencia` varchar(45) DEFAULT NULL,
  `bairro_residencia` varchar(25) DEFAULT NULL,
  `cidade_residencia` varchar(25) DEFAULT NULL,
  `estado_residencia` varchar(20) DEFAULT NULL,
  `empresa` varchar(45) DEFAULT NULL,
  `cep_comercial` varchar(8) DEFAULT NULL,
  `rua_comercial` varchar(45) DEFAULT NULL,
  `numero_comercial` varchar(8) DEFAULT NULL,
  `complemento_comercial` varchar(20) DEFAULT NULL,
  `bairro_comercial` varchar(25) DEFAULT NULL,
  `cidade_comercial` varchar(25) DEFAULT NULL,
  `estado_comercial` varchar(20) DEFAULT NULL,
  `telefone_comercial` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `id_mensalista_UNIQUE` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'','26072017','Eduardo Santana','09065887741','0201433331','2126058547','21983288411','carlos.esc@live.com','','24435420','','','','','','','','','','','','','','','0000000000'),(2,'','30072017','Shirlei da Silva','09065887741','311252','2112345678','21659855454','Shirlei@Coelho','','','','','','','','','','','','','','','','','0'),(38,'12082017','','Solrac Odraude','09065887741','','','','','','','','','','','','','','','','','','','','','');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configuracoes`
--

DROP TABLE IF EXISTS `configuracoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `configuracoes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tolerancia_desistencia` int(11) NOT NULL DEFAULT '3',
  `tolerancia_fracoes` int(11) NOT NULL DEFAULT '5',
  `diaria_hora` int(11) NOT NULL DEFAULT '3',
  `diaria_minuto` int(11) NOT NULL DEFAULT '31',
  `pernoite_inicio` varchar(5) NOT NULL DEFAULT '21:00',
  `pernoite_termino` varchar(5) NOT NULL DEFAULT '09:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuracoes`
--

LOCK TABLES `configuracoes` WRITE;
/*!40000 ALTER TABLE `configuracoes` DISABLE KEYS */;
INSERT INTO `configuracoes` VALUES (1,5,2,3,0,'19:00','9:00');
/*!40000 ALTER TABLE `configuracoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contrato` (
  `id_contrato` int(7) NOT NULL AUTO_INCREMENT,
  `id_cliente_fk` int(7) NOT NULL,
  `placa_1` varchar(7) DEFAULT NULL,
  `placa_2` varchar(7) DEFAULT NULL,
  `placa_3` varchar(7) DEFAULT NULL,
  `placa_4` varchar(7) DEFAULT NULL,
  `status` varchar(7) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `medicao` varchar(11) NOT NULL,
  `quantidade` int(2) NOT NULL,
  `data_inicio` varchar(8) NOT NULL,
  `data_termino` varchar(8) NOT NULL,
  `dia_vencimento` varchar(2) NOT NULL,
  `valor` float NOT NULL,
  `ultima_alteracao` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id_contrato`),
  UNIQUE KEY `id_contrato_UNIQUE` (`id_contrato`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fatura`
--

DROP TABLE IF EXISTS `fatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fatura` (
  `id_fatura` int(7) NOT NULL AUTO_INCREMENT,
  `id_contrato_fk` int(7) NOT NULL,
  `mes_referencia` varchar(2) NOT NULL,
  `status` varchar(8) NOT NULL,
  PRIMARY KEY (`id_fatura`),
  UNIQUE KEY `idfatura_UNIQUE` (`id_fatura`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fatura`
--

LOCK TABLES `fatura` WRITE;
/*!40000 ALTER TABLE `fatura` DISABLE KEYS */;
INSERT INTO `fatura` VALUES (1,2,'','Não Paga'),(2,2,'','Paga'),(3,2,'','Paga'),(4,3,'08','Paga'),(5,1,'07','Não Paga');
/*!40000 ALTER TABLE `fatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patio`
--

DROP TABLE IF EXISTS `patio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patio` (
  `id_patio` int(7) NOT NULL AUTO_INCREMENT,
  `id_contrato_fk` int(7) NOT NULL,
  `placa` varchar(7) NOT NULL,
  `rps` varchar(20) NOT NULL,
  `prisma` varchar(4) NOT NULL,
  `tipo` varchar(25) NOT NULL,
  `preco_30_minutos` float NOT NULL,
  `preco_60_minutos` float NOT NULL,
  `preco_demais_fracoes` float NOT NULL,
  `preco_diaria` float NOT NULL,
  `preco_pernoite` float NOT NULL,
  `estacionado` varchar(3) NOT NULL,
  `data_entrada` varchar(10) NOT NULL,
  `hora_entrada` varchar(5) NOT NULL,
  `tolerancia_desistencia` int(2) NOT NULL,
  `tolerancia_entre_fracoes` int(2) NOT NULL,
  `diaria_horas` int(2) NOT NULL,
  `diaria_minutos` int(2) NOT NULL,
  `pernoite_inicio` varchar(5) NOT NULL,
  `pernoite_termino` varchar(5) NOT NULL,
  `data_saida` varchar(10) DEFAULT NULL,
  `hora_saida` varchar(5) DEFAULT NULL,
  `permanencia` varchar(25) DEFAULT NULL,
  `valor_total` float DEFAULT NULL,
  `data_entrada_hora_minuto` varchar(10) DEFAULT NULL,
  `data_entrada_valor` float DEFAULT NULL,
  `data_saida_hora_minuto` varchar(10) DEFAULT NULL,
  `data_saida_valor` float DEFAULT NULL,
  `diaria_quantidade` int(11) DEFAULT NULL,
  `diaria_valor_total` float DEFAULT NULL,
  `pernoite_quantidade` int(11) DEFAULT NULL,
  `pernoite_valor_total` float DEFAULT NULL,
  PRIMARY KEY (`id_patio`),
  UNIQUE KEY `rps_UNIQUE` (`rps`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patio`
--

LOCK TABLES `patio` WRITE;
/*!40000 ALTER TABLE `patio` DISABLE KEYS */;
INSERT INTO `patio` VALUES (115,1,'ABC1234','20170811210756','01','Mensalista',4,8,4,32,15,'sim','11/08/2017','21:07',5,2,3,0,'19:00','9:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(118,0,'AAA1111','20170812110956','03','Bicicleta',1,2,1,15,10,'sim','12/08/2017','11:09',5,2,3,0,'19:00','9:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(119,2,'BCA4321','20170812111156','02','Mensalista',0,0,0,0,0,'sim','12/08/2017','11:11',5,2,3,0,'19:00','9:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `patio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rotativo`
--

DROP TABLE IF EXISTS `rotativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rotativo` (
  `id_rotativo` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(12) NOT NULL DEFAULT 'Rotativo',
  `nome` varchar(30) CHARACTER SET ucs2 NOT NULL,
  `preco30minutos` float NOT NULL,
  `preco60minutos` float NOT NULL,
  `precodemaisfracoes` float NOT NULL,
  `precodiaria` float NOT NULL,
  `precopernoite` float NOT NULL,
  PRIMARY KEY (`id_rotativo`),
  UNIQUE KEY `tipo_UNIQUE` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rotativo`
--

LOCK TABLES `rotativo` WRITE;
/*!40000 ALTER TABLE `rotativo` DISABLE KEYS */;
INSERT INTO `rotativo` VALUES (14,'Rotativo','Carro',4,8,4,32,15),(23,'Rotativo','Bicicleta',1,2,1,15,10),(24,'Rotativo','Moto',4,8,4,32,15),(25,'Rotativo','Teste',10,15,2,30,15);
/*!40000 ALTER TABLE `rotativo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `cargo` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_UNIQUE` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veiculo` (
  `id_veiculo` int(7) NOT NULL AUTO_INCREMENT,
  `placa` varchar(7) NOT NULL,
  `data_hora_cadastro` varchar(16) NOT NULL,
  `data_hora_primeira_utilizacao` varchar(16) DEFAULT NULL,
  `data_hora_ultima_alteracao` varchar(16) DEFAULT NULL,
  `marca` varchar(20) DEFAULT NULL,
  `modelo` varchar(20) DEFAULT NULL,
  `cor` varchar(15) DEFAULT NULL,
  `ano_modelo` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`placa`),
  UNIQUE KEY `placa_UNIQUE` (`placa`),
  UNIQUE KEY `id_veiculo_UNIQUE` (`id_veiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
INSERT INTO `veiculo` VALUES (96,'AAA1111','12/08/2017 10:05','12/08/2017 10:05',NULL,NULL,NULL,NULL,NULL),(93,'ABC1234','11/08/2017 20:49','11/08/2017 20:49',NULL,NULL,NULL,NULL,NULL),(95,'BCA4321','12/08/2017 09:55','12/08/2017 09:55',NULL,NULL,NULL,NULL,NULL),(92,'LBF6141','10/08/2017 21:03','10/08/2017 21:03',NULL,NULL,NULL,NULL,NULL),(94,'ZZZ9999','11/08/2017 20:56','11/08/2017 20:56',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-21 20:32:25
