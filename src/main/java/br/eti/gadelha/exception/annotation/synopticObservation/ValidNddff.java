package br.eti.gadelha.exception.annotation.synopticObservation;


import br.eti.gadelha.exception.validator.synopticObservation.ValidNddffValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNddffValidator.class })
@Documented
public @interface ValidNddff {

    String message() default "{validNddff.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}