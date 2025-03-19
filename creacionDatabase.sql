CREATE DATABASE IF NOT EXISTS `tiendaEntornosG1`
USE `tiendaEntornosG1`;

CREATE TABLE IF NOT EXISTS `tipodocumento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

INSERT INTO `tipodocumento` (`id`, `tipo`) 
VALUES
(5, 'CEDULA'),
(6, 'TARJETA'),
(7, 'PASAPORTE');

CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idTipoDocumento` int NOT NULL,
  `numeroDocumento` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci NOT NULL,
  `nombre` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci NOT NULL,
  `nombreUsuario` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario_unique` (`nombreUsuario`),
  UNIQUE KEY `usuario_unique_1` (`numeroDocumento`),
  UNIQUE KEY `usuario_unique_2` (`email`),
  KEY `fktipodocumento` (`idTipoDocumento`),
  CONSTRAINT `fktipodocumento` FOREIGN KEY (`idTipoDocumento`) REFERENCES `tipodocumento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;

INSERT INTO `usuario` (`id`, `idTipoDocumento`, `numeroDocumento`, `email`, `nombre`, `password`, `nombreUsuario`)
VALUES
	(1, 5, '63124561', 'pedro@lafloresta.com', 'Pedro Alonso Paquetiva', '123', 'admin'),
	(2, 5, '9123455', 'pepe@gmail.com', 'Pepe', '123456', 'cliente'),
	(4, 6, '890123445', 'palonso@floresta.edu.co', 'Pedro Alonso Paquetiva', 'pepito', 'pepe'),
	(9, 5, '91239999', 'JAnono@uis.edu.co', 'Jorge Arturo Cifuentes Velez', 'nono123456', 'elnono'),
	(10, 5, '91234190', 'llopez@gmail.com', 'Luis Pedro López', '123456', 'llopez'),
	(11, 5, '631245618', 'Sninio@uis.edu.co', 'Sandra Milena NIño', 'ssndra123', 'sninio'),
	(12, 5, '1098123451', 'Falarcon@gmail.com', 'Fernando José Alarcón Suarez', '12345', 'FAlarcon'),
	(13, 6, '65081136415', 'lcalderon@gmail.com', 'Luis Fernando Calderón', '12311', 'lcalderon'),
	(14, 5, '90213778', 'jsuarez@gmail.com', 'Jorge Ernesto Suarez', '123456', 'jsuarez');

CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idTipoDocumento` int NOT NULL,
  `numeroDocumento` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci NOT NULL,
  `direccion` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci NOT NULL,
  `nombre` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci NOT NULL,
  `telefono` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cliente_unique` (`numeroDocumento`),
  UNIQUE KEY `email_unique` (`email`),
  KEY `FK_TIPODOCUMENTO_CLIENTE` (`idTipoDocumento`),
  CONSTRAINT `FK_TIPODOCUMENTO_CLIENTE` FOREIGN KEY (`idTipoDocumento`) REFERENCES `tipodocumento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;

CREATE TABLE `proveedor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `direccion` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `nombre` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `telefono` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `nit` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `proveedor_unique_nit` (`nit`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;

INSERT INTO `proveedor` (`id`, `ciudad`, `direccion`, `nombre`, `telefono`, `nit`) VALUES
	(2, 'Bogotá', 'Carrera 123 # 12 - 80', 'Colgate', '312456123', '890123122'),
	(4, 'Bogotá', 'Avenida 7 # 12 - 80', 'Carvajal S.A', '23467811', '890123564');

CREATE TABLE IF NOT EXISTS `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idProveedor` int(11) NOT NULL,
  `ivaCompra` double NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `precioCompra` double NOT NULL,
  `precioVenta` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PROVEEDOR_PRODUCTO` (`idProveedor`),
  CONSTRAINT `FK_PROVEEDOR_PRODUCTO` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

CREATE TABLE IF NOT EXISTS `venta` (
  `id` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `ivaVenta` double NOT NULL,
  `totalVenta` double NOT NULL,
  `valorVenta` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CLIENTE_VENTA` (`idCliente`),
  KEY `FK_USUARIO_VENTA` (`idUsuario`),
  CONSTRAINT `FK_CLIENTE_VENTA` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FK_USUARIO_VENTA` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

CREATE TABLE IF NOT EXISTS `detalleventa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idProducto` int(11) NOT NULL,
  `idVenta` int(11) NOT NULL,
  `cantidadProducto` int(11) NOT NULL,
  `valorTotal` double NOT NULL,
  `valorVenta` double NOT NULL,
  `valorIva` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_VENTA_DETALLE` (`idVenta`),
  KEY `FK_PRODUCTO_DETALLE` (`idProducto`),
  CONSTRAINT `FK_PRODUCTO_DETALLE` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`id`),
  CONSTRAINT `FK_VENTA_DETALLE` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
