package com.joshuacodes.moneymanagerclient.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.math.BigDecimal;
import javax.swing.table.TableModel;
import org.junit.jupiter.api.Test;
import com.joshuacodes.moneymanagerclient.model.DeductionDTO;
import com.joshuacodes.moneymanagerclient.model.DeductionTypes;
import com.joshuacodes.moneymanagerclient.model.DeductionsInMemory;
import com.joshuacodes.moneymanagerclient.view.DeductionView;

class DeductionViewControllerTest {

  @Test
  void GetView_ViewNotNull_DeductionViewReturned() {
    // Given
    DeductionViewController controller = new DeductionViewController();

    // When
    DeductionView view = controller.getView();

    // Then
    assertTrue(view != null);
  }

  @Test
  void ClearForm_WithDeductionsEntered_DeductionsCleared() {
    // Given
    DeductionViewController controller =
        new DeductionViewController(new AddDeductionViewController(), new DeductionsInMemory());
    controller.addDeduction(buildDeduction());

    // when
    controller.clearForm();

    // then
    TableModel model = controller.getView().getDeductionsTable().getModel();
    assertTrue(model.getRowCount() == 0);

  }

  @Test
  void AddDeduction_NewDeduction_ModelContainsOneDeduction() {
    // Given
    DeductionViewController controller =
        new DeductionViewController(new AddDeductionViewController(), new DeductionsInMemory());

    // when
    controller.addDeduction(buildDeduction());


    // then
    TableModel model = controller.getView().getDeductionsTable().getModel();
    assertTrue(model.getRowCount() == 1);
  }

  @Test
  void DeleteDeduction_WithAddedDeduction_ModelContainsZeroDeductions() {
    // Given
    DeductionViewController controller =
        new DeductionViewController(new AddDeductionViewController(), new DeductionsInMemory());

    // when
    controller.addDeduction(buildDeduction());
    controller.getView().getDeductionsTable().selectAll();
    controller.deleteDeduction();


    // then
    TableModel model = controller.getView().getDeductionsTable().getModel();
    assertTrue(model.getRowCount() == 0);
  }

  private DeductionDTO buildDeduction() {
    DeductionDTO dto = new DeductionDTO();
    dto.setName("Test deduction");
    dto.setAmount(BigDecimal.valueOf(10000.00));
    dto.setType(DeductionTypes.SAVINGS);
    return dto;
  }

}
