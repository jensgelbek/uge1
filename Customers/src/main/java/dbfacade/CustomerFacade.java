
package dbfacade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class CustomerFacade {
       private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    private CustomerFacade() {}

    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }
    /*
    public Book addBook(String author){
        Book book = new Book(author);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
            return book;
        }finally {
            em.close();
        }
    }
    */
    
            
          
    public Customer findBYID(Long id){
         EntityManager em = emf.createEntityManager();
        try{
            Customer customer = em.find(Customer.class,id);
            System.out.println(customer);
            return customer;
        }finally {
            em.close();
        }
    }/*
    public List<Customer> getByLastName(String name){
         EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Customer> query = em.createQuery("Select customer from Customer customer WHERE customer.lastname Like "+name,Customer.class);
            return query.getResultList();
        }finally {
            em.close();
        }
    }
    */
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");      
    CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
    facade.findBYID(1L);
    //System.out.println(facade.findBYID(1));
    
    
   
    }
}
