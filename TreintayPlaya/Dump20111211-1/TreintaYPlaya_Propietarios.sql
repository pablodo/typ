CREATE DATABASE  IF NOT EXISTS `treintayplaya` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `TreintaYPlaya`;
-- MySQL dump 10.13  Distrib 5.1.34, for apple-darwin9.5.0 (i386)
--
-- Host: localhost    Database: TreintaYPlaya
-- ------------------------------------------------------
-- Server version	5.1.47

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
-- Table structure for table `Propietarios`
--

DROP TABLE IF EXISTS `Propietarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Propietarios` (
  `propID` int(11) NOT NULL AUTO_INCREMENT,
  `propApellido` varchar(45) DEFAULT NULL,
  `propNombre` varchar(45) DEFAULT NULL,
  `propEmail` varchar(45) DEFAULT NULL,
  `propTelefono` varchar(45) DEFAULT NULL,
  `propCelular` varchar(45) DEFAULT NULL,
  `propCUIT` varchar(45) DEFAULT NULL,
  `propBanco` varchar(45) DEFAULT NULL,
  `propNCuenta` varchar(45) DEFAULT NULL,
  `propCBU` varchar(45) DEFAULT NULL,
  `propTCuenta` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`propID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Base de Propietarios de las Unidades Funcionales.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Propietarios`
--

LOCK TABLES `Propietarios` WRITE;
/*!40000 ALTER TABLE `Propietarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `Propietarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-12-12 14:56:27
