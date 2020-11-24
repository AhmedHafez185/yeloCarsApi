/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yelo.app.exceptions;

import com.yelo.app.dto.CarDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Ahmed Hafez
 */
@Component
public class CarValidator implements Validator {

   
    @Override
    public boolean supports(Class<?> clazz) {
        return CarDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CarDto carDto = (CarDto) target;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Name Is Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owner", "Owner Is Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "model", "Model Is Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hideMe", "hideMe Is Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "color", "Color Is Required");
        
        if (carDto.getHideMe() < 0  || carDto.getHideMe() > 1) {
            errors.rejectValue("hideMe", "hide error value");
        }
        
        
    }

}

