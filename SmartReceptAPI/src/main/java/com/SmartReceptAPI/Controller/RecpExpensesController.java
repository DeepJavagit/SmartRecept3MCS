package com.SmartReceptAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
}
