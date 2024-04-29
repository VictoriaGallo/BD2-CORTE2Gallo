package Service;

import Model.Course;
import Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


// Servicio
@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    public List<Course> getCoursesWithMoreThanHours(int totalHours) {
        return repository.findByTotalHoursGreaterThan(totalHours);
    }
}
