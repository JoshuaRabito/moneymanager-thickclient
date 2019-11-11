package swing.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import model.Deduction;

public class DeductionTableModel extends AbstractTableModel {

	private List<Deduction> deductions;

	private DeductionColumns[] columnNames = DeductionColumns.values();
	private final Class[] columnClass = new Class[] { String.class, DeductionType.class, BigDecimal.class };

	public DeductionTableModel() {
		deductions = new ArrayList<>();
	}

	public DeductionTableModel(List<Deduction> deductions) {
		this.deductions = deductions;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column].getDisplayName();
	}

	@Override
	public int getRowCount() {
		return deductions.size();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		switch (column) {
		case 2:
			return true; // only the amount is editable
		default:
			return false;
		}
	}

	@Override
	public Object getValueAt(int row, int column) {
		Deduction deduction = getDeduction(row);

		switch (column) {
		case 0:
			return deduction.getName();
		case 1:
			return deduction.getType();
		case 2:
			return deduction.getAmount();
		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object value, int row, int column) {
		Deduction deduction = getDeduction(row);

		switch (column) {
		case 0:
			deduction.setName((String) value);
			break;
		case 1:
			deduction.setType((DeductionType) value);
			break;
		case 2:
			deduction.setAmount((BigDecimal) value);
			break;
		}

		fireTableCellUpdated(row, column);
	}

	public Deduction getDeduction(int row) {
		return deductions.get(row);
	}

	public void addDeduction(Deduction deduction) {
		insertDeduction(getRowCount(), deduction);
	}

	public void insertDeduction(int row, Deduction deduction) {
		deductions.add(row, deduction);
		fireTableRowsInserted(row, row);
	}

	public void removeDeduction(int row) {
		deductions.remove(row);
		fireTableRowsDeleted(row, row);
	}

}
