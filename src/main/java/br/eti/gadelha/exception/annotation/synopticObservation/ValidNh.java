package br.eti.gadelha.exception.annotation.synopticObservation;


import br.eti.gadelha.exception.validator.synopticObservation.ValidNhValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNhValidator.class })
@Documented
public @interface ValidNh {

    String message() default "Para o código N digitado, o campo h não é aceito. Favor verificar N ou h";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}