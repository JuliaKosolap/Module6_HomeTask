INSERT INTO worker (name, birthday, level, salary)
VALUES
('Ivan', '1980-06-23',  'Junior', 1000),
('Karl', '1901-01-01', 'Senior', 50000),
('John', '1985-01-10', 'Trainee', 100),
('Shane', '1965-08-31', 'Middle', 2500),
('Lena', '1993-12-10', 'Trainee', 895),
('Alex', '1981-07-22', 'Senior', 7000),
('Kate', '1978-05-09', 'Middle', 3255),
('Nik', '1990-11-11', 'Junior', 3100),
('Anna', '1950-10-04', 'Senior', 9500),
('Andrew', '1985-09-10', 'Junior', 2476);


INSERT INTO client (name)
VALUES
('Luck Besson'),
('Jennifer Lopez'),
('Kate Blanchett'),
('Tom Hanks'),
('Jorge Martin');

INSERT INTO project (id, client_id, start_date, finish_date)
VALUES
(1, 5, '2018-01-01',  '2018-02-01'),
(2, 3, '2000-07-01', '2001-03-01'),
(3, 3, '2020-01-10', '2020-04-10'),
(4, 1, '2005-08-31', '2005-11-30'),
(5, 4, '2007-12-15', '2008-06-15'),
(6, 3, '2012-07-22', '2020-10-25'),
(7, 2, '1998-05-09', '1998-10-09'),
(8, 2, '2019-11-11', '2022-12-31'),
(9, 2, '2022-01-10', '2023-01-10'),
(10, 5, '2017-12-01', '2018-02-01');

INSERT INTO project_worker (project_id, worker_id)
VALUES
(1, 1),
(1, 2),
(1, 8),
(2, 10),
(3, 2),
(3, 7),
(3, 9),
(4, 5),
(5, 1),
(6, 2),
(6, 4),
(6, 6),
(7, 8),
(7, 10),
(8, 8),
(8, 2),
(8, 5),
(8, 9),
(9, 6),
(9, 1),
(10, 4),
(10, 2);