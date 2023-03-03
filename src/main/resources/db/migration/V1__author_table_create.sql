CREATE TABLE author
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL
);

INSERT INTO author (name, surname)
values ('Angel', 'Miralles');
INSERT INTO author (name, surname)
values ('Antonio', 'Miralles');
INSERT INTO author (name, surname)
values ('Juan', 'Miralles');
