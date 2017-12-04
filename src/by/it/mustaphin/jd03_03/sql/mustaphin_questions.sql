CREATE DATABASE  IF NOT EXISTS `mustaphin` DEFAULT CHARACTER SET utf8;
USE `mustaphin`;
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `id_question` int(11) NOT NULL AUTO_INCREMENT,
  `theme` varchar(45) NOT NULL DEFAULT 'n/a',
  PRIMARY KEY (`id_question`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
INSERT INTO `questions` VALUES (1,'Вводная тема'),(2,'Общие положения'),(3,'Техника безопасности');
