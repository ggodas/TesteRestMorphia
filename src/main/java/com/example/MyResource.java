package com.example;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.Morphia;
import com.models.*;
import com.mongodb.Mongo;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Tarefinha getIt() {
    	
    	try {
			Mongo mongo = new Mongo("monaco");
			Morphia morphia = new Morphia();
			Datastore datastore = morphia.createDatastore(mongo, "morphia");
			
			morphia
			.map(Account.class);
	         
		     Address address = new Address();
		     address.setNumber("81");
		     address.setStreet("Mongo Street");
		     address.setTown("City");
		     address.setPostcode("CT81 1DB"); 
		 
		     Account account = new Account();
		     account.setName("Personal Account");
		 
		     List<Account> accounts = new ArrayList<Account>();
		     accounts.add(account); 
		 
		     Customer customer = new Customer();
		     customer.setAddress(address);
		     customer.setName("Mr Bank Customer");
		     customer.setAccounts(accounts);
		     
		     Key<Customer> savedCustomer = datastore.save(customer);   
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        Tarefinha tarefinha = new Tarefinha();

        tarefinha.setId(1);
        tarefinha.setDescricao("Minha primeira tarefinha");
        return tarefinha;
    	
    }
}
