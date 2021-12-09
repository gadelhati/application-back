package br.eti.gadelha.exception.annotation.observation;


import br.eti.gadelha.exception.validator.observation.ValidNhCLCMhValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNhCLCMhValidator.class })
@Documented
public @interface ValidNhCLCMh {

    String message() default "Para o código Nh digitado, os campos CL CM ou h não são aceitos. Favor verificar Nh, CL, CM ou h";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}