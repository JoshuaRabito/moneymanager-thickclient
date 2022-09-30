package com.joshuacodes.moneymanagerclient.model;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class DeductionsInMemory {

  private Set<DeductionDTO> deductions;

  public DeductionsInMemory() {
    deductions = new HashSet<>();
  }

  public void add(DeductionDTO deduction) {
    deductions.add(deduction);
  }

  public void remove(DeductionDTO deduction) {
    deductions.remove(deduction);
  }

  public Set<DeductionDTO> getDeductions() {
    // return defensive copy
    Set<DeductionDTO> copiedDeductions = new HashSet<>();
    copiedDeductions.addAll(deductions);
    return copiedDeductions;
  }

  public void removeAll() {
    deductions = new HashSet<>();
  }


}
