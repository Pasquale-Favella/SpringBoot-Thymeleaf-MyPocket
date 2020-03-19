package com.expenseapp.expenseapp.controller;





import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.expenseapp.expenseapp.data.ExpenseCategoryRepository;
import com.expenseapp.expenseapp.data.ExpenseRepository;
import com.expenseapp.expenseapp.model.Expense;


@Controller
@RequestMapping("expenses")
public class ExpenseController {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	@Autowired
	private ExpenseCategoryRepository expenseCategoryRepository;
	
	
	@GetMapping
	public String displayAllExpense(Model model) {
		
		model.addAttribute("expenses",expenseRepository.findAll());
		return "expenses/index";
	}
	@GetMapping("create")
	public String renderCreateExpenseForm(Model model) {
		model.addAttribute("title","Create Expense");
		model.addAttribute(new Expense());
		model.addAttribute("categories",expenseCategoryRepository.findAll());
		return "expenses/create";
	}
	@PostMapping("create")
	public String createExpense(@ModelAttribute @Valid Expense newExpense,Errors errors,Model model) {
		if(errors.hasErrors()) {
			model.addAttribute("title","Create expense");
			return "expenses/create";
		}
		expenseRepository.save(newExpense);
		return "redirect:";
	}
	
	@GetMapping("delete")
	public String displayDeleteForm(Model model) {
		model.addAttribute("title","Delete Expense");
		model.addAttribute("expenses",expenseRepository.findAll());
		return "expenses/delete";
	}
	@PostMapping("delete")
	public String processDeleteExpenseForm(@RequestParam(required=false) int[] expenseIds) {
		if(expenseIds!=null) {
			for(int id : expenseIds) {
				expenseRepository.deleteById(id);
			}
		}
		return "redirect:";
	}

}
