package br.eti.gadelha.exception.annotation.synopticObservation;


import br.eti.gadelha.exception.validator.synopticObservation.ValidNhCLCMValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNhCLCMValidator.class })
@Documented
public @interface ValidNhCLCM {

    String message() default "{validNhCLCM.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}