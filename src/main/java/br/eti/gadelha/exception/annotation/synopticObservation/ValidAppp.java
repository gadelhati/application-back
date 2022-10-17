package br.eti.gadelha.exception.annotation.synopticObservation;

import br.eti.gadelha.exception.validator.synopticObservation.ValidApppValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidApppValidator.class })
@Documented
public @interface ValidAppp {

    String message() default "{validAppp.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}