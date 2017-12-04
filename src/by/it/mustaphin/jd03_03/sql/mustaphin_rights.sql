CREATE DATABASE  IF NOT EXISTS `mustaphin` DEFAULT CHARACTER SET utf8;
USE `mustaphin`;
DROP TABLE IF EXISTS `rights`;
CREATE TABLE `rights` (
  `id_user` int(11) NOT NULL,
  `admin` tinyint(4) NOT NULL DEFAULT '0',
  `user` tinyint(4) NOT NULL DEFAULT '0',
  `guest` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_user`),
  CONSTRAINT `fk_rights_users1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
