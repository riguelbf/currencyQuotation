package br.com.currencyQuotation.domain.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 23966499895075588L;

	public BusinessException(String exceptionMessage) {
		try {
			String fullMessage = "Error: ".concat(exceptionMessage).concat("\n");
			throw new Exception(fullMessage);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
