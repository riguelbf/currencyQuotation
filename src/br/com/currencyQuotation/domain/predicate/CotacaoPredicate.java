package br.com.currencyQuotation.domain.predicate;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import br.com.currencyQuotation.domain.CotacaoEntity;

public class CotacaoPredicate {

	public static Predicate<CotacaoEntity> containsDate(LocalDate date) {
		return c -> c.getDataCotacao().equals(date);
	}
	
	public static Predicate<CotacaoEntity> containsCurrency(String currency) {
		return c -> c.getMoeda().equals(currency);
	}

	public List<CotacaoEntity> filterCotacao(List<CotacaoEntity> cotacoes, Predicate<CotacaoEntity> predicate) {
		return cotacoes.stream().filter(predicate).collect(Collectors.<CotacaoEntity> toList());
	}
}
