/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import com.google.gson.Gson;
import entities.Employee;
import facades.FacadeEmployee;
import static facades.FacadeEmployee.getFacadeEmployee;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.New;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
@Path("employee")
public class ApiResource {
 EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();  

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ApiResource
     */
    public ApiResource() {
    }

    /**
     * Retrieves representation of an instance of dto.ApiResource
     * @return an instance of java.lang.String
     */
    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        FacadeEmployee fe = getFacadeEmployee(emf);
        List<Employee> el=fe.getAlleEmployee();
        List<EmployeeDTO> eld=new ArrayList<EmployeeDTO>();
                for(Employee e:el){
                    eld.add(new EmployeeDTO(e));
                }

         return new Gson().toJson(eld);                  
    }

    @Path("/highestpaid")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson2() {
        FacadeEmployee fe = getFacadeEmployee(emf);
        Employee e=fe.getEmployeeWithHighestSalary();
        
         return new Gson().toJson(new EmployeeDTO(e));                  
    }
     @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getFromID(@PathParam("id") int id) {
       FacadeEmployee fe = getFacadeEmployee(emf);
       EmployeeDTO ed=new EmployeeDTO(fe.getEmployeeById(id));
       return new Gson().toJson(ed);
    
    }
    @Path("name/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getFromID(@PathParam("name") String name) {
       FacadeEmployee fe = getFacadeEmployee(emf);
       EmployeeDTO ed=new EmployeeDTO(fe.getEmployeeByName(name));
       return new Gson().toJson(ed);
    
    }
   
    
    
}
