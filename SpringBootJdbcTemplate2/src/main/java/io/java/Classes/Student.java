package io.java.Classes;

import java.util.HashSet;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "S_ID")
	private Long S_ID;
	
	@Column(name = "F_Name")
	private String F_Name;
	
	@Column(name = "S_Name")
	private String S_Name;
	
	@Column(name = "S_Age")
	private int S_Age;

	@Column(name = "S_Password")
	private int S_Password;
	
	public Student(String F_Name, String S_Name, int S_Age,int S_Password) {
		this.F_Name = F_Name;
		this.S_Name = S_Name;
		this.S_Age = S_Age;
		this.S_Password = S_Password;
	}
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "StudentEnrolled",
				joinColumns = @JoinColumn(name = "S_ID"),
				inverseJoinColumns = @JoinColumn(name = "C_ID")
			)
			
	
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
	


	public Student() {
		super();
	}

	


	public int getS_Password() {
		return S_Password;
	}


	public void setS_Password(int s_Password) {
		S_Password = s_Password;
	}


	public Long getS_ID() {
		return S_ID;
	}



	public void setS_ID(Long s_ID) {
		S_ID = s_ID;
	}



	public String getF_Name() {
		return F_Name;
	}



	public void setF_Name(String f_Name) {
		F_Name = f_Name;
	}



	public String getS_Name() {
		return S_Name;
	}



	public void setS_Name(String s_Name) {
		S_Name = s_Name;
	}



	public int getS_Age() {
		return S_Age;
	}



	public void setS_Age(int s_Age) {
		S_Age = s_Age;
	}



	@Override
	public String toString() {
		return "Student [S_ID=" + S_ID + ", F_Name=" + F_Name + ", S_Name=" + S_Name + ", S_Age=" + S_Age + "]";
	}


	
	
	
}