package com.joshuacodes.moneymanagerclient.controller;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import javax.swing.ComboBoxModel;
import org.junit.jupiter.api.Test;
import com.joshuacodes.moneymanagerclient.controller.AddDeductionViewController;
import com.joshuacodes.moneymanagerclient.model.DeductionTypes;
import com.joshuacodes.moneymanagerclient.view.AddDeductionView;

class AddDeductionViewControllerTest {


  @Test
  void PopulateCombos_OnInstantiation_PopulatedWithDeductionTypes() {
    // Given
    AddDeductionViewController controller = new AddDeductionViewController();

    // When
    ComboBoxModel<DeductionTypes> model = controller.getView().getTypeCombo().getModel();

    // Then
    assertAll(() -> assertTrue(model.getSize() == DeductionTypes.values().length));
  }

  @Test
  void GetView_ViewNotNull_AddDeductionViewReturned() {
    // Given
    AddDeductionViewController controller = new AddDeductionViewController();

    // When
    AddDeductionView view = controller.getView();

    // Then
    assertAll(() -> assertTrue(view != null));
  }

  @Test
  void ClearForm_WithTextEntered_TextCleared() {
    // Given
    AddDeductionViewController controller = new AddDeductionViewController();
    controller.getView().getNameTxt().setText("Test");
    controller.getView().getAmountTxt().setText("456");
    controller.getView().getTypeCombo().setSelectedItem(DeductionTypes.OTHER);

    // when
    controller.clearForm();

    // then
    assertAll(() -> assertEquals("", controller.getView().getNameTxt().getText()),
        () -> assertEquals("", controller.getView().getAmountTxt().getText()),
        () -> assertEquals(null, controller.getView().getTypeCombo().getSelectedItem()));
  }



}
