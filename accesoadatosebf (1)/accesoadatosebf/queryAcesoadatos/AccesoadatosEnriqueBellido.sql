CREATE SCHEMA `vehiculos` ;
use vehiculos;
CREATE TABLE `vehiculos`.`vehiculos` (
  `ID_Vehiculo` INT NOT NULL AUTO_INCREMENT,
  `Matricula` VARCHAR(9) NULL,
  `Marca` VARCHAR(30) NULL,
  `Modelo` VARCHAR(30) NULL,
  `Anyo` INT NULL,
  `Potencia` INT NULL,
  `Plazas` INT NULL,
  `Deposito` DOUBLE NULL,
  `Consumo` DOUBLE NULL,
  `L_correcto` TINYINT NULL,
  `Observaciones` VARCHAR(40) NULL,
  PRIMARY KEY (`ID_Vehiculo`));
  create user ebf identified by "ebf";
  grant all on table * to ebf;
  grant all on vehiculos.* to ebf;


