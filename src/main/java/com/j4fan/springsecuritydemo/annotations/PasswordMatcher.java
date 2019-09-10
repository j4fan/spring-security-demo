package com.j4fan.springsecuritydemo.annotations;

import com.j4fan.springsecuritydemo.validator.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordMatcher {

    String message() default "Password not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}