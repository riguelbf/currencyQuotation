package br.com.currencyQuotation.domain.specification;

import br.com.currencyQuotation.domain.exception.BusinessException;

public class NotEmptySpecification implements SpecificationBase {

	private static final long serialVersionUID = -6611874684561619111L;

	public void validate(Object value) {

		if (((String) value).isEmpty())
			new BusinessException("Value can not be empty!");

	}
}
