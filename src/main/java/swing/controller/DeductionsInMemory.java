package swing.controller;

import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import model.Deduction;

@ApplicationScoped
public class DeductionsInMemory {
	
	private Set<Deduction> deductionsInMemory;

	private DeductionsInMemory() {
		 deductionsInMemory = new HashSet<>();
	}
	
	public void add(Deduction deduction) {
		deductionsInMemory.add(deduction);
	}
	
	public void remove(Deduction deduction) {
		deductionsInMemory.remove(deduction);
	}
	
	public Set<Deduction> getDeductions() {
		//return defensive copy
		Set<Deduction> copiedDeductions = new HashSet<>();
		copiedDeductions.addAll(deductionsInMemory);
		return copiedDeductions;
	}

	public void removeAll() {
		deductionsInMemory = new HashSet<>();
	}


}
