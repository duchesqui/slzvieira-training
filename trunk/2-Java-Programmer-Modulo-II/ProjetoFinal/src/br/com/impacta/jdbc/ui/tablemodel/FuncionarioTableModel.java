package br.com.impacta.jdbc.ui.tablemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.impacta.jdbc.model.Funcionario;

public class FuncionarioTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private static final Class<?>[] COLUMN_CLASS = { Integer.class,
			String.class, Double.class, String.class };

	private static final String[] COLUMN_NAME = { "Matrícula", "Nome",
			"Salário", "Cargo" };

	private List<Funcionario> funcionarioLista;

	public FuncionarioTableModel() {
		// do nothing
	}

	public FuncionarioTableModel(List<Funcionario> funcionarioLista) {
		this.funcionarioLista = funcionarioLista;
	}
	
	public Class<?> getColumnClass(int columnIndex) {
		return COLUMN_CLASS[columnIndex];
	}

	public int getColumnCount() {
		return COLUMN_CLASS.length;
	}

	public String getColumnName(int column) {
		return COLUMN_NAME[column];
	}

	public int getRowCount() {
		return funcionarioLista == null ? 0 : funcionarioLista.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		if (funcionarioLista == null) {
			return null;
		}

		Funcionario funcionario = funcionarioLista.get(rowIndex);

		switch (columnIndex) {
			case 0:  return funcionario.getId();
			case 1:  return funcionario.getNome();
			case 2:  return funcionario.getSalario();
			case 3:  return funcionario.getNomeCargo();
			default: return null;
		}
	}

	public List<Funcionario> getFuncionarioLista() {
		return funcionarioLista;
	}

	public void setFuncionarioLista(List<Funcionario> funcionarioLista) {
		this.funcionarioLista = funcionarioLista;
	}
}
