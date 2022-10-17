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

    String message() default "Para o código TTT digitado, o campo ww não é aceito. Favor verificar TTT ou ww";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}