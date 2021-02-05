/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;
                                
import entity.Animal;
import com.google.gson.Gson;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author PC
 */
@Path("animal_db")
public class AnimaFromDB {
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimaFromDB
     */
    public AnimaFromDB() {
                                                    }

   @Path("/animals")
@GET
@Produces(MediaType.APPLICATION_JSON)
public String getAnimals() {
  EntityManager em = emf.createEntityManager();
  try{
      TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a", Animal.class);
      List<Animal> animals = query.getResultList();
      return new Gson().toJson(animals);
   } finally {
          em.close();
   }
}
    @Path("animalbyid/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimal(@PathParam("id") int id) {
        //Hvis den kaldes med .../animalbyid/2  vil id nu være lig 2.
        //Den værdi kan I så benytte til at slå op i databasen med em.find(
        EntityManager em = emf.createEntityManager();
        Animal animal = em.find(Animal.class, id);
        return new Gson().toJson(animal);
    }
 @Path("animalbytype/{type}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimal(@PathParam("type") String type) {
        //Hvis den kaldes med .../animalbyid/2  vil id nu være lig 2.
        //Den værdi kan I så benytte til at slå op i databasen med em.find(
        EntityManager em = emf.createEntityManager();
  try{
      TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a WHERE a.type=:type", Animal.class);
      
    Animal animal = query.setParameter("type",type).getSingleResult();
      return new Gson().toJson(animal);
   } finally {
          em.close();
  
    }
    }
      @Path("/random_animal")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomAnimal() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a", Animal.class);
            List<Animal> animals = query.getResultList();
            int antal = animals.size();
            int chosen_one = (int) (Math.random() * antal);
            return new Gson().toJson(animals.get(chosen_one));
        } finally {
            em.close();
        }
    }
}
