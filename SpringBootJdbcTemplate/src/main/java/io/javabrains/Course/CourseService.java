package io.javabrains.Course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.Student.Student;
import io.javabrains.Teacher.Teacher;
import io.javabrains.Student.StudentRepository;
import io.javabrains.Teacher.TeacherRepository;

@Service
public class CourseService {

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

	public Course enrollStudent(Long c_id, Long s_id) {
		Student student = studentRepository.findById(s_id).get();
		Course	course = courseRepository.findById(c_id).get();
		course.enrollStudent(student);
		return courseRepository.save(course);
	}

	public Course enrollTeacher(Long c_id, Long t_id) {
		Teacher teacher = teacherRepository.findById(t_id).get();
		Course	course = courseRepository.findById(c_id).get();
		course.enrollTeacher(teacher);
		return courseRepository.save(course);
	}
	



}
