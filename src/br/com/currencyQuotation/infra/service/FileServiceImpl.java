package br.com.currencyQuotation.infra.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import br.com.currencyQuotation.domain.exception.FileException;
import br.com.currencyQuotation.domain.factory.CotacaoFactory;
import br.com.currencyQuotation.domain.service.FileService;

public class FileServiceImpl<CotacaoEntity> implements FileService<CotacaoEntity> {

	private BufferedReader bufferedReader;
	private FileReader fileReader;
	private List<CotacaoEntity> cotacoes;

	@SuppressWarnings({ "finally", "unchecked" })
	@Override
	public List<CotacaoEntity> read(String fullFileName) throws IOException {
		try {

			fileReader = new FileReader(fullFileName);
			
			if(fileReader == null){
				new FileException("File not found!");
			}
			
			bufferedReader = new BufferedReader(fileReader);

			String lineFile;
			while ((lineFile = bufferedReader.readLine()) != null) {
				cotacoes.add((CotacaoEntity) new CotacaoFactory().build(lineFile));
			}

		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fullFileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fullFileName + "'");
		} finally {
			bufferedReader.close();
			return cotacoes;
		}
	}
}
