package br.eti.gadelha.exception.annotation.synopticObservation;

import br.eti.gadelha.exception.validator.synopticObservation.ValidTTTTnTnTnValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidTTTTnTnTnValidator.class })
@Documented
public @interface ValidTTTTnTnTn {

    String message() default "{validTnTnTn.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}