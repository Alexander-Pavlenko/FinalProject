-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cinema_shema
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `description`
--

DROP TABLE IF EXISTS `description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `description` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `duration` int(11) DEFAULT NULL,
  `miniDescription` text,
  `timeDate` datetime DEFAULT NULL,
  `formatFilm` varchar(100) DEFAULT NULL,
  `picture` varchar(100) DEFAULT NULL,
  `mark` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `description`
--

LOCK TABLES `description` WRITE;
/*!40000 ALTER TABLE `description` DISABLE KEYS */;
INSERT INTO `description` VALUES (1,180,'Tatooine. Planet-desert. Already aged Jedi Knight Obi-Wan Kenobi saves the young Luke Skywalker, as he tries to find the missing Droid. From that moment on, Luke realizes his true purpose: it is one of the Jedi Knights. While the Civil War engulfed the galaxy, and the troops of the rebels are fighting against the evil Emperor\'s forces, to Luke and Obi Wan joins desperate pilot mercenary Han Solo, and accompanied by two droids, R2D2 and C-3PO, this unusual squad goes in search rebel leader - Princess Leia. The heroes have to fight with desperate terrifying Darth Vader - the right hand of the Emperor and his secret weapon - \"Death Star.\"','2016-05-13 00:00:00','IMAX 4D','starWars.jpg',5),(2,150,'We send signals into space and waiting for a response. But are we sure that we want to get it? What if the aliens are potentially dangerous? In 2009 at a conference in Washington, astronaut Edgar Mitchell walked on the moon, made a sensational statement about the existence of extraterrestrial life. Now we know, the contact is not just possible, it is inevitable!','2016-12-10 00:00:00','IMAX 4D','battleship.jpg',5),(3,200,'Fantastic film \"The Avengers\" is based on the popular comic books Marvel Comics, the story about the adventures of the superhero team possessing supernatural powers. Director of the International Agency for the support of the World Nick Fury, known just as SHIELD, summoned to a secret base where scientists conduct research found a space object. This cube has boundless energy, which can lead to the release of energy so powerful that humanity is hard to imagine.','2015-10-01 00:00:00','IMAX 4D','avengers.jpg',5),(4,150,'The land in the densely populated galaxy known as the planet of the thieves, and the birth of her Peter Quill is fully consistent with unflattering stereotype: during one of his dangerous adventures, he managed to steal the powerful villain Ronan. The artifact, which fell into the hands of Peter, turned out to be a mysterious sphere, which was necessary for the implementation of Ronan some evil plan.','2015-10-10 00:00:00','IMAX 4D','single.jpg',5);
/*!40000 ALTER TABLE `description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nameFilm` varchar(256) DEFAULT NULL,
  `idDescription` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idDescription` (`idDescription`),
  CONSTRAINT `film_ibfk_1` FOREIGN KEY (`idDescription`) REFERENCES `description` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film`
--

LOCK TABLES `film` WRITE;
/*!40000 ALTER TABLE `film` DISABLE KEYS */;
INSERT INTO `film` VALUES (1,'Star Wars',1),(2,'Battleship',2),(3,'Avengers',3),(4,'GUARDIANS OF THE GALAXY',4);
/*!40000 ALTER TABLE `film` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hall`
--

DROP TABLE IF EXISTS `hall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hall` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nameHall` varchar(256) DEFAULT NULL,
  `countColumes` int(11) DEFAULT NULL,
  `countRows` int(11) DEFAULT NULL,
  `places` blob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hall`
--

