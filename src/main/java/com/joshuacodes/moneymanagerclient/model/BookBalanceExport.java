package com.joshuacodes.moneymanagerclient.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class BookBalanceExport {

  private String firstName;
  private String lastName;
  private List<DeductionDTO> deductions;
  private BigDecimal netIncome;
  private BigDecimal grossIncome;
  private AccountType accountType;
  private String accountName;



  private BookBalanceExport() {
    // Enforce use of builder
  }


  public static class ExportBuilder {
    private String fName;
    private String lName;
    private List<DeductionDTO> deductList;
    private BigDecimal net;
    private BigDecimal gross;
    private AccountType type;
    private String accountName;


    public ExportBuilder with(Consumer<ExportBuilder> buildFuntion) {
      buildFuntion.accept(this);
      return this;
    }

    public BookBalanceExport build() {
      BookBalanceExport balanceExport = new BookBalanceExport();
      balanceExport.setAccountType(type);
      balanceExport.setGrossIncome(gross);
      balanceExport.setNetIncome(net);
      balanceExport.setDeductions(deductList);
      balanceExport.setLastName(lName);
      balanceExport.setFirstName(fName);
      balanceExport.setAccountName(accountName);
      return balanceExport;
    }

    public ExportBuilder setfName(String fName) {
      this.fName = fName;
      return this;
    }

    public ExportBuilder setlName(String lName) {
      this.lName = lName;
      return this;

    }

    public ExportBuilder setDeductList(List<DeductionDTO> deductList) {
      this.deductList = deductList;
      return this;

    }

    public ExportBuilder setNet(BigDecimal net) {
      this.net = net;
      return this;

    }

    public ExportBuilder setGross(BigDecimal gross) {
      this.gross = gross;
      return this;

    }

    public ExportBuilder setType(AccountType type) {
      this.type = type;
      return this;

    }

    public ExportBuilder setAccountName(String accountName) {
      this.accountName = accountName;
      return this;
    }

  }


  public String getFirstName() {
    return firstName;
  }


  private void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return lastName;
  }


  private void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public List<DeductionDTO> getDeductions() {
    return deductions;
  }


  private void setDeductions(List<DeductionDTO> deductions) {
    this.deductions = deductions;
  }


  public BigDecimal getNetIncome() {
    return netIncome;
  }


  private void setNetIncome(BigDecimal netIncome) {
    this.netIncome = netIncome;
  }


  public BigDecimal getGrossIncome() {
    return grossIncome;
  }


  private void setGrossIncome(BigDecimal grossIncome) {
    this.grossIncome = grossIncome;
  }


  public AccountType getAccountType() {
    return accountType;
  }


  private void setAccountType(AccountType accountType) {
    this.accountType = accountType;
  }

  public String getAccountName() {
    return accountName;
  }
  
  private void setAccountName(String accountName) {
    this.accountName = accountName;
  }


  @Override
  public int hashCode() {
    return Objects.hash(accountName, accountType, deductions, firstName, grossIncome, lastName,
        netIncome);
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    BookBalanceExport other = (BookBalanceExport) obj;
    return Objects.equals(accountName, other.accountName) && accountType == other.accountType
        && Objects.equals(deductions, other.deductions)
        && Objects.equals(firstName, other.firstName)
        && Objects.equals(grossIncome, other.grossIncome)
        && Objects.equals(lastName, other.lastName) && Objects.equals(netIncome, other.netIncome);
  }


  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("BookBalanceExport [firstName=");
    builder.append(firstName);
    builder.append(", lastName=");
    builder.append(lastName);
    builder.append(", deductions=");
    builder.append(deductions);
    builder.append(", netIncome=");
    builder.append(netIncome);
    builder.append(", grossIncome=");
    builder.append(grossIncome);
    builder.append(", accountType=");
    builder.append(accountType);
    builder.append(", accountName=");
    builder.append(accountName);
    builder.append("]");
    return builder.toString();
  }
  
  

}
