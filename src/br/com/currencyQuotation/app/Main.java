package br.com.currencyQuotation.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

import br.com.currencyQuotation.domain.CotacaoEntity;
import br.com.currencyQuotation.infra.service.FileServiceImpl;

public class Main {

	public static void main(String[] args) {

		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter full file name :");
			String fullFileName = br.readLine();
			
			System.out.print("Enter from :");
			String from = br.readLine();
			
			System.out.print("Enter to :");
			String to = br.readLine();
			
			System.out.print("Enter value :");
			BigDecimal value = BigDecimal.valueOf(Long.parseLong(br.readLine()));
			
			System.out.print("Enter quotation :");
			String quotation = br.readLine();
			
			List<CotacaoEntity> cotacoes = new FileServiceImpl<CotacaoEntity>().read(fullFileName);
			
			BigDecimal currencyQuotation = new QuotationServiceImpl(cotacoes).currencyQuotation(from, to, value, quotation);
			System.out.print("Your quotation is: ".concat(currencyQuotation.toString()));

		} catch (IOException e) {
			System.out.println("Error \n: ".concat(e.getMessage()));
		}
	}

}
