package br.eti.gadelha.exception.annotation.synopticObservation;


import br.eti.gadelha.exception.validator.synopticObservation.ValidNhCLCMCHhValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNhCLCMCHhValidator.class })
@Documented
public @interface ValidNhCLCMCHh {

    String message() default "Para o código Nh digitado, os campos CL CM CH ou h não são aceitos. Favor verificar Nh CL CM CH ou h";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}