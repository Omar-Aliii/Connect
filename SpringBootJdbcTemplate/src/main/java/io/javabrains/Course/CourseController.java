package io.javabrains.Course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.Student.Student;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping(method=RequestMethod.GET,value="/Course")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@RequestMapping("/Course/{id}")
	public Course getCourse(@PathVariable Long id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/Course")
	public void addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/Course/{id}")
	public void updateStudent(@RequestBody Course course,@PathVariable String id) {
		courseService.updateCourse(id, course);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/Course/{c_id}/Student/{s_id}")
	public void enrollStudentToCourse(@PathVariable Long c_id,
										@PathVariable Long s_id) {
		courseService.enrollStudent(c_id,s_id);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/Course/{c_id}/Teacher/{t_id}")
	public void enrollTeacherToCourse(@PathVariable Long c_id,
										@PathVariable Long t_id) {
		courseService.enrollTeacher(c_id,t_id);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/Course/{id}")
	public void deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
	}
}
