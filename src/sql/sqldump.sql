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
  `beszerzesidatum` date NOT NULL,
  `kolcsonzesidij` int NOT NULL,
  `futottkmdij` int NOT NULL,
  `statusz` int NOT NULL,
  PRIMARY KEY (`idjarmu`)
) ENGINE=InnoDB AUTO_INCREMENT=353 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `kolcsonzes`
--

DROP TABLE IF EXISTS `kolcsonzes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kolcsonzes` (
  `idkolcsonzes` int NOT NULL AUTO_INCREMENT,
  `kolcsonzesideje` date DEFAULT NULL,
  `jarmu` int NOT NULL,
  `ugyfel` int NOT NULL,
  PRIMARY KEY (`idkolcsonzes`,`jarmu`,`ugyfel`),
  KEY `fk_kolcsonzes_jarmu1_idx` (`jarmu`),
  KEY `fk_kolcsonzes_ugyfel1_idx` (`ugyfel`),
  CONSTRAINT `fk_kolcsonzes_jarmu1` FOREIGN KEY (`jarmu`) REFERENCES `jarmu` (`idjarmu`),
  CONSTRAINT `fk_kolcsonzes_ugyfel1` FOREIGN KEY (`ugyfel`) REFERENCES `ugyfel` (`idugyfel`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Dump completed on 2020-05-08 11:33:02
