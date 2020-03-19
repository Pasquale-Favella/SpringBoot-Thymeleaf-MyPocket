package com.expenseapp.expenseapp.controller;




import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.expenseapp.expenseapp.data.ExpenseRepository;
import com.expenseapp.expenseapp.model.Expense;



@Controller
@RequestMapping("charts")
public class ChartsController {

//	@GetMapping
//	public String displayChart(Model model) {
//		
//		Map<String,Integer> expenses=new LinkedHashMap<>();
//		expenses.put("categoria", 20);
//		expenses.put("categoria", 20);
//		expenses.put("cat", 40);
//		expenses.put("bos", 20);
//		model.addAttribute("expenses",expenses);
//		return "charts/index";
//	}
	@Autowired
	private ExpenseRepository expenseRepository;
	@GetMapping
	public String displayChart(Model model) throws ParseException {

		
		model.addAttribute("expenses",getDataSpesa());
		
		return "charts/index";
	}
	@SuppressWarnings("deprecation")
	public  Map<Double,Long>  getDataSpesa() throws ParseException{
		Map <Double,Long> dataspesa = new HashMap<Double,Long>();		
		for(Expense e : expenseRepository.findAll()){
			 String[] dataf=e.getExpensedate().split("-");
			dataspesa.put(e.getTot(),Date.UTC(Integer.parseInt(dataf[0])-1900, Integer.parseInt(dataf[1])-1, Integer.parseInt(dataf[2]), 0, 0, 0));
		}
		 Map<Double,Long> sortedByDate = dataspesa.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		return sortedByDate;	
	}
}
