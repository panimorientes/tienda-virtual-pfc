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



