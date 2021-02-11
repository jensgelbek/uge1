/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import dtos.CustomerDTO;
import facades.BankCustomerFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author PC
 */
@Path("bankcustomer")
public class BankCustomerResource {
 EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();  

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ApiResource
     */
    public BankCustomerResource() {
    }

    @Path ("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("id") int id) {
        BankCustomerFacade bf=BankCustomerFacade.getBankCustomerFacade(emf);
         return new Gson().toJson(bf.getCustomerByID(id));   
    }
    
    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll(@PathParam("id") int id) {
        BankCustomerFacade bf=BankCustomerFacade.getBankCustomerFacade(emf);
        return new Gson().toJson(bf.getAllBankCustomers());
    }
}
