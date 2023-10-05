package io.java.Repo;

import org.springframework.data.repository.CrudRepository;

import io.java.Classes.Student;

public interface StudentRepository extends CrudRepository<Student,Long> {

}