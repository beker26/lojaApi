package br.com.lojaprodutos.lojaprodutos.exception;

public class BusinessException extends Exception {
	
	public BusinessException() {}
	public BusinessException(String message) {super(message);}
	public BusinessException(String message, Throwable cause) {super(message, cause);}
	
	private static final long serialVersionUID = 1L;

}
