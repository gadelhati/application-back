package br.eti.gadelha.exception.annotation.observation;

import br.eti.gadelha.exception.validator.observation.ValidTnTnTnValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidTnTnTnValidator.class })
@Documented
public @interface ValidTnTnTn {

    String message() default "TdTdTd não pode ser maior que TTT. Favor verificar";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}