package br.com.currencyQuotation.domain.exception;

public class QuotationException extends BusinessException{

	public QuotationException(String exceptionMessage) {
		super(exceptionMessage);
	}

	private static final long serialVersionUID = 1L;
	
}
