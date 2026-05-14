CREATE DATABASE IF NOT EXISTS casa_rural;
USE casa_rural;

CREATE TABLE IF NOT EXISTS habitaciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(10) NOT NULL UNIQUE,
    tipo VARCHAR(50) NOT NULL,
    capacidad INT NOT NULL,
    precio_noche DECIMAL(10,2) NOT NULL,
    descripcion TEXT
);

CREATE TABLE IF NOT EXISTS clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(150) NOT NULL UNIQUE,
    dni VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS reservas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_entrada DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    numero_personas INT NOT NULL,
    estado VARCHAR(20) NOT NULL DEFAULT 'pendiente',
    observaciones TEXT,
    cliente_id INT NOT NULL,
    habitacion_id INT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id),
    FOREIGN KEY (habitacion_id) REFERENCES habitaciones(id)
);

CREATE TABLE IF NOT EXISTS facturas (
    numero_factura INT AUTO_INCREMENT PRIMARY KEY,
    fecha_emision DATE NOT NULL,
    concepto VARCHAR(255) NOT NULL,
    base_imponible DECIMAL(10,2) NOT NULL,
    iva DECIMAL(5,2) NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    reserva_id INT NOT NULL UNIQUE,
    FOREIGN KEY (reserva_id) REFERENCES reservas(id)
);


-- VISTAS

CREATE OR REPLACE VIEW vista_reservas_detalle AS
SELECT
    r.id AS reserva_id,
    c.nombre AS cliente,
    c.email,
    h.numero AS habitacion,
    h.tipo,
    r.fecha_entrada,
    r.fecha_fin,
    r.numero_personas,
    r.estado
FROM reservas r
JOIN clientes c ON r.cliente_id = c.id
JOIN habitaciones h ON r.habitacion_id = h.id;

CREATE OR REPLACE VIEW vista_facturas_detalle AS
SELECT
    f.numero_factura,
    f.fecha_emision,
    f.concepto,
    f.base_imponible,
    f.iva,
    f.total,
    c.nombre AS cliente,
    h.numero AS habitacion,
    r.fecha_entrada,
    r.fecha_fin
FROM facturas f
JOIN reservas r ON f.reserva_id = r.id
JOIN clientes c ON r.cliente_id = c.id
JOIN habitaciones h ON r.habitacion_id = h.id;


-- PROCEDIMIENTOS

DELIMITER $$

DROP PROCEDURE IF EXISTS sp_reservas_por_cliente$$
CREATE PROCEDURE sp_reservas_por_cliente(IN p_cliente_id INT)
BEGIN
    SELECT
        r.id,
        r.fecha_entrada,
        r.fecha_fin,
        r.numero_personas,
        r.estado,
        h.numero AS habitacion
    FROM reservas r
    JOIN habitaciones h ON r.habitacion_id = h.id
    WHERE r.cliente_id = p_cliente_id;
END$$

DROP PROCEDURE IF EXISTS sp_habitaciones_disponibles$$
CREATE PROCEDURE sp_habitaciones_disponibles(
    IN p_fecha_entrada DATE,
    IN p_fecha_fin DATE
)
BEGIN
    SELECT *
    FROM habitaciones
    WHERE id NOT IN (
        SELECT habitacion_id
        FROM reservas
        WHERE estado NOT IN ('cancelada')
          AND fecha_entrada < p_fecha_fin
          AND fecha_fin > p_fecha_entrada
    );
END$$

DELIMITER ;