LOCK TABLES `hall` WRITE;
/*!40000 ALTER TABLE `hall` DISABLE KEYS */;
INSERT INTO `hall` VALUES (16,'Vip1',9,9,'¨\Ì\0ur\0[[Lmodel.Place;;ﬂô|ánÖ\0\0xp\0\0\0	ur\0[Lmodel.Place;ëdOUt\0\0xp\0\0\0	sr\0model.Placeøq)Øaç\Íi\0I\0columnD\0priceI\0rowL\0statet\0\rLmodel/State;xp\0\0\0\0@Y\0\0\0\0\0\0\0\0\0\0~r\0model.State\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0BUSYsq\0~\0\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	uq\0~\0\0\0\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0~q\0~\0t\0FREEuq\0~\0\0\0\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0uq\0~\0\0\0\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0uq\0~\0\0\0\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0uq\0~\0\0\0\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0uq\0~\0\0\0\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0uq\0~\0\0\0\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0uq\0~\0\0\0\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	sq\0~\0\0\0\0@Y\0\0\0\0\0\0\0\0\0q\0~\0	');
/*!40000 ALTER TABLE `hall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session`
--

DROP TABLE IF EXISTS `session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `session` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idFilm` int(11) DEFAULT NULL,
  `idHall` int(11) DEFAULT NULL,
  `dateShow` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idFilm` (`idFilm`),
  KEY `idHall` (`idHall`),
  CONSTRAINT `session_ibfk_1` FOREIGN KEY (`idFilm`) REFERENCES `film` (`id`),
  CONSTRAINT `session_ibfk_2` FOREIGN KEY (`idHall`) REFERENCES `hall` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session`
--

LOCK TABLES `session` WRITE;
/*!40000 ALTER TABLE `session` DISABLE KEYS */;
INSERT INTO `session` VALUES (9,1,16,'2016-12-30 14:38:16'),(10,2,16,'2016-12-30 14:38:33'),(11,3,16,'2016-12-30 14:38:40'),(12,4,16,'2016-12-30 14:40:00');
/*!40000 ALTER TABLE `session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `columPlace` int(11) DEFAULT NULL,
  `rowPlace` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `idUser` int(11) DEFAULT NULL,
  `idSession` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idUser` (`idUser`),
  KEY `idSession` (`idSession`),
  CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`id`),
  CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`idSession`) REFERENCES `session` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (80,4,4,87,1,10),(81,4,4,87,1,10),(82,3,4,86,1,10),(83,3,4,86,1,10),(84,0,4,85,1,9),(85,4,7,84,1,9),(86,4,6,83,1,9),(87,4,5,82,1,9),(88,4,4,81,1,9),(89,4,1,80,1,9),(90,4,2,79,1,12),(91,2,3,78,1,12),(92,3,3,77,1,12),(93,3,2,76,1,12),(94,4,3,100,1,9),(95,3,3,100,1,9),(96,2,1,100,1,9),(97,5,4,100,1,9),(98,4,2,100,1,9),(99,4,3,100,1,9),(100,4,2,100,1,9),(101,1,1,100,1,9),(102,1,0,100,1,9),(103,0,0,100,1,9),(104,0,2,100,1,9),(105,2,0,100,1,9),(106,1,0,100,1,9),(107,0,0,100,1,9),(108,2,1,100,1,9),(109,1,1,100,1,9),(110,0,1,100,1,9),(111,4,4,100,1,9),(112,3,3,100,1,9),(113,2,2,100,1,9),(114,1,2,100,1,9),(115,0,2,100,1,9),(116,6,1,60,1,9),(117,5,1,60,1,9),(118,4,1,60,1,9),(119,3,1,60,1,9),(120,0,5,60,1,9),(121,0,4,60,1,9),(122,0,3,60,1,9),(123,0,8,60,1,9),(124,0,7,60,1,9),(125,0,6,60,1,9),(126,1,6,60,1,9),(127,1,5,60,1,9),(128,1,4,60,1,9),(129,1,3,60,1,9),(130,8,8,60,1,9),(131,8,7,60,1,9),(132,8,6,60,1,9),(133,3,7,60,1,9),(134,2,7,60,1,9),(135,1,7,60,1,9),(136,2,4,60,1,9),(137,2,3,60,1,9),(138,4,2,60,1,9),(139,3,2,60,1,9),(140,3,0,100,14,9),(141,4,0,60,1,9),(142,4,0,99,14,9),(143,8,0,99,14,9);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `e_mail` varchar(100) DEFAULT NULL,
  `isClient` tinyint(1) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'sasha','123','Sasha','Pavlenko','alexandrer@gmail.com',0,40,10131),(14,'dima','dima','Dima','Bilichenko','dima.bilichenko@gmail.com',1,3,702),(15,'ravil1','4321','Ravil','Safarov','ravilsafarov@mail.ru',1,0,12321),(17,'pavlenko','1234','Sasha','pavlenko','alexandrer@gmail.com',1,2,1233);
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

-- Dump completed on 2017-01-23 23:31:03
