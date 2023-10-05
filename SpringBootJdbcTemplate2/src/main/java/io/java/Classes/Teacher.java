package io.java.Classes;



import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_ID")
	private Long T_Id;
	
	@Column(name = "T_Password")
	private String T_Password;
	
	@Column(name = "T_Name")
	private String T_Name;
	
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



	public String getT_Password() {
		return T_Password;
	}

	public void setT_Password(String t_Password) {
		T_Password = t_Password;
	}

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
		return "Teacher [T_Id=" + T_Id + ", T_Password=" + T_Password + ", T_Name=" + T_Name + "]";
	}


	public Teacher(Long t_Id, String t_Name,String T_Password) {
		this.T_Id = t_Id;
		this.T_Name = t_Name;
		this.T_Password = T_Password;
	}

	public Teacher() {
		super();
	}
	



	
	
}