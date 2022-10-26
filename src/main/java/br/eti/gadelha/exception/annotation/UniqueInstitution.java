package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ValidatorUniqueInstitution;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueInstitution.class })
@Documented
public @interface UniqueInstitution {

    String message() default "{unique.institution}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}