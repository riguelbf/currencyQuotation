package br.com.currencyQuotation.domain.specification;

import br.com.currencyQuotation.domain.exception.BusinessException;

public class LengthSpecification implements SpecificationBase {

	private static final long serialVersionUID = 1L;

	public void validate(Object value, Long length) {

		if (((String) value).isEmpty() || ((String) value).length() != length) {
			this.generateExceptionRole("Given more than allowed!");
		}
	}

	@Override
	public void generateExceptionRole(String errorMessage) {
		new BusinessException(errorMessage);
	}
}
