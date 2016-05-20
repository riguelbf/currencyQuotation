package br.com.currencyQuotation.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.currencyQuotation.domain.specification.DateSpecification;
import br.com.currencyQuotation.domain.specification.GreaterThanZeroSpecification;
import br.com.currencyQuotation.domain.specification.LengthSpecification;
import br.com.currencyQuotation.domain.specification.NotEmptySpecification;
import br.com.currencyQuotation.domain.specification.NotNullSpecification;

public class CurrencyQuotationEntity extends AggregationRoot {

	private static final long serialVersionUID = 1666606619868645344L;

	private String from;

	private String to;

	private Number value;

	private LocalDate quotation;

	public CurrencyQuotationEntity(String from, String to, Number value, String quotation) {
		setFrom(from);
		setTo(to);
		setValue(value);
		setQuotation(quotation);
	}

	public String getFrom() {
		return from;
	}

	private void setFrom(String from) {
		
		new LengthSpecification().validate(from, 3L);
		new NotEmptySpecification().validate(from);
		new NotNullSpecification().validate(from);
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	private void setTo(String to) {

		new LengthSpecification().validate(from, 3L);
		new NotEmptySpecification().validate(to);
		new NotNullSpecification().validate(to);
		this.to = to;
	}

	public Number getValue() {
		return value;
	}

	private void setValue(Number value) {

		new NotNullSpecification().validate(value);
		new GreaterThanZeroSpecification().validate(new BigDecimal(value.toString()));
		this.value = value;
	}

	public LocalDate getQuotation() {
		return quotation;
	}

	private void setQuotation(String quotation) {

		new NotEmptySpecification().validate(value);
		new NotNullSpecification().validate(value);
		this.quotation = new DateSpecification().validate(quotation);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((quotation == null) ? 0 : quotation.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrencyQuotationEntity other = (CurrencyQuotationEntity) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (quotation == null) {
			if (other.quotation != null)
				return false;
		} else if (!quotation.equals(other.quotation))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
