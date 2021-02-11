package facades;

import dtos.CustomerDTO;
import entities.BankCustomer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class BankCustomerFacade {

    private static BankCustomerFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private BankCustomerFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static BankCustomerFacade getBankCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BankCustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public CustomerDTO getCustomerByID (int id){
        EntityManager em = emf.createEntityManager();
        TypedQuery<BankCustomer> query = em.createQuery("SELECT bc FROM BankCustomer bc WHERE bc.id=:id", BankCustomer.class);
        query.setParameter("id",id);
        return new CustomerDTO(query.getSingleResult());
    }
    
    public List<CustomerDTO> getCustomerDTOByName(String name){
        EntityManager em = emf.createEntityManager();
        TypedQuery<BankCustomer> query=em.createQuery("SELECT bc FROM BankCustomer WHERE (lastname=:lastname,firstname=:firstname)",BankCustomer.class);
        String lastname=name.substring(name.indexOf(" ")+1);
        System.out.println(lastname);
        query.setParameter("lastname",lastname);
        String firstname=name.substring(0, name.indexOf(" "));
        query.setParameter("firstname", firstname);
        return CustomerDTO.getDtos(query.getResultList());
              
    }
    
    public BankCustomer addCustomer(BankCustomer bc){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(bc);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return bc;
    }
    
    public List<BankCustomer> getAllBankCustomers(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<BankCustomer> query = em.createQuery("SELECT r FROM BankCustomer r", BankCustomer.class);
        return query.getResultList();
    }
    
    public static void main(String[] args) {
        String name="jens gelbek";
        String lastname=name.substring(name.indexOf(" ")+1);
        System.out.println(lastname);
       // query.setParameter("lastname",lastname);
        String firstname=name.substring(0, name.indexOf(" "));
        System.out.println(firstname);
       //fe.getAll().forEach(dto->System.out.println(dto));
    }

}
