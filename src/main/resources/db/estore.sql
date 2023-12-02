-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ecommerce
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ecommerce
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ecommerce` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ecommerce` ;

-- -----------------------------------------------------
-- Table `ecommerce`.`ADMINS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`ADMINS` (
  `adminId` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `fullName` VARCHAR(255) NOT NULL,
  `loginType` INT NULL DEFAULT '1',
  `addedOn` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`adminId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ecommerce`.`CATEGORIES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`CATEGORIES` (
  `categoryId` INT NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(255) NOT NULL,
  `categoryDescription` VARCHAR(255) NULL DEFAULT NULL,
  `categoryImageUrl` VARCHAR(500) NULL DEFAULT NULL,
  `active` INT NULL DEFAULT '0',
  `addedOn` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`categoryId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ecommerce`.`USERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`USERS` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `fullName` VARCHAR(255) NOT NULL,
  `street` VARCHAR(50) NULL DEFAULT NULL,
  `city` VARCHAR(50) NULL DEFAULT NULL,
  `state` VARCHAR(50) NULL DEFAULT NULL,
  `country` VARCHAR(50) NULL DEFAULT NULL,
  `pincode` INT NULL DEFAULT NULL,
  `image` VARCHAR(1000) NULL DEFAULT NULL,
  `contact` BIGINT NULL DEFAULT NULL,
  `addedOn` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ecommerce`.`ORDERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`ORDERS` (
  `orderId` INT NOT NULL,
  `orderDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `orderStatus` VARCHAR(50) NOT NULL,
  `totalItems` INT NOT NULL,
  `itemsSubTotal` INT NOT NULL,
  `shipmentCharges` INT NOT NULL,
  `totalAmount` INT NOT NULL,
  `paymentStatus` INT NULL DEFAULT '0',
  `paymentStatusTitle` VARCHAR(255) NULL DEFAULT NULL,
  `paymentMethod` INT NULL DEFAULT NULL,
  `paymentMethodTitle` VARCHAR(255) NOT NULL,
  `userId` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `contact` BIGINT NOT NULL,
  `address` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`orderId`),
  INDEX `userId` (`userId` ASC) VISIBLE,
  CONSTRAINT `orders_ibfk_1`
    FOREIGN KEY (`userId`)
    REFERENCES `ecommerce`.`USERS` (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ecommerce`.`PRODUCTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`PRODUCTS` (
  `productId` INT NOT NULL AUTO_INCREMENT,
  `productTitle` VARCHAR(500) NOT NULL,
  `productDescription` VARCHAR(500) NOT NULL,
  `productCode` VARCHAR(500) NOT NULL,
  `categoryId` INT NULL DEFAULT NULL,
  `images` VARCHAR(1000) NULL DEFAULT NULL,
  `thumbnailImage` INT NULL DEFAULT '0',
  `price` INT NULL DEFAULT '0',
  `addedOn` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `rating` INT NOT NULL,
  PRIMARY KEY (`productId`),
  INDEX `categoryId` (`categoryId` ASC) VISIBLE,
  CONSTRAINT `products_ibfk_1`
    FOREIGN KEY (`categoryId`)
    REFERENCES `ecommerce`.`CATEGORIES` (`categoryId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ecommerce`.`ORDERITEMS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`ORDERITEMS` (
  `orderItemId` INT NOT NULL AUTO_INCREMENT,
  `orderId` INT NULL DEFAULT NULL,
  `productId` INT NULL DEFAULT NULL,
  `productCode` VARCHAR(255) NOT NULL,
  `productImg` VARCHAR(255) NOT NULL,
  `productTitle` VARCHAR(255) NOT NULL,
  `productDescription` VARCHAR(255) NOT NULL,
  `productCategory` VARCHAR(255) NOT NULL,
  `price` INT NOT NULL,
  `quantity` INT NOT NULL,
  `totalPrice` INT NOT NULL,
  PRIMARY KEY (`orderItemId`),
  INDEX `orderId` (`orderId` ASC) VISIBLE,
  INDEX `productId` (`productId` ASC) VISIBLE,
  CONSTRAINT `orderitems_ibfk_1`
    FOREIGN KEY (`orderId`)
    REFERENCES `ecommerce`.`ORDERS` (`orderId`),
  CONSTRAINT `orderitems_ibfk_2`
    FOREIGN KEY (`productId`)
    REFERENCES `ecommerce`.`PRODUCTS` (`productId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ecommerce`.`SHIPMENTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`SHIPMENTS` (
  `shipmentId` INT NOT NULL AUTO_INCREMENT,
  `orderId` INT NULL DEFAULT NULL,
  `shipmentStatus` INT NULL DEFAULT NULL,
  `shipmentTitle` VARCHAR(255) NULL DEFAULT NULL,
  `shipmentDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `expectedDeliveryDate` DATETIME NULL DEFAULT NULL,
  `shipmentMethod` VARCHAR(255) NULL DEFAULT NULL,
  `shipmentCompany` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`shipmentId`),
  INDEX `orderId` (`orderId` ASC) VISIBLE,
  CONSTRAINT `shipments_ibfk_1`
    FOREIGN KEY (`orderId`)
    REFERENCES `ecommerce`.`ORDERS` (`orderId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
