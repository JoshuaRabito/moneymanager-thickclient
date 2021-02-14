package com.joshuacodes.moneymanagerclient.controller;

import java.beans.PropertyVetoException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;
import com.joshuacodes.moneymanagerclient.view.MainFrame;

@ApplicationScoped
public class MainFrameController {

  private MainFrame mainFrame;

  @Inject
  private LookAndFeelViewController lookAndFeelViewController;

  @Inject
  private DeductionViewController deductionViewController;

  @Inject
  private NetIncomeViewController netIncomeViewController;

  @Inject
  private LoadFinanceController loadFinanceController;

  @Inject
  private SavingsSearchController deductionSearchController;

  private MainFrameController() {}

  public MainFrame initMainFrame() {
    init();
    bindListeners();
    return mainFrame;
  }

  private void init() {
    this.mainFrame = new MainFrame();

  }

  private void bindListeners() {
    mainFrame.getDeductionItem().addActionListener(e -> {
      refreshDesktopPane();
      openView(deductionViewController.getView());
    });

    mainFrame.getNetIncomeItem().addActionListener(e -> {
      refreshDesktopPane();
      openView(netIncomeViewController.getView());
    });

    mainFrame.getLookAndFeelItem().addActionListener(e -> {
      refreshDesktopPane();
      openView(lookAndFeelViewController.getView());
    });

    mainFrame.getLoadItem().addActionListener(e -> {
      refreshDesktopPane();
      openView(loadFinanceController.getView());
    });

    mainFrame.getSearchItem().addActionListener(e -> {
      refreshDesktopPane();
      openView(deductionSearchController.getView());

    });
  }

  private void refreshDesktopPane() {
    mainFrame.getContentPane().removeAll();
    mainFrame.getContentPane().updateUI();
  }

  private void openView(JInternalFrame view) {
    SwingUtilities.invokeLater(() -> {
      mainFrame.getContentPane().add(view);
      view.toFront();
      view.setVisible(true);
      try {
        view.setSelected(true);
      } catch (PropertyVetoException e) {
        e.printStackTrace();
      }
    });
  }

  public void updateComponents() {
    SwingUtilities.updateComponentTreeUI(mainFrame);
  }

}
