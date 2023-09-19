package io.javabrains.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.Course.Course;
import io.javabrains.Student.Student;

@Service
public class TeacherService {

	
	@Autowired
	private TeacherRepository teacherRepository;
	public List<Teacher> getAllTeachers() {
		List<Teacher> teachers = new ArrayList<>();
		teacherRepository.findAll().forEach(teachers::add);
		return teachers;
	}
	
	
	public Teacher getTeacher(Long id) {
		return teacherRepository.findById(id).orElse(null);
	}

	public void addTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
	}

	public void updateTeacher(String id, Teacher teacher) {
		teacherRepository.save(teacher);
	}


	public Set<Course> getCoursebyTeacherId(Long id) {
		Teacher teacher = teacherRepository.findById(id).orElse(null);
		return teacher.getCourses();
	}


}
