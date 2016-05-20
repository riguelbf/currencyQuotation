package br.com.currencyQuotation.domain.specification;

import br.com.currencyQuotation.domain.exception.BusinessException;

public class NotNullSpecification implements SpecificationBase {

	private static final long serialVersionUID = -9216880835750785846L;

	public void validate(Object value) {

		if (value == null) {
			this.generateExceptionRole("Value less than zero!");
		}
	}

	@Override
	public void generateExceptionRole(String errorMessage) {
		new BusinessException(errorMessage);

	}
}
