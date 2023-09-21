package io.javabrains.Teacher;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.javabrains.Course.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long T_Id;
	
	@JsonIgnore
	@OneToMany(mappedBy = "teacher")
	private Set<Course> courses = new HashSet<>();
	
	public Set<Course> getCourses() {
		return courses;
	}
	

	public Set<String> extractCourseNames() {
    	Set<String> courseNames = new HashSet<>();
        for (Course course : courses) {
            courseNames.add(course.getC_Name());
        }
        return courseNames;
    }

	private String T_Name;

	public Long getT_Id() {
		return T_Id;
	}

	public void setT_Id(Long t_Id) {
		T_Id = t_Id;
	}

	public String getT_Name() {
		return T_Name;
	}

	public void setT_Name(String t_Name) {
		T_Name = t_Name;
	}

	@Override
	public String toString() {
		return "Teacher [T_Id=" + T_Id + ", courses=" + courses + ", T_Name=" + T_Name + "]";
	}

	public Teacher(Long t_Id, String t_Name) {
		super();
		T_Id = t_Id;
		T_Name = t_Name;
	}

	public Teacher() {
		super();
	}
	



	
	
}
