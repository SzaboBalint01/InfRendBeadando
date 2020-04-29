CREATE DATABASE  IF NOT EXISTS `bead_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bead_db`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bead_db
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `jarmu`
--

DROP TABLE IF EXISTS `jarmu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jarmu` (
  `idjarmu` int NOT NULL AUTO_INCREMENT,
  `tipus` varchar(45) NOT NULL,
  `rendszam` varchar(45) NOT NULL,
  `gyarto` varchar(45) NOT NULL,
  `alvazszam` varchar(45) NOT NULL,
  `beszerzesidatum` datetime NOT NULL,
  `kolcsonzesidij` int NOT NULL,
  `futottkmdij` int NOT NULL,
  `statusz` int NOT NULL,
  PRIMARY KEY (`idjarmu`)
) ENGINE=InnoDB AUTO_INCREMENT=351 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jarmu`
--

LOCK TABLES `jarmu` WRITE;
/*!40000 ALTER TABLE `jarmu` DISABLE KEYS */;
INSERT INTO `jarmu` (`idjarmu`, `tipus`, `rendszam`, `gyarto`, `alvazszam`, `beszerzesidatum`, `kolcsonzesidij`, `futottkmdij`, `statusz`) VALUES (345,'KA_mini','HKB-661','FORD','1G1ZC5E08CF148007','2020-01-09 04:22:38',5000,100,0),(346,'Spark','312-NSN','Chevrolet','KNDJF723X67268993','2020-02-10 06:55:01',5100,95,1),(347,'Wagon','ACR-101','Suzuki','5UXWX5C58CL719234','2020-02-21 00:32:45',4950,105,0),(348,'Swift','AEK-950','Suzuki','1J8FT28W68D760789','2020-04-08 08:42:33',4500,115,2),(349,'742CU','H-12421','Bayliner','1G1PA5SH0E7260515','2020-04-17 01:58:42',20000,200,1),(350,'Antares 6OB','H-12532','Beneteau','1HD1KB415AB626001','2020-04-21 05:17:15',25000,250,0);
/*!40000 ALTER TABLE `jarmu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kolcsonzes`
--

DROP TABLE IF EXISTS `kolcsonzes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kolcsonzes` (
  `idkolcsonzes` int NOT NULL,
  `kolcsonzesideje` datetime DEFAULT NULL,
  `jarmu` int NOT NULL,
  `ugyfel` int NOT NULL,
  PRIMARY KEY (`idkolcsonzes`,`jarmu`,`ugyfel`),
  KEY `fk_kolcsonzes_jarmu1_idx` (`jarmu`),
  KEY `fk_kolcsonzes_ugyfel1_idx` (`ugyfel`),
  CONSTRAINT `fk_kolcsonzes_jarmu1` FOREIGN KEY (`jarmu`) REFERENCES `jarmu` (`idjarmu`),
  CONSTRAINT `fk_kolcsonzes_ugyfel1` FOREIGN KEY (`ugyfel`) REFERENCES `ugyfel` (`idugyfel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kolcsonzes`
--

LOCK TABLES `kolcsonzes` WRITE;
/*!40000 ALTER TABLE `kolcsonzes` DISABLE KEYS */;
INSERT INTO `kolcsonzes` (`idkolcsonzes`, `kolcsonzesideje`, `jarmu`, `ugyfel`) VALUES (1,'2020-05-14 03:05:39',346,1),(2,'2020-05-15 06:06:45',349,3);
/*!40000 ALTER TABLE `kolcsonzes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ugyfel`
--

DROP TABLE IF EXISTS `ugyfel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ugyfel` (
  `idugyfel` int NOT NULL AUTO_INCREMENT,
  `szemelyiszam` varchar(8) COLLATE utf8_hungarian_ci NOT NULL,
  `nev` varchar(45) COLLATE utf8_hungarian_ci NOT NULL,
  `szulido` date NOT NULL,
  `szulhely` varchar(45) COLLATE utf8_hungarian_ci NOT NULL,
  `cim` varchar(80) COLLATE utf8_hungarian_ci NOT NULL,
  `telefon` varchar(20) COLLATE utf8_hungarian_ci NOT NULL,
  `ceg` varchar(45) COLLATE utf8_hungarian_ci DEFAULT NULL,
  PRIMARY KEY (`idugyfel`),
  UNIQUE KEY `szemelyiszam_UNIQUE` (`szemelyiszam`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ugyfel`
--

LOCK TABLES `ugyfel` WRITE;
/*!40000 ALTER TABLE `ugyfel` DISABLE KEYS */;
INSERT INTO `ugyfel` (`idugyfel`, `szemelyiszam`, `nev`, `szulido`, `szulhely`, `cim`, `telefon`, `ceg`) VALUES (1,'RDWSU9GN','Halász Zsolt','1962-11-03','Budapest','Jakabháza Kis Diófa u. 56.','06 70 234 424','0'),(2,'753V4B9E','Rácz Szabolcs','1989-12-07','Veszprém','Nemesvámos Rákóczi út 26.','06 20 115 141','0'),(3,'IMWUNVZ2','Pásztor Balázs','1988-08-21','Miskolc','Nagybózsva Hegyalja út 34.','06 70 194 847','Nemtudom kft.'),(4,'C7NJZHFD','Szekeres Erzsébet','1994-12-08','Szeged','Bashalom Budaörsi út 4.','06 30 131 855','0');
/*!40000 ALTER TABLE `ugyfel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-29 21:38:36
