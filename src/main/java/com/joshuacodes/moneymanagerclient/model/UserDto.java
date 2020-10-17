package com.joshuacodes.moneymanagerclient.model;

import java.util.Objects;

public class UserDto {
  private String firstName;
  private String lastName;

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

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    UserDto other = (UserDto) obj;
    return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("UserDto [firstName=").append(firstName).append(", lastName=").append(lastName)
        .append("]");
    return builder.toString();
  }

}
