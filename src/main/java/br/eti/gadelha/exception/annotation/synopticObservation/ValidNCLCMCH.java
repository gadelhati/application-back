package br.eti.gadelha.exception.annotation.synopticObservation;

import br.eti.gadelha.exception.validator.synopticObservation.ValidNCLCMCHValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNCLCMCHValidator.class })
@Documented
public @interface ValidNCLCMCH {

    String message() default "Para o código N digitado, os campos CL CM ou CH não são aceitos. Favor verificar N CL CM ou CH";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}