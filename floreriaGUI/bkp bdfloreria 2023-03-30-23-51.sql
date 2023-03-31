CREATE DATABASE  IF NOT EXISTS `bdfloreriainterfaz` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bdfloreriainterfaz`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: bdfloreriainterfaz
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tcliente`
--

DROP TABLE IF EXISTS `tcliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tcliente` (
  `idcliente` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `tipodocumento` varchar(45) NOT NULL,
  `numdocumento` varchar(45) NOT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idcliente`),
  UNIQUE KEY `idcliente_UNIQUE` (`idcliente`),
  UNIQUE KEY `numdocumento_UNIQUE` (`numdocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tcliente`
--

LOCK TABLES `tcliente` WRITE;
/*!40000 ALTER TABLE `tcliente` DISABLE KEYS */;
INSERT INTO `tcliente` VALUES (23,'A','A','DNI','12345678','a','AMIGABLE','DESACTIVO'),(24,'JHON','QUISPE','DNI','1241','jhon','AMIGABLE','ACTIVO');
/*!40000 ALTER TABLE `tcliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tdetalleventa`
--

DROP TABLE IF EXISTS `tdetalleventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tdetalleventa` (
  `iddetalleventa` int NOT NULL AUTO_INCREMENT,
  `tdocumentoventa_iddocumentoventa` int NOT NULL,
  `tflor_idflor` int NOT NULL,
  `p_unitario` double NOT NULL,
  `cantidad` int NOT NULL,
  `descuento` double NOT NULL,
  PRIMARY KEY (`iddetalleventa`,`tdocumentoventa_iddocumentoventa`,`tflor_idflor`),
  UNIQUE KEY `iddetalleventa_UNIQUE` (`iddetalleventa`),
  KEY `fk_tdetalleventa_tdocumentoventa_idx` (`tdocumentoventa_iddocumentoventa`),
  KEY `fk_tdetalleventa_tflor1_idx` (`tflor_idflor`),
  CONSTRAINT `fk_tdetalleventa_tdocumentoventa` FOREIGN KEY (`tdocumentoventa_iddocumentoventa`) REFERENCES `tdocumentoventa` (`iddocumentoventa`),
  CONSTRAINT `fk_tdetalleventa_tflor1` FOREIGN KEY (`tflor_idflor`) REFERENCES `tflor` (`idflor`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tdetalleventa`
--

LOCK TABLES `tdetalleventa` WRITE;
/*!40000 ALTER TABLE `tdetalleventa` DISABLE KEYS */;
/*!40000 ALTER TABLE `tdetalleventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tdocumentoventa`
--

DROP TABLE IF EXISTS `tdocumentoventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tdocumentoventa` (
  `iddocumentoventa` int NOT NULL AUTO_INCREMENT,
  `tipodocumento` varchar(45) NOT NULL,
  `numdocumento` varchar(45) NOT NULL,
  `tcliente_idcliente` int NOT NULL,
  `tvendedor_idvendedor` int NOT NULL,
  `fechaventa` date NOT NULL,
  `preciototal` double NOT NULL,
  `igv` double NOT NULL,
  `descuento` double NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`iddocumentoventa`,`tcliente_idcliente`,`tvendedor_idvendedor`),
  UNIQUE KEY `iddocumentoventa_UNIQUE` (`iddocumentoventa`),
  KEY `fk_tdocumentoventa_tcliente1_idx` (`tcliente_idcliente`),
  KEY `fk_tdocumentoventa_tvendedor1_idx` (`tvendedor_idvendedor`),
  CONSTRAINT `fk_tdocumentoventa_tcliente1` FOREIGN KEY (`tcliente_idcliente`) REFERENCES `tcliente` (`idcliente`),
  CONSTRAINT `fk_tdocumentoventa_tvendedor1` FOREIGN KEY (`tvendedor_idvendedor`) REFERENCES `tvendedor` (`idvendedor`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tdocumentoventa`
--

LOCK TABLES `tdocumentoventa` WRITE;
/*!40000 ALTER TABLE `tdocumentoventa` DISABLE KEYS */;
/*!40000 ALTER TABLE `tdocumentoventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tflor`
--

DROP TABLE IF EXISTS `tflor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tflor` (
  `idflor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(75) NOT NULL,
  `aroma` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `precio` double NOT NULL DEFAULT '0',
  `stock` int NOT NULL,
  `fcreacion` datetime NOT NULL,
  `estado` varchar(12) NOT NULL DEFAULT '"inactivo"',
  PRIMARY KEY (`idflor`),
  UNIQUE KEY `idflor_UNIQUE` (`idflor`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tflor`
--

LOCK TABLES `tflor` WRITE;
/*!40000 ALTER TABLE `tflor` DISABLE KEYS */;
INSERT INTO `tflor` VALUES (62,'MARGARITA','DULCE','ROJO',5,5,'2023-12-15 12:45:15','ACTIVO'),(63,'ROSA','DULCE','ROJO',14,14,'2023-12-15 12:45:15','ACTIVO'),(64,'ROSA','DULCE','AMARILLO',4,4,'2023-03-28 08:58:35','ACTIVO'),(65,'ROSA','AMARGO','MARRON',4.6,5,'2023-03-28 09:01:17','ACTIVO'),(66,'ROSA SALVAJE','DULCE','ROJO',14,14,'2023-03-28 09:30:00','ACTIVO'),(67,'A','A','A',344.7,2,'2023-03-28 09:41:51','ACTIVO');
/*!40000 ALTER TABLE `tflor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tvendedor`
--

DROP TABLE IF EXISTS `tvendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tvendedor` (
  `idvendedor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `tipodocumento` varchar(45) NOT NULL,
  `numdocumento` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `comision` double NOT NULL,
  `contrasenea` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idvendedor`),
  UNIQUE KEY `numdocumento_UNIQUE` (`numdocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tvendedor`
--

LOCK TABLES `tvendedor` WRITE;
/*!40000 ALTER TABLE `tvendedor` DISABLE KEYS */;
INSERT INTO `tvendedor` VALUES (6,'ROAN','ROCA','DNI','12345678','roas',3000,'awds','DESACTIVO'),(7,'','A','DNI','23456789','ff',4000,'asf','DESACTIVO'),(8,'','APAZA','DNI','98765476','luis',4600,'awds','DESACTIVO'),(9,'LUIS','ROCCA','DNI','1241241','kyu',2495,'asda','ACTIVO'),(11,'LUIS','QUISPE','DNI','2439','luis',4596.8,'sdf','DESACTIVO'),(12,'A','A','DNI','2143221','aa',2342,'aaa','DESACTIVO');
/*!40000 ALTER TABLE `tvendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bdfloreriainterfaz'
--

--
-- Dumping routines for database 'bdfloreriainterfaz'
--
/*!50003 DROP FUNCTION IF EXISTS `creardocventalasID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `creardocventalasID`(
ptipodocumento varchar(45), 
pnumdocumento varchar(45) ,
pidcliente int,
pidvendedor int ,
pfechaventa date ,
ppreciototal double ,
pigv double ,
pdescuento double ,
pestado varchar(45) ) RETURNS int
BEGIN
		INSERT INTO `bdfloreriaInterfaz`.`tdocumentoventa`
		VALUES(	0,
ptipodocumento ,
pnumdocumento ,
pidcliente,
pidvendedor ,
pfechaventa ,
ppreciototal ,
pigv ,
pdescuento,
pestado
		);

RETURN last_insert_id();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizarCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarCliente`(
pidcliente int,
pnombres varchar(45) ,
papellidos varchar(45) ,
ptipodocumento varchar(45) ,
pnumdocumento varchar(45) ,
pcorreo varchar(45) ,
ptipo varchar(45) ,
pestado varchar(45)
)
BEGIN
			UPDATE `bdfloreriainterfaz`.`tcliente`
			SET	`nombres` = pnombres,
			`apellidos`=papellidos,
			`tipodocumento `= ptipodocumento,
			`numdocumento` = pnumdocumento,
			`correo`= pcorreo,
			`tipo `= ptipo,
			`estado `=pestado WHERE `idcliente` = pidcliente;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizarDocVenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarDocVenta`(
piddocumentoventa int ,
ptipodocumento varchar(45) ,
pnumdocumento varchar(45) ,
ptcliente_idcliente int ,
ptvendedor_idvendedor int,
pfechaventa date ,
ppreciototal double ,
pigv double ,
pdescuento double ,
pestado varchar(45)
)
BEGIN
	UPDATE `bdfloreriaInterfaz`.`tdocumentoventa`
    SET  
`tipodocumento` = ptipodocumento,
`numdocumento` = pnumdocumento ,
`tcliente_idcliente` = tcliente_idcliente ,
`tvendedor_idvendedor` = ptvendedor_idvendedor ,
`fechaventa` = pfechaventa ,
`preciototal` = ppreciototal ,
`igv` = pigv ,
`descuento` = pdescuento,
`estado` = pestado  where iddocumentoventa = piddocumentoventa;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizarflor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarflor`(
pidflor int,
pnombre varchar(75),
paroma varchar(45),
pcolor varchar(45),
pprecio double,
pstock int,
pfcreacion datetime,
pestado varchar(12)
)
BEGIN
	UPDATE `bdfloreriaInterfaz`.`tflor`
		SET	`nombre` = pnombre,
			`aroma` = paroma,
			`color` =pcolor,
			`precio` = pprecio,
			`stock` = pstock,
			`fcreacion` = pfcreacion,
			`estado` = pestado
		WHERE `idflor` = pidflor;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizarVendedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarVendedor`(
pidvendedor int ,
pnombre varchar(45) ,
papellidos varchar(45) ,
ptipodocumento varchar(45) ,
pnumdocumento varchar(45),
pcorreo varchar(45) ,
pcomision double ,
pcontrasenea varchar(45),
pestado varchar(45)
)
BEGIN
	UPDATE `bdfloreriaInterfaz`.`tvendedor`
    SET  
`nombre` = pnombre ,
`apellidos` = papellidos ,
`tipodocumento` = ptipodocumento ,
`numdocumento` = pnumdocumento ,
`correo ` = pcorreo ,
`comision ` = pcomision ,
`contrasenea ` = pcontrasenea ,
`estado ` = pestado where idvendedor = pidvendedor;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `crearCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `crearCliente`(
pnombres varchar(45), 
papellidos varchar(45) ,
ptipodocumento varchar(45) ,
pnumdocumento varchar(45) ,
pcorreo varchar(45) ,
ptipo varchar(45) ,
pestado varchar(45)
)
BEGIN
	INSERT INTO `bdfloreriaInterfaz`.`tcliente`
		VALUES(	0,
				pnombres ,
				papellidos ,
				ptipodocumento ,
				pnumdocumento,
				pcorreo ,
				ptipo,
				pestado 
		);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `crearDetalle` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `crearDetalle`(
piddocumentoventa int ,
pidflor int ,
pp_unitario double ,
pcantidad int ,
pdescuento double
)
BEGIN
		INSERT INTO `bdfloreriaInterfaz`.`tdetalleventa`
		VALUES(	0,
        piddocumentoventa ,
pidflor ,
pp_unitario ,
pcantidad ,
pdescuento);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `crearFlor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `crearFlor`(
pnombre varchar(75),
paroma varchar(45),
pcolor varchar(45),
pprecio double,
pstock int,
pfcreacion datetime,
pestado varchar(12)
)
BEGIN
	INSERT INTO `bdfloreriaInterfaz`.`tflor`
		VALUES(	0,
				pnombre,paroma,
				pcolor,pprecio,
				pstock,pfcreacion,
				pestado
		);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `crearVendedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `crearVendedor`(
pnombre varchar(45) ,
papellidos varchar(45) ,
ptipodocumento varchar(45) ,
pnumdocumento varchar(45),
pcorreo varchar(45) ,
pcomision double ,
pcontrasenea varchar(45),
pestado varchar(45))
BEGIN
		INSERT INTO `bdfloreriaInterfaz`.`tvendedor`
		VALUES(	0,
				pnombre  ,
				papellidos ,
                ptipodocumento ,
				pnumdocumento,
				pcorreo  ,
				pcomision ,
                pcontrasenea,
				pestado 
		);
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `EliminarCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarCliente`(pidcliente int)
BEGIN
	UPDATE `bdfloreriainterfaz`.`tcliente` SET `estado` = 'DESACTIVO' WHERE `idcliente` = pidcliente;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `EliminarFlores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarFlores`(pidflor int)
BEGIN
		UPDATE `bdfloreria`.`tflor`
		SET	`estado` = 'DESACTIVO'
		WHERE `idflor` = pidflor;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `EliminarVendedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarVendedor`(pidvendedor int)
BEGIN
	UPDATE `bdfloreriainterfaz`.`tvendedor` SET `estado` = 'DESACTIVO' WHERE `idvendedor` = pidvendedor;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `EliminarVenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarVenta`(pididdocumentoventa int)
BEGIN
	UPDATE `bdfloreriainterfaz`.`tdocumentoventa` SET `estado` = 'DESACTIVO' WHERE `iddocumentoventa` = pididdocumentoventa;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listaDocVenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listaDocVenta`(pestado varchar(12))
BEGIN
	SELECT * FROM `bdfloreriaInterfaz`.`tdocumentoventa` where estado = pestado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarCliente`(pestado varchar(45))
BEGIN
	SELECT * FROM `bdfloreriaInterfaz`.`tcliente`  where estado = pestado;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarFlores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarFlores`(pestado varchar(12))
BEGIN
	SELECT * FROM `bdfloreriaInterfaz`.`tflor` where estado = pestado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarVendedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarVendedor`(pestado varchar(45))
BEGIN
	SELECT * FROM `bdfloreriaInterfaz`.`tvendedor`  where estado = pestado;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-31  2:42:58
