CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE team
(
    id          SERIAL NOT NULL,
    name        VARCHAR(255),
    nationality VARCHAR(255),
    image_path  VARCHAR(255),
    CONSTRAINT pk_team PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE circuit
(
    id         SERIAL NOT NULL,
    name       VARCHAR(255),
    country    VARCHAR(255),
    length     VARCHAR(255),
    lap_record VARCHAR(255),
    image_path VARCHAR(255),
    CONSTRAINT pk_circuit PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;


CREATE TABLE event
(
    id        SERIAL NOT NULL,
    race_name VARCHAR(255),
    country   VARCHAR(255),
    date      date,
    CONSTRAINT pk_result PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;


CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE driver
(
    id            SERIAL NOT NULL,
    name          VARCHAR(255),
    points        INTEGER,
    data_of_birth date,
    racing_number VARCHAR(255),
    image_path    VARCHAR(255),
    team_id       INTEGER,
    circuit_id    INTEGER,
    CONSTRAINT pk_driver PRIMARY KEY (id)
);

ALTER TABLE driver
    ADD CONSTRAINT FK_DRIVER_ON_CIRCUIT FOREIGN KEY (circuit_id) REFERENCES circuit (id);

ALTER TABLE driver
    ADD CONSTRAINT FK_DRIVER_ON_TEAM FOREIGN KEY (team_id) REFERENCES team (id);

CREATE TABLE users
(
    id       SERIAL NOT NULL,
    username VARCHAR(255),
    role     VARCHAR(255),
    password VARCHAR(255),
    CONSTRAINT pk_users PRIMARY KEY (id)
);