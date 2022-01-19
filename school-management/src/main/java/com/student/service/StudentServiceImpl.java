package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo.entity.User;
import com.student.entity.Student;
import com.student.exception.BusinessException;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		if(student.getName().isEmpty() || student.getName().equals(null)) {
			throw new BusinessException("101", "the name is null please enter the name");
		}
		
	try {
		 Student studentRepo=studentRepository.save(student);
		 return studentRepo;
		
	}catch(IllegalArgumentException e) {
	throw new BusinessException("102", "business exception due to null value in name"+e.getMessage());
	}
	
	
	
	
	}

	@Override
	public List<Student> getStudents() {
		List<Student> stu=null;
		try {
		stu=studentRepository.findAll();
return stu;
		}catch (BusinessException e) {
			throw new BusinessException("103", " the list is empty"+e.getMessage());
		}
	
	}

	@Override
	public Student getStudentById(int id) {
		try {
			Student stu=studentRepository.findById(id).get();
			return stu;
		}catch (BusinessException e) {
		throw new BusinessException("102"," the id you have enterd dosent exist in database"+e.getMessage());
			
		}catch(Exception e) {
			throw new BusinessException("103", " please check the entered value ");
		}
			
		
	}

//	@Override
//	public Student update(Student ids) {
//		Optional<Student> stuuser=studentRepository.findById(ids.getId());
//		Student stu=null;
//		if(stuuser.isPresent()) {
//			stu=stuuser.get();
//			stu.setName(ids.getName());
//			stu.setAge(ids.getAge());
//			stu.setAddress(ids.getAddress());
//			studentRepository.save(stu);
//		}else {
//			return new Student();
//		}
//		return stu;
//	}
//	
	@Override
	public Student update(Student u) {
		Optional<Student> optnuser = studentRepository.findById(u.getId());
		Student oldUser =new Student();

		if (optnuser.isPresent()) {
			oldUser = optnuser.get();
			oldUser.setName(u.getName());
			oldUser.setAge(u.getAge());
			oldUser.setId(u.getId());
			oldUser.setAddress(u.getAddress());
		

	
			studentRepository.save(oldUser);
		} else {
			return new Student();
		}
		return oldUser;

	}

	

	@Override
	public void delete(int id) {
		try {
			studentRepository.deleteById(id);
		}catch(BusinessException e) {
			throw new BusinessException("440", "the id you are trying to delete dosenot exist"+e.getMessage());
		}
		
		
	}
	
public List<Student> getAdd(){
	
return	studentRepository.stuAdd();
}	

}
