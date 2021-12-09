package br.eti.gadelha.exception.annotation.observation;

import br.eti.gadelha.exception.validator.observation.ValidVVWWValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidVVWWValidator.class })
@Documented
public @interface ValidVVWW {

    String message() default "Para o código VV digitado, o campo ww não é aceito. Favor verificar VV ou ww";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}