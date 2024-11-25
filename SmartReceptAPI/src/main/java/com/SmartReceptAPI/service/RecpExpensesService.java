package com.SmartReceptAPI.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.SmartReceptAPI.entity.RecpExpenses;
import com.SmartReceptAPI.repo.RecpExpensesRepository;

@Service
public class RecpExpensesService{
	
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
//	public boolean deleteExpense(String name) {
//		 if (repo.existsByname(name) {
//	            repo.deleteByname(name);
//	            return true;
//	        }
//	        return false;
//    }
	
	
}