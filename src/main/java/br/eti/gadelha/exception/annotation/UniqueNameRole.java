package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.UniqueNameRoleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueNameRoleValidator.class)
public @interface UniqueNameRole {
    public String message() default "{unique}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}