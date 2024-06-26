SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `cartao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cartao` ;

CREATE TABLE IF NOT EXISTS `cartao` (
  `id_cartao` INT NOT NULL AUTO_INCREMENT,
  `numero_cartao` VARCHAR(16) NULL,
  `senha` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_cartao`),
  UNIQUE INDEX `numeroCartao_UNIQUE` (`numero_cartao` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saldo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `saldo` ;

CREATE TABLE IF NOT EXISTS `saldo` (
  `id_saldo` INT NOT NULL AUTO_INCREMENT,
  `saldo` DECIMAL(10,2) NOT NULL DEFAULT 0,
  `cartao_id` INT NOT NULL,
  PRIMARY KEY (`id_saldo`),
  INDEX `fk_Saldo_cartao_idx` (`cartao_id` ASC),
  CONSTRAINT `fk_Saldo_cartao`
    FOREIGN KEY (`cartao_id`)
    REFERENCES `cartao` (`id_cartao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
