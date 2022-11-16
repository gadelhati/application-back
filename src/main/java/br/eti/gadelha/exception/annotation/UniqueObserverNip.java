package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ValidatorUniqueObserverNip;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueObserverNip.class })
@Documented
public @interface UniqueObserverNip {

    String message() default "{unique.observer.nip}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}