package com.SmartReceptAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SmartReceptAPI.entity.RecpExpenses;
import com.SmartReceptAPI.service.RecpExpensesService;

@RestController
@RequestMapping("/api/expenses")
public class RecpExpensesController {
     
	@Autowired
	private RecpExpensesService expenseservice;
	
	   public RecpExpensesController(RecpExpensesService expenseservice) {
	        this.expenseservice = expenseservice;
	    }
	
	
	@PostMapping
	public ResponseEntity<RecpExpenses> addExpenses(@RequestBody RecpExpenses expens){
		 return ResponseEntity.ok(expenseservice.addExpenses(expens));
	}
	
	@GetMapping
    public ResponseEntity<List<RecpExpenses>> getAllExpenses() {
        List<RecpExpenses> expenses = expenseservice.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }
	
	 @GetMapping("/{name}")
	    public ResponseEntity<?> getExpenseByName(@PathVariable String name) {
	        RecpExpenses expense = expenseservice.getExpensesByName(name);
	        if (expense != null) {
	            return ResponseEntity.ok(expense);
	        } else { 
	        	 return ResponseEntity.ok("Name is Not found or check the Name");
	        }
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<String> deleteByName(@PathVariable  Long id){
		 boolean response = expenseservice.deleteExpense(id);
		 if(response) {
			 return ResponseEntity.ok("Expenses Deleted Succesfully");
		 }
		 return ResponseEntity.ok("Id is not present please check it");
	 }	
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<?> updateExpenseById(@PathVariable Long id, @RequestBody RecpExpenses updatedExpense) {
	     // Find the expense by ID
	     RecpExpenses existingExpense = expenseservice.findById(id);
	     // If the expense exists, update it
	     if (existingExpense != null) {
	         existingExpense.setStartdate(updatedExpense.getStartdate());
	         existingExpense.setEnddate(updatedExpense.getEnddate());
	         existingExpense.setCurrency(updatedExpense.getCurrency());
	         existingExpense.setComment(updatedExpense.getComment());
	         existingExpense.setName(updatedExpense.getName()); // Allowing name change

	         // Save the updated entity
	         RecpExpenses savedExpense = expenseservice.update(existingExpense); // Use an update-specific method
	         return ResponseEntity.ok(savedExpense);
	     } else {
	         // If the expense doesn't exist, return 404 with a custom message
	         return ResponseEntity.ok("You Entered Id is Wrong Please cheaked");
	     }
	 }
	 
	 
}
