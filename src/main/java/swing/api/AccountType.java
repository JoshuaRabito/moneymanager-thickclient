package swing.api;

public enum AccountType {
	CHECKING("Checking"),SAVINGS("Savings");
	
	private String type;

	private AccountType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	
	


}
