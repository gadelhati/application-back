package br.eti.gadelha.exception.annotation.synopticObservation;


import br.eti.gadelha.exception.validator.synopticObservation.ValidNhCLCMhValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNhCLCMhValidator.class })
@Documented
public @interface ValidNhCLCMh {

    String message() default "{validNhCLCMh.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}