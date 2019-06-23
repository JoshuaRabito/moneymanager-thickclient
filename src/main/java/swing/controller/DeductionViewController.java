package swing.controller;

import swing.view.DeductionView;

public enum DeductionViewController {
	INSTANCE;
	
	private DeductionView view;

	private DeductionViewController() {
		initView();

	}

	private void initView() {
		view = new DeductionView();
		bindListeners();
		populateCombos();
		
	}

	private void bindListeners() {
		// TODO Auto-generated method stub
		
	}

	private void populateCombos() {
		// TODO Auto-generated method stub
		
	}

	public DeductionView getView() {
		return view;
	}
	
	

}
