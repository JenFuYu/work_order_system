CREATE DATABASE  IF NOT EXISTS `work_order` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `work_order`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: work_order
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `work_order`
--

DROP TABLE IF EXISTS `work_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `school_id` int DEFAULT NULL,
  `submitter_id` int DEFAULT NULL,
  `created_at` varchar(45) DEFAULT NULL,
  `order_type_id` int DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `assignment_id` int DEFAULT NULL,
  `general_affairs_id` int DEFAULT NULL,
  `end_time` varchar(45) DEFAULT NULL,
  `remark` varchar(45) DEFAULT NULL,
  `inspector_user_id` int DEFAULT NULL,
  `inspector_at` varchar(45) DEFAULT NULL,
  `fake` int DEFAULT NULL,
  `deleted_at` varchar(45) DEFAULT NULL,
  `delete_user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_order`
--

LOCK TABLES `work_order` WRITE;
/*!40000 ALTER TABLE `work_order` DISABLE KEYS */;
INSERT INTO `work_order` VALUES (1,1,1,'2023-02-13 16:18:00',1,'電燈泡不亮',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(2,2,2,'2023-02-13 16:2018:00',1,'廁所馬桶不通',3,2,'2023-02-14 14:21:00',NULL,1,'2023/02/14 04:09:04',0,NULL,NULL),(3,3,1,'2023-02-14 14:21:00',1,'電腦無法開機',3,2,NULL,NULL,NULL,NULL,0,NULL,NULL),(4,3,3,'2023-02-14 14:25:00',1,'桌子壞掉',3,2,'2023-02-14 14:26:00',NULL,NULL,NULL,0,NULL,NULL),(5,1,1,'2023/02/15 12:06:07',1,'',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(6,3,2,'2023/02/15 12:08:51',3,'採購工單測試\n指派測試2',3,2,'2023/02/15 03:08:12','工單已完成\n驗收功能完成\n歷史功能完成',3,'2023/02/15 04:09:04',0,NULL,NULL),(7,3,2,'2023/02/15 12:08:51',3,'採購工單測試\n指定功能測試',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `work_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-17 15:25:58
