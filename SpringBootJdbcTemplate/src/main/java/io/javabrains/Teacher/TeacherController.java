package io.javabrains.Teacher;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.Course.Course;


@RestController
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	
	
	@RequestMapping(method=RequestMethod.GET,value="/Teacher")
		public List<Teacher> getAllTeachers(){
		return teacherService.getAllTeachers();
	}
	@RequestMapping("/Teacher/{id}")
	public Teacher getTeacher(@PathVariable Long id) {
		return teacherService.getTeacher(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/Teacher")
	public void addTeacher(@RequestBody Teacher teacher) {
		teacherService.addTeacher(teacher);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/Teacher/{id}")
	public void updateTeacher(@RequestBody Teacher teacher,@PathVariable String id) {
		teacherService.updateTeacher(id, teacher);
		
	}
	@RequestMapping("/Teacher/{id}/Courses")
	public Set<Course> getCoursebyTeacherId(@PathVariable Long id) {
		return teacherService.getCoursebyTeacherId(id);
	}
}
