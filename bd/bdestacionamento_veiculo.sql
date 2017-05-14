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

-- Dump completed on 2017-05-14 15:25:25
