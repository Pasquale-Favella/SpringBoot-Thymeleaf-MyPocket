package com.expenseapp.expenseapp.model;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class ExpenseMCategory extends AbstractEntity{
	
	@Size(min=3,message="La categoria deve contenere almeno 3 caratteri")
	private String name;
	

	public ExpenseMCategory(@Size(min=3,message="La categoria deve contenere almeno 3 caratteri")String name) {
		
		this.name = name;
	}
	public ExpenseMCategory() {	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return name;
	}

}
