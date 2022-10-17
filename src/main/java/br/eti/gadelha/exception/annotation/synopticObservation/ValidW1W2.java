package br.eti.gadelha.exception.annotation.synopticObservation;

import br.eti.gadelha.exception.validator.synopticObservation.ValidW1W2Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidW1W2Validator.class })
@Documented
public @interface ValidW1W2 {

    String message() default "{validW1W2.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}