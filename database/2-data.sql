INSERT INTO proveedor
  (codigo, nombre, direccion, email, telefono)
VALUES
  ('LCHI', 'Laboratorio Chile', 'Avenida Marathon #1315, Ñuñoa - Santiago.', 'contacto@laboratoriochile.cl', '56 22 365 5000'),
  ('LMAV', 'Laborarotio Maver', 'Las Encinas 1777, Valle Grande - Lampa.', 'contacto@maver.cl', '56 22 487 4100'),
  ('LPAS', 'Laboratorio Pasteur', 'Román Diaz 1271, Providencia - Santiago.', 'contacto@lpasteur.cl', '56 22 438 3100');

INSERT INTO producto
  (codigo, descripcion, tipo, clase, nivel_rotacion, aplica_impuesto, id_proveedor)
VALUES
  ('ACIC20', 'Aciclovir 200 mg', 'Comprimidos', 'Antiviral', 'A', TRUE, 1),
  ('CLON05', 'Clonazepam 0,5 mg', 'Comprimidos', 'Ansiolítico', 'B', TRUE, 1),
  ('HIED35', 'Hiedrix 35 mg / 5 mL', 'Jarabes', 'Expectorante', 'C', FALSE, 1),
  ('TAPS40', 'Tapsin 400 mg', 'Comprimidos', 'Descongestivos', 'A', TRUE, 2),
  ('ARMO10', 'Armonyl Valeriana 100 mg', 'Comprimidos', 'Tranquilizante natural', 'B', TRUE, 2),
  ('NENE10', 'Neneglóss 100 g', 'Pomadas', 'Hipoalergénico', 'C', FALSE, 2),
  ('RUPA10', 'Rupatadina 10 mg', 'Comprimidos', 'Antihistamínico', 'A', TRUE, 3),
  ('METF50', 'Metformina clorhidrato 500 mg', 'Comprimidos', 'Antidiabético', 'B', TRUE, 3),
  ('IVER06', 'Ivermectina 6 mg', 'Gotas', 'Antiparasitario', 'C', FALSE, 3);

INSERT INTO producto_detalle
  (id_producto, precio, descuento, costo, peso, volumen, cantidad, aplica_descuento)
VALUES
  (1, 2890, 890, 1000, 10, 0, 0, FALSE),
  (2, 4120, 120, 3000, 15, 0, 0, FALSE),
  (3, 3959, 959, 2500, 20, 0, 0, FALSE),
  (4, 1319, 319, 500, 25, 0, 0, FALSE),
  (5, 4990, 2400, 2000, 30, 0, 0, TRUE),
  (6, 2990, 990, 1500, 35, 0, 0, FALSE),
  (7, 15540, 2540, 10000, 40, 0, 0, FALSE),
  (8, 6790, 2790, 3500, 45, 0, 0, TRUE),
  (9, 9490, 1490, 6000, 50, 0, 0, FALSE);

INSERT INTO producto_lote
  (id_producto, serie, fecha_expiracion, codigo_barra, precio, costo, cantidad, cantidad_bloqueada, original, innerpack, largo, ancho, alto, peso)
