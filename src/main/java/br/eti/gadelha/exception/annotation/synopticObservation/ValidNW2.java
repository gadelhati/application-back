package br.eti.gadelha.exception.annotation.synopticObservation;

import br.eti.gadelha.exception.validator.synopticObservation.ValidNW2Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNW2Validator.class })
@Documented
public @interface ValidNW2 {

    String message() default "{validNW2.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}