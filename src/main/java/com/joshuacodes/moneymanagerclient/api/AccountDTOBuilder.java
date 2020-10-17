package com.joshuacodes.moneymanagerclient.api;

import java.math.BigDecimal;
import java.util.List;
import com.joshuacodes.moneymanagerclient.model.AccountDTO;
import com.joshuacodes.moneymanagerclient.model.AccountType;
import com.joshuacodes.moneymanagerclient.model.DeductionDTO;

public final class AccountDTOBuilder {

  private List<DeductionDTO> deductions;
  private AccountType type;
  private String firstName;
  private String lastName;
  private String accountName;
  private BigDecimal gross;
  private BigDecimal net;

  private AccountDTOBuilder() {
   //Use factory method
  }
  
  public static AccountDTOBuilder getInstance() {
    return new AccountDTOBuilder();
  }
  
  public void buildAccountDTO() {
    
  }

  public AccountDTOBuilder setDeductList(final List<DeductionDTO> deductions) {
    this.deductions = deductions;
    return this;
  }

  public AccountDTOBuilder setType(final AccountType accountType) {
    this.type = accountType;
    return this;
  }

  public AccountDTOBuilder setfirstName(final String name) {
    this.firstName = name;
    return this;
  }

  public AccountDTOBuilder setlastName(final String name) {
    this.lastName = name;
    return this;
  }

  public AccountDTOBuilder setAccountName(final String name) {
    this.accountName = name;
    return this;
  }

  public AccountDTOBuilder setGross(BigDecimal gross) {
    this.gross = gross;
    return this;
  }

  public AccountDTOBuilder setNet(BigDecimal net) {
    this.net = net;
    return this;
  }

  public AccountDTO build() {
    AccountDTO accountDTO = new AccountDTO();
    accountDTO.setAccountName(accountName);
    accountDTO.setAccountType(type.getType());
    accountDTO.setDeductions(deductions);
    accountDTO.setFirstName(firstName);
    accountDTO.setGrossAmount(gross);
    accountDTO.setLastName(lastName);
    accountDTO.setNetAmount(net);
    return accountDTO; 
  }




  
  

}
