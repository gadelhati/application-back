package br.eti.gadelha.exception.annotation.synopticObservation;

import br.eti.gadelha.exception.validator.synopticObservation.ValidCMCHValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidCMCHValidator.class })
@Documented
public @interface ValidCMCH {

    String message() default "{validCMCH}.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}