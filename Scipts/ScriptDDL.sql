create database academicTB_Global;
use  academicTB_Global;


CREATE TABLE courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(50) UNIQUE NOT NULL,
    course_description TEXT,   
    credit_hours INT
);


CREATE TABLE students (
    student_id INT PRIMARY KEY  AUTO_INCREMENT,
    student_name VARCHAR(25) NOT NULL,
    student_email VARCHAR(25) unique,
    enrollment_status VARCHAR(10) DEFAULT 'Activo', 
    CONSTRAINT chk_enrollment_status CHECK (enrollment_status IN ('Activo', 'Inactivo'))
);

-- Tabla de Unión students-courses (Muchos a Muchos)
CREATE TABLE enrollments (
    enrollment_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);


CREATE TABLE professors (
    professor_id INT PRIMARY KEY AUTO_INCREMENT,
    professor_name VARCHAR(255) NOT NULL,
    professor_email VARCHAR(25) UNIQUE NOT NULL,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

