CREATE DATABASE  IF NOT EXISTS `mustaphin` DEFAULT CHARACTER SET utf8;
USE `mustaphin`;
DROP TABLE IF EXISTS `answers`;
CREATE TABLE `answers` (
  `id_answer` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(45) NOT NULL,
  `fk_question` int(11) NOT NULL,
  `correct` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id_answer`),
  KEY `fk_answers_questions1_idx` (`fk_question`),
  CONSTRAINT `fk_answers_questions1` FOREIGN KEY (`fk_question`) REFERENCES `questions` (`id_question`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
