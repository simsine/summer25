-- Specifying schema
DROP SCHEMA IF EXISTS spring CASCADE;
CREATE SCHEMA spring;
SET search_path TO spring;

-- Creating tables
CREATE TABLE todo_list (
	id SERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE todo (
	id SERIAL PRIMARY KEY,
	list_id INTEGER NOT NULL,
	content TEXT NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT NOW(),
	finished_at TIMESTAMP,
	FOREIGN KEY (list_id) REFERENCES todo_list(id)
);

-- Inserting data
INSERT INTO todo_list(name) VALUES
	('Handleliste')
;

INSERT INTO todo(list_id, content) VALUES
	(1, 'Brød'),
	(1, 'Melk'),
	(1, 'Smør')
;
