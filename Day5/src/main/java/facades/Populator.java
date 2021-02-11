/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.CustomerDTO;
import entities.BankCustomer;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        System.out.println("lidt");
        BankCustomerFacade fe = BankCustomerFacade.getBankCustomerFacade(emf);
        System.out.println("hertil");
       fe.addCustomer(new BankCustomer("morten","skildpadde","123fdesf",100500,4,"klovn"));
       fe.addCustomer(new BankCustomer("postmand","per","123fdesf",124500,4,"klovn"));
       fe.addCustomer(new BankCustomer("Atiba","H","123fdesf",240500,4,"kongen"));
       fe.addCustomer(new BankCustomer("santa","Klavs","123fdesf",30500,4,"giver gode gaver"));
       
        
    }
    
    public static void main(String[] args) {
        populate();
    }
}
