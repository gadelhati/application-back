package br.eti.gadelha.exception.annotation.synopticObservation;


import br.eti.gadelha.exception.validator.synopticObservation.ValidNhValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNhValidator.class })
@Documented
public @interface ValidNh {

    String message() default "{validNh.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}