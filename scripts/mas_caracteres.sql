ALTER TABLE Propietarios MODIFY propTelefono varchar(50) COLLATE utf8_unicode_ci NOT NULL;
ALTER TABLE Propietarios MODIFY propCelular varchar(50) COLLATE utf8_unicode_ci NOT NULL;
ALTER TABLE Propietarios MODIFY propCBU varchar(30) COLLATE utf8_unicode_ci NOT NULL;
ALTER TABLE Propietarios MODIFY propTitularCuenta varchar(65) COLLATE utf8_unicode_ci NOT NULL;
ALTER TABLE Contratos MODIFY conDetalle varchar(3000) COLLATE utf8_unicode_ci NOT NULL;
