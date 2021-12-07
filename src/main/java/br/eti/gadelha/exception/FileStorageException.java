package br.eti.gadelha.exception;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public class FileStorageException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	public FileStorageException(String message) {
        super(message);
    }
    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}