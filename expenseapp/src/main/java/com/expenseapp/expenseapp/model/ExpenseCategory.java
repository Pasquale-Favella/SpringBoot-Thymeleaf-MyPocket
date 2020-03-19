package com.expenseapp.expenseapp.model;

public enum ExpenseCategory {
	VIAGGIO("Viaggio"),
	COMPERE("Compere"),
	LAVORO("Lavoro"),
	CIBO("Cibo"),
	VARIE("Varie");
	
	public String getDisplayCategory() {
		return displayCategory;
	}

	private final String displayCategory;
	
	private ExpenseCategory(String displayCategory) {
		this.displayCategory = displayCategory;
	}


}
