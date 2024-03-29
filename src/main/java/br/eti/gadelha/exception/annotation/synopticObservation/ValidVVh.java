package br.eti.gadelha.exception.annotation.synopticObservation;

import br.eti.gadelha.exception.validator.synopticObservation.ValidVVhValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidVVhValidator.class })
@Documented
public @interface ValidVVh {

    String message() default "{validVVh.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}