package br.eti.gadelha.exception.annotation.auth;

import br.eti.gadelha.exception.validator.auth.PasswordHasDigitValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordHasDigitValidator.class)
public @interface PasswordHasDigit {
    public String message() default "{password.digit}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}