package br.eti.gadelha.exception.annotation.synopticObservation;

import br.eti.gadelha.exception.validator.synopticObservation.ValidTTTValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidTTTValidator.class })
@Documented
public @interface ValidTTT {

    String message() default "{validTTT.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}