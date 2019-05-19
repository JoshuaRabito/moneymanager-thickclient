package swing.controller;

import javax.swing.DefaultComboBoxModel;

import swing.api.AccountType;
import swing.view.MainView;

public enum MainViewController {
	INSTANCE;
	
	private MainView view;

	private MainViewController() {
		initView();
		
	}

	private void initView() {
		view = new MainView();	
		populateCombos();
	}
	
	private void populateCombos() {
		if (view != null) {
			view.getAccountTypeCombo().setModel(new DefaultComboBoxModel<>(AccountType.values()));
		}
		
	}
	
	public MainView getView() {
		return view;
	}

}
