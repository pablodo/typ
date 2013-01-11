ALTER TABLE Alquileres ADD COLUMN alqEmailPropietario int(11) NOT NULL after alqUF;
ALTER TABLE Alquileres ADD COLUMN alqPropietarioOpe int(11) NOT NULL after alqFormaPagoImp;
ALTER TABLE Alquileres ADD COLUMN alqPropietarioImp int(11) NOT NULL after alqPropietarioOpe;
