package com.joshuacodes.moneymanagerclient.api;

public enum DeductionColumns {

	NAME("Name"), TYPE("Type"), AMOUNT("Amount");

	private String displayName;

	private DeductionColumns(String columnName) {
		this.displayName = columnName;
	}
	
	public String getDisplayName() {
		return displayName;
	}

}
