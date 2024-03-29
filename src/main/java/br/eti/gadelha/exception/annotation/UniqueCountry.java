package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ValidatorUniqueCountry;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueCountry.class })
@Documented
public @interface UniqueCountry {

    String message() default "{unique.country}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}