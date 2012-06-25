package br.com.impacta.projetofinal.ui.tablemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.impacta.jdbc.model.CargoVO;

public class CargoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private static final Class<?>[] COLUMN_CLASS = { Integer.class,
			String.class };

	private static final String[] COLUMN_NAME = { "Código", "Nome" };

	private List<CargoVO> cargoLista;

	public CargoTableModel() {
		// do nothing
	}

	public CargoTableModel(List<CargoVO> cargoLista) {
		this.cargoLista = cargoLista;
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
		return cargoLista == null ? 0 : cargoLista.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		if (cargoLista == null) {
			return null;
		}

		CargoVO cargo = cargoLista.get(rowIndex);

		switch (columnIndex) {
			case 0:  return cargo.getId();
			case 1:  return cargo.getNome();
			default: return null;
		}
	}

	public List<CargoVO> getCargoLista() {
		return cargoLista;
	}

	public void setCargoLista(List<CargoVO> cargoLista) {
		this.cargoLista = cargoLista;
	}
}
