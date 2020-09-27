package com.joshuacodes.moneymanagerclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DeductionTypes {
  @JsonProperty("Rent")
  RENT,
  @JsonProperty("Medical")
  MEDICAL,
  @JsonProperty("Food")
  FOOD,
  @JsonProperty("Utility")
  UTILITY,
  @JsonProperty("Car")
  CAR,
  @JsonProperty("Other")
  OTHER,
  @JsonProperty("Savings")
  SAVINGS;

}
