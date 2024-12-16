SET NAMES utf8;
SET time_zone = '+02:00';
SET sql_mode = '';
DROP DATABASE IF EXISTS `gestion-alimentos`;
CREATE DATABASE `gestion-alimentos` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `gestion-alimentos`;

-- Crear tabla Alimentos
CREATE TABLE alimento (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           nombre VARCHAR(255) NOT NULL,
                           tipo VARCHAR(50) NOT NULL,  -- Puede ser 'perecedero' o 'no perecedero'
                           estado VARCHAR(50) NOT NULL,  -- Puede ser 'abierto' o 'cerrado'
                           fecha_caducidad DATE NOT NULL
);

-- Crear tabla Ubicaciones
CREATE TABLE ubicacion (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             descripcion VARCHAR(255) NOT NULL,  -- Ejemplo: "balda superior en la alacena"
                             tipo_ubicacion VARCHAR(50) NOT NULL,  -- Ejemplo: 'alacena', 'nevera', 'congelador'
                             capacidad INT NOT NULL  -- Capacidad máxima de productos en la ubicación
);

-- Crear tabla Existencias
CREATE TABLE existencia (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             alimento_id INT,
                             ubicacion_id INT,
                             cantidad INT NOT NULL,
                             fecha_entrada DATE NOT NULL,
                             FOREIGN KEY (alimento_id) REFERENCES alimento(id),
                             FOREIGN KEY (ubicacion_id) REFERENCES ubicacion(id)
);
