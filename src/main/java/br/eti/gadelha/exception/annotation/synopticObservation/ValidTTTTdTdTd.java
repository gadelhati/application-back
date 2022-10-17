package br.eti.gadelha.exception.annotation.synopticObservation;

import br.eti.gadelha.exception.validator.synopticObservation.ValidTTTTdTdTdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidTTTTdTdTdValidator.class })
@Documented
public @interface ValidTTTTdTdTd {

    String message() default "Verificar o valor de TdTdTd. O mesmo deve ser menor ou igual TTT";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}