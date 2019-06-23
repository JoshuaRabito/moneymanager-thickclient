package swing.api;

import java.io.Serializable;

public class Deduction implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private DeductionType type;
	private Double amount;
	
	public Deduction(String name, DeductionType type, Double amount) {
		super();
		this.name = name;
		this.type = type;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DeductionType getType() {
		return type;
	}

	public void setType(DeductionType type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	} 
	
	
	
	

}