VALUES
  (1, '20C085', '03/2022', '7800068014703', 2890, 1000, 0, 0, 0, 0, 0, 0, 0, 0),
  (1, '20C086', '03/2022', '7800068014703', 2890, 1000, 0, 0, 0, 0, 0, 0, 0, 0),
  (1, '20C087', '05/2023', '7800068014703', 2890, 1000, 0, 0, 0, 0, 0, 0, 0, 0),
  (2, 'L62', '01/2023', '7795373014046', 4120, 3000, 0, 0, 0, 0, 0, 0, 0, 0),
  (2, 'L63', '06/2023', '7795373014046', 4120, 3000, 0, 0, 0, 0, 0, 0, 0, 0),
  (2, 'L64', '12/2023', '7795373014046', 4120, 3000, 0, 0, 0, 0, 0, 0, 0, 0),
  (3, 'C27171', '05/2023', '7800058535379', 3959, 2500, 0, 0, 0, 0, 0, 0, 0, 0),
  (3, 'C27172', '05/2024', '7800058535379', 3959, 2500, 0, 0, 0, 0, 0, 0, 0, 0),
  (3, 'C27173', '05/2025', '7800058535379', 3959, 2500, 0, 0, 0, 0, 0, 0, 0, 0),
  (4, '21H171', '07/2023', '7800004303434', 1319, 500, 0, 0, 0, 0, 0, 0, 0, 0),
  (4, '21H171', '12/2023', '7800004303434', 1319, 500, 0, 0, 0, 0, 0, 0, 0, 0),
  (4, '21H171', '07/2024', '7800004303434', 1319, 500, 0, 0, 0, 0, 0, 0, 0, 0),
  (5, 'DECW', '05/2024', '7800007142061', 4990, 2000, 0, 0, 0, 0, 0, 0, 0, 0),
  (5, 'AACQ', '04/2025', '7800007142061', 4990, 2000, 0, 0, 0, 0, 0, 0, 0, 0),
  (5, 'FACB', '11/2026', '7800007142061', 4990, 2000, 0, 0, 0, 0, 0, 0, 0, 0),
  (6, '21G077', '07/2023', '7800068030321', 2990, 1500, 0, 0, 0, 0, 0, 0, 0, 0),
  (6, '21G078', '07/2023', '7800068030321', 2990, 1500, 0, 0, 0, 0, 0, 0, 0, 0),
  (6, '21G077', '12/2023', '7800068030321', 2990, 1500, 0, 0, 0, 0, 0, 0, 0, 0),
  (7, '005035', '05/2023', '7800059003211', 15540, 10000, 0, 0, 0, 0, 0, 0, 0, 0),
  (7, '005035', '06/2023', '7800059003211', 15540, 10000, 0, 0, 0, 0, 0, 0, 0, 0),
  (7, '005035', '07/2023', '7800059003211', 15540, 10000, 0, 0, 0, 0, 0, 0, 0, 0),
  (8, 'CYZE', '10/2022', '7800007791382', 6790, 3500, 0, 0, 0, 0, 0, 0, 0, 0),
  (8, 'DTUC', '07/2023', '7800007791382', 6790, 3500, 0, 0, 0, 0, 0, 0, 0, 0),
  (8, 'CLCL', '12/2023', '7800007791382', 6790, 3500, 0, 0, 0, 0, 0, 0, 0, 0),
  (9, 'D200371', '04/2023', '7800063120041', 9490, 6000, 0, 0, 0, 0, 0, 0, 0, 0),
  (9, 'D200372', '06/2023', '7800063120041', 9490, 6000, 0, 0, 0, 0, 0, 0, 0, 0),
  (9, 'D200374', '08/2023', '7800063120041', 9490, 6000, 0, 0, 0, 0, 0, 0, 0, 0);

INSERT INTO ubicacion_tipo
  (codigo, descripcion, clasificacion)
VALUES
  ('PLR', 'Pallet Rack', 'Fija'),
  ('PAL', 'Pallete', 'Movil'),
  ('RAR', 'Reception Area', 'Fija'),
  ('FLR', 'Flow Rack', 'Fija'),
  ('PCK', 'Picking', 'Fija');

INSERT INTO ubicacion
  (codigo, nivel, segmento, codigo_tipo)
