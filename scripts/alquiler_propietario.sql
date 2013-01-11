ALTER TABLE Alquileres ADD COLUMN alqEmailPropietario int(11) after alqUF;
ALTER TABLE Alquileres ADD COLUMN alqPropietarioOpe int(11) after alqFormaPagoImp;
ALTER TABLE Alquileres ADD COLUMN alqPropietarioImp int(11) after alqPropietarioOpe;
