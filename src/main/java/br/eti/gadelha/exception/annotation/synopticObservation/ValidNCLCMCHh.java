package br.eti.gadelha.exception.annotation.synopticObservation;


import br.eti.gadelha.exception.validator.synopticObservation.ValidNCLCMCHhValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNCLCMCHhValidator.class })
@Documented
public @interface ValidNCLCMCHh {

    String message() default "{validNCLCMCHh.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}