package br.com.currencyQuotation.domain.specification;

import br.com.currencyQuotation.domain.exception.BusinessException;

public class NotEmptySpecification implements SpecificationBase {

	private static final long serialVersionUID = -6611874684561619111L;

	public void validate(Object value) {

		if (value.toString().isEmpty()) {
			this.generateExceptionRole("Value can not be empty!");
		}
	}

	@Override
	public void generateExceptionRole(String errorMessage) {
		new BusinessException(errorMessage);

	}
}
