package com.models;

import com.google.code.morphia.annotations.Entity;

@Entity
public class Account extends BaseEntity {
	  private String name;
	  
	    public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
}
