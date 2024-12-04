package com.SmartReceptAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

@Entity
@Table(name = "Recp_Expenses")
public class RecpExpenses {
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "recepexpensesId")
   private Long id;
   private String name;
   private String startdate;
   private String enddate;
   private String currency;
   private String comment;
   
   public RecpExpenses() {
	   
   }
   
   public RecpExpenses(Long id, String name, String startdate, String enddate, String currency, String comment) {
       this.id = id;
       this.name = name;
       this.startdate = startdate;
       this.enddate = enddate;
       this.currency = currency;
       this.comment = comment;
   }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getStartdate() {
	return startdate;
}

public void setStartdate(String startdate) {
	this.startdate = startdate;
}

public String getEnddate() {
	return enddate;
}

public void setEnddate(String enddate) {
	this.enddate = enddate;
}

public String getCurrency() {
	return currency;
}

public void setCurrency(String currency) {
	this.currency = currency;
}

public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}
   

   
}
