package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class DeductionDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private DeductionTypes type;
	private BigDecimal amount;
	
	
	
	public DeductionDTO() {
		
	}

	public DeductionDTO(String name, DeductionTypes type, BigDecimal amount) {
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

	public DeductionTypes getType() {
		return type;
	}

	public void setType(DeductionTypes type) {
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

  @Override
  public int hashCode() {
    return Objects.hash(amount, name, type);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DeductionDTO other = (DeductionDTO) obj;
    return Objects.equals(amount, other.amount) && Objects.equals(name, other.name)
        && type == other.type;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("DeductionDTO [name=");
    builder.append(name);
    builder.append(", type=");
    builder.append(type);
    builder.append(", amount=");
    builder.append(amount);
    builder.append("]");
    return builder.toString();
  }

	
	
	
	

}
