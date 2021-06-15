package com.nikhil.demo.Service;

import java.util.List;
import java.util.Optional;

import com.nikhil.demo.Entity.StudentEntity;

public interface StudentService {

	String createStudent(StudentEntity student);

	List<StudentEntity> getAll();



	StudentEntity getById(int id) throws Exception;

	void update(StudentEntity student) throws Exception;

	void deletebyId(int id);



	void userlogin(int id, String password) throws Exception;


	

}
