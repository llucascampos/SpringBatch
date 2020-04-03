package br.com.veiculos.veiculosbatch.models;

import java.util.Date;

public class Veiculo {
	private int	id;
	private String categoria;
	private String marca;
	private String modelo;
	private int ano_fabricacao;
	private int ano_modelo;
	private String chassi;
	private double valor;
	private String placa;
	private int id_proprietario;
	private int id_cliente_vinculado;
	private int id_operacao;
	private int id_acao;
	private Date data_acao;
	
	public Veiculo() {
		
	}

	public Veiculo(int id, String categoria, String marca, String modelo, int ano_fabricacao, int ano_modelo, String chassi,
			double valor, String placa, int id_proprietario, int id_acao, Date data_acao) {
		this.id = id;
		this.categoria = categoria;
		this.marca = marca;
		this.modelo = modelo;
		this.ano_fabricacao = ano_fabricacao;
		this.ano_modelo = ano_modelo;
		this.chassi = chassi;
		this.valor = valor;
		this.placa = placa;
		this.id_proprietario = id_proprietario;
		this.id_acao = id_acao;
		this.data_acao = data_acao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno_fabricacao() {
		return ano_fabricacao;
	}

	public void setAno_fabricacao(int ano_fabricacao) {
		this.ano_fabricacao = ano_fabricacao;
	}

	public int getAno_modelo() {
		return ano_modelo;
	}

	public void setAno_modelo(int ano_modelo) {
		this.ano_modelo = ano_modelo;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getId_proprietario() {
		return id_proprietario;
	}

	public void setId_proprietario(int id_proprietario) {
		this.id_proprietario = id_proprietario;
	}

	public int getId_acao() {
		return id_acao;
	}

	public void setId_acao(int id_acao) {
		this.id_acao = id_acao;
	}

	public Date getData_acao() {
		return data_acao;
	}

	public void setData_acao(Date data_acao) {
		this.data_acao = data_acao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Veiculo other = (Veiculo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getId_cliente_vinculado() {
		return id_cliente_vinculado;
	}

	public void setId_cliente_vinculado(int id_cliente_vinculado) {
		this.id_cliente_vinculado = id_cliente_vinculado;
	}

	public int getId_operacao() {
		return id_operacao;
	}

	public void setId_operacao(int id_operacao) {
		this.id_operacao = id_operacao;
	}

}
