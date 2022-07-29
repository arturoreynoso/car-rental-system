INSERT INTO car(name, typeCar, modelYear, brandCar, colorCar, seatingCapacity, plateNumber, rate)
VALUES ('Mazda2', 'MINICOMPACT', 2013, 'MAZDA', 'WHITE',5,'BC18351', 40),
       ('Focus',  'COMPACT', 2017, 'FORD', 'BLACK', 5,'RT67435', 50),
       ('Civic', 'COMPACT', 2013, 'HONDA', 'GRAY',5,'YU57359', 58),
       ('Jetta', 'COMPACT', 2009, 'VOLKSWAGEN', 'RED',5,'PF82349', 20),
       ('iX3', 'STANDARD_SUV', 2018, 'BMW', 'BLUE',7,'JK63482', 70);

INSERT INTO customer(name, lastName, phoneNumber, username)
VALUES ('Andrea', 'Aceves', '5545672389', 'andrea'),
       ('Benjamin', 'Hidalgo', '5678912435', 'benjamin'),
       ('Gabriel', 'Santiago', '5508963478', 'gabriel');

INSERT INTO reservation(hireDate, returnDate, carId, customerId, rate, status)
VALUES ('2022-01-08 04:00:00', '2022-06-08 04:00:00', 2, 1, 40, 'OPEN'),
       ('2022-01-08 04:00:00', '2022-06-08 04:00:00', 2, 1, 40, 'OPEN');