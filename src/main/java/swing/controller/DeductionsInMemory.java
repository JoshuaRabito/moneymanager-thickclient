package swing.controller;

import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import model.DeductionDTO;

@ApplicationScoped
public class DeductionsInMemory {
	
	private Set<DeductionDTO> deductionsInMemory;

	private DeductionsInMemory() {
		 deductionsInMemory = new HashSet<>();
	}
	
	public void add(DeductionDTO deduction) {
		deductionsInMemory.add(deduction);
	}
	
	public void remove(DeductionDTO deduction) {
		deductionsInMemory.remove(deduction);
	}
	
	public Set<DeductionDTO> getDeductions() {
		//return defensive copy
		Set<DeductionDTO> copiedDeductions = new HashSet<>();
		copiedDeductions.addAll(deductionsInMemory);
		return copiedDeductions;
	}

	public void removeAll() {
		deductionsInMemory = new HashSet<>();
	}


}
