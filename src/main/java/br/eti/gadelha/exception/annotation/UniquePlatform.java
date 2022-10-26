package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ValidatorUniquePlatform;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniquePlatform.class })
@Documented
public @interface UniquePlatform {

    String message() default "{unique.platform}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}