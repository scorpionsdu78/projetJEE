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
public class SB_Employee
{
    @PersistenceContext
    EntityManager em;
    EntityManagerFactory emf;
    
    public List<EmployeeApi> GET()
    {   
        // We manage our Entity Managers
        emf = Persistence.createEntityManagerFactory("se.m1_JEE_PROJECT_V2_war_1.0PU");
        em = emf.createEntityManager();
        
        
        // We do our SQL query
        TypedQuery q = em.createNamedQuery("EmployeeApi.findAll", EmployeeApi.class);
        
        
        // We initialize a list at null, then fill it with the query's results
        List<EmployeeApi> returnList = null;
        returnList = q.getResultList();
        
        
        // If the list is empty, display an error message
        if(returnList == null)
            System.out.println("ERROR IN SB_EMPLOYEE");
        
        
        // Return the list
        return returnList;
    }
    
    
    public EmployeeApi GET(int id){
        
        emf = Persistence.createEntityManagerFactory("se.m1_JEE_PROJECT_V2_war_1.0PU");
        
        em = emf.createEntityManager();
        
        TypedQuery<EmployeeApi> q = em.createNamedQuery("EmployeeApi.findById", EmployeeApi.class);
        
        return q.getResultList().get(0);
    }
    
    
    public void PUT(int id, String last_name, String first_name, String home_pho, String mob_pho, String work_pho, String email, int idadd, String street, String postal, String city){
        EmployeeApi employee = GET(id);
        
        if(last_name != null)
            employee.setLast_name(last_name);

        
        if(first_name != null)
            employee.setFirst_name(first_name);

        
        if(home_pho != null)
            employee.setHome_phone(home_pho);

        
        if(mob_pho != null)
            employee.setCell_phone(mob_pho);

        
        if(work_pho != null)
            employee.setWork_phone(work_pho);

        
        if(email != null)
            employee.setEmail(email);

        
        SB_Adress sb_adress = new SB_Adress();
        sb_adress.PUT(idadd, street, postal, city);
    }    
}