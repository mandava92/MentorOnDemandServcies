package com.mentorondemand.user.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy= {UserValidator.class})
@Target({ TYPE })
@Retention(RUNTIME)
public @interface UserValidation {
	String message() default "{com.mentorondemand.user.userName}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
