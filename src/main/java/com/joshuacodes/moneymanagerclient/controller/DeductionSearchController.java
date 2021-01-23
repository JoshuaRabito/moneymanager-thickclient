package com.joshuacodes.moneymanagerclient.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.swing.DefaultComboBoxModel;
import com.joshuacodes.moneymanagerclient.api.ViewActions;
import com.joshuacodes.moneymanagerclient.api.ViewableCombo;
import com.joshuacodes.moneymanagerclient.model.DeductionTypes;
import com.joshuacodes.moneymanagerclient.view.DeductionSearchView;

@ApplicationScoped
public class DeductionSearchController
    implements ViewableCombo<DeductionSearchView>, ViewActions<DeductionSearchView> {

  private DeductionSearchView view;



  public DeductionSearchController() {
    initView();
  }

  private void initView() {
    view = new DeductionSearchView();
    view.setVisible(true);
    bindListeners();
    populateCombos();

  }

  @Override
  public void bindListeners() {
    // TODO Auto-generated method stub

  }

  @Override
  public DeductionSearchView getView() {
    return this.view;
  }

  @Override
  public void clearForm() {
    // TODO Auto-generated method stub

  }

  @Override
  public void close() {
    clearForm();
    view.dispose();
  }

  @Override
  public void populateCombos() {
    view.getTypeCombo().setModel(new DefaultComboBoxModel<>(DeductionTypes.values()));
  }

}
