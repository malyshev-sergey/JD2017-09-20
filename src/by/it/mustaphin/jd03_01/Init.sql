CREATE DATABASE  IF NOT EXISTS mustaphin;
USE mustaphin;
DROP TABLE IF EXISTS answers_catalog;
CREATE TABLE answers_catalog (
  `id_answer` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(45) NOT NULL,
  `fk_question` int(11) NOT NULL,
  `correct` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id_answer`),
  KEY `fk_answers_questions1_idx` (`fk_question`),
  CONSTRAINT `fk_answers_questions1` FOREIGN KEY (`fk_question`) REFERENCES `questions` (`id_question`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `id_question` int(11) NOT NULL AUTO_INCREMENT,
  `theme` varchar(45) NOT NULL DEFAULT 'n/a',
  PRIMARY KEY (`id_question`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `users_has_roles`;
CREATE TABLE `users_has_roles` (
  `id_user` int(11) NOT NULL,
  `id_role` int(11) NOT NULL,
  PRIMARY KEY (`id_user`,`id_role`),
  KEY `fk_users_has_roles_roles1_idx` (`id_role`),
  KEY `fk_users_has_roles_users1_idx` (`id_user`),
  CONSTRAINT `fk_users_has_roles_roles1` FOREIGN KEY (`id_role`) REFERENCES `roles` (`id_role`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_roles_users1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dump completed on 2017-11-29 15:17:29
