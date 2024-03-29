package br.eti.gadelha.exception.annotation.synopticObservation;

import br.eti.gadelha.exception.validator.synopticObservation.ValidVVWWValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidVVWWValidator.class })
@Documented
public @interface ValidVVWW {

    String message() default "{validVVWW.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}