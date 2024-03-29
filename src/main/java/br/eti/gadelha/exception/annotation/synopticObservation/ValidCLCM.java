package br.eti.gadelha.exception.annotation.synopticObservation;

import br.eti.gadelha.exception.validator.synopticObservation.ValidCLCMValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidCLCMValidator.class })
@Documented
public @interface ValidCLCM {

    String message() default "{validCLCM.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}