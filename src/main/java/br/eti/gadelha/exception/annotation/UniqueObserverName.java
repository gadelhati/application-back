package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ValidatorUniqueObserverName;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueObserverName.class })
@Documented
public @interface UniqueObserverName {

    String message() default "{unique.observer.name}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}