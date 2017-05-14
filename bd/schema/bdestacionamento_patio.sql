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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-14 15:26:52
