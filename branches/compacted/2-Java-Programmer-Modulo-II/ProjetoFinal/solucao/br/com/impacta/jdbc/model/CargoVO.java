package br.com.impacta.jdbc.model;

public class CargoVO {

	/** role_code INTEGER */
	private int id;

	/** role_name VARCHAR(20) */
	private String nome;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return getNome();
	}
}
