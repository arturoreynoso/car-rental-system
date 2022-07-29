DROP TYPE  IF EXISTS brand CASCADE;
DROP TYPE IF EXISTS carType CASCADE;
DROP TYPE IF EXISTS color CASCADE;
DROP TYPE IF EXISTS reservationStatus CASCADE;

DROP TABLE IF EXISTS car CASCADE;
DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS reservation CASCADE;

CREATE TYPE brand AS ENUM('BMW', 'FORD', 'HONDA', 'MAZDA', 'VOLKSWAGEN');
CREATE TYPE carType AS ENUM('MINICOMPACT', 'SUBCOMPACT', 'COMPACT',
                            'MID_SIZE', 'LARGE', 'TWO_SEATER', 'MINIVAN',
                            'SMALL_SUV', 'STANDARD_SUV');
CREATE TYPE color AS ENUM('WHITE', 'BLACK', 'GRAY', 'SILVER', 'RED', 'BLUE');
CREATE TYPE reservationStatus AS ENUM('OPEN','PAST_DUE','COMPLETE');

CREATE TABLE car (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    typeCar carType,
    modelYear INTEGER NOT NULL,
    brandCar brand,
    colorCar color,
    seatingCapacity INTEGER NOT NULL,
    plateNumber VARCHAR(50),
    rate INTEGER NOT NULL);

CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    phoneNumber varchar(20) NOT NULL,
    username VARCHAR(50) NOT NULL);

CREATE TABLE reservation (
    id SERIAL PRIMARY KEY,
    hireDate TIMESTAMP NOT NULL,
    returnDate TIMESTAMP NOT NULL,
    carId INTEGER NOT NULL,
    customerId INTEGER NOT NULL,
    rate INTEGER NOT NULL,
    status reservationStatus);