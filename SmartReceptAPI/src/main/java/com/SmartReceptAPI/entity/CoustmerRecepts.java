package com.SmartReceptAPI.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "coustmer_recep")
public class CoustmerRecepts {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long coustmerreceptId;
     private String name;
     private Long price;
     private String currency;
     private String date;
     private String comment;
     private String category;
     private boolean reimbursable;
     private boolean fullpageimage;
     private Long recept_expenses_id;

     public Long getCoustmerreceptId() {
          return coustmerreceptId;
     }

     public void setCoustmerreceptId(Long coustmerreceptId) {
          this.coustmerreceptId = coustmerreceptId;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public Long getPrice() {
          return price;
     }

     public void setPrice(Long price) {
          this.price = price;
     }

     public String getCurrency() {
          return currency;
     }

     public void setCurrency(String currency) {
          this.currency = currency;
     }

     public String getDate() {
          return date;
     }

     public void setDate(String date) {
          this.date = date;
     }

     public String getComment() {
          return comment;
     }

     public void setComment(String comment) {
          this.comment = comment;
     }

     public boolean isReimbursable() {
          return reimbursable;
     }

     public void setReimbursable(boolean reimbursable) {
          this.reimbursable = reimbursable;
     }

     public String getCategory() {
          return category;
     }

     public void setCategory(String category) {
          this.category = category;
     }

     public boolean isFullpageimage() {
          return fullpageimage;
     }

     public void setFullpageimage(boolean fullpageimage) {
          this.fullpageimage = fullpageimage;
     }

     public Long getRecept_expenses_id() {
          return recept_expenses_id;
     }

     public void setRecept_expenses_id(Long recept_expenses_id) {
          this.recept_expenses_id = recept_expenses_id;
     }
}
