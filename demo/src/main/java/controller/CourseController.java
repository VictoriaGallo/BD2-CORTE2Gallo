package controller;

import Model.Course;
import Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.*;

// Controlador
@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CourseRepository coursesRepository;

    @GetMapping
    public List<Course> getAllCourses() {
        return coursesRepository.findAll();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return coursesRepository.save(course);
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable String id) {
        Course course = coursesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found: " + id));
        return course;
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable String id, @RequestBody Course course) {
        course.setId(id);
        return coursesRepository.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable String id) {
        coursesRepository.deleteById(id);
    }

    @GetMapping("/withRatingGreaterThan/{N}")
    public List<Course> findCoursesWithRatingGreaterThan(@PathVariable int N) {
        return coursesRepository.findByTotalHoursGreaterThan(N);
    }
}
