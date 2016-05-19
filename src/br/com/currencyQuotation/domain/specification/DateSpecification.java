package br.com.currencyQuotation.domain.specification;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.currencyQuotation.domain.exception.BusinessException;

public class DateSpecification implements SpecificationBase {

	private static final long serialVersionUID = -8331850486596395976L;

	public void validate(Object value) {

		try {
			final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate.parse(value.toString(), formatter);
		} catch (Exception e) {
			new BusinessException("Invalid date!!");
		}
	}
}
