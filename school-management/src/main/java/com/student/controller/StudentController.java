package com.student.controller;

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
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.entity.User;
//import com.employee.entity.Employee;
//import com.employee.entity.Employee;
import com.student.entity.Addess;
import com.student.entity.Student;
import com.student.exception.BusinessException;
import com.student.exception.ControllerException;
import com.student.service.AddressService;
import com.student.service.StudentService;
import com.student.service.StudentServiceImpl;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentServiceImpl stuser;
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/save")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		
		try {
			Student student2= studentService.addStudent(student);
			return  new ResponseEntity<Student>(student2, HttpStatus.CREATED);
			
		}catch(BusinessException e) {
			
			ControllerException ce=new ControllerException(e.getErrorcode(),e.getMessage() );
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch(IllegalArgumentException e1) {
			
			ControllerException ce=new ControllerException("101", "address is null please fill it");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
		
	
}		
		
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getStudents(){
	  List<Student> list  =studentService.getStudents();
return new ResponseEntity<List<Student>>(list,HttpStatus.OK);

		}		
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getStuById(@PathVariable int id){
		
		try {
			Student getById=studentService.getStudentById(id);
			return new ResponseEntity<Student>(getById, HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce=new ControllerException(e.getErrorcode(), e.getMessage());
			return new  ResponseEntity<ControllerException>(ce, HttpStatus.OK);
		}
		
	}
	
//	@PutMapping("/update")
//	public Student update(@RequestBody Student student) {
//		return studentService.update(student);
//	}	
	
	@PutMapping("/update")
	public ResponseEntity<Student> update(@RequestBody Student student){
		Student student1=studentService.update(student);
		return new ResponseEntity<Student>(student1,HttpStatus.OK);
	}
	
	

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmpById(@PathVariable int id){
		try {
			
			studentService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}catch(BusinessException e) {
			ControllerException con=new ControllerException(e.getErrorcode(), e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}catch (Exception e) {
			 ControllerException con=new ControllerException("202", "please check the id");
			 return new ResponseEntity<ControllerException>(HttpStatus.ACCEPTED);
		}
		
	}
	
	@GetMapping("/getAdd")
	public List<Student> getAddStu(){
	return	stuser.getAdd();
	}
	
	
	}	
	
		
	
	
	
	
	
