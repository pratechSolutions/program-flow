package com.programflow.programflow.util.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = com.programflow.programflow.util.validators.PasswordValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "Password is mandatory.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
