package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class FinanceSearchDTO implements Serializable {
  
  private String firstName;
  private String lastName;
  private Date dateCreated;
  private String accountName;

  
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountName, dateCreated, firstName, lastName);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    FinanceSearchDTO other = (FinanceSearchDTO) obj;
    return Objects.equals(accountName, other.accountName)
        && Objects.equals(dateCreated, other.dateCreated)
        && Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("FinanceSearchDTO [firstName=");
    builder.append(firstName);
    builder.append(", lastName=");
    builder.append(lastName);
    builder.append(", dateCreated=");
    builder.append(dateCreated);
    builder.append(", accountName=");
    builder.append(accountName);
    builder.append("]");
    return builder.toString();
  }
  
  

}
