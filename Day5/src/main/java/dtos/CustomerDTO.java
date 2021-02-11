/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class CustomerDTO {
   private Long id;
    private String name;
    private String accountNumber;
    private double balance;

    public CustomerDTO(String name,  String accountNumber, double balance) {
        this.name=name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
   
   
    
    public static List<CustomerDTO> getDtos(List<BankCustomer> rms){
        List<CustomerDTO> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new CustomerDTO(rm)));
        return rmdtos;
    }


    public CustomerDTO(BankCustomer bc) {
        this.id = bc.getId();
        this.name = bc.getFirstname()+" "+bc.getLastName();
        this.accountNumber=bc.getAccountNumber();
        this.balance=bc.getBalance();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

   
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" + "id=" + id + ", name=" + name + ", accountNumber=" + accountNumber + ", balance=" + balance + '}';
    }

  
}
