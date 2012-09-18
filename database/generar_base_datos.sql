DROP TABLE IF EXISTS Usuario;
CREATE TABLE Usuario
(
	email VARCHAR (100) NOT NULL,
	password VARCHAR (50) NOT NULL,
    nombre VARCHAR(30),
    apellido VARCHAR (40),
    PRIMARY KEY (email)
);


DROP TABLE IF EXISTS Cliente;
CREATE TABLE Cliente
(
	email VARCHAR (100) NOT NULL,
	direccion VARCHAR (300),
	PRIMARY KEY (email),
	FOREIGN KEY (email) REFERENCES Usuario
);

DROP TABLE IF EXISTS Administrador;
CREATE TABLE Administrador
(
	email VARCHAR (100) NOT NULL,
	PRIMARY KEY (email),
    FOREIGN KEY (email) REFERENCES Usuario
);

DROP TABLE IF EXISTS Pedido;
CREATE TABLE Pedido
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	fecha DATE NOT NULL,
	precio DOUBLE NOT NULL DEFAULT 0,
	cliente VARCHAR (100) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (cliente) REFERENCES Cliente
);

DROP TABLE IF EXISTS PaqueteProducto;
CREATE TABLE PaqueteProducto
(
	pedido INTEGER NOT NULL,
	producto INTEGER NOT NULL,
	n INTEGER,
	nombre_producto VARCHAR (30),
	descripcion VARCHAR (100),
	precio DOUBLE NOT NULL,
	PRIMARY KEY (pedido, producto),
	FOREIGN KEY (pedido) REFERENCES Pedido,
	FOREIGN KEY (producto) REFERENCES Producto
);

DROP TABLE IF EXISTS Producto;
CREATE TABLE Producto
(
	referencia INTEGER NOT NULL AUTO_INCREMENT,
	nombre VARCHAR (30),
	precio DOUBLE NOT NULL,
	categoria VARCHAR (30),
	descripcion VARCHAR (100),
	ruta_imagen VARCHAR (500),
	stock INTEGER NOT NULL DEFAULT 0,
	PRIMARY KEY (referencia)
);

DROP TABLE IF EXISTS Critica;
CREATE TABLE Critica
(
	cliente VARCHAR(100) NOT NULL,
	producto INTEGER NOT NULL,
	nota DOUBLE NOT NULL DEFAULT 0,
	texto VARCHAR(3000),
	PRIMARY KEY (cliente,producto),
	FOREIGN KEY (cliente) REFERENCES Cliente,
	FOREIGN KEY (producto) REFERENCES Producto
);

DROP TABLE IF EXISTS Favorito;
CREATE TABLE Favorito
(
	cliente VARCHAR(100) NOT NULL,
	producto INTEGER NOT NULL,
	PRIMARY KEY (cliente,producto),
	FOREIGN KEY (cliente) REFERENCES Cliente,
	FOREIGN KEY (producto) REFERENCES Producto
);


