CREATE TABLE IF NOT EXISTS `Liquidaciones` (
  `liqID` int(11) NOT NULL AUTO_INCREMENT,
  `liqFecha` datetime NOT NULL,
  `liqPropietario` int(11) NOT NULL,
  `liqImporte` decimal(10,2) NOT NULL,
  `liqACobrar` decimal(10,2) NOT NULL,
  `liqAPagar` decimal(10,2) NOT NULL,
  `liqNoImputado` decimal(10,2) NOT NULL,
  `liqSinComision` decimal(10,2) NOT NULL,
  `liqComisiones` decimal(10,2) NOT NULL,
  `liqGanancia` decimal(10,2) NOT NULL,
  PRIMARY KEY (`liqID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;

ALTER TABLE Movimientos ADD COLUMN movLiquidacion int(11) after movDetalle;
ALTER TABLE Movimientos DROP COLUMN movFechaSaldado;
ALTER TABLE Movimientos DROP COLUMN movSaldado;
ALTER TABLE Movimientos DROP COLUMN movPropietarioSaldado;
