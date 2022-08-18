INSERT INTO car(name, typecar, modelyear, brandcar, colorcar, seatingcapacity, platenumber, rate)
VALUES ('Mazda2', 'SUBCOMPACT', 2013, 'MAZDA', 'WHITE',5,'BC18351', 40),
       ('Focus',  'COMPACT', 2017, 'FORD', 'BLACK', 5,'RT67435', 50),
       ('Civic', 'COMPACT', 2013, 'HONDA', 'GRAY',5,'YU57359', 58),
       ('Jetta', 'COMPACT', 2009, 'VOLKSWAGEN', 'RED',5,'PF82349', 20),
       ('iX3', 'MID_SIZE', 2018, 'BMW', 'BLUE',7,'JK63482', 70),
       ('Mazda3', 'MID_SIZE', 2018, 'MAZDA', 'BLUE',6,'JK53482', 60),
       ('Ford3', 'COMPACT', 2014, 'FORD', 'BLUE', 6, 'PL16927', 48);

INSERT INTO customer(name, lastname, phonenumber, username, email, role, password)
VALUES ('Andrea', 'Aceves', '5545672389', 'andrea', 'andrea@gmail.com', 'CUSTOMER', 'andrea'),
       ('Benjamin', 'Hidalgo', '5678912435', 'benjamin', 'benjamin@gmail.com', 'CUSTOMER', 'benjamin'),
       ('Gabriel', 'Santiago', '5508963478', 'gabriel', 'gabriel@gmail.com', 'CUSTOMER', 'gabriel'),
       ('Pedro', 'Acosta', '2348876234', 'pedro', 'pedro@gmail.com', 'CUSTOMER', 'pedro'),
       ('Galilea', 'Medina', '1234567891', 'galilea', 'galilea@gmail.com', 'CUSTOMER', 'galilea');

INSERT INTO reservation(hiredate, returndate, carid, customerid, status)
VALUES ('2022-08-08', '2022-08-26', 1, 1, 'OPEN'),
       ('2022-08-08', '2022-08-15', 2, 2, 'OPEN'),
       ('2022-08-07', '2022-08-15', 3,3,'OPEN');