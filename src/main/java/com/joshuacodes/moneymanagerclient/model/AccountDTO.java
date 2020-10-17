package com.joshuacodes.moneymanagerclient.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AccountDTO implements Serializable {
  
  private Long accountId;
  private UserDto user;
  private String accountType;
  private String accountName;
  private List<DeductionDTO> deductions;
  private BigDecimal grossAmount;
  private BigDecimal netAmount;
  private Date dateCreated;
  private Date dateUpdated;

  
  
  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public UserDto getUser() {
    return user;
  }

  public void setUser(UserDto user) {
    this.user = user;
  }

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
    return Objects.hash(accountId, accountName, accountType, dateCreated, dateUpdated, deductions,
        grossAmount, netAmount, user);
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
    return Objects.equals(accountId, other.accountId)
        && Objects.equals(accountName, other.accountName)
        && Objects.equals(accountType, other.accountType)
        && Objects.equals(dateCreated, other.dateCreated)
        && Objects.equals(dateUpdated, other.dateUpdated)
        && Objects.equals(deductions, other.deductions)
        && Objects.equals(grossAmount, other.grossAmount)
        && Objects.equals(netAmount, other.netAmount) && Objects.equals(user, other.user);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("AccountDTO [accountId=").append(accountId).append(", user=").append(user)
        .append(", accountType=").append(accountType).append(", accountName=").append(accountName)
        .append(", deductions=").append(deductions).append(", grossAmount=").append(grossAmount)
        .append(", netAmount=").append(netAmount).append(", dateCreated=").append(dateCreated)
        .append(", dateUpdated=").append(dateUpdated).append("]");
    return builder.toString();
  }


}
