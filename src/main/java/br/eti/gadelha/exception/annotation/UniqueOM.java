package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ValidatorUniqueOM;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueOM.class })
@Documented
public @interface UniqueOM {

    String message() default "{unique.om}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}