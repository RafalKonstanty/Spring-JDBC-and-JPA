--CREATE TABLE IF NOT EXISTS person
--(
--id INTEGER NOT NULL AUTO_INCREMENT,
--name VARCHAR(255) NOT NULL,
--location VARCHAR(255),
--birth_date TIMESTAMP,
--primary key(id)
--);

INSERT INTO person (id, name, location, birth_date) VALUES (1, 'John', 'U.S.', NOW());
INSERT INTO person (id, name, location, birth_date) VALUES (2, 'James', 'U.K.', NOW());
INSERT INTO person (id, name, location, birth_date) VALUES (3, 'Jenny', 'Warsaw', NOW());
