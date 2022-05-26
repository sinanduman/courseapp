package tr.com.turktelekom.boot.courseapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v2")
public class CourseControllerV2 {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    public Collection<Course> getCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Integer id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("/course")
    public void addCourse(@RequestBody Course course) {
        courseService.save(course);
    }

    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable Integer id) {
        courseService.deleteById(id);
    }

}
