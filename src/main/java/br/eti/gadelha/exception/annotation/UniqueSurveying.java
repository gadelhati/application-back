package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ValidatorUniqueSurveying;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueSurveying.class })
@Documented
public @interface UniqueSurveying {

    String message() default "{unique.surveying}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}