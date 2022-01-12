DROP TABLE IF EXISTS proveedor;
DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS producto_detalle;
DROP TABLE IF EXISTS ubicacion_tipo;
DROP TABLE IF EXISTS ubicacion;

CREATE TABLE proveedor(
   id INT GENERATED ALWAYS AS IDENTITY,
   codigo VARCHAR(255) UNIQUE NOT NULL,
   nombre VARCHAR(255) NOT NULL,
   direccion VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   telefono VARCHAR(255) NOT NULL,
   created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   available BOOLEAN NOT NULL DEFAULT TRUE,
   PRIMARY KEY(id)
);

CREATE TABLE producto(
   id INT GENERATED ALWAYS AS IDENTITY,
   codigo VARCHAR(255) UNIQUE NOT NULL,
   descripcion VARCHAR(255) NOT NULL,
   tipo VARCHAR(255) NOT NULL,
   clase VARCHAR(255) NOT NULL,
   nivel_rotacion VARCHAR(1) NOT NULL,
   aplica_impuesto BOOLEAN NOT NULL DEFAULT FALSE,
   proveedor_id INT NOT NULL,
   created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   available BOOLEAN NOT NULL DEFAULT TRUE,
   PRIMARY KEY(id),
   CONSTRAINT fk_proveedor
     FOREIGN KEY(proveedor_id) 
	  REFERENCES proveedor(id)
);

CREATE TABLE producto_detalle(
	id INT GENERATED ALWAYS AS IDENTITY,
	id_producto INT NOT NULL,
	precio INT NOT NULL DEFAULT 0,
	descuento INT NOT NULL DEFAULT 0,
	costo INT NOT NULL DEFAULT 0,
	peso INT NOT NULL DEFAULT 0,
	volumen INT NOT NULL DEFAULT 0,
	cantidad INT NOT NULL DEFAULT 0,
	aplica_descuento BOOLEAN NOT NULL DEFAULT FALSE,
   created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   available BOOLEAN NOT NULL DEFAULT TRUE,
   PRIMARY KEY(id),
   CONSTRAINT fk_producto_detalle
     FOREIGN KEY(id_producto) 
	  REFERENCES producto(id)
);

CREATE TABLE producto_lote(
	id INT GENERATED ALWAYS AS IDENTITY,
	id_producto INT NOT NULL,
	serie VARCHAR(255) NOT NULL,
	fecha_expiracion VARCHAR(255) NOT NULL,
	codigo_barra VARCHAR(255) NOT NULL,
	precio INT NOT NULL DEFAULT 0,
	cantidad INT NOT NULL DEFAULT 0,
	cantidad_bloqueada INT NOT NULL DEFAULT 0,
	original INT NOT NULL DEFAULT 0,
	innerpack INT NOT NULL DEFAULT 0,
	largo INT NOT NULL DEFAULT 0,
	ancho INT NOT NULL DEFAULT 0,
	alto INT NOT NULL DEFAULT 0,
	peso INT NOT NULL DEFAULT 0,
   created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   available BOOLEAN NOT NULL DEFAULT TRUE,
   PRIMARY KEY(id),
   CONSTRAINT fk_producto_lote
     FOREIGN KEY(id_producto) 
	  REFERENCES producto(id)
);

CREATE TABLE ubicacion_tipo(
	codigo VARCHAR(255) UNIQUE NOT NULL,
	descripcion VARCHAR(255) NOT NULL,
	clasificacion VARCHAR(255) NOT NULL,
   created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   available BOOLEAN NOT NULL DEFAULT TRUE,
   PRIMARY KEY(codigo)
);

CREATE TABLE ubicacion(
	id INT GENERATED ALWAYS AS IDENTITY,
	codigo VARCHAR(255) NOT NULL,
	nivel VARCHAR(255) NOT NULL,
	segmento VARCHAR(255) NOT NULL,
	codigo_tipo VARCHAR(255) NOT NULL,
   created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   available BOOLEAN NOT NULL DEFAULT TRUE,
   PRIMARY KEY(id),
   CONSTRAINT fk_ubicacion_tipo
     FOREIGN KEY(codigo_tipo) 
	  REFERENCES ubicacion_tipo(codigo)
);

CREATE TABLE producto_ubicacion_almacen(
	id INT GENERATED ALWAYS AS IDENTITY,
	id_producto INT NOT NULL,
	id_ubicacion INT NOT NULL,
	clasificacion VARCHAR(255) NOT NULL,
	cantidad_maxima INT NOT NULL DEFAULT 0,
	cantidad_minima INT NOT NULL DEFAULT 0,
	orden_recorrido INT NOT NULL DEFAULT 0,
   created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   available BOOLEAN NOT NULL DEFAULT TRUE,
   PRIMARY KEY(id),
   CONSTRAINT fk_producto_almacen
     FOREIGN KEY(id_producto) 
	  REFERENCES producto(id),
   CONSTRAINT fk_ubicacion_almacen
     FOREIGN KEY(id_ubicacion) 
	  REFERENCES ubicacion(id)
);
