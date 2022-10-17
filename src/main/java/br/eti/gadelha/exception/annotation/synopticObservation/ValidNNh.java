package br.eti.gadelha.exception.annotation.synopticObservation;

import br.eti.gadelha.exception.validator.synopticObservation.ValidNNhValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNNhValidator.class })
@Documented
public @interface ValidNNh {

    String message() default "{validNNh.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}