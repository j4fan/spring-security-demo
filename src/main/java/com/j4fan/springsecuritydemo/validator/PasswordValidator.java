package com.j4fan.springsecuritydemo.validator;

import com.j4fan.springsecuritydemo.annotations.PasswordMatcher;
import com.j4fan.springsecuritydemo.domin.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordMatcher, Object> {


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        UserDTO user = (UserDTO) value;
        return user.getPassword().equals(user.getMatchPassword());
    }
}
