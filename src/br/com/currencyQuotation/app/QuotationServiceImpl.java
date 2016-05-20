package br.com.currencyQuotation.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import br.com.currencyQuotation.domain.CotacaoEntity;
import br.com.currencyQuotation.domain.CurrencyQuotationEntity;
import br.com.currencyQuotation.domain.exception.QuotationException;
import br.com.currencyQuotation.domain.predicate.CotacaoPredicate;
import br.com.currencyQuotation.domain.service.QuotationService;

public class QuotationServiceImpl implements QuotationService {

	private List<CotacaoEntity> cotacoes;
	private CurrencyQuotationEntity currencyQuotationEntity;

	public QuotationServiceImpl(List<CotacaoEntity> cotacoes) {
		this.cotacoes = cotacoes;
	}

	@Override
	public BigDecimal currencyQuotation(String from, String to, Number value, String quotation) {

		currencyQuotationEntity = new CurrencyQuotationEntity(from, to, value, quotation);

		ValidateQuotations();

		List<CotacaoEntity> quotationFinded = CotacaoPredicate.filterCotacao(this.cotacoes,
				CotacaoPredicate.containsDate(currencyQuotationEntity.getQuotation()));
		
		if ( quotationFinded.size() <= 0) {
			
			CotacaoEntity lastQuotation = getLastQuatation(this.cotacoes, currencyQuotationEntity.getQuotation());
			
			return lastQuotation.getTaxaCompra().multiply(new BigDecimal(value.toString()));
		}

		return quotationFinded.get(0).getTaxaCompra().multiply(new BigDecimal(value.toString()));
	}

	private void ValidateQuotations() {
		Boolean isValidQuotationFrom = CotacaoPredicate.filterCotacao(this.cotacoes, CotacaoPredicate.containsCurrency(currencyQuotationEntity.getFrom().toUpperCase())).size() > 0;
		Boolean isValidQuotationTo = CotacaoPredicate.filterCotacao(this.cotacoes,CotacaoPredicate.containsCurrency(currencyQuotationEntity.getTo().toUpperCase())).size() > 0;

		if (!isValidQuotationFrom  || !isValidQuotationTo) {
			new QuotationException("Invalid quotations from and/or to!");
		}
	}

	private CotacaoEntity getLastQuatation(List<CotacaoEntity> cotacoes, LocalDate dateQuotation)
			throws NoSuchElementException {

		CotacaoEntity lastQuotation = null;
		
		try {
			LocalDate lastDate = dateQuotation.getDayOfWeek().getValue() == 7L ? dateQuotation.plusDays(-2)
					: dateQuotation.plusDays(-1);

			lastQuotation = CotacaoPredicate.filterCotacao(cotacoes, CotacaoPredicate.containsDate(lastDate))
					.stream().filter(CotacaoPredicate.containsCurrency(currencyQuotationEntity.getTo())).findFirst().get();

		} catch (NoSuchElementException e) {
			new QuotationException("Quotation of the previous day or of day is not available!");
		}

		return lastQuotation;
	}
}
