-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema solicitudesDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema solicitudesDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `solicitudesDB` DEFAULT CHARACTER SET utf8 ;
USE `solicitudesDB` ;

-- -----------------------------------------------------
-- Table `solicitudesDB`.`solicitudes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `solicitudesDB`.`solicitudes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `monto` INT NULL,
  `producto` VARCHAR(45) NULL,
  `tipoSolicitudStr` VARCHAR(45) NULL,
  `idTipoSolicitud` INT NULL,
  `tasa` INT NULL,
  `plazo` INT NULL,
  `frecuencia` VARCHAR(20) NULL,
  `fechaSolicitud` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solicitudesDB`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `solicitudesDB`.`clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellidoPaterno` VARCHAR(45) NULL,
  `apellidoMaterno` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solicitudesDB`.`promotores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `solicitudesDB`.`promotores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `promotor` VARCHAR(45) NULL,
  `empresa` VARCHAR(45) NULL,
  `idCliente` INT NULL,
  `idSolicitud` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `idCliente_idx` (`idCliente` ASC) VISIBLE,
  INDEX `idSolicitud_idx` (`idSolicitud` ASC) VISIBLE,
  CONSTRAINT `idClientePromotor`
    FOREIGN KEY (`idCliente`)
    REFERENCES `solicitudesDB`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idSolicitudPromotor`
    FOREIGN KEY (`idSolicitud`)
    REFERENCES `solicitudesDB`.`solicitudes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solicitudesDB`.`estatus_solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `solicitudesDB`.`estatus_solicitud` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idSolicitud` INT NULL,
  `estatus` VARCHAR(45) NULL,
  `motivo` VARCHAR(45) NULL,
  `fechaCambio` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `idSolicitud_idx` (`idSolicitud` ASC) VISIBLE,
  CONSTRAINT `idSolicitudEstatus`
    FOREIGN KEY (`idSolicitud`)
    REFERENCES `solicitudesDB`.`solicitudes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solicitudesDB`.`creditos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `solicitudesDB`.`creditos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idSolicitud` INT NULL,
  `capitalDispersado` DOUBLE NULL,
  `monto` DOUBLE NULL,
  `taza` DOUBLE NULL,
  `plazo` INT NULL,
  `frecuencia` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `idSolicitud_idx` (`idSolicitud` ASC) VISIBLE,
  CONSTRAINT `idSolicitudCredito`
    FOREIGN KEY (`idSolicitud`)
    REFERENCES `solicitudesDB`.`solicitudes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
