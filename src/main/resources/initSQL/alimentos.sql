-- Alimentos con fecha de caducidad dentro de 7 días o menos
INSERT INTO alimento (nombre, tipo, estado, fecha_caducidad)
VALUES
    ('Leche entera', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 3 DAY),
    ('Pan de molde', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 2 DAY),
    ('Yogur natural', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 5 DAY),
    ('Tomates', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 4 DAY),
    ('Pechuga de pollo', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 1 DAY),
    ('Jamon York', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 3 DAY),
    ('Lechuga', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 2 DAY),
    ('Queso fresco', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 7 DAY),
    ('Pescado fresco', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 1 DAY),
    ('Huevos', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 6 DAY),
    ('Manzanas', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 3 DAY),
    ('Pepinos', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 4 DAY),
    ('Fresas', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 2 DAY),
    ('Leche condensada', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 7 DAY),
    ('Carne de cerdo', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 1 DAY),
    ('Papas', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 5 DAY),
    ('Naranjas', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 3 DAY),
    ('Bacalao fresco', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 2 DAY),
    ('Alitas de pollo', 'Perecedero', 'Cerrado', CURDATE() + INTERVAL 6 DAY);

-- Alimentos con fecha de caducidad más lejana (más de 7 días)
INSERT INTO alimento (nombre, tipo, estado, fecha_caducidad)
VALUES
    ('Arroz', 'No perecedero', 'Cerrado', CURDATE() + INTERVAL 30 DAY),
    ('Pasta', 'No perecedero', 'Cerrado', CURDATE() + INTERVAL 60 DAY),
    ('Harina', 'No perecedero', 'Cerrado', CURDATE() + INTERVAL 45 DAY),
    ('Conserva de atún', 'No perecedero', 'Cerrado', CURDATE() + INTERVAL 90 DAY),
    ('Conserva de tomate', 'No perecedero', 'Cerrado', CURDATE() + INTERVAL 180 DAY),
    ('Sal', 'No perecedero', 'Cerrado', CURDATE() + INTERVAL 365 DAY),
    ('Azúcar', 'No perecedero', 'Cerrado', CURDATE() + INTERVAL 180 DAY),
    ('Lentejas', 'No perecedero', 'Cerrado', CURDATE() + INTERVAL 120 DAY),
    ('Cereal', 'No perecedero', 'Cerrado', CURDATE() + INTERVAL 90 DAY),
    ('Aceite de oliva', 'No perecedero', 'Cerrado', CURDATE() + INTERVAL 365 DAY);
