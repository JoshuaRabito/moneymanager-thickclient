package swing.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.DeductionDTO;
import model.DeductionTypes;

public class DeductionTableModel extends AbstractTableModel {

  private List<DeductionDTO> deductions;

  private DeductionColumns[] columnNames = DeductionColumns.values();
  private final Class[] columnClass =
      new Class[] {String.class, DeductionTypes.class, BigDecimal.class};

  public DeductionTableModel() {
    deductions = new ArrayList<>();
  }

  public DeductionTableModel(List<DeductionDTO> deductions) {
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
    return column == 2;

  }

  @Override
  public Object getValueAt(int row, int column) {
    DeductionDTO deduction = getDeduction(row);

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
    DeductionDTO deduction = getDeduction(row);

    switch (column) {
      case 0:
        deduction.setName((String) value);
        break;
      case 1:
        deduction.setType((DeductionTypes) value);
        break;
      case 2:
        deduction.setAmount((BigDecimal) value);
        break;
    }

    fireTableCellUpdated(row, column);
  }

  public DeductionDTO getDeduction(int row) {
    return deductions.get(row);
  }

  public void addDeduction(DeductionDTO deduction) {
    insertDeduction(getRowCount(), deduction);
  }

  public void addDeductions(List<DeductionDTO> deductions) {
    for (DeductionDTO deduction : deductions) {
      insertDeduction(getRowCount(), deduction);
    }
  }

  public void insertDeduction(int row, DeductionDTO deduction) {
    deductions.add(row, deduction);
    fireTableRowsInserted(row, row);
  }

  public void removeDeduction(int row) {
    deductions.remove(row);
    fireTableRowsDeleted(row, row);
  }

  public void removeAllDeductions() {

    for (int i = deductions.size() - 1; i >= 0; i--) {
      deductions.remove(i);
      fireTableRowsDeleted(i, i);
    }


  }

}
