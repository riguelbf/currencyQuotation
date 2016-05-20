package br.com.currencyQuotation.domain.factory;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.currencyQuotation.domain.CotacaoEntity;
import br.com.currencyQuotation.domain.TipoMoeda;
import br.com.currencyQuotation.domain.specification.DateSpecification;

public class CotacaoFactory {

	public CotacaoEntity build(String lineFile){
		
		String[] values = lineFile.split(";");
		
		LocalDate date = new DateSpecification().validate(values[0]);
		
		return new CotacaoEntity(values[1],TipoMoeda.valueOf(values[2]), values[3], new BigDecimal(values[4].replace(',', '.')), new BigDecimal(values[5].replace(',', '.')), new BigDecimal(values[6].replace(',', '.')), new BigDecimal(values[7].replace(',', '.')), date);
	
	}
}
