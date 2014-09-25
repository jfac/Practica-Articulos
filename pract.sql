SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
CREATE SCHEMA IF NOT EXISTS `pracextra` DEFAULT CHARACTER SET latin1 ;
USE `mydb` ;
USE `pracextra` ;

-- -----------------------------------------------------
-- Table `pracextra`.`articulos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `pracextra`.`articulos` (
  `idArticulos` INT(11) NOT NULL AUTO_INCREMENT ,
  `Nom` VARCHAR(45) NOT NULL ,
  `Stock` INT(11) NOT NULL ,
  `precio` DOUBLE NOT NULL ,
  PRIMARY KEY (`idArticulos`) )
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pracextra`.`clientes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `pracextra`.`clientes` (
  `idClientes` INT(11) NOT NULL AUTO_INCREMENT ,
  `Nombres` VARCHAR(45) NOT NULL ,
  `App` VARCHAR(45) NOT NULL ,
  `Apm` VARCHAR(45) NOT NULL ,
  `Password` VARCHAR(32) NOT NULL ,
  `Tipo` VARCHAR(3) NOT NULL ,
  PRIMARY KEY (`idClientes`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pracextra`.`ventas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `pracextra`.`ventas` (
  `idVentas` INT(11) NOT NULL AUTO_INCREMENT ,
  `idClientes` INT(11) NOT NULL ,
  `fecha` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`idVentas`) ,
  INDEX `idClientes` (`idClientes` ASC) ,
  CONSTRAINT `idClientes`
    FOREIGN KEY (`idClientes` )
    REFERENCES `pracextra`.`clientes` (`idClientes` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pracextra`.`detallevta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `pracextra`.`detallevta` (
  `iddetalleVta` INT(11) NOT NULL AUTO_INCREMENT ,
  `idventas` INT(11) NOT NULL ,
  `idarticulos` INT(11) NOT NULL ,
  `cantidad` INT(11) NOT NULL ,
  `monto` DOUBLE NOT NULL ,
  PRIMARY KEY (`iddetalleVta`) ,
  INDEX `idventas` (`idventas` ASC) ,
  INDEX `idarticulo` (`idarticulos` ASC) ,
  CONSTRAINT `idarticulos`
    FOREIGN KEY (`idarticulos` )
    REFERENCES `pracextra`.`articulos` (`idArticulos` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idventas`
    FOREIGN KEY (`idventas` )
    REFERENCES `pracextra`.`ventas` (`idVentas` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