INSERT INTO Usuario VALUES ('David@iso2.com', '111111', 'David', 'Perez');
INSERT INTO Usuario VALUES ('Jorge@iso2.com', '111111', 'Jorge', 'Tordesillas');
INSERT INTO Usuario VALUES ('Sergio@iso2.com', '111111', 'Sergio', 'Alises');
INSERT INTO Usuario VALUES ('Jesus@iso2.com', '111111', 'Jesus', 'Garcia');
INSERT INTO Usuario VALUES ('Rodrigo@iso2.com', '111111', 'Rodrigo', 'Manzano');
INSERT INTO Usuario VALUES ('Gabriel@iso2.com', '111111', 'Gabriel', 'Jobs');
INSERT INTO Usuario VALUES ('Javier@iso2.com', '111111', 'Javier', 'Tordesillas');
INSERT INTO Usuario VALUES ('Roberto@iso2.com', '111111', 'Roberto', 'Merino');
INSERT INTO Usuario VALUES ('Payaso@iso2.com', '111111', 'Payaso', 'Gates');
INSERT INTO Usuario VALUES ('Cacho@iso2.com', '111111', 'Cacho', 'Manzano');
INSERT INTO Usuario VALUES ('Mourinho@iso2.com', '111111', 'Mourinho', 'Monda');
INSERT INTO Usuario VALUES ('Guardiola@iso2.com', '111111', 'Guardiola', 'Testillano');
INSERT INTO Cliente VALUES ('David@iso2.com', 'Avenida de Europa');
INSERT INTO Cliente VALUES ('Jorge@iso2.com', 'Calle Bachiller Fernan Gomez');
INSERT INTO Cliente VALUES ('Sergio@iso2.com', 'Calle Toledo');
INSERT INTO Cliente VALUES ('Jesus@iso2.com', 'Avenida de Barber');
INSERT INTO Cliente VALUES ('Rodrigo@iso2.com', 'Calle Azucena');
INSERT INTO Cliente VALUES ('Gabriel@iso2.com', 'Avenida de Barber');
INSERT INTO Cliente VALUES ('Javier@iso2.com', 'Calle Toledo');
INSERT INTO Cliente VALUES ('Roberto@iso2.com', 'Calle Bachiller Fernan Gomez');
INSERT INTO Cliente VALUES ('Payaso@iso2.com', 'Avenida de Barber');
INSERT INTO Cliente VALUES ('Cacho@iso2.com', 'Calle Toledo');
INSERT INTO Administrador VALUES ('Mourinho@iso2.com');
INSERT INTO Administrador VALUES ('Guardiola@iso2.com');
INSERT INTO Producto VALUES ('1', 'Honda cb 250', '1149', 'Motos', 'Una moto guapisima', 'img/cb250.jpeg', '2');
INSERT INTO Producto VALUES ('2', 'Piaggio zip', '953', 'Motos', 'Una moto para aparcar facil', 'img/pzip.jpeg', '2');
INSERT INTO Producto VALUES ('3', 'Piaggio zip compressor', '3187', 'Motos', 'La misma que la zip pero comprimida', 'img/Motos.jpeg', '4');
INSERT INTO Producto VALUES ('4', 'Yamaha Aerox', '659', 'Motos', 'La mejor marca', 'img/pzipc.jpeg', '5');
INSERT INTO Producto VALUES ('5', 'Suzuki Burgmann', '3456', 'Motos', 'Scooter convencional de Suzuki', 'img/sburg.jpeg', '5');
INSERT INTO Producto VALUES ('6', 'Aprilia Rally', '2059', 'Motos', 'Scooter de cilindrada menor', 'img/arally.jpeg', '12');
INSERT INTO Producto VALUES ('7', 'Ninja', '663', 'Motos', 'Ninja, no se ve', 'img/ninja.jpeg', '11');
INSERT INTO Producto VALUES ('8', 'Harley Davidson 1000', '707', 'Motos', 'La moto estandar de los satanases del infierno', 'img/hdavid.jpeg', '8');
INSERT INTO Producto VALUES ('9', 'Montesa 50', '1475', 'Motos', 'Tipica moto de campo', 'img/montesa.jpeg', '10');
INSERT INTO Producto VALUES ('10', 'Puma sprint', '19', 'Zapatillas', 'Las zapatillas mas molonas', 'img/psprint.jpeg', '14');
INSERT INTO Producto VALUES ('11', 'Totan 90', '18', 'Zapatillas', 'Zapatillas guapas', 'img/total90.jpeg', '20');
INSERT INTO Producto VALUES ('12', 'Nike 90', '6', 'Zapatillas', 'Sirven para todo', 'img/nike90.jpeg', '18');
INSERT INTO Producto VALUES ('13', 'Adidas 60', '49', 'Zapatillas', 'Zapatillas de la marca que patrocina al Real Madrid', 'img/adidas60.jpeg', '13');
INSERT INTO Producto VALUES ('14', 'Botas de campo', '7', 'Zapatillas', 'Las mejores para vendimiar', 'img/botasCampo.jpeg', '23');
INSERT INTO Producto VALUES ('15', 'Chanclas playeras', '32', 'Zapatillas', 'Las mejores para ir a la playa', 'img/playeras.jpeg', '20');
INSERT INTO Producto VALUES ('16', 'Sandalias de cuero', '65', 'Zapatillas', 'En la tierra media se usaban mucho', 'img/cuero.jpeg', '22');
INSERT INTO Producto VALUES ('17', 'Converse de toda la vida', '8', 'Zapatillas', 'Ahora que se han puesto de moda...', 'img/converse.jpeg', '24');
INSERT INTO Producto VALUES ('18', 'Converse Star', '6', 'Zapatillas', 'Las usa Will Smith', 'img/converse2.jpeg', '22');
INSERT INTO Producto VALUES ('19', 'Converse normal', '9', 'Camisetas', 'Ahora que se han puesto de moda...', 'img/converse3.jpeg', '19');
INSERT INTO Producto VALUES ('20', 'Converse sport', '18', 'Camisetas', 'Las deportivas de converse', 'img/converseSport.jpeg', '21');
INSERT INTO Producto VALUES ('21', 'Converse Love', '43', 'Camisetas', 'Para encontrar el amor', 'img/love.jpeg', '42');
INSERT INTO Producto VALUES ('22', 'Camiseta de cuello alto', '12', 'Camisetas', 'Para no pasar frio en invierno', 'img/cuelloAlto.jpeg', '27');
INSERT INTO Producto VALUES ('23', 'Camiseta casual', '23', 'Camisetas', 'Para pasar desapercibido', 'img/casual.jpeg', '42');
INSERT INTO Producto VALUES ('24', 'Adidas Portero', '21', 'Camisetas', 'Camiseta de portero', 'img/portero.jpeg', '26');
INSERT INTO Producto VALUES ('25', 'Nike Rugby', '35', 'Camisetas', 'La mejor Nike para jugar al futbol', 'img/rugby.jpeg', '39');
INSERT INTO Producto VALUES ('26', 'Puma futbol', '28', 'Camisetas', 'Las mejores para jugar al futbol', 'img/pfutbol.jpeg', '46');
INSERT INTO Producto VALUES ('27', 'Quicksilver sport', '7', 'Camisetas', 'Marca de rapers', 'img/quicksilver.jpeg', '46');
INSERT INTO Producto VALUES ('28', 'Ciudad Mujer 65', '186', 'Bicicletas', 'Para mujeres pequenas', 'img/bicimpequena.jpeg', '39');
INSERT INTO Producto VALUES ('29', 'Ciudad Mujer 70', '97', 'Bicicletas', 'Para mujeres medianas', 'img/bicimmediana.jpeg', '32');
INSERT INTO Producto VALUES ('30', 'Ciudad Mujer 75', '22', 'Bicicletas', 'Para mujeres altas', 'img/bicimgrande.jpeg', '38');
INSERT INTO Producto VALUES ('31', 'Ciudad Mujer sin barra centro', '26', 'Bicicletas', 'Sin barrote', 'img/bicimsinbarra.jpeg', '58');
INSERT INTO Producto VALUES ('32', 'Ciudad Hombre 70', '146', 'Bicicletas', 'Para hombres pequenos', 'img/bicihpequeno.jpeg', '34');
INSERT INTO Producto VALUES ('33', 'Campo Hombre 70', '107', 'Bicicletas', 'Para hombres medianos', 'img/bicihmediana.jpeg', '42');
INSERT INTO Producto VALUES ('34', 'Ciudad Hombre 75', '85', 'Bicicletas', 'Para hombres altos', 'img/bicihgrande.jpeg', '37');
INSERT INTO Producto VALUES ('35', 'BMX unisex mini', '198', 'Bicicletas', 'Para hacer piruetas', 'img/bmx.jpeg', '54');
INSERT INTO Producto VALUES ('36', 'BMX Pro', '25', 'Bicicletas', 'Para hacer piruetas nivel profesional', 'img/bmxpro.jpeg', '39');

