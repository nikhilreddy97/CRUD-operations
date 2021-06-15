package com.nikhil.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nikhil.demo.Entity.StudentEntity;
import com.nikhil.demo.Repository.StudentRepository;

@Service
@Transactional
public class Studentimpl implements StudentService {

	@Autowired
	StudentRepository repository;


	@Override
	public String createStudent(StudentEntity student) {
		// TODO Auto-generated method stub

		repository.save(student);

		return "saved";

	}

	@Override
	public List<StudentEntity> getAll() {
		// TODO Auto-generated method stub

		List<StudentEntity> result = repository.findAll();

		return result;
	}

	@Override
	public StudentEntity getById(int id) throws Exception {
		// TODO Auto-generated method stub

		Optional<StudentEntity> result = repository.findById(id);

		if (result.isPresent()) {
			return result.get();
		} else {
			throw new Exception("not found");

		}

	}

	@Override
	public void update(StudentEntity student) throws Exception {
		// TODO Auto-generated method stub
		repository.findById(student.getId()).map((response) -> {

			response.setId(student.getId());
			response.setName(student.getName());
			response.setCollege(student.getCollege());
			response.setGrade(student.getGrade());

			return repository.save(response);
		}).orElseThrow(() -> new Exception("not found"));
		

	}
//	if(!result.isPresent()) {
//		throw new  Exception ("not found");
//	}
//	
//	studentdata.setName(student.getName());	
//	studentdata.setCollege(student.getCollege());
//	
//	studentdata.setGrade(student.getGrade());
//	
//	return repository.save(studentdata);
//}

	@Override
	public void deletebyId(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public void userlogin(int id, String password) throws Exception {
		// TODO Auto-generated method stub

		Optional<StudentEntity> result = repository.findStudentEntityByIdAndPassword(id,password);
		if (!result.isPresent()) {
			throw new Exception("details are invalid");

		}

	}

}
