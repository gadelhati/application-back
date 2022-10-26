package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ValidatorUniqueFederativeUnit;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueFederativeUnit.class })
@Documented
public @interface UniqueFederativeUnit {

    String message() default "{unique.federativeUnit}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}