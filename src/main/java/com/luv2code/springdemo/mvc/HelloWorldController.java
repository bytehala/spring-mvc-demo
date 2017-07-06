package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	/**
	 * 
	 * @param request - HttpServletRequest is passed when you want to read form data in your controller
	 * @param model
	 * @return
	 */
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		theName = theName.toUpperCase();
		
		String result = "Yo " + theName + "!";
		
		model.addAttribute("message", result); // This attribute name will be accessed inside the JSP pag
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormV3(@RequestParam("studentName") String theName, Model model) {
		
		theName = theName.toUpperCase();
		
		String result = "Yo " + theName + "! This is Process Form V3";
		
		model.addAttribute("message", result); // This attribute name will be accessed inside the JSP pag
		
		return "helloworld";
	}

}