INSERT INTO Producto VALUES ('37', 'Chewbacca parlante', '30', 'Otros', 'Juguete mas inutil que un submarino descapotable', 'img/chewbacca.jpg', '60');
INSERT INTO Producto VALUES ('38', 'Despertador Space Invaders', '45', 'Otros', 'Despertador de lo mas geek', 'img/despertador.jpg', '40');
INSERT INTO Producto VALUES ('39', 'Enfriador de botellas', '54', 'Otros', 'El complemento ideal para una cena romantica.', 'img/enfriador.jpg', '76');
INSERT INTO Producto VALUES ('40', 'Funda Eminem para moviles', '10', 'Otros', 'Una funda de ultima generacion para tu movil.', 'img/funda.jpg', '51');
INSERT INTO Producto VALUES ('41', 'Hucha Pac-Man', '12', 'Otros', 'Ahorra de una forma divertida con esta magnifica hucha', 'img/hucha.jpg', '69');
INSERT INTO Producto VALUES ('42', 'Hub USB de Darth Vader', '62', 'Otros', 'Hub USB inutilmente enorme', 'img/vader_usb_base.jpg', '42');
INSERT INTO Producto VALUES ('43', 'iNotepad', '520', 'Otros', 'Bloq de notas tipo iPad', 'img/inotepad.jpg', '46');
INSERT INTO Producto VALUES ('44', 'Posavasos Rubbik', '347', 'Otros', 'Un posavasos con estilo', 'img/posavasos.jpg', '53');
INSERT INTO Producto VALUES ('45', 'Puzzle magnetico', '760', 'Otros', 'Asegura tu entretenamiento durante horas.', 'img/puzzle.jpg', '61');
INSERT INTO Producto VALUES ('46', 'Hucha de R2D2', '794', 'Otros', 'Ahorra de una forma geek', 'img/r2d2.jpg', '87');
INSERT INTO Producto VALUES ('47', 'Hucha SAVE', '91', 'Otros', 'Ahorra de una forma geek', 'img/save.jpg', '70');
INSERT INTO Producto VALUES ('48', 'Raton Lego', '357', 'Otros', 'Ergonomia cero para el control de tu PC.', 'img/mouse.jpg', '93');
INSERT INTO Producto VALUES ('49', 'Reloj invertido', '287', 'Otros', 'Reloj estupido que va en sentido antihorario', 'img/reloj.jpg', '87');
INSERT INTO Producto VALUES ('50', 'Sacapuntas culo de gato', '290', 'Otros', 'Pon al gatito mirando para Cuenca mientras sacas punta a tu lapiz', 'img/sacapuntas.jpeg', '51');
INSERT INTO Producto VALUES ('51', 'Salero y pimentero robot', '798', 'Otros', 'Robots distribuidores de sal y pimienta', 'img/salero.jpeg', '51');
INSERT INTO Producto VALUES ('52', 'Taza Rubik', '295', 'Otros', 'Taza incomoda, pero chula.', 'img/taza.jpg', '66');
INSERT INTO Producto VALUES ('53', 'Mierda pincha en un palo', '502', 'Otros', 'El regalo ideal para tu pareja', 'img/mierdaenpalo.jpg', '103');
INSERT INTO Producto VALUES ('54', 'Nokia L34', '368', 'Moviles', 'Un movil como otro cualquiera. Nada del otro mundo', 'img/movil1.jpg', '104');
INSERT INTO Producto VALUES ('55', 'Nokia i2', '368', 'Moviles', 'Un movil como otro cualquiera. Pero mas bonito.', 'img/movil2.jpg', '104');
INSERT INTO Producto VALUES ('56', 'Motorola 21F', '368', 'Moviles', 'Un movil como otro cualquiera. Pero mas bonito.', 'img/movil3.jpg', '104');

