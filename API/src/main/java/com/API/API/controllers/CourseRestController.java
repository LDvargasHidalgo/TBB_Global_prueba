package com.API.API.controllers;

import com.API.API.models.entity.CourseEntity;
import com.API.API.models.services.ICourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CourseRestController {

    @Autowired
    private ICourseService courseService;


    // GET ALL COURSE
    @GetMapping("/courses")
    public ResponseEntity<List<CourseEntity>> getAllCourses() {
        List<CourseEntity> courses = courseService.findAll();
        if (courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    // GET COURSE BY ID
    @GetMapping("/courses/{id}")
    public ResponseEntity<?> show(@PathVariable Integer id) {
        CourseEntity course = null;
        Map<String, Object> response = new HashMap<>();
        try {
            course = courseService.findById(id);
        } catch (DataAccessException e) {
            response.put("message", "Error al realizar la consulta en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().toString()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (course == null) {
            response.put("message", "El curso ID:".concat(id.toString()).concat(" No existe en la base de datos"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CourseEntity>(course, HttpStatus.OK);
    }


    //CREATE NEW COURSE
    @PostMapping("courses")
    public ResponseEntity<?> create(@Valid @RequestBody CourseEntity course, BindingResult result) {
        CourseEntity courseNew = null;
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().
                    stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .toList();
            response.put("error", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            courseNew = courseService.save(course);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al  realizar el insert en la db");
            response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El curso ha sido creado con éxito");
        response.put("curso", courseNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    // UPDATE COURSE BY ID
    @PutMapping("/courses/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody CourseEntity course, BindingResult result, @PathVariable Integer id) {
        CourseEntity courseActual = courseService.findById(id);
        CourseEntity courseUpdated = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().
                    stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .toList();
            response.put("error", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if (courseActual == null) {
            response.put("mensaje", "Error: no se pudo editar, el curso con ID".concat(id.toString().concat("No existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            courseActual.setCourseName(course.getCourseName());
            courseActual.setCourseDescription(course.getCourseDescription());
            courseActual.setCreditHours(course.getCreditHours());
            courseUpdated = courseService.save(courseActual);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al  actualizar el curso en la base de datos");
            response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El curso ha sido actualizado con éxito");
        response.put("course", courseUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    //DELETE COURSE BY ID
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            String message = courseService.deleteCourse(id);
            response.put("mensaje", message);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al  eliminar el curso en la base de datos");
            response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