VALUES
  ('001', 'A', '01', 'PLR'),
  ('001', 'A', '02', 'PLR'),
  ('001', 'A', '03', 'PLR'),
  ('001', 'A', '04', 'PLR'),
  ('001', 'B', '01', 'PLR'),
  ('001', 'B', '02', 'PLR'),
  ('001', 'B', '03', 'PLR'),
  ('001', 'B', '04', 'PLR'),
  ('001', 'C', '01', 'PLR'),
  ('001', 'C', '02', 'PLR'),
  ('001', 'C', '03', 'PLR'),
  ('001', 'C', '04', 'PLR'),
  ('002', 'A', '01', 'PLR'),
  ('002', 'A', '02', 'PLR'),
  ('002', 'A', '03', 'PLR'),
  ('002', 'A', '04', 'PLR'),
  ('002', 'B', '01', 'PLR'),
  ('002', 'B', '02', 'PLR'),
  ('002', 'B', '03', 'PLR'),
  ('002', 'B', '04', 'PLR'),
  ('002', 'C', '01', 'PLR'),
  ('002', 'C', '02', 'PLR'),
  ('002', 'C', '03', 'PLR'),
  ('002', 'C', '04', 'PLR'),
  ('003', 'A', '01', 'PLR'),
  ('003', 'A', '02', 'PLR'),
  ('003', 'A', '03', 'PLR'),
  ('003', 'A', '04', 'PLR'),
  ('003', 'B', '01', 'PLR'),
  ('003', 'B', '02', 'PLR'),
  ('003', 'B', '03', 'PLR'),
  ('003', 'B', '04', 'PLR'),
  ('003', 'C', '01', 'PLR'),
  ('003', 'C', '02', 'PLR'),
  ('003', 'C', '03', 'PLR'),
  ('003', 'C', '04', 'PLR'),
  ('001', 'A', '01', 'FLR'),
  ('001', 'A', '02', 'FLR'),
  ('001', 'A', '03', 'FLR'),
  ('001', 'A', '04', 'FLR'),
  ('001', 'A', '05', 'FLR'),
  ('001', 'B', '01', 'FLR'),
  ('001', 'B', '02', 'FLR'),
  ('001', 'B', '03', 'FLR'),
  ('001', 'B', '04', 'FLR'),
  ('001', 'B', '05', 'FLR'),
  ('002', 'A', '01', 'FLR'),
  ('002', 'A', '02', 'FLR'),
  ('002', 'A', '03', 'FLR'),
  ('002', 'A', '04', 'FLR'),
  ('002', 'A', '05', 'FLR'),
  ('002', 'B', '01', 'FLR'),
  ('002', 'B', '02', 'FLR'),
  ('002', 'B', '03', 'FLR'),
  ('002', 'B', '04', 'FLR'),
  ('002', 'B', '05', 'FLR'),
  ('001', '0', '01', 'PCK'),
  ('001', '0', '02', 'PCK'),
  ('001', '0', '03', 'PCK'),
  ('001', '0', '04', 'PCK'),
  ('001', '0', '05', 'PCK'),
  ('001', '0', '06', 'PCK'),
  ('001', '0', '07', 'PCK'),
  ('001', '0', '08', 'PCK'),
  ('001', '0', '09', 'PCK'),
  ('001', '0', '01', 'RAR'),
  ('002', '0', '01', 'RAR'),
  ('003', '0', '01', 'RAR'),
  ('004', '0', '01', 'RAR'),
  ('001', '0', '01', 'PAL'),
  ('002', '0', '01', 'PAL'),
  ('003', '0', '01', 'PAL'),
  ('004', '0', '01', 'PAL'),
  ('005', '0', '01', 'PAL'),
  ('006', '0', '01', 'PAL'),
  ('007', '0', '01', 'PAL'),
  ('008', '0', '01', 'PAL'),
  ('009', '0', '01', 'PAL'),
  ('010', '0', '01', 'PAL'),
  ('011', '0', '01', 'PAL'),
  ('012', '0', '01', 'PAL'),
  ('013', '0', '01', 'PAL'),
  ('014', '0', '01', 'PAL'),
  ('015', '0', '01', 'PAL'),
  ('016', '0', '01', 'PAL'),
  ('017', '0', '01', 'PAL'),
  ('018', '0', '01', 'PAL'),
  ('019', '0', '01', 'PAL'),
  ('020', '0', '01', 'PAL'),
  ('021', '0', '01', 'PAL'),
  ('022', '0', '01', 'PAL'),
  ('023', '0', '01', 'PAL'),
  ('024', '0', '01', 'PAL'),
  ('025', '0', '01', 'PAL'),
  ('026', '0', '01', 'PAL'),
  ('027', '0', '01', 'PAL'),
  ('028', '0', '01', 'PAL'),
  ('029', '0', '01', 'PAL'),
  ('030', '0', '01', 'PAL'),
  ('031', '0', '01', 'PAL'),
  ('032', '0', '01', 'PAL'),
  ('033', '0', '01', 'PAL'),
  ('034', '0', '01', 'PAL'),
  ('035', '0', '01', 'PAL'),
  ('036', '0', '01', 'PAL'),
  ('037', '0', '01', 'PAL'),
  ('038', '0', '01', 'PAL'),
  ('039', '0', '01', 'PAL'),
  ('040', '0', '01', 'PAL'),
  ('041', '0', '01', 'PAL'),
  ('042', '0', '01', 'PAL'),
  ('043', '0', '01', 'PAL'),
  ('044', '0', '01', 'PAL'),
  ('045', '0', '01', 'PAL'),
  ('046', '0', '01', 'PAL'),
  ('047', '0', '01', 'PAL'),
  ('048', '0', '01', 'PAL'),
  ('049', '0', '01', 'PAL'),
  ('050', '0', '01', 'PAL'),
  ('051', '0', '01', 'PAL'),
  ('052', '0', '01', 'PAL'),
  ('053', '0', '01', 'PAL'),
  ('054', '0', '01', 'PAL'),
  ('055', '0', '01', 'PAL'),
  ('056', '0', '01', 'PAL'),
  ('057', '0', '01', 'PAL'),
  ('058', '0', '01', 'PAL'),
  ('059', '0', '01', 'PAL'),
  ('060', '0', '01', 'PAL'),
  ('061', '0', '01', 'PAL'),
  ('062', '0', '01', 'PAL'),
  ('063', '0', '01', 'PAL'),
  ('064', '0', '01', 'PAL'),
  ('065', '0', '01', 'PAL'),
  ('066', '0', '01', 'PAL'),
  ('067', '0', '01', 'PAL'),
  ('068', '0', '01', 'PAL'),
  ('069', '0', '01', 'PAL'),
  ('070', '0', '01', 'PAL'),
  ('071', '0', '01', 'PAL'),
  ('072', '0', '01', 'PAL'),
  ('073', '0', '01', 'PAL'),
  ('074', '0', '01', 'PAL'),
  ('075', '0', '01', 'PAL'),
  ('076', '0', '01', 'PAL'),
  ('077', '0', '01', 'PAL'),
  ('078', '0', '01', 'PAL'),
  ('079', '0', '01', 'PAL'),
  ('080', '0', '01', 'PAL'),
  ('081', '0', '01', 'PAL'),
  ('082', '0', '01', 'PAL'),
  ('083', '0', '01', 'PAL'),
  ('084', '0', '01', 'PAL'),
  ('085', '0', '01', 'PAL'),
  ('086', '0', '01', 'PAL'),
  ('087', '0', '01', 'PAL'),
  ('088', '0', '01', 'PAL'),
  ('089', '0', '01', 'PAL'),
  ('090', '0', '01', 'PAL'),
  ('091', '0', '01', 'PAL'),
  ('092', '0', '01', 'PAL'),
  ('093', '0', '01', 'PAL'),
  ('094', '0', '01', 'PAL'),
  ('095', '0', '01', 'PAL'),
  ('096', '0', '01', 'PAL'),
  ('097', '0', '01', 'PAL'),
  ('098', '0', '01', 'PAL'),
  ('099', '0', '01', 'PAL'),
  ('100', '0', '01', 'PAL');

