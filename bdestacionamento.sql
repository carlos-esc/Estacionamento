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
INSERT INTO `configuracoes` VALUES (1,3,0,3,0,'19:00','9:00');
/*!40000 ALTER TABLE `configuracoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patio`
--

DROP TABLE IF EXISTS `patio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patio` (
  `id_patio` int(11) NOT NULL AUTO_INCREMENT,
  `id_veiculo_fk` int(11) NOT NULL,
  `placa_fk` varchar(7) NOT NULL,
  `rps` varchar(20) NOT NULL,
  `prisma` varchar(4) NOT NULL,
  `tipo` varchar(25) NOT NULL,
  `preco30minutos` float NOT NULL,
  `preco60minutos` float NOT NULL,
  `precodemaisfracoes` float NOT NULL,
  `precodiaria` float NOT NULL,
  `precopernoite` float NOT NULL,
  `estacionado` varchar(3) NOT NULL,
  `dataentrada` varchar(10) NOT NULL,
  `horaentrada` varchar(5) NOT NULL,
  `toleranciadesistencia` int(2) NOT NULL,
  `toleranciaentrefracoes` int(2) NOT NULL,
  `diariahoras` int(2) NOT NULL,
  `diariaminutos` int(2) NOT NULL,
  `pernoiteinicio` varchar(5) NOT NULL,
  `pernoitetermino` varchar(5) NOT NULL,
  `datasaida` varchar(10) DEFAULT NULL,
  `horasaida` varchar(5) DEFAULT NULL,
  `permanencia` varchar(25) DEFAULT NULL,
  `valortotal` float DEFAULT NULL,
  `horaminutodataentrada` varchar(10) DEFAULT NULL,
  `horaminutodatasaida` varchar(10) DEFAULT NULL,
  `diarias` int(11) DEFAULT NULL,
  `pernoites` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_patio`,`placa_fk`),
  UNIQUE KEY `rps_UNIQUE` (`rps`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patio`
--

LOCK TABLES `patio` WRITE;
/*!40000 ALTER TABLE `patio` DISABLE KEYS */;
INSERT INTO `patio` VALUES (46,42,'','26032017170850','01','Rotativo',4,8,4,32,15,'sim','26/03/2017','16:12',0,0,0,0,'','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(47,43,'','26032017175807','02','Rotativo',4,8,4,32,15,'nao','26/03/2017','17:58',0,0,0,0,'','','26/03/2017','18:03','000d | 00h | 05m',4,'','',0,0),(48,54,'','26032017175933','03','Rotativo',4,8,4,32,15,'sim','26/03/2017','17:59',0,0,0,0,'','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(49,46,'','01052017193631','50','grande',5,8,1,32,3.6,'nao','01/05/2017','19:36',0,0,0,0,'','','06/05/2017','20:43','005d | 01h | 07m',178,'','Diária',5,5),(50,0,'','06052017193942','02','Moto',3,6,3,27,15,'sim','06/05/2017','19:39',0,0,0,0,'','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(51,49,'','06052017200818','02','Moto',3,6,3,27,15,'sim','06/05/2017','20:08',0,0,0,0,'','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(52,56,'','07052017153357','0000','Rotativo',4,8,4,32,15,'nao','07/05/2017','15:33',0,0,0,0,'','','07/05/2017','16:00','000d | 00h | 27m',4,'','',0,0),(53,56,'','07052017160116','0000','Evento',25,25,0,25,0,'nao','07/05/2017','16:01',0,0,0,0,'','','07/05/2017','16:13','000d | 00h | 12m',25,'','',0,0),(54,56,'','07052017161400','0000','Rotativo',4,8,4,32,15,'nao','07/05/2017','16:14',0,0,0,0,'','','07/05/2017','16:16','000d | 00h | 02m',0,'Tolerância','Tolerância',0,0),(55,57,'','07052017161438','04','Evento',25,25,0,25,0,'nao','07/05/2017','16:14',0,0,0,0,'','','07/05/2017','16:15','000d | 00h | 01m',0,'Tolerância','Tolerância',0,0),(56,58,'','07052017161523','65','Evento',25,25,0,25,0,'nao','07/05/2017','16:15',0,0,0,0,'','','07/05/2017','16:15','000d | 00h | 00m',0,'Tolerância','Tolerância',0,0),(57,59,'','07052017161541','642','Moto',3,6,3,27,15,'nao','07/05/2017','16:15',0,0,0,0,'','','07/05/2017','16:16','000d | 00h | 01m',0,'Tolerância','Tolerância',0,0),(58,58,'','07052017161635','649','Evento',25,25,0,25,0,'nao','07/05/2017','16:16',0,0,0,0,'','','07/05/2017','16:17','000d | 00h | 01m',0,'Tolerância','Tolerância',0,0),(59,56,'','07052017163030','65','Evento',25,25,0,25,0,'nao','07/05/2017','16:30',0,0,0,0,'','','07/05/2017','16:32','000d | 00h | 02m',0,'Tolerância','Tolerância',0,0),(60,60,'','07052017163041','98','Evento',25,25,0,25,0,'nao','07/05/2017','16:30',0,0,0,0,'','','07/05/2017','16:32','000d | 00h | 02m',0,'Tolerância','Tolerância',0,0),(61,61,'','07052017163054','45','Evento',25,25,0,25,0,'nao','07/05/2017','16:30',0,0,0,0,'','','07/05/2017','16:32','000d | 00h | 02m',0,'Tolerância','Tolerância',0,0),(62,62,'','07052017163111','21','Evento',25,25,0,25,0,'nao','07/05/2017','16:31',0,0,0,0,'','','07/05/2017','16:32','000d | 00h | 01m',0,'Tolerância','Tolerância',0,0),(63,57,'','07052017163605','32','Evento',25,25,0,25,0,'nao','07/05/2017','16:36',0,0,0,0,'','','07/05/2017','16:43','000d | 00h | 07m',25,'','',0,0),(64,63,'','07052017163614','36','Evento',25,25,0,25,0,'nao','07/05/2017','16:36',0,0,0,0,'','','07/05/2017','16:43','000d | 00h | 07m',25,'','',0,0),(65,64,'','07052017163622','98','Evento',25,25,0,25,0,'nao','07/05/2017','16:36',0,0,0,0,'','','07/05/2017','16:38','000d | 00h | 02m',0,'Tolerância','Tolerância',0,0),(66,65,'','07052017163635','41','Evento',25,25,0,25,0,'nao','07/05/2017','16:36',0,0,0,0,'','','07/05/2017','16:38','000d | 00h | 02m',0,'Tolerância','Tolerância',0,0),(67,66,'','07052017163654','74','Rotativo',4,8,4,32,15,'nao','07/05/2017','16:36',0,0,0,0,'','','07/05/2017','16:37','000d | 00h | 01m',0,'Tolerância','Tolerância',0,0),(68,67,'','07052017163721','14','Evento',25,25,0,25,0,'nao','07/05/2017','16:37',0,0,0,0,'','','07/05/2017','16:37','000d | 00h | 00m',0,'Tolerância','Tolerância',0,0),(69,58,'','07052017163905','65','Evento',25,25,0,25,0,'nao','07/05/2017','16:39',0,0,0,0,'','','07/05/2017','16:49','000d | 00h | 10m',25,'','',0,0),(70,68,'','07052017163914','445','Evento',25,25,0,25,0,'nao','07/05/2017','16:39',0,0,0,0,'','','07/05/2017','16:43','000d | 00h | 04m',25,'','',0,0),(71,69,'','07052017163924','46','Moto',3,6,3,27,15,'nao','07/05/2017','16:39',0,0,0,0,'','','07/05/2017','16:43','000d | 00h | 04m',3,'','',0,0),(72,70,'','07052017163944','49','Moto',3,6,3,27,15,'nao','07/05/2017','16:39',0,0,0,0,'','','07/05/2017','16:43','000d | 00h | 04m',3,'','',0,0),(73,43,'','07052017164916','32','Evento',25,25,0,25,0,'nao','07/05/2017','16:49',0,0,0,0,'','','07/05/2017','16:56','000d | 00h | 07m',25,'','',0,0),(74,71,'','07052017164935','56','Evento',25,25,0,25,0,'sim','07/05/2017','16:49',0,0,0,0,'','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(75,72,'','07052017165616','07','Rotativo',4,8,4,32,15,'nao','07/05/2017','16:56',0,0,0,0,'','','07/05/2017','16:59','000d | 00h | 03m',0,'Tolerância','Tolerância',0,0),(76,73,'','07052017170009','65','Moto',3,6,3,27,15,'nao','07/05/2017','17:00',0,0,0,0,'','','07/05/2017','17:00','000d | 00h | 00m',0,'Tolerância','Tolerância',0,0),(77,73,'','07052017170118','54','Moto',3,6,3,27,15,'nao','07/05/2017','17:01',0,0,0,0,'','','07/05/2017','17:01','000d | 00h | 00m',0,'Tolerância','Tolerância',0,0),(78,73,'','07052017170157','548','Evento',25,25,0,25,0,'nao','07/05/2017','17:01',0,0,0,0,'','','07/05/2017','17:03','000d | 00h | 02m',0,'Tolerância','Tolerância',0,0),(79,73,'','07052017170322','98','Evento',25,25,0,25,0,'sim','07/05/2017','17:03',0,0,0,0,'','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(80,74,'','07052017171234','58','Testando tamanho do texto',100,200,500,99,88,'sim','13/05/2017','17:12',0,0,0,0,'','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(81,75,'','07052017171421','54','Testando tamanho do texto',100,200,500,0,999.99,'nao','13/05/2017','19:00',0,0,0,0,'','','14/05/2017','09:07','000d | 14h | 07m',1499.99,'','00h | 07m',0,1);
/*!40000 ALTER TABLE `patio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rotativotipopreco`
--

DROP TABLE IF EXISTS `rotativotipopreco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rotativotipopreco` (
  `id_rotativo` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(30) CHARACTER SET ucs2 NOT NULL,
  `preco30minutos` float NOT NULL,
  `preco60minutos` float NOT NULL,
  `precodemaisfracoes` float NOT NULL,
  `precodiaria` float NOT NULL,
  `precopernoite` float NOT NULL,
  PRIMARY KEY (`id_rotativo`),
  UNIQUE KEY `tipo_UNIQUE` (`tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rotativotipopreco`
--

LOCK TABLES `rotativotipopreco` WRITE;
/*!40000 ALTER TABLE `rotativotipopreco` DISABLE KEYS */;
INSERT INTO `rotativotipopreco` VALUES (14,'Rotativo',4,8,4,32,15),(18,'Evento',25,25,0,25,0),(19,'Moto',3,6,3,27,15),(20,'Testando tamanho do texto',100,200,500,0,999.99);
/*!40000 ALTER TABLE `rotativotipopreco` ENABLE KEYS */;
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
  `id_veiculo` int(11) NOT NULL AUTO_INCREMENT,
  `placa` varchar(7) NOT NULL,
  `datahoraregistro` varchar(16) NOT NULL,
  `marca` varchar(20) DEFAULT NULL,
  `modelo` varchar(20) DEFAULT NULL,
  `anofabricacao` varchar(4) DEFAULT NULL,
  `anomodelo` varchar(4) DEFAULT NULL,
  `cor` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_veiculo`),
  UNIQUE KEY `placa_UNIQUE` (`placa`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
INSERT INTO `veiculo` VALUES (40,'AAA0000','03/03/2017 05:49','','','','',''),(41,'BBB0000','03/03/2017 19:35','','','','',''),(42,'LBF6141','03/03/2017 22:51','','','','',''),(43,'ABC1234','05/03/2017 13:23','','','','',''),(44,'ABC1235','05/03/2017 13:29','','','','',''),(45,'ZZZ9999','11/03/2017 18:51','','','','',''),(46,'ABC1236','11/03/2017 19:25','','','','',''),(47,'AAA1111','11/03/2017 19:28','','','','',''),(48,'OOO0000','11/03/2017 19:29','','','','',''),(49,'ZZZ1111','11/03/2017 19:33','','','','',''),(50,'WWW1111','11/03/2017 19:33','','','','',''),(51,'CCC0000','12/03/2017 15:42','','','','',''),(52,'LSX4702','17/03/2017 01:11','','','','',''),(53,'SSS1230','26/03/2017 12:56','','','','',''),(54,'ABC0001','26/03/2017 17:59','','','','',''),(56,'ABC0101','07/05/2017 15:34','','','','',''),(57,'ABC0000','07/05/2017 16:14','','','','',''),(58,'ABC9999','07/05/2017 16:15','','','','',''),(59,'ABC6459','07/05/2017 16:15','','','','',''),(60,'ABC0202','07/05/2017 16:30','','','','',''),(61,'ABC0303','07/05/2017 16:30','','','','',''),(62,'ABC0404','07/05/2017 16:31','','','','',''),(63,'ABC1111','07/05/2017 16:36','','','','',''),(64,'ABC2222','07/05/2017 16:36','','','','',''),(65,'ABC6666','07/05/2017 16:36','','','','',''),(66,'ABC9874','07/05/2017 16:36','','','','',''),(67,'ABC6548','07/05/2017 16:37','','','','',''),(68,'ABC4257','07/05/2017 16:39','','','','',''),(69,'ABC9845','07/05/2017 16:39','','','','',''),(70,'ABC8984','07/05/2017 16:39','','','','',''),(71,'ABC9865','07/05/2017 16:49','','','','',''),(72,'ABC6598','07/05/2017 16:56','','','','',''),(73,'WWW7777','07/05/2017 17:00','','','','',''),(74,'WWW5555','07/05/2017 17:12','','','','',''),(75,'ABC5555','07/05/2017 17:14','','','','','');
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

-- Dump completed on 2017-05-14 15:23:45
