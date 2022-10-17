package br.eti.gadelha.exception.annotation.synopticObservation;

import br.eti.gadelha.exception.validator.synopticObservation.ValidTnTnTnValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidTnTnTnValidator.class })
@Documented
public @interface ValidTnTnTn {

    String message() default "{validTnTnTn.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}