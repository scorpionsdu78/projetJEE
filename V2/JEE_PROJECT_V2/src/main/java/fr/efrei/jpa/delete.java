/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.jpa;

import fr.efrei.API.EmployeeApi;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author francois
 */
@Stateless
public class delete {
    
    @PersistenceContext
    EntityManager em;
    EntityManagerFactory emf;
    
    public void DELETE(int id){
        
        emf = Persistence.createEntityManagerFactory("se.m1_JEE_PROJECT_V2_war_1.0PU");
        em = emf.createEntityManager();
        
        
        
        
        EmployeeApi employee;
        TypedQuery<EmployeeApi> q = em.createNamedQuery("EmployeeApi.findById", EmployeeApi.class);
        q.setParameter("id", id);
        
        // We initialize a list at null, then fill it with the query's results
        List<EmployeeApi> returnList = null;
        returnList = q.getResultList();
        
        
        // If the list is empty, display an error message
        if(returnList == null)
            System.out.println("ERROR IN SB_EMPLOYEE (get by ID)");
        
        
        // We return the FIRST element of the query
        employee= (EmployeeApi)returnList.get(0);        
        if(employee != null){
            System.out.println("\n\n\nemployee a delete: " + employee+"\n\n\n");
        }else{
            System.out.println("\n\n\nunable to get the employee to delete\n\n\n");
        }
        
        em.remove(employee.getAdresses().get(0));
        em.remove(employee);
        
        
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
