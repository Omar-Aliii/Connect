package io.javabrains.Student;

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
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(method=RequestMethod.GET,value="/Student")
		public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	@RequestMapping("/Student/{id}")
	public Student getStudent(@PathVariable Long id) {
		return studentService.getStudent(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/Student")
	public void addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/Student/{id}")
	public void updateStudent(@RequestBody Student student,@PathVariable String id) {
		studentService.updateStudent(id, student);
		
	}
	@RequestMapping("/Student/{id}/Courses")
	public Set<String> getCoursebyStudentId(@PathVariable Long id) {
		return studentService.getCoursebyStudentId(id);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/Student/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}
	
}
