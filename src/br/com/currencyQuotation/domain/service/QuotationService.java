package br.com.currencyQuotation.domain.service;

import java.math.BigDecimal;

public interface QuotationService {
	public BigDecimal currencyQuotation(String from, String to, Number value, String quotation);
}
