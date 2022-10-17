package br.eti.gadelha.exception.annotation.synopticObservation;

import br.eti.gadelha.exception.validator.synopticObservation.ValidTxTxTxValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidTxTxTxValidator.class })
@Documented
public @interface ValidTxTxTx {

    String message() default "TxTxTx não pode ser maior que TTT. Favor verificar";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}