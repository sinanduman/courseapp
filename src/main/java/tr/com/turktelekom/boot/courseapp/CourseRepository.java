package tr.com.turktelekom.boot.courseapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    public List<Course> findAll();
    public Course findAllById(Integer id);
}
