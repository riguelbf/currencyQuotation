package br.com.currencyQuotation.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.currencyQuotation.domain.specification.GreaterThanZeroSpecification;
import br.com.currencyQuotation.domain.specification.NotEmptySpecification;
import br.com.currencyQuotation.domain.specification.NotNullSpecification;

public class CotacaoEntity extends AggregationRoot {

	private static final long serialVersionUID = 3931413983358002226L;

	private String codMoeda;
	private TipoMoeda tipo;
	private String moeda;
	private BigDecimal taxaCompra;
	private BigDecimal taxaVenda;
	private BigDecimal paridadeCompra;
	private BigDecimal paridadeVenda;
	private LocalDate dataCotacao;

	public CotacaoEntity(String codMoeda, TipoMoeda tipo, String moeda, BigDecimal taxaCompra, BigDecimal taxaVenda,
			BigDecimal paridadeCompra, BigDecimal paridadeVenda, LocalDate dataCotacao) {

		setCodMoeda(codMoeda);
		setTipo(tipo);
		setMoeda(moeda);
		setTaxaCompra(taxaCompra);
		setTaxaVenda(taxaVenda);
		setParidadeCompra(paridadeCompra);
		setParidadeVenda(paridadeVenda);
		setDataCotacao(dataCotacao);
	}

	
	public LocalDate getDataCotacao() {
		return dataCotacao;
	}


	public void setDataCotacao(LocalDate dataCotacao) {
		this.dataCotacao = dataCotacao;
	}


	public String getCodMoeda() {
		return codMoeda;
	}

	private void setCodMoeda(String codMoeda) {

		new NotEmptySpecification().validate(codMoeda);
		new NotNullSpecification().validate(codMoeda);
		this.codMoeda = codMoeda;
	}

	public TipoMoeda getTipo() {
		return tipo;
	}

	private void setTipo(TipoMoeda tipo) {
		new NotNullSpecification().validate(tipo);
		this.tipo = tipo;
	}

	public String getMoeda() {
		return moeda;
	}

	private void setMoeda(String moeda) {
		new NotEmptySpecification().validate(moeda);
		new NotNullSpecification().validate(moeda);
		this.moeda = moeda;
	}

	public BigDecimal getTaxaCompra() {
		return taxaCompra;
	}

	private void setTaxaCompra(BigDecimal taxaCompra) {
		new GreaterThanZeroSpecification().validate(taxaCompra);
		this.taxaCompra = taxaCompra;
	}

	public BigDecimal getTaxaVenda() {
		return taxaVenda;
	}

	private void setTaxaVenda(BigDecimal taxaVenda) {
		new GreaterThanZeroSpecification().validate(taxaVenda);
		this.taxaVenda = taxaVenda;
	}

	public BigDecimal getParidadeCompra() {
		return paridadeCompra;
	}

	private void setParidadeCompra(BigDecimal paridadeCompra) {
		new GreaterThanZeroSpecification().validate(paridadeCompra);
		this.paridadeCompra = paridadeCompra;
	}

	public BigDecimal getParidadeVenda() {
		return paridadeVenda;
	}

	private void setParidadeVenda(BigDecimal paridadeVenda) {
		new GreaterThanZeroSpecification().validate(paridadeVenda);
		this.paridadeVenda = paridadeVenda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codMoeda == null) ? 0 : codMoeda.hashCode());
		result = prime * result + ((moeda == null) ? 0 : moeda.hashCode());
		result = prime * result + ((paridadeCompra == null) ? 0 : paridadeCompra.hashCode());
		result = prime * result + ((paridadeVenda == null) ? 0 : paridadeVenda.hashCode());
		result = prime * result + ((taxaCompra == null) ? 0 : taxaCompra.hashCode());
		result = prime * result + ((taxaVenda == null) ? 0 : taxaVenda.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		CotacaoEntity other = (CotacaoEntity) obj;
		if (codMoeda == null) {
			if (other.codMoeda != null)
				return false;
		} else if (!codMoeda.equals(other.codMoeda))
			return false;
		if (moeda == null) {
			if (other.moeda != null)
				return false;
		} else if (!moeda.equals(other.moeda))
			return false;
		if (paridadeCompra == null) {
			if (other.paridadeCompra != null)
				return false;
		} else if (!paridadeCompra.equals(other.paridadeCompra))
			return false;
		if (paridadeVenda == null) {
			if (other.paridadeVenda != null)
				return false;
		} else if (!paridadeVenda.equals(other.paridadeVenda))
			return false;
		if (taxaCompra == null) {
			if (other.taxaCompra != null)
				return false;
		} else if (!taxaCompra.equals(other.taxaCompra))
			return false;
		if (taxaVenda == null) {
			if (other.taxaVenda != null)
				return false;
		} else if (!taxaVenda.equals(other.taxaVenda))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
}
