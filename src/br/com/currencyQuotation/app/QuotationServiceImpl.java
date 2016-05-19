package br.com.currencyQuotation.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.currencyQuotation.domain.CotacaoEntity;
import br.com.currencyQuotation.domain.exception.QuotationException;
import br.com.currencyQuotation.domain.predicate.CotacaoPredicate;
import br.com.currencyQuotation.domain.service.QuotationService;

public class QuotationServiceImpl implements QuotationService{

	CotacaoPredicate predicate = new CotacaoPredicate();
	private List<CotacaoEntity> cotacoes;
	
	public QuotationServiceImpl(List<CotacaoEntity> cotacoes){
		this.cotacoes = cotacoes;
	}
	
	@Override
	public BigDecimal currencyQuotation(String from, String to, Number value, String quotation) {
		
		CotacaoEntity quotationFrom = predicate.filterCotacao(this.cotacoes, CotacaoPredicate.containsCurrency(from)).get(0);
		CotacaoEntity quotationTo = predicate.filterCotacao(this.cotacoes, CotacaoPredicate.containsCurrency(to)).get(0);
		
		if(quotationFrom == null || quotationTo == null){
			new QuotationException("Invalid quotations!");
		}
		
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateQuotation = LocalDate.parse(quotation, formatter);
		
		if(predicate.filterCotacao(this.cotacoes, CotacaoPredicate.containsDate(dateQuotation)) == null){
			dateQuotation = getLastQuatation(this.cotacoes, dateQuotation);
			
			if(dateQuotation == null){
				new QuotationException("Quotation of the previous day or of day is not available!");
			}
		}
		
		
		return null;
	}

	private LocalDate getLastQuatation(List<CotacaoEntity> cotacoes2, LocalDate dateQuotation) {
		// TODO Auto-generated method stub
		return null;
	}

}
