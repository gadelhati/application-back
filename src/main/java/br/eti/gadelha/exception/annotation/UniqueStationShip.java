package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ValidatorUniqueStationShip;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueStationShip.class })
@Documented
public @interface UniqueStationShip {

    String message() default "{unique.stationOnShore}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}