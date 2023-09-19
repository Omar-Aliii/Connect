package io.javabrains.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.Course.Course;


@Service
public class StudentService {
	
		@Autowired
		private StudentRepository studentRepository;
		
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

		public Set<Course> getCoursebyStudentId(Long id) {
			Student student = studentRepository.findById(id).orElse(null);
			return student.getCourses();
		}
		

}
