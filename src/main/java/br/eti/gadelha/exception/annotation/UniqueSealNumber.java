package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.UniqueSealNumberValidator;

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
@Constraint(validatedBy = UniqueSealNumberValidator.class)
public @interface UniqueSealNumber {
    public String message() default "{unique.seal.number}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}