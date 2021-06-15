package com.nikhil.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nikhil.demo.Entity.StudentEntity;
@Repository
public interface StudentRepository extends  JpaRepository<StudentEntity,Integer> {

	

	Optional<StudentEntity> findStudentEntityByIdAndPassword(int id, String password);
	}

	


