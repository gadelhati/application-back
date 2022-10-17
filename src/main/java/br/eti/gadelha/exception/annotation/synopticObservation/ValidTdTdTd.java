package br.eti.gadelha.exception.annotation.synopticObservation;

import br.eti.gadelha.exception.validator.synopticObservation.ValidTdTdTdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidTdTdTdValidator.class })
@Documented
public @interface ValidTdTdTd {

    String message() default "{validTdTdTd.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}