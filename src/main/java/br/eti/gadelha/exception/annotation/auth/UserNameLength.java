package br.eti.gadelha.exception.annotation.auth;

import br.eti.gadelha.exception.validator.auth.UserNameLengthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserNameLengthValidator.class)
public @interface UserNameLength {
    public String message() default "{username.length}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}