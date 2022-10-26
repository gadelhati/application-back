package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ValidatorUniqueObserver;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueObserver.class })
@Documented
public @interface UniqueObserver {

    String message() default "{unique.observer}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}