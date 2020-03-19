package com.expenseapp.expenseapp.model;





import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Expense extends AbstractEntity{
	
	
	@NotBlank(message="Il campo non puo essere vuoto!")
	@Size(max=500,message="Descrizione troppo lunga!")
	private String description;
	
	@NotBlank(message="Il campo non puo essere vuoto!")
	@Size(max=50,message="Massimo 50 caratteri!")
	private String location;
	@NumberFormat()
	private Double tot;
	private String expensedate;
	
	@ManyToOne
	@NotNull(message="necessario aggiungere la categoria di spesa")
	private ExpenseMCategory expenseCategory;
	
	public Expense() {}
	
	public Expense(String description, String location,Double tot,ExpenseMCategory expenseCategory,String expensedate) {
		//this();
		this.location=location;
		this.description = description;
		this.tot=tot;
		this.expenseCategory=expenseCategory;
		this.expensedate=expensedate;
		
		
	}
	
	
	public String getExpensedate() {
		return expensedate;
	}
	public void setExpensedate(String expensedate) {
		this.expensedate = expensedate;
	}
	

	public ExpenseMCategory getExpenseCategory() {
		return expenseCategory;
	}

	public void setExpenseCategory(ExpenseMCategory expenseCategory) {
		this.expenseCategory = expenseCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public Double getTot() {
		return tot;
	}

	public void setTot(Double tot) {
		this.tot = tot;
	}

	
	

}
