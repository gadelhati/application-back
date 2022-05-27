package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.PasswordHasLetterValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordHasLetterValidator.class)
public @interface PasswordHasLetter {
    public String message() default "{password.letter}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}