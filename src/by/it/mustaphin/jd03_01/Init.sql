-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mustaphin
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table answers_catalog
--

DROP TABLE IF EXISTS answers_catalog;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE answers_catalog (
  id_answer int(11) NOT NULL AUTO_INCREMENT,
  text varchar(45) NOT NULL,
  fk_question int(11) NOT NULL,
  correct tinyint(1) DEFAULT '0',
  PRIMARY KEY (id_answer),
  KEY fk_answers_questions1_idx (fk_question),
  CONSTRAINT fk_answers_questions1 FOREIGN KEY (fk_question) REFERENCES questions (id_question) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table answers_catalog
--

LOCK TABLES answers_catalog WRITE;
/*!40000 ALTER TABLE answers_catalog DISABLE KEYS */;
/*!40000 ALTER TABLE answers_catalog ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table questions
--

DROP TABLE IF EXISTS questions;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE questions (
  id_question int(11) NOT NULL AUTO_INCREMENT,
  theme varchar(45) NOT NULL DEFAULT 'n/a',
  PRIMARY KEY (id_question)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table questions
--

LOCK TABLES questions WRITE;
/*!40000 ALTER TABLE questions DISABLE KEYS */;
/*!40000 ALTER TABLE questions ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table roles
--

DROP TABLE IF EXISTS roles;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE roles (
  id_role int(11) NOT NULL AUTO_INCREMENT,
  type varchar(45) NOT NULL,
  PRIMARY KEY (id_role)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table roles
--

LOCK TABLES roles WRITE;
/*!40000 ALTER TABLE roles DISABLE KEYS */;
/*!40000 ALTER TABLE roles ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table users
--

DROP TABLE IF EXISTS users;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE users (
  id_user int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  login varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  fk_question int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (id_user),
  KEY fk_users_questions1_idx (fk_question),
  CONSTRAINT fk_users_questions1 FOREIGN KEY (fk_question) REFERENCES questions (id_question) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table users
--

LOCK TABLES users WRITE;
/*!40000 ALTER TABLE users DISABLE KEYS */;
/*!40000 ALTER TABLE users ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table users_has_roles
--

DROP TABLE IF EXISTS users_has_roles;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE users_has_roles (
  id_user int(11) NOT NULL,
  id_role int(11) NOT NULL,
  PRIMARY KEY (id_user,id_role),
  KEY fk_users_has_roles_roles1_idx (id_role),
  KEY fk_users_has_roles_users1_idx (id_user),
  CONSTRAINT fk_users_has_roles_roles1 FOREIGN KEY (id_role) REFERENCES roles (id_role) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_users_has_roles_users1 FOREIGN KEY (id_user) REFERENCES users (id_user) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table users_has_roles
--

LOCK TABLES users_has_roles WRITE;
/*!40000 ALTER TABLE users_has_roles DISABLE KEYS */;
/*!40000 ALTER TABLE users_has_roles ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-25 18:31:29
