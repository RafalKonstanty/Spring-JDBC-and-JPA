CREATE TABLE IF NOT EXISTS person
(
id INTEGER NOT NULL AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
location VARCHAR(255),
birth_date TIMESTAMP,
primary key(id)
);

INSERT INTO person (name, location, birth_date) VALUES ('John', 'U.S.', NOW());
INSERT INTO person (name, location, birth_date) VALUES ('James', 'U.K.', NOW());
INSERT INTO person (name, location, birth_date) VALUES ('Jenny', 'Warsaw', NOW());
