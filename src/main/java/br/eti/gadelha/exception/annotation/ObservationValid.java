package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ObservationValidValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Constraint(validatedBy = ObservationValidValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ObservationValid {

    String message() default "Fields values don't match!";

    String field();

    String fieldMatch();

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        ObservationValid[] value();
    }
}