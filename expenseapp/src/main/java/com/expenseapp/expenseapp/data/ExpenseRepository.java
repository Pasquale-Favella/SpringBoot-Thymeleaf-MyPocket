package com.expenseapp.expenseapp.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.expenseapp.expenseapp.model.Expense;
@Repository
public interface ExpenseRepository extends CrudRepository<Expense,Integer>{

}
