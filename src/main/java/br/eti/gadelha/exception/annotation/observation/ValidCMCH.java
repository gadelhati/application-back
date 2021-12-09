package br.eti.gadelha.exception.annotation.observation;

import br.eti.gadelha.exception.validator.observation.ValidCMCHValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidCMCHValidator.class })
@Documented
public @interface ValidCMCH {

    String message() default "Para o código CM digitado, o campo CH não é aceito. Favor verificar CM ou CH";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}