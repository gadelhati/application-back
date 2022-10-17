package br.eti.gadelha.exception.annotation.auth;

import br.eti.gadelha.exception.validator.auth.PasswordHasLetterValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordHasLetterValidator.class)
public @interface PasswordHasLetter {
    public String message() default "{password.letter}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}