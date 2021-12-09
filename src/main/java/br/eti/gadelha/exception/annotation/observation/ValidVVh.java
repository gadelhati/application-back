package br.eti.gadelha.exception.annotation.observation;

import br.eti.gadelha.exception.validator.observation.ValidVVhValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidVVhValidator.class })
@Documented
public @interface ValidVVh {

    String message() default "Para o código VV digitado, o campo h não é aceito. Favor verificar VV ou h";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}