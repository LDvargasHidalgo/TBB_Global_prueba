
INSERT INTO courses ( course_name, course_description, credit_hours)
VALUES 
('Introducción a la Programación', 'Curso introductorio a la programación en diversos lenguajes', 4),
( 'Desarrollo Web Full Stack', 'Curso completo de desarrollo web, frontend y backend', 6),
( 'Desarrollo de Aplicaciones Móviles', 'Curso enfocado en el desarrollo de aplicaciones para dispositivos móviles', 5),
( 'Inteligencia Artificial y Machine Learning', 'Curso avanzado sobre inteligencia artificial y machine learning', 6),
('Ciberseguridad', 'Curso sobre técnicas y herramientas para la ciberseguridad', 5);


INSERT INTO students (student_name, student_email, enrollment_status)
VALUES 
('Daniela Vargas', 'Dany@gmail.com', 'Activo'),
('Leonel Messi', 'Leor@gmail.com', 'Activo'),
('Mariana Beltran', 'Mary@gmail.com', 'Inactivo'),
('Daniel Vargas', 'daniel@gmail.com', 'Activo'),
('Rafael Diaz', 'rafa@gmail.com', 'Inactivo'),
('Mateo Rodríguez', 'mateo@gmail..com', 'Activo'),
('Isabella Gómez', 'isabella@Yahoo.com', 'Activo'),
('Lucas Fernández', 'lucas@gmail..com', 'Activo'),
('Valentina Ruiz', 'valentina@gmail..com', 'Inactivo'),
('Adrián Díaz', 'adrian@gmail..com', 'Activo');


INSERT INTO professors (professor_name, professor_email, course_id)
VALUES 
('Alejandra Sánchez', 'alejandra@gmail.com', 1),
('Javier García', 'javi@gmail.com', 2),
('Eva Martínez', 'evita@gmail.com', 3),
('Tere Hidalgo', 'tere4@gmail.com', 4),
('Diana Gutierrez', 'dvdayan@yahoo.es', 5);


INSERT INTO enrollments (student_id, course_id)
VALUES 
(1, 1),
(2, 2), 
(3, 1), 
(4, 3),
(5, 2), 
(6, 4), 
(7, 3), 
(8, 5), 
(9, 4),
(10, 1), 
(1, 3), 
(2, 1), 
(3, 4), 
(4, 2),
(5, 5);

/*Consultar el nombre del estudiante y el curso en el que esta inscrito */
SELECT s.student_name, c.course_name
FROM students s
INNER JOIN enrollments e ON s.student_id = e.student_id
INNER JOIN courses c ON e.course_id = c.course_id;


/*cantidad de estudiantes activos en cada curso */
SELECT c.course_name, COUNT(s.student_id) AS active_students_count
FROM courses c
JOIN enrollments e ON c.course_id = e.course_id
JOIN students s ON e.student_id = s.student_id
WHERE s.enrollment_status = 'Activo'
GROUP BY c.course_name;

/*Nobres de todos los estudiantes y todos los profesores*/
SELECT student_name FROM students
UNION
SELECT professor_name FROM professors;


/*Cantidad de estudiantes activos e inactivos*/
SELECT
    SUM(CASE WHEN enrollment_status = 'Activo' THEN 1 ELSE 0 END) AS active_students,
    SUM(CASE WHEN enrollment_status = 'Inactivo' THEN 1 ELSE 0 END) AS inactive_students
FROM students;


/*Descripcion para los cursos según sus creditos*/
SELECT
    course_name,
    credit_hours,
    CASE
        WHEN credit_hours >= 5 THEN 'Curso extenso'
        WHEN credit_hours >= 3 THEN 'Curso intermedio'
        ELSE 'Curso corto'
    END AS course_description
FROM courses;



