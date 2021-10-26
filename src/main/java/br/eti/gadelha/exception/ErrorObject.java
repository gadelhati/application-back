package br.eti.gadelha.exception;

import lombok.AllArgsConstructor;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@AllArgsConstructor
public class ErrorObject {

    private final String message;
    private final String field;
    private final Object parameter;
}