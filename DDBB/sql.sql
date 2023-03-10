-- MySQL Script generated by MySQL Workbench
-- Mon Dec 12 10:51:11 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb`;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Restaurantes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Restaurantes` (
  `idRestaurante` INT NOT NULL AUTO_INCREMENT,
  `horario` VARCHAR(45) NULL DEFAULT NULL,
  `nRestaurante` VARCHAR(45) NULL DEFAULT NULL,
  `direccion` VARCHAR(45) NULL DEFAULT NULL,
  `telefono` INT NULL DEFAULT NULL,
  `nMesas` INT NULL DEFAULT NULL,
  `url` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idRestaurante`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Menu` (
  `Restaurantes_idRestaurante` INT NOT NULL,
  `nPlato` VARCHAR(45) NULL DEFAULT NULL,
  `precioComida` VARCHAR(45) NULL DEFAULT NULL,
  `tComida` VARCHAR(45) NULL DEFAULT NULL,
  `url` VARCHAR(45) NULL,
  CONSTRAINT `fk_Menu_Restaurantes1`
    FOREIGN KEY (`Restaurantes_idRestaurante`)
    REFERENCES `mydb`.`Restaurantes` (`idRestaurante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuarios` (
  `idUsuarios` INT NOT NULL AUTO_INCREMENT,
  `nameSurname` VARCHAR(45) NULL DEFAULT NULL,
  `nUsuario` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `nTelefono` VARCHAR(15) NULL DEFAULT NULL,
  `passUsuario` LONGTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`idUsuarios`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Mesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Mesa` (
  `idMesa` INT NOT NULL,
  `isReservada` TINYINT NULL DEFAULT NULL,
  `isOcupada` TINYTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`idMesa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Orders` (
  `idOrder` INT NOT NULL AUTO_INCREMENT,
  `orderDate` DATE NULL DEFAULT NULL,
  `precioTotal` DOUBLE NULL DEFAULT NULL,
  `pagado` TINYINT NULL DEFAULT NULL,
  `Restaurantes_idRestaurante` INT NOT NULL,
  PRIMARY KEY (`idOrder`, `Restaurantes_idRestaurante`),
  INDEX `fk_Orders_Restaurantes1_idx` (`Restaurantes_idRestaurante` ASC) VISIBLE,
  CONSTRAINT `fk_Orders_Restaurantes1`
    FOREIGN KEY (`Restaurantes_idRestaurante`)
    REFERENCES `mydb`.`Restaurantes` (`idRestaurante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pedido` (
  `idOrder` INT NOT NULL AUTO_INCREMENT,
  `nComida` VARCHAR(45) NULL DEFAULT NULL,
  `cantidadPlato` VARCHAR(45) NULL DEFAULT NULL,
  `precioSuma` VARCHAR(45) NULL,
  `Orders_idOrder` INT NOT NULL,
  PRIMARY KEY (`idOrder`, `Orders_idOrder`),
  INDEX `fk_Pedido_Orders1_idx` (`Orders_idOrder` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_Orders1`
    FOREIGN KEY (`Orders_idOrder`)
    REFERENCES `mydb`.`Orders` (`idOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

/*INSERTS DE RESTAURANTES*/
insert into restaurantes values(1,"11:00 - 16:00", "Tagliatella", "Llobateras", 943658654, 24, "tagliatella.png");
insert into restaurantes values(2,"12:00 - 23:00", "Burguer", "Llobateras", 765376586, 27, "burgerKing.png");
insert into restaurantes values(3,"10:30 - 17:30", "Goiko", "Lepanto", 657483957, 30, "goiko.png");
insert into restaurantes values(4,"9:30 - 20:30", "McDonalds", "Gracia", 654323467, 0, "mcDonalds.png");
insert into restaurantes values(5,"10:00 - 22:30", "Ginos", "Urquinaona", 987654345, 10, "ginos.png");
insert into restaurantes values(6,"13:00 - 02:00", "Hollywood", "Diagonal Mar", 644368432, 20, "hollywood.png");


/*INSERTS DE MENU EN RESTAURANTES*/
insert into menu values(1,"Bravas", 6, "entrante", "");
insert into menu values(1,"Pasta", 11, "primer plato", "");
insert into menu values(1,"Helado de vainilla", 7, "postre", "");

/*INSERTS BURGUER*/
insert into menu values(2,"Croquetas", 7, "entrante", "croquetas.png");
insert into menu values(2,"Patatas bravas", 5, "entrante", "bravas.png");
insert into menu values(2,"Chipirones", 14, "entrante", "chipirones.png");
insert into menu values(2,"Calamares", 9, "entrante", "calamares.png");
insert into menu values(2,"Aros de cebolla", 8, "entrante", "arosCebolla.png");

insert into menu values(2,"Ensalada mixta", 10, "primer plato", "ensaladaMixta.png");
insert into menu values(2,"Ensalada cesar", 12, "primer plato", "ensaladaCesar.png");
insert into menu values(2,"Pizza", 12, "primer plato", "pizza.png");
insert into menu values(2,"Carne a la brasa", 17, "primer plato", "carneBrasa.png");
insert into menu values(2,"Chuleta de cerdo", 24, "primer plato", "chuletaCerdo.png");
insert into menu values(2,"Bocadillo de lomo", 6, "primer plato", "bocadilloLomo.png");
insert into menu values(2,"Hamburguesa", 5, "primer plato", "hamburguesa.png");

insert into menu values(2,"Coulant", 8, "postre", "coulant.png");
insert into menu values(2,"Pastel de queso", 9, "postre", "pastelQueso.png");
insert into menu values(2,"Platano", 4, "postre", "platano.png");
insert into menu values(2,"Fresas", 3, "postre", "fresas.png");

insert into menu values(2,"Agua", 2, "bebidas", "agua.png");
insert into menu values(2,"Cocacola", 3, "bebidas", "cocacola.png");
insert into menu values(2,"Fanta", 3, "bebidas", "fanta.png");
insert into menu values(2,"Vino", 20, "bebidas", "vino.png");
/*
insert into menu values(2,"Crema catalana", 20, "postre", "cremaCatalana.png");
*/

/*INSERTS GOIKO*/
insert into menu values(3,"Pulpo a la gallega", 10, "entrante", "");
insert into menu values(3,"Arroz caldoso", 23, "primer plato", "");
insert into menu values(3,"Crema catalana", 6, "postre", "");

/*INSERTS HOLLYWOOD*/
insert into menu values(6,"Pulpo a la gallega", 10, "entrante", "");
insert into menu values(6,"Arroz caldoso", 23, "primer plato", "");
insert into menu values(6,"Crema catalana", 6, "postre", "");
insert into menu values(6,"Agua", 2, "bebidas", "agua.png");


select * from orders;
select * from pedido;

select * from usuarios;
SELECT * FROM restaurantes;

SELECT idOrder, orderDate, pagado, Restaurantes_idRestaurante from orders where orderDate = current_date();

INSERT INTO orders values (null, '2020-11-19', null, true,2);
INSERT INTO orders values (null, '2021-11-19', null, true,2);
