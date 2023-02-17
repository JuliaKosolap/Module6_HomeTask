CREATE TABLE worker
(id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR NOT NULL CHECK(CHAR_LENGTH(name)<1000 AND CHAR_LENGTH(name)>2),
birthday DATE CHECK (birthday>'1900-01-01'),
level VARCHAR NOT NULL CHECK (level='Trainee' OR level ='Junior' OR level='Middle' OR level='Senior'),
salary INT CHECK (salary>=100 AND salary<=100000));

CREATE TABLE client
(id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR NOT NULL CHECK(CHAR_LENGTH(name)<1000 AND CHAR_LENGTH(name)>2));

CREATE TABLE project
(id INT PRIMARY KEY AUTO_INCREMENT,
client_id INT,
start_date DATE,
finish_date DATE);

CREATE TABLE project_worker
(project_id INT,
FOREIGN KEY (project_id) REFERENCES project(id),
worker_id INT,
FOREIGN KEY (worker_id) REFERENCES worker(id),
PRIMARY KEY(project_id, worker_id));