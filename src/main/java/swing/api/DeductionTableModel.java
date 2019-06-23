package swing.api;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class DeductionTableModel extends AbstractTableModel {

	private List<Deduction> deductions;

	private DeductionColumns[] columnNames = DeductionColumns.values();

	public DeductionTableModel() {
		this.deductions = new ArrayList<>();
	}

	public void addDeduction(Deduction deduction) {
		deductions.add(deduction);
		fireTableRowsInserted(deductions.size() - 1, deductions.size() - 1);
	}

	@Override
	public int getRowCount() {
		return deductions.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {

		return columnNames[columnIndex].getDisplayName();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return deductions.get(rowIndex).getName();
		case 1:
			return deductions.get(rowIndex).getType();
		case 2:
			return deductions.get(rowIndex).getAmount();

		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			if (aValue instanceof String) {
				deductions.get(rowIndex).setName((String) aValue);
			}
			
		case 1:
			if(aValue instanceof DeductionType) {
				deductions.get(rowIndex).setType((DeductionType) aValue);
			}
			
		case 2:
			if(aValue instanceof Double) {
				deductions.get(rowIndex).setAmount((Double) aValue);
			}
		}

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}
