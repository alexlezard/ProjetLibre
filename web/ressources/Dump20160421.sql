-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: projetlibre
-- ------------------------------------------------------
-- Server version	5.7.11

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `idcategory` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `user_iduser` int(11) NOT NULL,
  PRIMARY KEY (`idcategory`),
  UNIQUE KEY `idcategory_UNIQUE` (`idcategory`),
  KEY `fk_category_user1_idx` (`user_iduser`),
  CONSTRAINT `fk_category_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'ETNA',11),(2,'Course',11),(3,'Sport',10),(4,'ETNA',10),(5,'ETNA School',1),(6,'PAKpak',11),(8,'Java',10),(11,'Moto',11),(12,'Boire',11),(23,'Boire competition',11),(24,'C++',11),(25,'Ruby tuto',11),(26,'Boire',11),(27,'Boire',11),(28,'Apple',11),(29,'CHAT',11),(30,'Boire',11),(33,'Cuisine',12),(35,'Laos',12),(36,'Cuisine',13),(37,'Voyage',13),(38,'Menage',13),(39,'Cambodge',13),(40,'SiemReap',13),(41,'Thai',13),(42,'Birmanie',13),(43,'Fitness',13),(44,'Java',12),(45,'java 99',14),(47,'C++',14),(48,'Java',12),(49,'Java',12),(50,'Java',12),(51,'Java 2',12),(52,'INDIA 99',12),(53,'Java 1',12),(54,'Java',12),(55,'Java',12),(56,'zert',12);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list`
--

DROP TABLE IF EXISTS `list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list` (
  `idlist` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category_idcategory` int(11) NOT NULL,
  PRIMARY KEY (`idlist`),
  UNIQUE KEY `idlist_UNIQUE` (`idlist`),
  KEY `fk_list_category1_idx` (`category_idcategory`),
  CONSTRAINT `fk_list_category1` FOREIGN KEY (`category_idcategory`) REFERENCES `category` (`idcategory`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list`
--

LOCK TABLES `list` WRITE;
/*!40000 ALTER TABLE `list` DISABLE KEYS */;
INSERT INTO `list` VALUES (2,'Dev java','Tache de developpeur java',1),(3,'Dev client','Tache dev techno client',1),(4,'Presentation projet','Presentation du projet wunderlist',0),(11,'developper statemachine','Developper une statemachine , voir tuto du super prof superman du java',44),(13,'developper pattern factory','Developper une factory , voir tuto le pattern',44),(14,'ecrire doc','Ecrire Documentation technique ',44),(15,'Java collection','le collection d\'objet java',44),(17,'Java le pattern','les 23 pattern java a connaitre',45),(18,'PHP','le collection d\'objet PHP',35),(19,'Java collection','le collection d\'objet java',44),(20,'PHP is BAd','PHP C DLA MERDE',44),(21,'PHP is BAd','PHP C DLA MERDE',44);
/*!40000 ALTER TABLE `list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `idtask` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `list_idlist` int(11) NOT NULL,
  `done` int(11) NOT NULL,
  PRIMARY KEY (`idtask`),
  UNIQUE KEY `idtask_UNIQUE` (`idtask`),
  KEY `fk_task_list1_idx` (`list_idlist`),
  CONSTRAINT `fk_task_list1` FOREIGN KEY (`list_idlist`) REFERENCES `list` (`idlist`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (2,'Developper une dao','Developper une dao pour interragir avec la base	',0,0),(3,'etudier les langage client','faire des recherche et erudier les different langages clients',0,0),(12,'task collection user 99','develloper la colleciton d\'objet java user',11,0),(13,'task 99','lorem ipsum 99 descript',11,0),(14,'task collection user 88','develloper la colleciton d\'objet java user',11,0),(15,'azerty 99','azerty 99',11,0),(16,'task 0203','lorem ipsum description 0203239',11,0),(17,'test change statut tache done : yes','azertyuiqsdfghjkl',11,1),(18,'task 0203','lorem ipsum description 0203239',11,0),(19,'task 0203','lorem ipsum description 0203239',11,0),(21,'task 0203','lorem ipsum description 0203239',11,0),(22,'task 0203',NULL,11,0),(23,'task 0203',NULL,11,0),(24,'AZERT',NULL,11,0);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mdp` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `iduser_UNIQUE` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'alexis','alexis.mohan@gmail.com','alexis'),(2,'said','said.said@gmail.com','said'),(3,'toto','toto@toto.fr','toto'),(4,'alexis','mohan_a@etna-alternance.net','123456'),(5,'Said le magnifique','Saidlemagnifique@saidcorp.com','SAID12345'),(7,'pakpak','pakpak@etna-alternance.net','Pakpak92'),(8,'gandhi','mahatma@gandhi.com','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92'),(9,'gandhi99','mahatma99@gandhi.com','1e67fb0b55425f675064fa4c56a2f3a0aa8f342728c978e36d29d5b39c1d5b66'),(10,'gandhi1000','mahatma1000@gandhi.com','1e67fb0b55425f675064fa4c56a2f3a0aa8f342728c978e36d29d5b39c1d5b66'),(11,'helloworld','hello@world.com','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92'),(12,'mekong','mekong@world.com','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92'),(13,'mekong99','mekong99@world.com','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92'),(14,'laos','laos@world.com','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92'),(15,'cambodge','cambodge@world.com','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-21 23:21:10
