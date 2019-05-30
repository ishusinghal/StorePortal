CREATE DATABASE  IF NOT EXISTS `storeportal` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `storeportal`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: storeportal
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `discount` (
  `dis_id` int(11) NOT NULL AUTO_INCREMENT,
  `percent_discount` int(11) DEFAULT NULL,
  `dis_for` int(11) NOT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(10) DEFAULT 'admin',
  PRIMARY KEY (`dis_id`),
  KEY `fk_disc_user_id` (`dis_for`),
  CONSTRAINT `discount_ibfk_1` FOREIGN KEY (`dis_for`) REFERENCES `users_type` (`u_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES (1,30,1,'2019-05-25 08:09:30','admin'),(2,10,2,'2019-05-25 08:09:30','admin'),(3,5,3,'2019-05-25 08:09:30','admin');
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_user`
--

DROP TABLE IF EXISTS `emp_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `emp_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(55) DEFAULT NULL,
  `user_type` int(11) NOT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  KEY `fk_emp_user_type` (`user_type`),
  CONSTRAINT `emp_user_ibfk_1` FOREIGN KEY (`user_type`) REFERENCES `users_type` (`u_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_user`
--

LOCK TABLES `emp_user` WRITE;
/*!40000 ALTER TABLE `emp_user` DISABLE KEYS */;
INSERT INTO `emp_user` VALUES (1,'Rahul',1,'2019-05-25 08:00:59'),(2,'Ajay',2,'2019-05-25 08:00:59'),(3,'Ravi',3,'2017-03-25 08:00:59'),(4,'Arun',3,'2018-05-25 08:00:59'),(5,'Pooja',3,'2019-05-25 08:00:59');
/*!40000 ALTER TABLE `emp_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transactions` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `bill_amount` decimal(10,0) DEFAULT NULL,
  `product_type` varchar(255) DEFAULT NULL,
  `tx_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`tid`),
  KEY `fk_user_id` (`user_id`),
  CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `emp_user` (`user_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (1,1,100,'GROCERY','2019-05-25 08:22:18'),(2,1,100,'CLOTHES','2019-05-25 08:22:18'),(3,2,200,'GROCERY','2019-05-25 08:22:18'),(4,2,200,'UTENSILS','2019-05-25 08:22:18'),(5,3,330,'GROCERY','2019-05-25 08:22:18'),(6,3,320,'UTENSILS','2019-05-25 08:22:18'),(7,4,200,'LUXURY','2019-05-25 08:22:18'),(8,5,300,'UTENSILS','2019-05-25 08:22:18'),(9,5,300,'GROCERY','2019-05-25 08:22:18');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_type`
--

DROP TABLE IF EXISTS `users_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users_type` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_type`
--

LOCK TABLES `users_type` WRITE;
/*!40000 ALTER TABLE `users_type` DISABLE KEYS */;
INSERT INTO `users_type` VALUES (1,'EMPLOYEE'),(2,'AFFILIATE'),(3,'CUSTOMER');
/*!40000 ALTER TABLE `users_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-25 15:23:17
