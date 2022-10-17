package br.eti.gadelha.exception.annotation.synopticObservation;

import br.eti.gadelha.exception.validator.synopticObservation.ValidNCLCMCHValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNCLCMCHValidator.class })
@Documented
public @interface ValidNCLCMCH {

    String message() default "{validNCLCMCH.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}