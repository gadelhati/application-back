package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ValidatorUniqueManufacturer;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueManufacturer.class })
@Documented
public @interface UniqueManufacturer {

    String message() default "{unique.manufacturer}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}