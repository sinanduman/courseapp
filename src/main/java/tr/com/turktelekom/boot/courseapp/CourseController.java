package tr.com.turktelekom.boot.courseapp;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CourseController {
    Map<String, Course> courseMap = new HashMap<>() {{
        put("1", new Course("1", "Java"));
        put("2", new Course("2", "Rust"));
    }};

    private static String API_URL = "https://api.genderize.io/?name=";

    @GetMapping("/course")
    public Collection<Course> getCourse() {
        return courseMap.values();
    }

    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable String id) {
        return courseMap.get(id);
    }

    @PostMapping("/course")
    public void addCourse(@RequestBody Course course) {
        courseMap.put(course.getId(), course);
    }

    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseMap.remove(id);
    }

    @GetMapping("/out/{name}")
    public void getOutApi(@PathVariable String name) {
        String url = API_URL + name;
        RestTemplate restTemplate = new RestTemplate();

        Object guess = restTemplate.getForObject(url, Object.class);
        System.out.println(guess);
    }

}
