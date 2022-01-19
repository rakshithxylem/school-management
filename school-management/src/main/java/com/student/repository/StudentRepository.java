package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.entity.Student;


@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer>{

	
//	@Query(value="",nativeQuery = true)
//	public List<Student> StuAge();
	
	@Query(value="  SELECT * FROM STUDENT  WHERE AGE>=18 ",nativeQuery = true)
	public List<Student> stuAdd();

}
