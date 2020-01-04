package swing.controller;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.ListModel;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import model.AccountType;
import model.BookBalanceExport;
import model.Deduction;
import swing.api.BookBalanceRestClient;
import swing.api.ViewableCombo;
import swing.validator.NetIncomeViewValidator;
import swing.view.MainFrame;
import swing.view.NetIncomeView;

public enum NetIncomeViewController implements ViewableCombo<NetIncomeView>{
	INSTANCE;

	private NetIncomeView view;
	private NetIncomeViewValidator validator;

	private NetIncomeViewController() {
		initView();
	}

	private void initView() {
		view = new NetIncomeView();
		validator = new NetIncomeViewValidator(view);
		bindListeners();
		populateCombos();
	}

	@Override
	public void bindListeners() {
		view.getCloseBtn().addActionListener(e -> close());
		view.getClearBtn().addActionListener(e -> clearForm());
		view.getCalcBtn().addActionListener(e -> calculateTotal());
		view.getAddDeductionsBtn().addActionListener(e -> addDeductions());
		view.getSaveBtn().addActionListener(e -> save());
	}


	private void save() {
		//validate net has been calculated
		boolean isValid = validator.validate(view.getGrossAmountTxt().getText(), view.getDeductionList().getModel());
		if(isValid) {
			//build managedFinanceExport
			BookBalanceExport export = buildBookBalanceExport();
			//send data to rest end point for storage
			sendExportToRestEndPoint(export);
		}
		
	}

	private void sendExportToRestEndPoint(BookBalanceExport export) {
		HttpStatus status = BookBalanceRestClient.getInstance().postBookBalance(export);
		System.out.println(status);
		
	}

	private BookBalanceExport buildBookBalanceExport() {
		return BookBalanceExport.ExportBuilder.newInstance().with(exportBuilder -> {
			Set<Deduction> deductions = DeductionsInMemory.INSTANCE.getDeductions();
			JComboBox<AccountType> accountTypeCombo = view.getAccountTypeCombo();
			exportBuilder.setDeductList(Arrays.asList(deductions.toArray(new Deduction[deductions.size()])));
			exportBuilder.setType(accountTypeCombo.getItemAt(accountTypeCombo.getSelectedIndex()));
			exportBuilder.setfName(view.getFirstNameTxt().getText());
			exportBuilder.setlName(view.getLastNameTxt().getText());
			exportBuilder.setGross(BigDecimal.valueOf(Double.valueOf(view.getGrossAmountTxt().getText())));
			exportBuilder.setNet(BigDecimal.valueOf(Double.valueOf(view.getNetAmountText().getText())));
		}).build();
	}

	private void addDeductions() {
		Set<Deduction> deductions = DeductionsInMemory.INSTANCE.getDeductions();
		view.getDeductionList().setListData(deductions.toArray(new Deduction[deductions.size()]));
		
	}

	@Override
	public void clearForm() {
		view.getGrossAmountTxt().setText("");
		view.getAccountTypeCombo().setSelectedItem(null);
		view.getDeductionList().setListData(new Deduction[0]);
	}

	private void calculateTotal() {
		boolean isValid = validator.validate(view.getGrossAmountTxt().getText(), view.getDeductionList().getModel());
		if(isValid) {
			Set<Deduction> deductions = DeductionsInMemory.INSTANCE.getDeductions();
			BigDecimal grossAmount = BigDecimal.valueOf(Double.valueOf(view.getGrossAmountTxt().getText()));
			for (Deduction deduction : deductions) {
				grossAmount = grossAmount.subtract(deduction.getAmount());
			}
			
			view.getNetAmountText().setValue(grossAmount);
		}	
	}

	@Override
	public void populateCombos() {
		view.getAccountTypeCombo().setModel(new DefaultComboBoxModel<>(AccountType.values()));

	}

	@Override
	public NetIncomeView getView() {
		return view;
	}

	@Override
	public void close() {
		clearForm();
		MainFrame.contentPane.getDesktopManager().closeFrame(view);	
	}

}
