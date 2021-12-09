package br.eti.gadelha.exception.annotation.observation;

import br.eti.gadelha.exception.validator.observation.ValidCLCMValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidCLCMValidator.class })
@Documented
public @interface ValidCLCM {

    String message() default "Para o código CL digitado, o campo CM não é aceito. Favor verificar CL ou CM";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}