package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ValidatorUniqueResearcher;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueResearcher.class })
@Documented
public @interface UniqueResearcher {

    String message() default "{unique.researcher}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}