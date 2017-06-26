package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a student object
		Student theStudent = new Student();
		
		// add student object to the model
		theModel.addAttribute("student", theStudent); // use the same string as "modelAttribute" name in jsp
		return "student-form";
	}
	
	@RequestMapping("/processForm") // Should be the same string in the "action" attribute of the form
	public String processForm(@ModelAttribute("student") Student theStudent) {
		return "student-confirmation";
	}

}
