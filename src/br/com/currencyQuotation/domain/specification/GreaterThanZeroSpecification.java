package br.com.currencyQuotation.domain.specification;

import java.math.BigDecimal;

import br.com.currencyQuotation.domain.exception.BusinessException;

public class GreaterThanZeroSpecification implements SpecificationBase {

	private static final long serialVersionUID = 1L;

	public void validate(BigDecimal value) {
		if(value.longValue() < 0){
			this.generateExceptionRole("Value less than zero!");
		}
	}

	@Override
	public void generateExceptionRole(String errorMessage) {
		new BusinessException("Value less than zero!");
	}
}
