package io.java.Services;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.java.Repo.TeacherRepository;
import io.java.Classes.Course;
import io.java.Classes.Teacher;

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


	public Set<String> getCoursebyTeacherId(Long id) {
		Teacher teacher = teacherRepository.findById(id).orElse(null);
		return teacher.extractCourseNames();
	}

	public void deleteTeacher(Long id) {
		Teacher teacher = teacherRepository.findById(id).orElse(null);
		Set<Course> teacherCourses = teacher.getCourses();
		for (Course course : teacherCourses) {
	        course.setTeacherToNULL();
		teacherRepository.deleteById(id);
		
	}


}
}