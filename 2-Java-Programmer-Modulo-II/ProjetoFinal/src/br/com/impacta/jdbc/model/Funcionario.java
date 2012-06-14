package br.com.impacta.jdbc.model;

public class Funcionario {

	/** func_code INTEGER */
	private int id;

	/** func_name VARCHAR(30) */
	private String nome;

	/** func_rmnt_val DOUBLE */
	private double salario;

	/** role_code INTEGER */
	private int idCargo;
	
	/** role_name VARCHAR(20) */
	private String nomeCargo;

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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}
}
