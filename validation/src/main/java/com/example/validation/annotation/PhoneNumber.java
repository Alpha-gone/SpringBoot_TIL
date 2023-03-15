package com.example.validation.annotation;

import com.example.validation.validator.PhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = {PhoneNumberValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {
    String message() default "핸드폰 번호 양식에 맞지 않습니다. ex)000-0000-0000";

    String regexp() default "^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
