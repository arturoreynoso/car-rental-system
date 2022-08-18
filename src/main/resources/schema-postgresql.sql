DROP TYPE  IF EXISTS brand CASCADE;
DROP TYPE IF EXISTS carType CASCADE;
DROP TYPE IF EXISTS color CASCADE;
DROP TYPE IF EXISTS reservationStatus CASCADE;

DROP TABLE IF EXISTS car CASCADE;
DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS employee CASCADE;
DROP TABLE IF EXISTS reservation CASCADE;

DROP SEQUENCE IF EXISTS hibernate_sequence;

--CREATE TYPE brand AS ENUM('BMW', 'FORD', 'HONDA', 'MAZDA', 'VOLKSWAGEN');
--CREATE TYPE carType AS ENUM('MINICOMPACT', 'SUBCOMPACT', 'COMPACT',
      --                      'MID_SIZE', 'LARGE', 'TWO_SEATER', 'MINIVAN',
            --                'SMALL_SUV', 'STANDARD_SUV');
--CREATE TYPE color AS ENUM('WHITE', 'BLACK', 'GRAY', 'SILVER', 'RED', 'BLUE');
--CREATE TYPE reservationStatus AS ENUM('OPEN','PAST_DUE','COMPLETE');

--CREATE TABLE hibernate_sequences (
  --  sequence_name VARCHAR(255) NOT NULL,
    --next_val int8,
    --primary key ( sequence_name ) );

CREATE TABLE car (
    id SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    typecar VARCHAR NOT NULL,
    modelyear INTEGER NOT NULL,
    brandcar VARCHAR NOT NULL,
    colorcar VARCHAR NOT NULL,
    seatingcapacity INTEGER NOT NULL,
    platenumber VARCHAR(250),
    rate INTEGER NOT NULL);

CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    lastname VARCHAR(250) NOT NULL,
    phonenumber varchar(250) NOT NULL,
    username VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    role VARCHAR(250) NOT NULL,
    password VARCHAR(250));

CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    lastname VARCHAR(250) NOT NULL,
    phonenumber varchar(20) NOT NULL,
    username VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    role VARCHAR(250) NOT NULL,
    password VARCHAR(250));

CREATE TABLE reservation (
    id SERIAL PRIMARY KEY,
    hiredate DATE NOT NULL,
    returndate DATE NOT NULL,
    carid INTEGER NOT NULL REFERENCES car(id) ON DELETE CASCADE,
    customerid INTEGER NOT NULL REFERENCES customer(id) ON DELETE CASCADE,
    status VARCHAR NOT NULL);