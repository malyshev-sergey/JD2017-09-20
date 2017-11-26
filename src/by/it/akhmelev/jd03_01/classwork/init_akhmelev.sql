-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema akhmelev
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `akhmelev` ;

-- -----------------------------------------------------
-- Schema akhmelev
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `akhmelev` DEFAULT CHARACTER SET utf8 ;
USE `akhmelev` ;

-- -----------------------------------------------------
-- Table `akhmelev`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akhmelev`.`roles` ;

CREATE TABLE IF NOT EXISTS `akhmelev`.`roles` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(50) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akhmelev`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akhmelev`.`users` ;

CREATE TABLE IF NOT EXISTS `akhmelev`.`users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `FK_roles` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles_idx` (`FK_roles` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`FK_roles`)
    REFERENCES `akhmelev`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akhmelev`.`ads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akhmelev`.`ads` ;

CREATE TABLE IF NOT EXISTS `akhmelev`.`ads` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `RoomCount` VARCHAR(45) NULL,
  `Floor` INT NULL,
  `Floors` INT NULL,
  `Price` DOUBLE NULL,
  `Area` DOUBLE NULL,
  `Description` VARCHAR(5000) NULL,
  `Address` VARCHAR(500) NULL,
  `FK_users` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ads_users1_idx` (`FK_users` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`FK_users`)
    REFERENCES `akhmelev`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `akhmelev`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `akhmelev`;
INSERT INTO `akhmelev`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');
INSERT INTO `akhmelev`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');
INSERT INTO `akhmelev`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `akhmelev`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `akhmelev`;
INSERT INTO `akhmelev`.`users` (`ID`, `Login`, `Password`, `Email`, `FK_roles`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@it.by', 1);
INSERT INTO `akhmelev`.`users` (`ID`, `Login`, `Password`, `Email`, `FK_roles`) VALUES (DEFAULT, 'user', 'puser', 'user@it.by', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `akhmelev`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `akhmelev`;
INSERT INTO `akhmelev`.`ads` (`ID`, `RoomCount`, `Floor`, `Floors`, `Price`, `Area`, `Description`, `Address`, `FK_users`) VALUES (DEFAULT, '2', 4, 5, 55555, 45, 'Хорошая квартира', 'Кнорина 2, кв. 11', 2);

COMMIT;

