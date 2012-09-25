-- phpMyAdmin SQL Dump
-- version 3.4.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 14-03-2012 a las 12:57:49
-- Versión del servidor: 5.1.61
-- Versión de PHP: 5.2.17
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
--
-- Base de datos: `sdioppolo_typ`
--
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `Alquileres`
--
CREATE TABLE IF NOT EXISTS `Alquileres` (
  `alqID` int(11) NOT NULL AUTO_INCREMENT,
  `alqEstado` int(11) NOT NULL,
  `alqFecha` datetime NOT NULL,
  `alqOperador` int(11) NOT NULL,
  `alqUF` int(11) NOT NULL,
  `alqCuentaOpePropID` int(11) NOT NULL,
  `alqCuentaImpPropID` int(11) NOT NULL,
  `alqCliente` int(11) NOT NULL,
  `alqFIN` datetime NOT NULL,
  `alqFOUT` datetime NOT NULL,
  `alqOcupantesA` int(11) NOT NULL,
  `alqOcupantesM` int(11) NOT NULL,
  `alqOcupantesB` int(11) NOT NULL,
  `alqDesayunos` int(11) NOT NULL,
  `alqDesayunosImp` int(11) NOT NULL,
  `alqContratoProp` int(11) NOT NULL,
  `alqContratoCli` int(11) NOT NULL,
  `alqImporteMinReserva` decimal(10,2) NOT NULL,
  `alqImporteReserva` decimal(10,2) NOT NULL,
  `alqDifImputacion` decimal(10,2) NOT NULL,
  `alqImporteSinComision` decimal(10,2) NOT NULL,
  `alqTotal` decimal(10,2) NOT NULL,
  `alqVencimiento` datetime NOT NULL,
  `alqFormaPagoOpe` int(11) NOT NULL,
  `alqFormaPagoImp` int(11) NOT NULL,
  `alqObservaciones` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`alqID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `Bancos`
--
CREATE TABLE IF NOT EXISTS `Bancos` (
  `bancoID` int(11) NOT NULL AUTO_INCREMENT,
  `bancoNombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`bancoID`),
  UNIQUE KEY `bancoNombre` (`bancoNombre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;
--
-- Volcado de datos para la tabla `Bancos`
--
INSERT INTO `Bancos` (`bancoID`, `bancoNombre`) VALUES
(7, 'Credicoop'),
(6, 'Frances'),
(3, 'Galicia'),
(1, 'H.S.B.C.'),
(4, 'Nación'),
(5, 'Provincia'),
(2, 'Santander Rio'),
(8, 'Macro'),
(9, 'CITI');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `Clientes`
--
CREATE TABLE IF NOT EXISTS `Clientes` (
  `cliID` int(11) NOT NULL AUTO_INCREMENT,
  `cliDNI` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `cliApellido` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `cliNombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `cliTelefono` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `cliCelular` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `cliEmail` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`cliID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `Contratos`
--
CREATE TABLE IF NOT EXISTS `Contratos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `conTipo` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `conDetalle` varchar(3000) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;
--
-- Volcado de datos para la tabla `Contratos`
--
INSERT INTO `Contratos` (`ID`, `conTipo`, `conDetalle`) VALUES
( 1, "Reserva Provisoria",           ''),
( 2, "Confirmación Cliente",         ''),
( 3, "Confirmación Propietario",     ''),
( 4, "Cancelación Cliente",          ''),
( 5, "Cancelación Propietario",      ''),
( 6, "Ingreso Cliente",              ''),
( 7, "Ingreso Propietario",          ''),
( 8, "Ingreso Completo Cliente",     ''),
( 9, "Ingreso Completo Propietario", ''),
(10, "Anulación Cliente",            ''),
(11, "Anulación Propietario",        '');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `DetAlquileres`
--
CREATE TABLE IF NOT EXISTS `DetAlquileres` (
  `dalqID` int(11) NOT NULL AUTO_INCREMENT,
  `dalqAlq` int(11) NOT NULL,
  `dalqFecha` date NOT NULL,
  PRIMARY KEY (`dalqID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `Propietarios`
--
CREATE TABLE IF NOT EXISTS `Propietarios` (
  `propID` int(11) NOT NULL AUTO_INCREMENT,
  `propApellido` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `propNombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `propEmail` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `propTelefono` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `propCelular` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `propCUIT` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `propBanco` int(11) NOT NULL,
  `propNCuenta` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `propCBU` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `propTCuenta` int(11) NOT NULL,
  `propTitularCuenta` varchar(65) COLLATE utf8_unicode_ci NOT NULL,
  `propUF` int(11) NOT NULL,
  PRIMARY KEY (`propID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `TCuentas`
--
CREATE TABLE IF NOT EXISTS `TCuentas` (
  `tcID` int(11) NOT NULL AUTO_INCREMENT,
  `tcNombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`tcID`),
  UNIQUE KEY `tcNombre` (`tcNombre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;
--
-- Volcado de datos para la tabla `TCuentas`
--
INSERT INTO `TCuentas` (`tcID`, `tcNombre`) VALUES
(1, 'Caja de Ahorro $'),
(2, 'Caja de Ahorro'),
(3, 'Cuenta Corriente'),
(4, 'Cuenta Corriente $'),
(5, 'Especial');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `TiposUF`
--
CREATE TABLE IF NOT EXISTS `TiposUF` (
  `tufID` int(11) NOT NULL AUTO_INCREMENT,
  `tufDetalle` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `tufMetros2` int(11) NOT NULL,
  `tufAmbientes` int(11) NOT NULL,
  `tufUbicacion` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`tufID`),
  UNIQUE KEY `tufDetalle` (`tufDetalle`)) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;
--
-- Volcado de datos para la tabla `TiposUF`
--
INSERT INTO `TiposUF` (`tufID`, `tufDetalle`, `tufMetros2`, `tufAmbientes`, `tufUbicacion`) VALUES
(1, '2 AMB AL FRENTE',      30, 2, 'Frente'),
(2, '3 AMB 1 BÑ AL FRENTE', 50, 3, 'Frente'),
(3, '3 AMB 1 BÑ LATERAL',   60, 3, 'LATERAL');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `UnidadesFuncionales`
--
CREATE TABLE IF NOT EXISTS `UnidadesFuncionales` (
  `ufID` int(11) NOT NULL AUTO_INCREMENT,
  `ufNombre` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ufTipo` int(11) NOT NULL,
  `ufDetalles` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `ufPrecio` int(11) NOT NULL,
  PRIMARY KEY (`ufID`),
  UNIQUE KEY `ufNombre` (`ufNombre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;
--
-- Volcado de datos para la tabla `UnidadesFuncionales`
--
INSERT INTO `UnidadesFuncionales` (`ufID`, `ufNombre`, `ufTipo`, `ufDetalles`, `ufPrecio`) VALUES
( 1, 'UF 01', 1, '', 0),
( 2, 'UF 02', 1, '', 0),
( 3, 'UF 03', 0, '', 0),
( 4, 'UF 04', 1, '', 0),
( 5, 'UF 05', 0, '', 0),
( 6, 'UF 06', 1, '', 0),
( 7, 'UF 07', 3, '', 0),
( 8, 'UF 08', 0, '', 0),
( 9, 'UF 09', 3, '', 0),
(10, 'UF 10', 0, '', 0),
(11, 'UF 11', 3, '', 0),
(12, 'UF 12', 1, '', 0),
(13, 'UF 13', 1, '', 0),
(14, 'UF 14', 0, '', 0),
(15, 'UF 15', 0, '', 0),
(16, 'UF 16', 0, '', 0),
(17, 'UF 17', 1, '', 0),
(18, 'UF 18', 3, '', 0),
(19, 'UF 19', 0, '', 0),
(20, 'UF 20', 3, '', 0),
(21, 'UF 21', 0, '', 0),
(22, 'UF 22', 1, '', 0),
(23, 'UF 23', 2, '', 0),
(24, 'UF 24', 1, '', 0),
(25, 'UF 25', 0, '', 0),
(26, 'UF 26', 0, '', 0),
(27, 'UF 27', 0, '', 0),
(28, 'UF 28', 1, '', 0);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `UsuariosWeb`
--
CREATE TABLE IF NOT EXISTS `UsuariosWeb` (
  `usrID` int(11) NOT NULL AUTO_INCREMENT,
  `usrEmail` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `usrPass` blob NOT NULL,
  `usrNivel` int(11) NOT NULL,
  `usrActivo` int(11) NOT NULL,
  `usrPropID` int(11) NOT NULL,
  PRIMARY KEY (`usrID`),
  UNIQUE KEY `usrEmail` (`usrEmail`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;
--
-- Volcado de datos para la tabla `UsuariosWeb`
--
INSERT INTO `UsuariosWeb` (`usrID`, `usrEmail`, `usrPass`, `usrNivel`, `usrActivo`, `usrPropID`) VALUES
(1, 'admin@typ.com', 0x8f2456956029dfd398da8724afdc399b, 1, 1, 0);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `FormasPago`
--
CREATE TABLE IF NOT EXISTS `FormasPago` (
  `fpID` int(11) NOT NULL AUTO_INCREMENT,
  `fpNombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `fpDestino` int(1) NOT NULL, /* A favor de (1: Comercializadora, 2: Propietario) */
  PRIMARY KEY (`fpID`),
  UNIQUE KEY `fpNombre` (`fpNombre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;
--
-- Volcado de datos para la tabla `FormasPago`
--
INSERT INTO `FormasPago` (`fpNombre`, `fpDestino`) VALUES
('Cta. Bancaria del Propietario', 2),
('Efectivo en Oficinas', 1),
('Efectivo en el Complejo', 1);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `Configuracion`
--
CREATE TABLE IF NOT EXISTS `Configuracion` (
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `emailPassword` blob,
  `mailing` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
--
-- Volcado de datos para la tabla `Configuracion`
--
INSERT INTO `Configuracion` (`mailing`, `email`, `emailPassword`) VALUES (1, 'tesoreria@30yplaya.com.ar', AES_ENCRYPT('hypersys2010', 'typ2012'));
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `Movimientos`
--
CREATE TABLE IF NOT EXISTS `Movimientos` (
  `movID` int(11) NOT NULL AUTO_INCREMENT,
  `movFecha` datetime NOT NULL,
  `movFechaSaldado` datetime default NULL,
  `movAlqID` int(11) NOT NULL,
  `movImporte` decimal(10,2) NOT NULL,
  `movSaldado` int(1) NOT NULL, /* (0: Sin saldar, 1: Saldado) */
  `movPropietarioSaldado` int(11) NOT NULL,
  `movDestino` int(1) NOT NULL, /* A favor de (1: Comercializadora, 2: Propietario) */
  `movDetalle` varchar(30) COLLATE utf8_unicode_ci default '',
  PRIMARY KEY (`movID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;
