CREATE DATABASE producer;

USE producer;

CREATE TABLE movie (
    id INT AUTO_INCREMENT,
    name VARCHAR(255),
    genre VARCHAR(255),
    year VARCHAR(255),
    PRIMARY KEY(id)
);

INSERT INTO movie(id, name, genre, year) VALUES (1, 'My Movie', 'Action', '2019');
