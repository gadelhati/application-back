package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ValidUserNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidUserNameValidator.class)
public @interface ValidJwt {
    public String message() default "{valid.jwt}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}