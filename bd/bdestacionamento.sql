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
  `data_inclusao` varchar(10) NOT NULL,
  `data_ultima_alteracao` varchar(10) DEFAULT NULL,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `identidade` varchar(11) DEFAULT NULL,
  `telefone` varchar(10) DEFAULT NULL,
  `celular` varchar(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `data_nascimento` varchar(10) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'','25/08/2017','Carlos','09065887741','','','21983288411','carlos.esc@live.com','','24435420','','','','','','','','','','','','','','',''),(2,'','24/08/2017','Eduardo','11111111111','','','21983288411','carlos.esc@live.com','','24435420','','','','','','','','','','','','','','',''),(38,'12/08/2017','25/08/2017','Santana','09065887741','','','21983288411','carlos.esc@live.com','','24435420','','','','','','','','','','','','','','',''),(39,'23/08/2017','25/08/2017','Caldas','09065887741','','','21983288411','carlos.esc@live.com','','24435420','','','','','','','','','','','','','','',''),(40,'23/08/2017','25/08/2017','Shirlei','09065887741','','','21983288411','carlos.esc@live.com','','24435420','','','','','','','','','','','','','','',''),(41,'01/09/2017','25/08/2017','Coelho','09065887741','','','21983288411','carlos.esc@live.com','','24435420','','','','','','','','','','','','','','','');
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
  `status` varchar(9) NOT NULL,
  `mensalista_ou_pacote` varchar(10) NOT NULL,
  `dias_ou_utilizacoes` varchar(11) NOT NULL,
  `quantidade` int(2) NOT NULL,
  `data_inicio` varchar(10) NOT NULL,
  `data_termino` varchar(10) NOT NULL,
  `dia_vencimento` varchar(2) NOT NULL,
  `valor` float NOT NULL,
  `data_cancelamento` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_contrato`),
  UNIQUE KEY `id_contrato_UNIQUE` (`id_contrato`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
INSERT INTO `contrato` VALUES (4,1,'DDD2121','       ','       ','       ','Ativo','Pacote','Dias',4,'31/01/2017','28/08/2017','01',300,''),(5,2,'LBF6141',NULL,NULL,NULL,'Ativo','Pacote','Utilizações',20,'27/01/2017','01/01/2020','01',400,''),(10,40,'ZZZ9999',NULL,NULL,NULL,'Cancelado','Mensalista','Utilizações',10,'08/05/2017','01/01/2020','10',280,'27/08/2017');
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
  `mes_referencia` varchar(7) NOT NULL,
  `periodo` varchar(21) NOT NULL,
  `vencimento` varchar(10) NOT NULL,
  `valor` float NOT NULL,
  `data_pagamento` varchar(10) DEFAULT NULL,
  `status` varchar(8) NOT NULL,
  PRIMARY KEY (`id_fatura`),
  UNIQUE KEY `idfatura_UNIQUE` (`id_fatura`)
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fatura`
--

