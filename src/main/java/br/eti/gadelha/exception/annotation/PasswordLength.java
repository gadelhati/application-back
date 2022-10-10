package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.PasswordLengthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordLengthValidator.class)
public @interface PasswordLength {
    public String message() default "{password.length}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}