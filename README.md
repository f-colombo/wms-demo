

# WMS - Demo [![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com) [![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg?style=flat-square)](https://github.com/your/your-project/blob/master/LICENSE)
> POC Warehouse Management System

Software diseñado y creado para optimizar los procesos de almacenamiento, distribución, cadena de suministro y cumplimiento dentro de una empresa de distribución de medicinas.
En esta prueba de concepto se manejan las entidades:
- Proveedor que fabrica uno o varios Productos.
- Producto que tiene uno o varios ProductoDetalle.
- Producto que tiene uno o varios ProductoLote.
- TipoUbicacion que difine una o varias Ubicaciones.
- Ubicaciones donde se puede almacenar los productos.
- ProductoUbicacionAlmacen donde se define cuales son las ubicaciones de Despacho, Almacenaje Primario y Almacenaje Secundario.
- ProductoUbicacionLote donde se tiene registro de las Ubicaciones donde se encuentra determinado Lote de un Producto y su Cantidad.

## Instalación/Ejecución

Una vez clonado el repositorio; abrir una console/terminal y ejecutar los siguientes comandos
1. Desde la carpeta `wms-demo/backend-sb` se debe construir el archivo .JAR correspondiente a la api, ejecutando el siguiente comando:
```shell
$ ./mvnw clean package
```
2. Desde la carpeta raíz `wms-demo` se contenerizan y ejecutan los componentes de la solución: db, backend y frontend; ejecutando el comando:
```shell
$ sudo docker-compose up --build
```

Se crean los servicios: db (postgres), backend (springboot) y frontend (reactjs).
La base de datos se crea con data pre-establecidad y los script se encuentran en la carpeta: `wms-demo/database`.

## Ejecución

- El servicio `db` (Postgre) esta activo por el puerto 5432.
- El servicio `backend` (springboot) esta ejecutando en la ruta: http://localhost:8080. Y tiene habilitados los siguientes EndPoint:
  - http://localhost:8080/api/v1/dashboard
  - http://localhost:8080/api/v1/productos
  - http://localhost:8080/api/v1/productos/1
  - http://localhost:8080/api/v1/proveedores/1/productos
  - http://localhost:8080/api/v1/productos/ubicaciones
  - http://localhost:8080/api/v1/productos/ubicaciones/lotes
  - http://localhost:8080/api/v1/proveedores
  - http://localhost:8080/api/v1/proveedores/1
  - http://localhost:8080/api/v1/ubicaciones
- El servicio `frontend` (ReactJs) esta ejecutando en la ruta: http://localhost:9090. Es el website de la aplicación WMS-Demo.

## Testing

El proyecto backend cuenta con dos Unit Testing.
Para realizar las pruebas se debe ir a la carpeta `wms-demo/backend-sb` y ejecutar el comando:
```shell
$ ./mvnw clean test
```
El proyecto frontend cuenta con tres Unit Testing.
Para realizar las pruebas se debe ir a la carpeta `wms-demo/frontend` y ejecutar el comando:
```shell
$ npm test
```

## Database

La base de datos esta en Postgresql y contenida en el servicio `db`.
Para ver mas información a cerca de las tablas y datos iniciales se puede explorar la carpeta: `wms-demo/database`


## Desarrollo

### Construido con

Postgres, SpringBoot, ReactJs y tecnología de contenedores Docker.

### Prerequisites

1. Docker
2. Docker compose

## Licensing

State what the license is and how to find the text version of the license.

