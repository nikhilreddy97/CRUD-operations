package com.nikhil.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.demo.Entity.StudentEntity;
import com.nikhil.demo.Service.StudentService;

@RestController
@RequestMapping("/details")
public class StudentContoller {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> createStudent(@RequestBody StudentEntity student){
		String response= service.createStudent(student);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/fetchall") 
	public ResponseEntity<List< StudentEntity>> getAll(){
		List<StudentEntity> response= service.getAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(response);	
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentEntity> getById(@PathVariable("id") int id) throws Exception{
		StudentEntity response= service.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}	
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody StudentEntity student) throws Exception {
		service.update(student);
		return ResponseEntity.status(HttpStatus.OK).body("updated");
		
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletebyId(@PathVariable("id") int id ) throws Exception{
		
		service.deletebyId(id);
		return ResponseEntity.status(HttpStatus.OK).body("deleted");
	}
		
		
	@PostMapping("/login")
	public ResponseEntity<StudentEntity> userlogin(@RequestBody StudentEntity student) throws Exception{
		
	    int id =student.getId();
	    String password=student.getPassword();
	    service.userlogin(id,password);
	    return ResponseEntity.ok(student);	             
		
	}
	
	
		
		
		
		
		
		
		
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
	
	

	