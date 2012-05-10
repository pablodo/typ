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
  `alqCliente` int(11) NOT NULL,
  `alqFIN` datetime NOT NULL,
  `alqFOUT` datetime NOT NULL,
  `alqOcupantesA` int(11) NOT NULL,
  `alqOcupantesM` int(11) NOT NULL,
  `alqOcupantesB` int(11) NOT NULL,
  `alqDesayunos` int(11) NOT NULL,
  `alqDesayunosImp` int(11) NOT NULL,
  `alqContrato` int(11) NOT NULL,
  `alqImporteReserva` decimal(10,2) NOT NULL,
  `alqTotal` decimal(10,2) NOT NULL,
  `alqTotalImp` decimal(10,2) NOT NULL,
  `alqVencimiento` datetime NOT NULL,
  `alqFormaPago` int(11) NOT NULL,
  `alqCuentaImp` int(11) NOT NULL,
  `alqCuentaOpe` int(11) NOT NULL,
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
--
-- Volcado de datos para la tabla `Clientes`
--
INSERT INTO `Clientes` (`cliID`, `cliDNI`, `cliApellido`, `cliNombre`, `cliTelefono`, `cliCelular`, `cliEmail`) VALUES
(1, '23456789', 'Bbbb', 'Bbb', '123-4567-8909-8765', '098-8765-4322-3456', 'Bbbb@gmail.com'),
(2, '21345678', 'Cccc', 'Ccc', '987-9876-7676-5644', '765-6756-5456-4564', 'Cccc@gmail.com'),
(3, '87766554', 'Dddd', 'Ddd', '765-7644-5586-7978', '543-3654-5765-8768', 'Dddd@gmail.com'),
(4, '12321324', 'kjknkjnkjn', 'knkk', '988-9786-8756-6456', '798-7986-8768-6686', 'gjgdjshgd@jvjhghj.sfgs');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `Conceptos`
--
CREATE TABLE IF NOT EXISTS `Conceptos` (
  `conID` int(11) NOT NULL AUTO_INCREMENT,
  `conTipo` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`conID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=22 ;
--
-- Volcado de datos para la tabla `Conceptos`
--
INSERT INTO `Conceptos` (`conID`, `conTipo`) VALUES
(16, 'Seña'),
(17, 'Reserva'),
(18, 'Cancelación'),
(19, 'Comisiones'),
(20, 'Pagos al Propietario'),
(21, 'Expensas');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `Contratos`
--
CREATE TABLE IF NOT EXISTS `Contratos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `conTipo` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `conDetalle` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;
--
-- Volcado de datos para la tabla `Conceptos`
--
INSERT INTO `Contratos` (`ID`, `conTipo`, `conDetalle`) VALUES
(1, "Reserva",          ''),
(2, "Cancelación",      ''),
(3, "Ingreso",          ''),
(4, "Ingreso Completo", ''),
(5, "Anulación",      '');
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
-- Estructura de tabla para la tabla `Movimientos`
--
CREATE TABLE IF NOT EXISTS `Movimientos` (
  `movID` int(11) NOT NULL AUTO_INCREMENT,
  `movFecha` datetime NOT NULL,
  `movTipoPago` int(11) NOT NULL,
  `movImporte` decimal(10,2) NOT NULL,
  `movUF` int(11) NOT NULL,
  `movImputacion` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `movImputacionValor` decimal(10,2) NOT NULL,
  PRIMARY KEY (`movID`)
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
  `propTelefono` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `propCelular` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `propCUIT` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `propBanco` int(11) NOT NULL,
  `propNCuenta` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `propCBU` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `propTCuenta` int(11) NOT NULL,
  `propUF` int(11) NOT NULL,
  PRIMARY KEY (`propID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;
--
-- Volcado de datos para la tabla `Propietarios`
--
INSERT INTO `Propietarios` (`propID`, `propApellido`, `propNombre`, `propEmail`, `propTelefono`, `propCelular`, `propCUIT`, `propBanco`, `propNCuenta`, `propCBU`, `propTCuenta`, `propUF`) VALUES
( 1, 'Patri',         'Juan Antonio', 'jjjuan23jjj@hotmail.com',    '011-155-010-2757', '011-155-010-2757', '20-11985872-1', 1, '6096-03413-8', '1500609900060960341382', 1, 1),
( 2, 'Dal Lago',      'Mercedes',     'carodal_lago@hotmail.com',   '011 154 969 1701', '011 154 969 1701', '',              0, '',             '',                       0, 1),
( 3, 'Menaged',       'David',        'menageddavid@hotmail.com',   '011 154 083 1845', '011 154 083 1845', '27-14026259-0', 6, '143-14296-4',  '0170143840000001429646', 2, 2),
( 4, 'Muebles París', 'Ariel',        'mueblesparis@speedy.com.ar', '',                 '0223 4964050',     '',              0, '',             '',                       0, 3),
( 5, 'Muebles París', 'Daniel',       '',                           '0223 154 473 760', '0223 4964050',     '30-70068339-3', 1, '0753-20349-1', '1500025100007532034914', 4, 3),
( 6, 'Bianchi'      , 'Patricia',     '',                           '',                 '',                 '27-24364732-6', 9, '5-201532-517', '0167777100052015325173', 1, 0),
( 7, 'Bianchi'      , 'Patricia',     '',                           '',                 '',                 '27-24364732-6', 1, '786153532',    '1500032900007861535328', 1, 0);
/*(  , '', '', '', '', '', '', 0, '', '', 0, 0),*/
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `Tarifas`
--
CREATE TABLE IF NOT EXISTS `Tarifas` (
  `tarifasID` int(11) NOT NULL AUTO_INCREMENT,
  `tarifasImporte` decimal(10,2) NOT NULL,
  PRIMARY KEY (`tarifasID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;
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
  UNIQUE KEY `tufDetalle` (`tufDetalle`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;
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
( 1, 'UF 01', 1, 'Aaaa.', 0),
( 2, 'UF 02', 1, 'Bbbb.', 0),
( 3, 'UF 03', 0, 'Cccc.', 0),
( 4, 'UF 04', 1, 'Dddd.', 0),
( 5, 'UF 05', 0, 'Bbbb.', 0),
( 6, 'UF 06', 1, 'Bbbb.', 0),
( 7, 'UF 07', 3, 'Bbbb.', 0),
( 8, 'UF 08', 0, 'Bbbb.', 0),
( 9, 'UF 09', 3, 'Bbbb.', 0),
(10, 'UF 10', 0, 'Bbbb.', 0),
(11, 'UF 11', 3, 'Aaaa.', 0),
(12, 'UF 12', 1, 'Bbbb.', 0),
(13, 'UF 13', 1, 'Cccc.', 0),
(14, 'UF 14', 0, 'Dddd.', 0),
(15, 'UF 15', 0, 'Bbbb.', 0),
(16, 'UF 16', 0, 'Bbbb.', 0),
(17, 'UF 17', 1, 'Bbbb.', 0),
(18, 'UF 18', 3, 'Bbbb.', 0),
(19, 'UF 19', 0, 'Bbbb.', 0),
(20, 'UF 20', 3, 'Bbbb.', 0),
(21, 'UF 21', 0, 'Aaaa.', 0),
(22, 'UF 22', 1, 'Bbbb.', 0),
(23, 'UF 23', 2, 'Cccc.', 0),
(24, 'UF 24', 1, 'Dddd.', 0),
(25, 'UF 25', 0, 'Bbbb.', 0),
(26, 'UF 26', 0, 'Bbbb.', 0),
(27, 'UF 27', 0, 'Bbbb.', 0),
(28, 'UF 28', 1, 'Bbbb.', 0);
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
(1, 'admin@typ.com', 0x8f2456956029dfd398da8724afdc399b, 1, 1, 0),
(2, 'prop1@typ.com', 0x8f2456956029dfd398da8724afdc399b, 2, 1, 0),
(3, 'prop2@typ.com', 0x8f2456956029dfd398da8724afdc399b, 2, 0, 0),
(4, 'prop3@typ.com', 0x8f2456956029dfd398da8724afdc399b, 2, 1, 0),
(5, 'admin1@typ.com', 0x8f2456956029dfd398da8724afdc399b, 1, 0, 0);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `FormasPago`
--
CREATE TABLE IF NOT EXISTS `FormasPago` (
  `fpID` int(11) NOT NULL AUTO_INCREMENT,
  `fpNombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`fpID`),
  UNIQUE KEY `fpNombre` (`fpNombre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;
--
-- Volcado de datos para la tabla `FormasPago`
--
INSERT INTO `FormasPago` (`fpNombre`) VALUES
('Contado'),
('30 dias');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `FormasPago`
--
CREATE TABLE IF NOT EXISTS `TiposPago` (
  `tpID` int(11) NOT NULL AUTO_INCREMENT,
  `tpNombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tpDestino` int(1) NOT NULL, /* A favor del propietario o a favor de la comercializadora */
  PRIMARY KEY (`tpID`),
  UNIQUE KEY `tpNombre` (`tpNombre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;
--
-- Volcado de datos para la tabla `FormasPago`
--
INSERT INTO `TiposPago` (`tpNombre`, `tpDestino`) VALUES
('Cta. Bancaria del Propietario', 1),
('Efectivo en Oficinas', 2),
('Efectivo en el Complejo', 2),
('Otros', 1);
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
