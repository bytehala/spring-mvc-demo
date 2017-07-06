package com.luv2code.springdemo.mvc.dao;

import java.util.List;

import com.luv2code.springdemo.mvc.Student;

public interface StudentDao {
	
	Student findByName(String name);
	
	List<Student> findAll();

}
