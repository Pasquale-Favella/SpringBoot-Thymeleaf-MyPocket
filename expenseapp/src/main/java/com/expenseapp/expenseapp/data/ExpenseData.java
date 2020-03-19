package com.expenseapp.expenseapp.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.expenseapp.expenseapp.model.Expense;

public class ExpenseData {
	
	/*
	 * CLASSE OBSOLETA LA TENGO PER BELLEZZA*/
	
	private static final Map<Integer,Expense> expenses=new HashMap<>();
	
	public static Collection<Expense> getAll(){
		return expenses.values();
	}
	
	public static Expense getById(int id) {
		return expenses.get(id);
	}
	
	public static void add(Expense expense) {
		expenses.put(expense.getId(),expense);
	}
	
	public static void remove(int id) {
		expenses.remove(id);
	}
	
	public static List<Double> getAllPrice(){
		List <Double> price = new ArrayList<Double>();
		for(Expense tot : expenses.values()){
			price.add(tot.getTot());
		}
		return price;	
	}
	public static List<Date> getAllDates() throws ParseException{
		List <Date> price = new ArrayList<Date>();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");  
		for(Expense date : expenses.values()){
			 Date dat=format.parse(date.getExpensedate());  
			price.add(dat);
		}
		return price;	
	}
	public static List<String> getAllCategory(){
		List <String> price = new ArrayList<String>();
		for(Expense category : expenses.values()){
			//price.add(category.getType().toString().toLowerCase());
		}
		return price;	
	}
	//prove
	@SuppressWarnings("deprecation")
	public static Map<Double,Long>  getDataSpesa() throws ParseException{
		Map <Double,Long> dataspesa = new HashMap<Double,Long>();		
		for(Expense category : expenses.values()){
			 String[] dataf=category.getExpensedate().split("-");
			dataspesa.put(category.getTot(),Date.UTC(Integer.parseInt(dataf[0])-1900, Integer.parseInt(dataf[1])-1, Integer.parseInt(dataf[2]), 0, 0, 0));
		}
		 Map<Double,Long> sortedByDate = dataspesa.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		return sortedByDate;	
	}
	@SuppressWarnings("deprecation")
	public static Map<String,Long>  getCategoryByDate() throws ParseException{
		Map <String,Long> categoriaspesa = new HashMap<String,Long>();
		//SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd"); 
		for(Expense category : expenses.values()){
			// Date dat=format.parse(category.getExpensedate()); 
			 String[] dataf=category.getExpensedate().split("-");
			
			 //categoriaspesa.put(category.getType().toString().toLowerCase(),Date.UTC(Integer.parseInt(dataf[0]), Integer.parseInt(dataf[1]), Integer.parseInt(dataf[2]), 0, 0, 0));
		}
		 Map<String,Long> categorySortedByDate = categoriaspesa.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		return categorySortedByDate;	
	}
	

}
