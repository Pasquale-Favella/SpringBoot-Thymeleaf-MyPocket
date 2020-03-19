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

import com.expenseapp.expenseapp.data.ExpenseCategoryRepository;

import com.expenseapp.expenseapp.model.ExpenseMCategory;

@Controller
@RequestMapping("category")
public class CategoryController {

	@Autowired
	private ExpenseCategoryRepository expenseCategoryRepository;
	
	@GetMapping
	public String displayAllExpense(Model model) {
		
		model.addAttribute("categories",expenseCategoryRepository.findAll());
		return "category/index";
	}
	@GetMapping("create")
	public String renderCreateCategoryForm(Model model) {
		model.addAttribute("title","Create Category");
		model.addAttribute("category",new ExpenseMCategory());
		
		return "category/create";
	}
	@PostMapping("create")
	public String createCategory(@ModelAttribute @Valid ExpenseMCategory newCategory,Errors errors,Model model) {
		if(errors.hasErrors()) {
			model.addAttribute("title","Create category");
			return "expenses/create";
		}
		expenseCategoryRepository.save(newCategory);
		return "redirect:";
	}
}
