package com.SmartReceptAPI.repotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.SmartReceptAPI.entity.RecpExpenses;


@SpringBootTest
public class RecpExpensesTest {
	
	@Test
	 public void isRecpExpensesarewithConstructorInjection() {
		
		Long id = 101L;
		String name = "Deepanshu";
		String startdate = "25/08/2002";
		String enddate = "25/08/2095";
		String currency = "India";
		String comment = "Trip plane";
		
	 RecpExpenses re = new RecpExpenses(id, name,startdate, enddate ,currency,comment);
	 
	 
	 assertNotNull(re);
     assertEquals(id, re.getId(), "ID should match");
     assertEquals(name, re.getName(), "Name should match");
     assertEquals(startdate, re.getStartdate(), "Start date should match");
     assertEquals(enddate, re.getEnddate(), "End date should match");
     assertEquals(currency, re.getCurrency(), "Currency should match");
     assertEquals(comment, re.getComment(), "Comment should match");
	}
	
	
	 @Test
	 public void testRecpExpensesSetters() {
	        // Arrange: Create an instance of RecpExpenses
	        RecpExpenses recpExpenses = new RecpExpenses();

	        // Act: Set values using setters
	        Long id = 2L;
	        String name = "Travel Expenses";
	        String startdate = "2024-12-01";
	        String enddate = "2024-12-05";
	        String currency = "EUR";
	        String comment = "Conference trip";

	        recpExpenses.setId(id);
	        recpExpenses.setName(name);
	        recpExpenses.setStartdate(startdate);
	        recpExpenses.setEnddate(enddate);
	        recpExpenses.setCurrency(currency);
	        recpExpenses.setComment(comment);

	        // Assert: Verify the values using getters
	        assertEquals(id, recpExpenses.getId(), "ID should match after setting");
	        assertEquals(name, recpExpenses.getName(), "Name should match after setting");
	        assertEquals(startdate, recpExpenses.getStartdate(), "Start date should match after setting");
	        assertEquals(enddate, recpExpenses.getEnddate(), "End date should match after setting");
	        assertEquals(currency, recpExpenses.getCurrency(), "Currency should match after setting");
	        assertEquals(comment, recpExpenses.getComment(), "Comment should match after setting");
	    }
}
