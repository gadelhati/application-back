package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ValidatorUniqueCompany;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueCompany.class })
@Documented
public @interface UniqueCompany {

    String message() default "{unique.company}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}