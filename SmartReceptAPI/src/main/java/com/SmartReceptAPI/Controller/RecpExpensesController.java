package com.SmartReceptAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
		RecpExpenses existingExpense = expenseservice.findById(id);
		if (existingExpense != null) {
			existingExpense.setStartdate(updatedExpense.getStartdate());
			existingExpense.setEnddate(updatedExpense.getEnddate());
			existingExpense.setCurrency(updatedExpense.getCurrency());
			existingExpense.setComment(updatedExpense.getComment());
			existingExpense.setName(updatedExpense.getName());
			RecpExpenses savedExpense = expenseservice.update(existingExpense);
			return ResponseEntity.ok(savedExpense);
		} else {
			return ResponseEntity.ok("You Entered Id is Wrong Please cheaked");
		}
	}
	
	
}
