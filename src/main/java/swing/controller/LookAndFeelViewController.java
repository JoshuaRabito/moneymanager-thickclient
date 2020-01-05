package swing.controller;

import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import swing.api.LookAndFeel;
import swing.api.ViewableCombo;
import swing.view.LookAndFeelView;
import swing.view.MainFrame;

public enum LookAndFeelViewController implements ViewableCombo<LookAndFeelView>{
INSTANCE;
	
	private LookAndFeelView view;

	private LookAndFeelViewController() {		
		initView();
		
	}

	private void initView() {
		view = new LookAndFeelView();
		view.setVisible(true);
		bindListeners();
		populateCombos();
		
	}

	@Override
	public void bindListeners() {
		view.getSaveBtn().addActionListener(e -> saveLookAndFeel());
		view.getCloseBtn().addActionListener(e -> close());
		view.getClearBtn().addActionListener(e -> clearForm());
	}

	
	private void saveLookAndFeel() {
		LookAndFeel layout = LookAndFeel.valueOf(view.getLayoutCombo().getModel().getSelectedItem().toString());
		   try {
			UIManager.setLookAndFeel(layout.getLookAndFeel());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void populateCombos() {
		view.getLayoutCombo().setModel(new DefaultComboBoxModel<>(LookAndFeel.values()));
	}

	@Override
	public LookAndFeelView getView() {
		return view;
	}

	@Override
	public void clearForm() {
		view.getLayoutCombo().setSelectedItem(null);
	}

	@Override
	public void close() {
		clearForm();
		MainFrame.contentPane.getDesktopManager().closeFrame(view);	
	}

}
