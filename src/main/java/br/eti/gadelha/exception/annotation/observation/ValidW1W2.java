package br.eti.gadelha.exception.annotation.observation;

import br.eti.gadelha.exception.validator.observation.ValidW1W2Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidW1W2Validator.class })
@Documented
public @interface ValidW1W2 {

    String message() default "W2 não pode ser menor que W1. Favor verificar";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}