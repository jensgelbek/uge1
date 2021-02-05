package tester;

import entity.Employee;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
      try {
            em.getTransaction().begin();
            em.persist(new Employee("xa12tt", "Kurt", "Wonnegut", new BigDecimal(335567)));
            em.persist(new Employee("hyu654", "Hanne", "Olsen", new BigDecimal(435867)));
            em.persist(new Employee("uio876", "Jan", "Olsen", new BigDecimal(411567)));
            em.persist(new Employee("klo999", "Irene", "Petersen", new BigDecimal(33567)));
            em.persist(new Employee("jik666", "Tian", "Wonnegut", new BigDecimal(56567)));
            em.getTransaction().commit();
            
            //Complete all these small tasks. Your will find the solution to all, but the last,
            //In this document: https://en.wikibooks.org/wiki/Java_Persistence/JPQL#JPQL_supported_functions
            
            //1) Create a query to fetch all employees with a salary > 100000 and print out all the salaries
            Query query = em.createQuery("Select e FROM Employee e WHERE e.salary > 100000");
            List<Employee> result = query.getResultList();
            for(Employee e:result){
                System.out.println(e);
            }
            //2) Create a query to fetch the employee with the id "klo999" and print out the firstname
            System.out.println(em.find(Employee.class, "klo999").getFirstName());
            //3) Create a query to fetch the highest salary and print the value
           query = em.createQuery("Select MAX(e.salary) FROM Employee e");
           System.out.println(query.getSingleResult());
            //4) Create a query to fetch the firstName of all Employees and print the names
            query = em.createQuery("Select e.firstName FROM Employee e");
            List<String> fornavne = query.getResultList();
            for(String fn:fornavne){
                System.out.println(fn);
                   
            }

            //5 Create a query to calculate the number of employees and print the number
            query = em.createQuery("Select COUNT (e) FROM Employee e");
            System.out.println("antal ansatet: "+query.getSingleResult());
            //6 Create a query to fetch the Employee with the higest salary and print all his details
            query = em.createQuery("Select MAX(e.salary) FROM Employee e");
            BigDecimal max=(BigDecimal) query.getSingleResult();
            query = em.createQuery("Select e FROM Employee e WHERE e.salary=:max");
            query.setParameter("max", max);
            Employee e=(Employee) query.getSingleResult();
            System.out.println(e.getId()+" "+e.getFirstName()+ " "+ e.getLastName()+" "+e.getSalary());
        } finally {
            em.close();
            emf.close();
        }
    }

}
