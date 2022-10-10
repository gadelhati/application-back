package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.UniqueEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {
    public String message() default "{unique}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}