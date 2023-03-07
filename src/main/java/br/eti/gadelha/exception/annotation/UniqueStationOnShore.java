package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ValidatorUniqueStationOnShore;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueStationOnShore.class })
@Documented
public @interface UniqueStationOnShore {

    String message() default "{unique.station.onshore}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}