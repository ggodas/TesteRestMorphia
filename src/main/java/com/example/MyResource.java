package com.example;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.query.Query;
import com.models.*;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ReadPreference;

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
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{codPosto}")
    public List<Abastecimento> getIt(@PathParam("codPosto") String codPosto) {
    	
    	try {
			MongoClient mongo = new MongoClient("128.10.0.112");
			Morphia morphia = new Morphia();
			Datastore datastore = morphia.createDatastore(mongo, "Abast");
			
			morphia
			.map(Abastecimento.class);
	         
		     Address address = new Address();
		     address.setNumber("1661");
		     address.setStreet("Av. Imperatriz Leopoldina");
		     address.setTown("City");
		     address.setPostcode("05305007"); 
		 
		     Account account = new Account();
		     account.setName("Conta Empresarial");
		 
		     List<Account> accounts = new ArrayList<Account>();
		     accounts.add(account);
		     
		     String nome = accounts.get(0).getName(); 
		 
		     Customer customer = new Customer();
		     customer.setAddress(address);
		     customer.setName("Mr Ctf Technologies");
		     customer.setAccounts(accounts);
		     
		     //Key<Customer> savedCustomer = datastore.save(customer);   
			List<Abastecimento> customers = datastore.createQuery(Abastecimento.class).field("fabric").equal(codPosto).limit(100).asList();
			datastore.getMongo().close();

			return customers;
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
      return null;
    	
    }
}
