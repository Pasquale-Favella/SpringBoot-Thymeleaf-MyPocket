package com.expenseapp.expenseapp.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.expenseapp.expenseapp.model.ExpenseMCategory;

@Repository
public interface ExpenseCategoryRepository extends CrudRepository<ExpenseMCategory,Integer>{

	
}
