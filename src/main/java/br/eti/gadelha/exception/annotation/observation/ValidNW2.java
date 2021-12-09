package br.eti.gadelha.exception.annotation.observation;

import br.eti.gadelha.exception.validator.observation.ValidNW2Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNW2Validator.class })
@Documented
public @interface ValidNW2 {

    String message() default "Para o código N digitado, o campo W2 não é aceito. Favor verificar N ou W2";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}