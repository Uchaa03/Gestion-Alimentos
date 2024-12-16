-- Existencias para alimentos que caducan en 7 días o menos

-- Relacionamos las existencias con ubicaciones (por ejemplo, 1=Alacena, 2=Nevera, 3=Congelador)
INSERT INTO existencias (alimento_id, ubicacion_id, cantidad, fecha_entrada)
VALUES
    (1, 1, 50, CURDATE()), -- Leche entera, Alacena, 50 unidades
    (2, 1, 30, CURDATE()), -- Pan de molde, Alacena, 30 unidades
    (3, 2, 20, CURDATE()), -- Yogur natural, Nevera, 20 unidades
    (4, 1, 40, CURDATE()), -- Tomates, Alacena, 40 unidades
    (5, 2, 15, CURDATE()), -- Pechuga de pollo, Nevera, 15 unidades
    (6, 2, 25, CURDATE()), -- Jamón York, Nevera, 25 unidades
    (7, 1, 30, CURDATE()), -- Lechuga, Alacena, 30 unidades
    (8, 2, 10, CURDATE()), -- Queso fresco, Nevera, 10 unidades
    (9, 2, 15, CURDATE()), -- Pescado fresco, Nevera, 15 unidades
    (10, 2, 12, CURDATE()), -- Huevos, Nevera, 12 unidades
    (11, 1, 50, CURDATE()), -- Manzanas, Alacena, 50 unidades
    (12, 1, 30, CURDATE()), -- Pepinos, Alacena, 30 unidades
    (13, 2, 20, CURDATE()), -- Fresas, Nevera, 20 unidades
    (14, 2, 25, CURDATE()), -- Leche condensada, Nevera, 25 unidades
    (15, 2, 20, CURDATE()), -- Carne de cerdo, Nevera, 20 unidades
    (16, 1, 40, CURDATE()), -- Papas, Alacena, 40 unidades
    (17, 1, 30, CURDATE()), -- Naranjas, Alacena, 30 unidades
    (18, 2, 12, CURDATE()), -- Bacalao fresco, Nevera, 12 unidades
    (19, 2, 15, CURDATE()), -- Alitas de pollo, Nevera, 15 unidades

-- Existencias para alimentos con fecha de caducidad más lejana (más de 7 días)
    (20, 1, 50, CURDATE()), -- Arroz, Alacena, 50 unidades
    (21, 1, 40, CURDATE()), -- Pasta, Alacena, 40 unidades
    (22, 1, 30, CURDATE()), -- Harina, Alacena, 30 unidades
    (23, 1, 20, CURDATE()), -- Conserva de atún, Alacena, 20 unidades
    (24, 1, 25, CURDATE()), -- Conserva de tomate, Alacena, 25 unidades
    (25, 1, 100, CURDATE()), -- Sal, Alacena, 100 unidades
    (26, 1, 60, CURDATE()), -- Azúcar, Alacena, 60 unidades
    (27, 1, 40, CURDATE()), -- Lentejas, Alacena, 40 unidades
    (28, 1, 20, CURDATE()), -- Cereal, Alacena, 20 unidades
    (29, 1, 30, CURDATE()); -- Aceite de oliva, Alacena, 30 unidades
