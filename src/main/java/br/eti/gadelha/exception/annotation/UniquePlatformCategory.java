package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ValidatorUniquePlatformCategory;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniquePlatformCategory.class })
@Documented
public @interface UniquePlatformCategory {

    String message() default "{unique.platformCategory}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}