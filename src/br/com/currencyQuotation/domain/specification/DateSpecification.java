package br.com.currencyQuotation.domain.specification;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.currencyQuotation.domain.exception.BusinessException;

public class DateSpecification implements SpecificationBase {

	private static final long serialVersionUID = -8331850486596395976L;

	public LocalDate validate(Object value) {

		LocalDate date = null;
		try {
			final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			date = LocalDate.parse(value.toString(), formatter);
		} catch (Exception e) {
			this.generateExceptionRole("Invalid date!!");
		}
		return date;
	}

	@Override
	public void generateExceptionRole(String errorMessage) {
		new BusinessException(errorMessage);
	}
}
