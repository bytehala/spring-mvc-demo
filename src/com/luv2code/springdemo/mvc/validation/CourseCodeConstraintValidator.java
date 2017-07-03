package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    
    private String coursePrefix;
    
    @Override
    public void initialize(CourseCode code) {
        coursePrefix = code.value();
    }
    
    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext context) {
        boolean result = theCode == null || (theCode.startsWith(coursePrefix));
        
        return result;
    }
    
}
