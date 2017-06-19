package application.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="PEDIDOS")
public class Pedido {

	@Id
	@Column(name = "NR_CONTROLE")
	@JsonFormat
	private Long  nrControle;
	
	@Column (name="DT_REGISTRO")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dtRegistro;
	
	@Column(name="NOME_PRODUTO")
	@JsonFormat
	private String nomeProduto;
	
	@Column(name="VLR_PRODUTO")
	@JsonFormat
	private BigDecimal valorProduto;
	
	@Column(name="QTDE")
	@JsonFormat
	private Integer quantidade;
	
	@Column(name ="ID_CLI")
	@JsonFormat
	private Long idCli;
	
	@Column(name="VLR_TOTAL")
	@JsonFormat
	private BigDecimal valorTotal;

	public Long getNrControle() {
		return nrControle;
	}

	public void setNrControle(Long nrControle) {
		this.nrControle = nrControle;
	}

	public Date getDtRegistro() {
		return dtRegistro;
	}

	public void setDtRegistro(Date localDate) {
		this.dtRegistro = localDate;
	}



	public BigDecimal getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(BigDecimal valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Long getIdCli() {
		return idCli;
	}

	public void setIdCli(Long idCli) {
		this.idCli = idCli;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	@Override
	public String toString() {
		return "Pedido = {"
		+ "numeroControle: " + nrControle
		+ ", dataRegistro: " + dtRegistro
		+ ", nomeProduto: " + nomeProduto
		+ ", valorProduto: " + valorProduto
		+ ", quantidade: " + quantidade
		+ ", clienteID: " + idCli
		+ ", valorTotal: " + valorTotal + "}";
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	
}