INSERT INTO Producto VALUES ('57', 'Motorola X3', '100', 'Moviles', 'Un movil como otro cualquiera. Pero mas bonito.', 'img/movil4.jpg', '104');
INSERT INTO Producto VALUES ('58', 'Sony Ericsson 3TT', '38', 'Moviles', 'Un movil como otro cualquiera. Nada del otro mundo', 'img/movil5.jpg', '104');
INSERT INTO Producto VALUES ('59', 'Nokia G1', '36', 'Moviles', 'Un movil como otro cualquiera. Nada del otro mundo', 'img/movil6.jpg', '104');
INSERT INTO Producto VALUES ('60', 'HTC 33', '36', 'Moviles', 'Un movil como otro cualquiera. Nada del otro mundo', 'img/movil7.jpg', '104');
INSERT INTO Producto VALUES ('61', 'HTC X1', '68', 'Moviles', 'Un movil como otro cualquiera. Pero mas bonito.', 'img/movil8.jpg', '104');
INSERT INTO Producto VALUES ('62', 'HTC v2', '68', 'Moviles', 'Un movil como otro cualquiera. Pero mas bonito.', 'img/movil9.jpg', '104');
INSERT INTO Producto VALUES ('63', 'Samsung C5', '6', 'Moviles', 'Un movil como otro cualquiera. Pero mas bonito.', 'img/movil10.jpg', '104');
INSERT INTO Producto VALUES ('64', 'Samsung V2', '38', 'Moviles', 'Un movil como otro cualquiera. Pero mas bonito.', 'img/movil1.jpg', '104');
INSERT INTO Producto VALUES ('65', 'Samsung R2', '3', 'Moviles', 'Un movil como otro cualquiera. Pero mas bonito.', 'img/movil2.jpg', '104');
INSERT INTO Producto VALUES ('66', 'Samsung JKT', '36', 'Moviles', 'Un movil como otro cualquiera. Pero mas bonito.', 'img/movil3.jpg', '104');
INSERT INTO Producto VALUES ('67', 'Nokia 4500', '36', 'Moviles', 'Un movil como otro cualquiera. Pero mas bonito.', 'img/movil4.jpg', '104');
INSERT INTO Producto VALUES ('68', 'iPhone 7', '68', 'Moviles', 'Un movil como otro cualquiera. Pero mas bonito.', 'img/movil5.jpg', '104');
INSERT INTO Producto VALUES ('69', 'iPhone Zurullo', '38', 'Moviles', 'Un movil como otro cualquiera. Pero mas bonito.', 'img/movil6.jpg', '104');
INSERT INTO Producto VALUES ('70', 'Nokia 45XS', '31', 'Moviles', 'Un movil como otro cualquiera. Pero mas bonito.', 'img/movil7.jpg', '104');



