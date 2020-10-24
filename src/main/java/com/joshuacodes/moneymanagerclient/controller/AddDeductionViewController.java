package com.joshuacodes.moneymanagerclient.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.swing.DefaultComboBoxModel;
import com.joshuacodes.moneymanagerclient.api.ViewActions;
import com.joshuacodes.moneymanagerclient.api.ViewableCombo;
import com.joshuacodes.moneymanagerclient.model.DeductionDTO;
import com.joshuacodes.moneymanagerclient.model.DeductionTypes;
import com.joshuacodes.moneymanagerclient.model.DeductionsInMemory;
import com.joshuacodes.moneymanagerclient.validator.AddDeductionViewValidator;
import com.joshuacodes.moneymanagerclient.view.AddDeductionView;

@ApplicationScoped
public class AddDeductionViewController implements ViewableCombo<AddDeductionView>, ViewActions<AddDeductionView>{

  private AddDeductionView view;
  private AddDeductionViewValidator validator;
  
  @Inject
  private DeductionViewController deductionViewController;
  
  @Inject 
  private DeductionsInMemory deductionsInMemory;
  
  public AddDeductionViewController() {
    initView();
    validator = new AddDeductionViewValidator(view);
  }

  private void initView() {
    view = new AddDeductionView();
    view.setVisible(true);
    bindListeners();
    populateCombos();

  }

  @Override
  public void bindListeners() {
    view.getSaveBtn().addActionListener(e -> saveDeduction());
    view.getCloseBtn().addActionListener(e -> close());
    view.getClearBtn().addActionListener(e -> clearForm());
  }

  private void saveDeduction() {
    if (validator.validate(view.getAmountTxt().getText(), view.getNameTxt().getText())) {
      DeductionDTO deduction = buildDeduction();
      deductionViewController.addDeduction(deduction);
      deductionsInMemory.add(deduction);
    }
  }

  private DeductionDTO buildDeduction() {
    DeductionDTO deduction = new DeductionDTO();
    BigDecimal amount = BigDecimal.valueOf(Double.valueOf(view.getAmountTxt().getText()));
    amount = amount.setScale(2, RoundingMode.UNNECESSARY);
    deduction.setAmount(amount);
    deduction.setName(view.getNameTxt().getText());
    deduction.setType(
        DeductionTypes.valueOf(view.getTypeCombo().getModel().getSelectedItem().toString()));
    return deduction;
  }

  @Override  
  public void populateCombos() {
    view.getTypeCombo().setModel(new DefaultComboBoxModel<>(DeductionTypes.values()));

  }

  @Override
  public AddDeductionView getView() {
    return view;
  }

  @Override
  public void clearForm() {
    view.getTypeCombo().setSelectedItem(null);
    view.getNameTxt().setText("");
    view.getAmountTxt().setText("");
  }

  @Override
  public void close() {
    clearForm();
    view.dispose();
  }

  public void loadDeductionInView(DeductionDTO deduction) {
    view.getNameTxt().setText(deduction.getName());
    view.getTypeCombo().setSelectedItem(deduction.getType());
    view.getAmountTxt().setText(deduction.getAmount().toPlainString());
    
  }

}