INSERT INTO producto_ubicacion_almacen
  (id_producto, id_ubicacion, clasificacion, cantidad_maxima, cantidad_minima, orden_recorrido)
VALUES
  (1, 57, 'Despacho', 20, 5, 1),
  (1, 37, 'Despacho', 40, 10, 2),
  (1, 1, 'Primario', 150, 50, 3),
  (1, 5, 'Primario', 2000, 2000, 4),
  (1, 9, 'Secundario', 3000, 3000, 5),
  (2, 58, 'Despacho', 20, 5, 6),
  (2, 38, 'Despacho', 40, 10, 7),
  (2, 2, 'Primario', 150, 50, 8),
  (2, 6, 'Primario', 2000, 2000, 9),
  (2, 10, 'Secundario', 3000, 3000, 10),
  (3, 59, 'Despacho', 20, 5, 11),
  (3, 39, 'Despacho', 40, 10, 12),
  (3, 3, 'Primario', 150, 50, 13),
  (3, 7, 'Primario', 2000, 2000, 14),
  (3, 11, 'Secundario', 3000, 3000, 15),
  (4, 60, 'Despacho', 20, 5, 16),
  (4, 40, 'Despacho', 40, 10, 17),
  (4, 4, 'Primario', 150, 50, 18),
  (4, 8, 'Primario', 2000, 2000, 19),
  (4, 12, 'Secundario', 3000, 3000, 20),
  (5, 61, 'Despacho', 20, 5, 21),
  (5, 41, 'Despacho', 40, 10, 22),
  (5, 13, 'Primario', 150, 50, 23),
  (5, 17, 'Secundario', 2000, 2000, 24),
  (6, 62, 'Despacho', 20, 5, 25),
  (6, 47, 'Despacho', 40, 10, 26),
  (6, 14, 'Primario', 150, 50, 27),
  (6, 18, 'Secundario', 2000, 2000, 28),
  (7, 63, 'Despacho', 20, 5, 29),
  (7, 48, 'Despacho', 40, 10, 30),
  (7, 15, 'Primario', 150, 50, 31),
  (7, 19, 'Secundario', 2000, 2000, 32),
  (8, 64, 'Despacho', 20, 5, 33),
  (8, 49, 'Despacho', 40, 10, 34),
  (8, 16, 'Primario', 150, 50, 35),
  (8, 20, 'Secundario', 2000, 2000, 36),
  (9, 65, 'Despacho', 20, 5, 37),
  (9, 50, 'Despacho', 40, 10, 38),
  (9, 25, 'Primario', 150, 50, 39),
  (9, 29, 'Secundario', 2000, 2000, 40);
  
INSERT INTO producto_ubicacion_lote
  (id_producto, id_ubicacion, id_lote, cantidad, cantidad_bloqueada)
VALUES
  (1, 57, 1, 2, 0),
  (2, 58, 4, 4, 1),
  (3, 59, 7, 6, 2),
  (4, 60, 10, 8, 3),
  (5, 61, 13, 10, 4),
  (6, 62, 16, 12, 5),
  (7, 63, 19, 14, 6),
  (8, 64, 22, 16, 7),
  (9, 65, 25, 18, 8);
  
