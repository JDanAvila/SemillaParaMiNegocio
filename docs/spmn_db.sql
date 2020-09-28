-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema semilla_db
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema spmn_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema spmn_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `spmn_db` DEFAULT CHARACTER SET utf8 ;
USE `spmn_db` ;

-- -----------------------------------------------------
-- Table `spmn_db`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`producto` (
  `idProducto` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `P_descripcion` VARCHAR(45) NOT NULL,
  `Cantidad` VARCHAR(45) NOT NULL,
  `Costo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`tienda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`tienda` (
  `idTienda` INT NOT NULL,
  `T_nombre` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `T_telefono` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTienda`),
  UNIQUE INDEX `idTienda_UNIQUE` (`idTienda` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`inventario` (
  `Tienda_idTienda` INT NOT NULL,
  `Producto_idProducto` INT NOT NULL,
  `producto_id_producto` INT NOT NULL,
  `tienda_id_tienda` INT NOT NULL,
  PRIMARY KEY (`Tienda_idTienda`, `Producto_idProducto`),
  INDEX `fk_Tienda_has_Producto_Producto1_idx` (`Producto_idProducto` ASC),
  INDEX `fk_Tienda_has_Producto_Tienda1_idx` (`Tienda_idTienda` ASC),
  CONSTRAINT `fk_Tienda_has_Producto_Producto`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `spmn_db`.`producto` (`idProducto`),
  CONSTRAINT `fk_Tienda_has_Producto_Tienda`
    FOREIGN KEY (`Tienda_idTienda`)
    REFERENCES `spmn_db`.`tienda` (`idTienda`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`proveedor` (
  `nit` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `cel` INT NOT NULL,
  PRIMARY KEY (`nit`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`factura_compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`factura_compra` (
  `idFactura` INT NOT NULL,
  `F_descripcion` VARCHAR(45) NOT NULL,
  `F_fecha` VARCHAR(45) NOT NULL,
  `inventario_Tienda_idTienda` INT NOT NULL,
  `inventario_Producto_idProducto` INT NOT NULL,
  `proveedor_nit` INT NOT NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `fk_factura_compra_inventario1_idx` (`inventario_Tienda_idTienda` ASC, `inventario_Producto_idProducto` ASC),
  INDEX `fk_factura_compra_proveedor1_idx` (`proveedor_nit` ASC),
  CONSTRAINT `fk_factura_compra_inventario`
    FOREIGN KEY (`inventario_Tienda_idTienda` , `inventario_Producto_idProducto`)
    REFERENCES `spmn_db`.`inventario` (`Tienda_idTienda` , `Producto_idProducto`),
  CONSTRAINT `fk_factura_compra_proveedor`
    FOREIGN KEY (`proveedor_nit`)
    REFERENCES `spmn_db`.`proveedor` (`nit`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`usuario` (
  `idUsuario` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Correo` VARCHAR(45) NOT NULL,
  `Contraseña` VARCHAR(45) NOT NULL,
  `U_telefono` VARCHAR(45) NOT NULL,
  `Tienda_idTienda` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC),
  INDEX `fk_Usuario_Tienda1_idx` (`Tienda_idTienda` ASC),
  CONSTRAINT `fk_Usuario_Tienda`
    FOREIGN KEY (`Tienda_idTienda`)
    REFERENCES `spmn_db`.`tienda` (`idTienda`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`factura_venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`factura_venta` (
  `idFactura` INT NOT NULL,
  `F_descripcion` VARCHAR(45) NOT NULL,
  `F_fecha` VARCHAR(45) NOT NULL,
  `cantidad` INT NOT NULL,
  `total` INT NOT NULL,
  `Usuario_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `fk_Factura_Usuario1_idx` (`Usuario_idUsuario` ASC),
  CONSTRAINT `fk_Factura_Usuario`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `spmn_db`.`usuario` (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`factura_has_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`factura_has_producto` (
  `Factura_idFactura` INT NOT NULL,
  `Producto_idProducto` INT NOT NULL,
  `factura_id_factura` INT NOT NULL,
  `producto_id_producto` INT NOT NULL,
  PRIMARY KEY (`Factura_idFactura`, `Producto_idProducto`),
  INDEX `fk_Factura_has_Producto_Producto1_idx` (`Producto_idProducto` ASC),
  INDEX `fk_Factura_has_Producto_Factura1_idx` (`Factura_idFactura` ASC),
  CONSTRAINT `fk_Factura_has_Producto_Factura`
    FOREIGN KEY (`Factura_idFactura`)
    REFERENCES `spmn_db`.`factura_venta` (`idFactura`),
  CONSTRAINT `fk_Factura_has_Producto_Producto`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `spmn_db`.`producto` (`idProducto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`impuesto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`impuesto` (
  `idIimpuestos` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `costo` INT NOT NULL,
  `descripción` VARCHAR(45) NOT NULL,
  `tienda_idTienda` INT NOT NULL,
  PRIMARY KEY (`idIimpuestos`),
  INDEX `fk_impuestos_tienda1_idx` (`tienda_idTienda` ASC),
  CONSTRAINT `fk_impuestos_tienda`
    FOREIGN KEY (`tienda_idTienda`)
    REFERENCES `spmn_db`.`tienda` (`idTienda`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`nomina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`nomina` (
  `idNomina` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `dias_trabajados` INT NOT NULL,
  `sueldo_basico` INT NOT NULL,
  `liquidacion_total` INT NOT NULL,
  `tienda_idTienda` INT NOT NULL,
  PRIMARY KEY (`idNomina`),
  INDEX `fk_nomina_tienda1_idx` (`tienda_idTienda` ASC),
  CONSTRAINT `fk_nomina_tienda`
    FOREIGN KEY (`tienda_idTienda`)
    REFERENCES `spmn_db`.`tienda` (`idTienda`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`reportes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`reportes` (
  `idReportes` INT NOT NULL,
  `Descripcion` VARCHAR(45) NOT NULL,
  `fecha_inicial` DATE NOT NULL,
  `cantidad_total` INT NOT NULL,
  `cantidad_especifica` INT NOT NULL,
  `inventario_Tienda_idTienda` INT NOT NULL,
  `inventario_Producto_idProducto` INT NOT NULL,
  PRIMARY KEY (`idReportes`),
  INDEX `fk_Reportes_inventario1_idx` (`inventario_Tienda_idTienda` ASC, `inventario_Producto_idProducto` ASC),
  CONSTRAINT `fk_Reportes_inventario`
    FOREIGN KEY (`inventario_Tienda_idTienda` , `inventario_Producto_idProducto`)
    REFERENCES `spmn_db`.`inventario` (`Tienda_idTienda` , `Producto_idProducto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`rol` (
  `idRol` INT NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRol`),
  UNIQUE INDEX `idRol_UNIQUE` (`idRol` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`rol_has_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`rol_has_usuario` (
  `rol_idRol` INT NOT NULL,
  `usuario_idUsuario` INT NOT NULL,
  `rol_id_rol` INT NOT NULL,
  `usuario_id_usuario` INT NOT NULL,
  PRIMARY KEY (`rol_idRol`, `usuario_idUsuario`),
  INDEX `fk_rol_has_usuario_usuario1_idx` (`usuario_idUsuario` ASC),
  INDEX `fk_rol_has_usuario_rol1_idx` (`rol_idRol` ASC),
  CONSTRAINT `fk_rol_has_usuario_rol`
    FOREIGN KEY (`rol_idRol`)
    REFERENCES `spmn_db`.`rol` (`idRol`),
  CONSTRAINT `fk_rol_has_usuario_usuario`
    FOREIGN KEY (`usuario_idUsuario`)
    REFERENCES `spmn_db`.`usuario` (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`servicio` (
  `nombreServicio` INT NOT NULL,
  `descripcion` VARCHAR(99) NOT NULL,
  `precio` INT NOT NULL,
  `tienda_idTienda` INT NOT NULL,
  PRIMARY KEY (`nombreServicio`),
  INDEX `fk_servicio_tienda1_idx` (`tienda_idTienda` ASC),
  CONSTRAINT `fk_servicio_tienda`
    FOREIGN KEY (`tienda_idTienda`)
    REFERENCES `spmn_db`.`tienda` (`idTienda`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
SET GLOBAL time_zone = '-5:00';

