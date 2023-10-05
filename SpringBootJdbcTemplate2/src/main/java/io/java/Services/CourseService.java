package io.java.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.java.Classes.Course;
import io.java.Classes.Student;
import io.java.Classes.Teacher;
import io.java.Repo.CourseRepository;
import io.java.Repo.StudentRepository;
import io.java.Repo.TeacherRepository;



@Service
public class CourseService {

	private static final Teacher NULL = null;

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
		}

	public Course getCourse(Long id) {
		return courseRepository.findById(id).orElse(null);
	}

	public void addCourse(Course course) {
		 courseRepository.save(course);
	}

	public void updateCourse(String id, Course course) {
		courseRepository.save(course);
	}

	public void enrollStudent(Long c_id, Long s_id) {
		Student student = studentRepository.findById(s_id).get();
		Course	course = courseRepository.findById(c_id).get();
		if(course.getTeacher()== NULL) {
			;
		}
		else {
		course.enrollStudent(student);
		courseRepository.save(course);
		}
	}

	public Course enrollTeacher(Long c_id, Long t_id) {
		Teacher teacher = teacherRepository.findById(t_id).get();
		Course	course = courseRepository.findById(c_id).get();
		course.enrollTeacher(teacher);
		return courseRepository.save(course);
	}

	public void deleteCourse(Long id) {
		Course course = courseRepository.findById(id).orElse(null);
		course.getEnrolledStudents();
		course.setEnrolledStudents(null);
		course.setTeacherToNULL();
		courseRepository.deleteById(id);
		
	}
	



}