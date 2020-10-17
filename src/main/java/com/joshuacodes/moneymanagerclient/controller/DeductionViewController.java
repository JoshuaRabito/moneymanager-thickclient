package com.joshuacodes.moneymanagerclient.controller;

import java.beans.PropertyVetoException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import com.joshuacodes.moneymanagerclient.api.DeductionTableModel;
import com.joshuacodes.moneymanagerclient.api.ViewActions;
import com.joshuacodes.moneymanagerclient.model.DeductionDTO;
import com.joshuacodes.moneymanagerclient.model.DeductionsInMemory;
import com.joshuacodes.moneymanagerclient.view.AddDeductionView;
import com.joshuacodes.moneymanagerclient.view.DeductionView;
import com.joshuacodes.moneymanagerclient.view.MainFrame;

@ApplicationScoped
public class DeductionViewController implements ViewActions<DeductionView> {

  private DeductionView view;

  @Inject
  private AddDeductionViewController addDeductionViewController;

  @Inject
  private DeductionsInMemory deductionsInMemory;
  
  

  public DeductionViewController() {
    initView();
  }

  public DeductionViewController(AddDeductionViewController addDeductionViewController,
      DeductionsInMemory deductionsInMemory) {
    super();
    this.addDeductionViewController = addDeductionViewController;
    this.deductionsInMemory = deductionsInMemory;
    initView();
  }

  private void initView() {
    view = new DeductionView();
    view.setVisible(true);
    bindListeners();

  }

  @Override
  public void bindListeners() {
    view.getAddBtn().addActionListener(e -> {
      SwingUtilities.invokeLater(() -> {

        AddDeductionView addView = addDeductionViewController.getView();
        MainFrame.contentPane.add(addView);
        addView.toFront();
        addView.setVisible(true);
        try {
          addView.setSelected(true);
        } catch (PropertyVetoException ex) {
          ex.printStackTrace();
        }

      });
    });

    view.getDeleteBtn().addActionListener(e -> {
      deleteDeduction();
    });

    view.getCloseBtn().addActionListener(e -> close());

    view.getClearBtn().addActionListener(e -> clearForm());

  }

  public void deleteDeduction() {
    DeductionTableModel model = (DeductionTableModel) view.getDeductionsTable().getModel();
    deductionsInMemory.remove(model.getDeduction(view.getDeductionsTable().getSelectedRow()));
    model.removeDeduction(view.getDeductionsTable().getSelectedRow());
  }

  @Override
  public DeductionView getView() {
    deductionsInMemory.getDeductions().stream().forEach(deduction -> addDeduction(deduction));
    return view;
  }

  @Override
  public void clearForm() {
    DeductionTableModel model = (DeductionTableModel) view.getDeductionsTable().getModel();
    model.removeAllDeductions();
    deductionsInMemory.removeAll();
  }

  public void addDeduction(DeductionDTO deduction) {
    DeductionTableModel model = (DeductionTableModel) view.getDeductionsTable().getModel();
    model.addDeduction(deduction);

  }

  @Override
  public void close() {
    view.dispose();

  }

}
