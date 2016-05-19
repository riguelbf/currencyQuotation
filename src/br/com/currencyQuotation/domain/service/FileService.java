package br.com.currencyQuotation.domain.service;

import java.io.IOException;
import java.util.List;

public interface FileService<T> {

	public List<T> read(String fullFileName) throws IOException;
	
}
