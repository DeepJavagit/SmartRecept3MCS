package com.SmartReceptAPI.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.SmartReceptAPI.entity.RecpExpenses;
import com.SmartReceptAPI.repo.RecpExpensesRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class RecpExpensesService{
	  @Autowired
	  private  RecpExpensesRepository repo;
	  
	  public RecpExpensesService(RecpExpensesRepository repo) {
	        this.repo = repo;
	    }
	
	public RecpExpenses addExpenses(RecpExpenses expense) {
		  return repo.save(expense);
	}
	
	public List<RecpExpenses> getAllExpenses() {
	        return repo.findAll();
	    }
	  
	public RecpExpenses getExpensesByName(String name) {
		return repo.findByName(name);
	}
	
	public RecpExpenses findById(Long id) {
		 Optional<RecpExpenses> expense = repo.findById(id);
		 return expense.orElse(null);
	}
	
	public boolean deleteExpense(Long id) {
		 if (repo.existsById(id)) {
	            repo.deleteById(id);
	            return true;
	        }
	        return false;
    }
	
	public RecpExpenses update(RecpExpenses expense) {
	    if (!repo.existsById(expense.getId())) {
	        throw new EntityNotFoundException("Expense with ID '" + expense.getId() + "' not found.");
	    }
	    return repo.save(expense); // Will only update if the ID exists
	}
	
	
}