package io.javabrains.Course;
import java.util.HashSet;
import java.util.Set;

import io.javabrains.Student.Student;
import io.javabrains.Teacher.Teacher;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Course")
public class Course {

	private static final Teacher Null = null;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID")
	private Long C_ID;
	
	@Column(name = "C_Name")
	private String C_Name;

	@Column(name = "C_Hours")
	private int C_Hours;

	@ManyToMany
	@JoinTable(
			name = "StudentEnrolled",
			joinColumns = @JoinColumn(name = "C_ID"),
			inverseJoinColumns = @JoinColumn(name = "S_ID")
			)
	
	private Set<Student> enrolledStudents = new HashSet<>();
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public void setTeacherToNULL() {
		teacher = Null;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "t_Id", referencedColumnName = "T_Id")
	private Teacher teacher;
	
	public Set<Student> getEnrolledStudents() {
		return enrolledStudents;
	}
	

	public void setEnrolledStudents(Set<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public String getC_Name() {
		return C_Name;
	}

	public void setC_Name(String c_Name) {
		C_Name = c_Name;
	}
	public Long getC_ID() {
		return C_ID;
	}

	public void setC_ID(Long c_ID) {
		C_ID = c_ID;
	}

	public int getC_Hours() {
		return C_Hours;
	}

	public void setC_Hours(int c_Hours) {
		C_Hours = c_Hours;
	}

	
	public Course(Long c_ID, int c_Hours) {
		super();
		C_ID = c_ID;
		C_Hours = c_Hours;
	}
	
	
	public Course() {
		super();
	}



	@Override
	public String toString() {
		return "Course [C_ID=" + C_ID + ", C_Name=" + C_Name + ", C_Hours=" + C_Hours + ", enrolledStudents="
				+ enrolledStudents + ", teacher=" + teacher + "]";
	}

	public void enrollStudent(Student student) {
		enrolledStudents.add(student);
		
	}
	public void enrollTeacher(Teacher teach) {
		this.teacher = teach;
		
	}
	
	
}
