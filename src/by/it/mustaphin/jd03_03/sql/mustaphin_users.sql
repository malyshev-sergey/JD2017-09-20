CREATE DATABASE  IF NOT EXISTS `mustaphin` DEFAULT CHARACTER SET utf8;
USE `mustaphin`;
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `fk_question` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_user`),
  KEY `fk_users_questions1_idx` (`fk_question`),
  CONSTRAINT `fk_users_questions1` FOREIGN KEY (`fk_question`) REFERENCES `questions` (`id_question`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
INSERT INTO `users` VALUES (1,'mustaphin marat','me','1234',2),(2,'ivan petrov','user1','4321',2),(10,'some','any','0000',2);
