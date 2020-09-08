package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AccountDTO implements Serializable {

  private String accountType;
  private String accountName;
  private List<DeductionDTO> deductions;
  private BigDecimal grossAmount;
  private BigDecimal netAmount;
  private Date dateCreated;
  private Date dateUpdated;

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public List<DeductionDTO> getDeductions() {
    return deductions;
  }

  public void setDeductions(List<DeductionDTO> deductions) {
    this.deductions = deductions;
  }

  public BigDecimal getGrossAmount() {
    return grossAmount;
  }

  public void setGrossAmount(BigDecimal grossAmount) {
    this.grossAmount = grossAmount;
  }

  public BigDecimal getNetAmount() {
    return netAmount;
  }

  public void setNetAmount(BigDecimal netAmount) {
    this.netAmount = netAmount;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Date getDateUpdated() {
    return dateUpdated;
  }

  public void setDateUpdated(Date dateUpdated) {
    this.dateUpdated = dateUpdated;
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountName, accountType, dateCreated, dateUpdated, deductions, grossAmount,
        netAmount);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AccountDTO other = (AccountDTO) obj;
    return Objects.equals(accountName, other.accountName)
        && Objects.equals(accountType, other.accountType)
        && Objects.equals(dateCreated, other.dateCreated)
        && Objects.equals(dateUpdated, other.dateUpdated)
        && Objects.equals(deductions, other.deductions)
        && Objects.equals(grossAmount, other.grossAmount)
        && Objects.equals(netAmount, other.netAmount);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("AccountDTO [accountType=");
    builder.append(accountType);
    builder.append(", accountName=");
    builder.append(accountName);
    builder.append(", deductions=");
    builder.append(deductions);
    builder.append(", grossAmount=");
    builder.append(grossAmount);
    builder.append(", netAmount=");
    builder.append(netAmount);
    builder.append(", dateCreated=");
    builder.append(dateCreated);
    builder.append(", dateUpdated=");
    builder.append(dateUpdated);
    builder.append("]");
    return builder.toString();
  }




}
