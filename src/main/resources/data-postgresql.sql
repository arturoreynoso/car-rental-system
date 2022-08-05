INSERT INTO car(name, typecar, modelyear, brandcar, colorcar, seatingcapacity, platenumber, rate)
VALUES ('Mazda2', 'MINICOMPACT', 2013, 'MAZDA', 'WHITE',5,'BC18351', 40),
       ('Focus',  'COMPACT', 2017, 'FORD', 'BLACK', 5,'RT67435', 50),
       ('Civic', 'COMPACT', 2013, 'HONDA', 'GRAY',5,'YU57359', 58),
       ('Jetta', 'COMPACT', 2009, 'VOLKSWAGEN', 'RED',5,'PF82349', 20),
       ('iX3', 'STANDARD_SUV', 2018, 'BMW', 'BLUE',7,'JK63482', 70);

INSERT INTO customer(name, lastname, phonenumber, username)
VALUES ('Andrea', 'Aceves', '5545672389', 'andrea'),
       ('Benjamin', 'Hidalgo', '5678912435', 'benjamin'),
       ('Gabriel', 'Santiago', '5508963478', 'gabriel'),
       ('Pedro', 'Acosta', '2348876234', 'pedro'),
       ('Galilea', 'Medina', '1234567891', 'galilea');

INSERT INTO reservation(hiredate, returndate, carid, customerid, rate, status)
VALUES ('2022-08-08', '2022-08-26', 1, 1, 40, 'OPEN'),
       ('2022-08-08', '2022-08-15', 2, 2, 30, 'OPEN'),
       ('2022-08-07', '2022-08-15', 3,3,20,'OPEN');