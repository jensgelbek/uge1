package facades;

import dtos.RenameMeDTO;
import entities.Employee;
import entities.RenameMe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class FacadeEmployee {

    private static FacadeEmployee instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private FacadeEmployee() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static FacadeEmployee getFacadeEmployee(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeEmployee();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public Employee getEmployeeById(int id){
        EntityManager em = emf.createEntityManager();
        return em.find(Employee.class, id);
    }
    
    public Employee getEmployeeByName(String name){
        EntityManager em = emf.createEntityManager();
        Employee e;
        try{
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.name=:name", Employee.class);
        query.setParameter("name", name);
        return query.getSingleResult();
        }
        finally{
            em.close();
        }
    }
    
    public Employee getEmployeeWithHighestSalary(){
        EntityManager em = emf.createEntityManager();
        int max;
        try{ Query query = em.createQuery("SELECT MAX(e.salary) FROM Employee e");
        max =(int) query.getSingleResult();
            System.out.println(max);
        TypedQuery<Employee> tquery=em.createQuery("SELECT e FROM Employee e WHERE e.salary=:max",Employee.class);
        tquery.setParameter("max", max);
        Employee e=(Employee)tquery.getSingleResult();
        return e;
        }
        finally{
            em.close();
        }
    }
    public List<Employee> getAlleEmployee(){
        EntityManager em = emf.createEntityManager();
        try{
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
        }
        finally{
            em.close();
        }
    }
     public Employee createeEmployee(Employee e){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return  e;
    }
 
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        FacadeEmployee fe = getFacadeEmployee(emf);
        Employee e=new Employee("torben","mosen",19);
        fe.createeEmployee(e);
        Employee e1=new Employee("von And","andeby",152152);
        fe.createeEmployee(e1);

        System.out.println(e);
        System.out.println("fndsghrd");
               
        System.out.println(fe.getEmployeeById(e.getId()));
        System.out.println(fe.getEmployeeByName("torben"));
        System.out.println(fe.getEmployeeWithHighestSalary());
    }

}
