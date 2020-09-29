SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
-- SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema spmn_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema spmn_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `spmn_db` DEFAULT CHARACTER SET utf8 ;
USE `spmn_db` ;

-- -----------------------------------------------------
-- Table `spmn_db`.`tienda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`tienda` (
  `id` INT(10) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `telefono` INT(15) NOT NULL,
  `caja_menor` VARCHAR(45) NOT NULL,
  `deudas` VARCHAR(45) NOT NULL,
  `saldo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`usuario` (
  `cedula` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `u_telefono` VARCHAR(45) NOT NULL,
  `tienda_id` INT(10) NOT NULL,
  PRIMARY KEY (`cedula`),
  INDEX `fk_usuario_tienda_idx` (`tienda_id` ASC),
  CONSTRAINT `fk_usuario_tienda`
    FOREIGN KEY (`tienda_id`)
    REFERENCES `spmn_db`.`tienda` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`factura_venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`factura_venta` (
  `id` INT(10) NOT NULL,
  `fecha` DATE NOT NULL,
  `descripcion` VARCHAR(128) NOT NULL,
  `total_bruto` VARCHAR(45) NOT NULL,
  `impuestos` VARCHAR(45) NOT NULL,
  `total_pagar` DECIMAL(8,2) NOT NULL,
  `cliente` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_factura_usuario_idx` (`cliente` ASC),
  CONSTRAINT `fk_factura_usuario`
    FOREIGN KEY (`cliente`)
    REFERENCES `spmn_db`.`usuario` (`cedula`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`impuesto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`impuesto` (
  `id` INT(10) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripción` VARCHAR(45) NOT NULL,
  `entidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`producto` (
  `id` INT(6) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `tamanio` VARCHAR(45) NOT NULL,
  `presentacion` VARCHAR(45) NOT NULL,
  `unidad_medida` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `costo` DECIMAL(10,2) NOT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`proveedor` (
  `nit` VARCHAR(16) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `cel` INT(15) NOT NULL,
  PRIMARY KEY (`nit`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`reportes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`reportes` (
  `id` INT(10) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `fecha_inicial` DATE NOT NULL,
  `cantidad_producto` INT(10) NOT NULL,
  `inventario_tienda_id` INT(10) NOT NULL,
  `inventario_producto_id` INT(10) NOT NULL,
  `tienda_id` INT(10) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_reportes_tienda_idx` (`tienda_id` ASC),
  CONSTRAINT `fk_reportes_tienda`
    FOREIGN KEY (`tienda_id`)
    REFERENCES `spmn_db`.`tienda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`rol` (
  `id` INT(11) NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`servicio` (
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(99) NOT NULL,
  `telefono` INT(10) NOT NULL,
  `entidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`nombre`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`cant_venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`cant_venta` (
  `factura_venta` INT(10) NOT NULL,
  `producto` INT(6) NOT NULL,
  `cantidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`factura_venta`, `producto`),
  INDEX `fk_cant_venta_producto_idx` (`producto` ASC),
  INDEX `fk_cant_venta_venta_idx` (`factura_venta` ASC),
  CONSTRAINT `fk_cant_venta_producto`
    FOREIGN KEY (`factura_venta`)
    REFERENCES `spmn_db`.`factura_venta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cant_venta_venta`
    FOREIGN KEY (`producto`)
    REFERENCES `spmn_db`.`producto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`inventario` (
  `producto` INT(6) NOT NULL,
  `tienda` INT(10) NOT NULL,
  `cantidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`producto`, `tienda`),
  INDEX `fk_inventario_tienda_idx` (`tienda` ASC),
  INDEX `fk_inventario_producto_idx` (`producto` ASC),
  CONSTRAINT `fk_inventario_tienda`
    FOREIGN KEY (`producto`)
    REFERENCES `spmn_db`.`producto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inventario_producto`
    FOREIGN KEY (`tienda`)
    REFERENCES `spmn_db`.`tienda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`usuario_rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`usuario_rol` (
  `usuario` INT(11) NOT NULL,
  `rol` INT(11) NOT NULL,
  PRIMARY KEY (`usuario`, `rol`),
  INDEX `fk_usuario_rol_rol_idx` (`rol` ASC),
  INDEX `fk_usuario_rol_usuario_idx` (`usuario` ASC),
  CONSTRAINT `fk_usuario_rol_rol`
    FOREIGN KEY (`usuario`)
    REFERENCES `spmn_db`.`usuario` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_rol_usuario`
    FOREIGN KEY (`rol`)
    REFERENCES `spmn_db`.`rol` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`pago_servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`pago_servicio` (
  `tienda` INT(11) NOT NULL,
  `servicio` VARCHAR(45) NOT NULL,
  `precio` DECIMAL(8,2) NOT NULL,
  `fecha_limite` DATE NOT NULL,
  `fecha_pago` DATE NULL,
  PRIMARY KEY (`tienda`, `servicio`),
  INDEX `fk_pago_servicio_servicio_idx` (`servicio` ASC),
  INDEX `fk_pago_servicio_tienda_idx` (`tienda` ASC),
  CONSTRAINT `fk_pago_servicio_servicio`
    FOREIGN KEY (`tienda`)
    REFERENCES `spmn_db`.`tienda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pago_servicio_tienda`
    FOREIGN KEY (`servicio`)
    REFERENCES `spmn_db`.`servicio` (`nombre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`pago_impuesto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`pago_impuesto` (
  `impuesto` INT(10) NOT NULL,
  `tienda` INT(10) NOT NULL,
  `costo` DECIMAL(8,2) NOT NULL,
  `fecha_limite` DATE NOT NULL,
  `fecha_pago` DATE NULL,
  PRIMARY KEY (`impuesto`, `tienda`),
  INDEX `fk_pago_impuesto_tienda_idx` (`tienda` ASC),
  INDEX `fk_pago_impuesto_impuesto_idx` (`impuesto` ASC),
  CONSTRAINT `fk_pago_impuesto_tienda`
    FOREIGN KEY (`impuesto`)
    REFERENCES `spmn_db`.`impuesto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pago_impuesto_impuesto`
    FOREIGN KEY (`tienda`)
    REFERENCES `spmn_db`.`tienda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`empleado` (
  `cedula` INT(11) NOT NULL,
  `sueldo_basico` VARCHAR(45) NOT NULL,
  `arl` VARCHAR(45) NOT NULL,
  `eps` VARCHAR(45) NOT NULL,
  `fecha_ingreso` VARCHAR(45) NOT NULL,
  `fecha_salida` VARCHAR(45) NULL,
  PRIMARY KEY (`cedula`),
  INDEX `fk_empleado_usuario_idx` (`cedula` ASC),
  CONSTRAINT `fk_empleado_usuario`
    FOREIGN KEY (`cedula`)
    REFERENCES `spmn_db`.`usuario` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spmn_db`.`recibo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`recibo` (
  `id` INT(6) NOT NULL,
  `fecha` DATE NOT NULL,
  `total_recibo` DECIMAL(10,2) NOT NULL,
  `descripcion` VARCHAR(128) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `fecha_pago` DATE NOT NULL,
  `proveedor_nit` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_recibo_proveedor_idx` (`proveedor_nit` ASC),
  CONSTRAINT `fk_recibo_proveedor`
    FOREIGN KEY (`proveedor_nit`)
    REFERENCES `spmn_db`.`proveedor` (`nit`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spmn_db`.`cant_compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`cant_compra` (
  `producto_id` INT(6) NOT NULL,
  `recibo` INT(6) NOT NULL,
  `cantidad` INT(3) NOT NULL,
  PRIMARY KEY (`producto_id`, `recibo`),
  INDEX `fk_cant_compra_recibo_idx` (`recibo` ASC),
  INDEX `fk_cant_compra_producto_idx` (`producto_id` ASC),
  CONSTRAINT `fk_cant_compra_prodcuto`
    FOREIGN KEY (`producto_id`)
    REFERENCES `spmn_db`.`producto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cant_compra_recibo`
    FOREIGN KEY (`recibo`)
    REFERENCES `spmn_db`.`recibo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spmn_db`.`pago_nomina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spmn_db`.`pago_nomina` (
  `empleado_cedula` INT(11) NOT NULL,
  `tienda_id` INT(10) NOT NULL,
  `dias_trab` INT(3) NOT NULL,
  `aux_trans` DECIMAL(10,2) NOT NULL,
  `liquidacion` DECIMAL(10,2) NOT NULL,
  `pension` DECIMAL(10,2) NOT NULL,
  `neto_pagado` DECIMAL(10,2) NOT NULL,
  `fecha_pago` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`empleado_cedula`, `tienda_id`),
  INDEX `fk_pago_nomina_tienda_idx` (`tienda_id` ASC),
  INDEX `fk_pago_nomina_empleado_idx` (`empleado_cedula` ASC),
  CONSTRAINT `fk_pago_nomina_empleado`
    FOREIGN KEY (`empleado_cedula`)
    REFERENCES `spmn_db`.`empleado` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pago_nomina_tienda`
    FOREIGN KEY (`tienda_id`)
    REFERENCES `spmn_db`.`tienda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
-- SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
SET GLOBAL time_zone = '-5:00';