LOCK TABLES `fatura` WRITE;
/*!40000 ALTER TABLE `fatura` DISABLE KEYS */;
INSERT INTO `fatura` VALUES (241,4,'01/2017','31/01/2017à27/02/2017','01/01/2017',300,NULL,'Não Paga'),(242,4,'02/2017','28/02/2017à27/03/2017','01/02/2017',300,NULL,'Não Paga'),(243,4,'03/2017','28/03/2017à27/04/2017','01/03/2017',300,NULL,'Não Paga'),(244,4,'04/2017','28/04/2017à27/05/2017','01/04/2017',300,NULL,'Não Paga'),(245,4,'05/2017','28/05/2017à27/06/2017','01/05/2017',300,NULL,'Não Paga'),(246,4,'06/2017','28/06/2017à27/07/2017','01/06/2017',300,NULL,'Não Paga'),(247,4,'07/2017','28/07/2017à27/08/2017','01/07/2017',300,NULL,'Não Paga'),(248,4,'08/2017','28/08/2017à27/09/2017','01/08/2017',300,NULL,'Não Paga'),(249,5,'01/2017','27/01/2017à26/02/2017','01/01/2017',400,NULL,'Não Paga'),(250,5,'02/2017','27/02/2017à26/03/2017','01/02/2017',400,NULL,'Não Paga'),(251,5,'03/2017','27/03/2017à26/04/2017','01/03/2017',400,NULL,'Não Paga'),(252,5,'04/2017','27/04/2017à26/05/2017','01/04/2017',400,NULL,'Não Paga'),(253,5,'05/2017','27/05/2017à26/06/2017','01/05/2017',400,NULL,'Não Paga'),(254,5,'06/2017','27/06/2017à26/07/2017','01/06/2017',400,NULL,'Não Paga'),(255,5,'07/2017','27/07/2017à26/08/2017','01/07/2017',400,NULL,'Não Paga'),(256,5,'08/2017','27/08/2017à26/09/2017','01/08/2017',400,NULL,'Não Paga'),(257,10,'05/2017','08/05/2017à07/06/2017','10/05/2017',280,NULL,'Não Paga'),(258,10,'06/2017','08/06/2017à07/07/2017','10/06/2017',280,NULL,'Não Paga'),(259,10,'07/2017','08/07/2017à07/08/2017','10/07/2017',280,NULL,'Não Paga'),(260,10,'08/2017','08/08/2017à07/09/2017','10/08/2017',280,NULL,'Não Paga');
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
  `tipo` varchar(11) NOT NULL,
  `nome` varchar(15) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patio`
--

LOCK TABLES `patio` WRITE;
/*!40000 ALTER TABLE `patio` DISABLE KEYS */;
INSERT INTO `patio` VALUES (115,1,'ABC1234','20170811210756','01','Mensalista',NULL,4,8,4,32,15,'sim','11/08/2017','21:07',5,2,3,0,'19:00','9:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(118,0,'AAA1111','20170812110956','03','Rotativo',NULL,1,2,1,15,10,'sim','12/08/2017','11:09',5,2,3,0,'19:00','9:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(119,2,'BCA4321','20170812111156','02','Mensalista',NULL,0,0,0,0,0,'sim','12/08/2017','11:11',5,2,3,0,'19:00','9:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(120,5,'LBF6141','20170824212816','90','Mensalista',NULL,0,0,0,0,0,'sim','24/08/2017','21:28',5,2,3,0,'19:00','9:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(121,0,'QQQ8888','20170824212844','37','Rotativo',NULL,4,8,4,32,15,'sim','24/08/2017','21:28',5,2,3,0,'19:00','9:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(123,0,'FFF7777','20170824215553','55','Rotativo','Moto',4,8,4,32,15,'sim','24/08/2017','21:55',5,2,3,0,'19:00','9:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
INSERT INTO `veiculo` VALUES (96,'AAA1111','12/08/2017 10:05',NULL,'24/08/2017 20:33','AUDI','A1000','ROSA','2018'),(93,'ABC1234','11/08/2017 20:49','11/08/2017 20:49',NULL,NULL,NULL,NULL,NULL),(97,'BBB2222','24/08/2017 20:26',NULL,'24/08/2017 20:33','01','02','03','04'),(95,'BCA4321','12/08/2017 09:55','12/08/2017 09:55',NULL,NULL,NULL,NULL,NULL),(101,'DDD2121','25/08/2017 20:36',NULL,'25/08/2017 20:57','','','',''),(100,'FFF7777','24/08/2017 21:55','24/08/2017 21:55',NULL,NULL,NULL,NULL,NULL),(99,'III1111','24/08/2017 21:38','24/08/2017 21:38',NULL,NULL,NULL,NULL,NULL),(92,'LBF6141','10/08/2017 21:03','10/08/2017 21:03',NULL,'FIAT','TIPO','BRANCA','1996'),(98,'QQQ8888','24/08/2017 21:28','24/08/2017 21:28',NULL,NULL,NULL,NULL,NULL),(94,'ZZZ9999','11/08/2017 20:56','11/08/2017 20:56',NULL,NULL,NULL,NULL,NULL);
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

-- Dump completed on 2017-08-27 17:48:49