INSERT INTO Pedido (fecha, cliente, precio) VALUES ('2012/12/12', 'Javier@iso2.com', '2518');
INSERT INTO Pedido (fecha, cliente, precio) VALUES ('2001/01/01', 'Jesus@iso2.com', '318');
INSERT INTO Pedido (fecha, cliente, precio) VALUES ('2011/11/24', 'Rodrigo@iso2.com', '953');
INSERT INTO Pedido (fecha, cliente, precio) VALUES ('2011/11/10', 'Javier@iso2.com', '420');
INSERT INTO Pedido (fecha, cliente, precio) VALUES ('2011/11/22', 'Jorge@iso2.com', '923');
INSERT INTO Pedido (fecha, cliente, precio) VALUES ('2011/11/20', 'David@iso2.com', '564');
INSERT INTO Pedido (fecha, cliente, precio) VALUES ('2011/11/23', 'Sergio@iso2.com', '243');
INSERT INTO Pedido (fecha, cliente, precio) VALUES ('2011/11/11', 'Payaso@iso2.com', '238');


INSERT INTO PaqueteProducto VALUES ('0', '1', '2', 'Honda cb 250', 'Una moto guapisima', '1149');
INSERT INTO PaqueteProducto VALUES ('0', '64', '1', 'HTC Legend', 'La leyenda de los moviles', '176');
INSERT INTO PaqueteProducto VALUES ('0', '60', '4', 'Linterna de cabeza', 'Sirve para lanzar a la cabeza', '11');
INSERT INTO PaqueteProducto VALUES ('1', '67', '2', 'Nokia Luma 800', 'Es el movil de las estrellas', '318');
INSERT INTO PaqueteProducto VALUES ('2', '2', '2', 'Piaggio zip', 'Una moto para aparcar facil', '953');
INSERT INTO PaqueteProducto VALUES ('3', '41', '10', 'Fregaplatos', 'El que mejor friega los platos', '420');
INSERT INTO PaqueteProducto VALUES ('4', '49', '9', 'Dell Inspiron 1500', 'El segundo mejor en relacion calidad-precio', '87');
INSERT INTO PaqueteProducto VALUES ('4', '70', '1', 'Geekphone', 'Movil para geeks', '140');
INSERT INTO PaqueteProducto VALUES ('5', '69', '2', 'Iphone 4', 'El mismo que el 4s', '282');
INSERT INTO PaqueteProducto VALUES ('6', '58', '3', 'Linterna de xenon', 'Esta hecha con faros de xenon', '81');
INSERT INTO PaqueteProducto VALUES ('7', '61', '2', 'Dell Streak', 'Con este movil puedes llamar', '119');
