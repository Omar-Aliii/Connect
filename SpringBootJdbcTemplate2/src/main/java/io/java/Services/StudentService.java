package io.java.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import io.java.Classes.Course;
import io.java.Classes.Student;
import io.java.Repo.CourseRepository;
import io.java.Repo.StudentRepository;



@Service
public class StudentService {
	
		@Autowired
		private StudentRepository studentRepository;
		@Autowired
		private CourseRepository courseRepository;
		
		public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		return students;
		}
		
		public Student getStudent(Long id) {
			return studentRepository.findById(id).orElse(null);
		}

		public void addStudent(Student student) {
			studentRepository.save(student);
		}

		public void updateStudent(String id, Student student) {
			studentRepository.save(student);
		}

		public Set<String> getCoursebyStudentId(Long id) {
			Student student = studentRepository.findById(id).orElse(null);
			return student.extractCourseNames();
		}

		public void deleteStudent(Long id) {
			 List<Course> courses = new ArrayList<>();
			 courseRepository.findAll().forEach(courses::add);
			 Student student = studentRepository.findById(id).orElse(null);
			 for(Course course : courses) {
				 Set<Student> students = course.getEnrolledStudents();
				 if(students.contains(student)) {
					 students.remove(student);
				 }
			 course.setEnrolledStudents(students);
			 }
			 studentRepository.deleteById(id);
			 
		}
		

}