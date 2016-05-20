package br.com.currencyQuotation.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.currencyQuotation.domain.CotacaoEntity;
import br.com.currencyQuotation.domain.CurrencyQuotationEntity;
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
		
		CurrencyQuotationEntity currencyQuotation = new CurrencyQuotationEntity(from, to, value, quotation);
		
		CotacaoEntity quotationFrom = predicate.filterCotacao(this.cotacoes, CotacaoPredicate.containsCurrency(currencyQuotation.getFrom())).get(0);
		CotacaoEntity quotationTo = predicate.filterCotacao(this.cotacoes, CotacaoPredicate.containsCurrency(currencyQuotation.getTo())).get(0);
		
		if(quotationFrom == null || quotationTo == null){
			new QuotationException("Invalid quotations from and/or to!");
		}
		
		if(predicate.filterCotacao(this.cotacoes, CotacaoPredicate.containsDate(currencyQuotation.getQuotation())) == null){
			CotacaoEntity lastQuotation = getLastQuatation(this.cotacoes, currencyQuotation.getQuotation());
			
			if(lastQuotation == null){
				new QuotationException("Quotation of the previous day or of day is not available!");
			}
		}
		
		
		return null;
	}

	private CotacaoEntity getLastQuatation(List<CotacaoEntity> cotacoes2, LocalDate dateQuotation) {
		// TODO Auto-generated method stub
		return null;
	}

}
