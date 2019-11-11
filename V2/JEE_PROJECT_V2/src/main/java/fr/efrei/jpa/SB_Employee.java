/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.jpa;

import fr.efrei.API.AdressApi;
import fr.efrei.API.EmployeeApi;
import java.util.ArrayList;
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
    
    /** GET all the Employees from the Database
     * 
     * @return all the Employees from the Database
     */
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
            System.out.println("ERROR IN SB_EMPLOYEE (get all)");
        
        
        // Return the list
        return returnList;
    }
    
    
    
        
    /** Get  the Employee from the database corresponding to a given ID
     * 
     * @param id ID of the Employee we search
     * @return The Employee from the database corresponding to a given ID
     */
    public EmployeeApi GET(int id)
    {
        // We manage our Entity Managers
        emf = Persistence.createEntityManagerFactory("se.m1_JEE_PROJECT_V2_war_1.0PU");
        em = emf.createEntityManager();
        
        
        // We do our SQL query
        TypedQuery<EmployeeApi> q = em.createNamedQuery("EmployeeApi.findById", EmployeeApi.class);
        
        
        // We initialize a list at null, then fill it with the query's results
        List<EmployeeApi> returnList = null;
        returnList = q.getResultList();
        
        
        // If the list is empty, display an error message
        if(returnList == null)
            System.out.println("ERROR IN SB_EMPLOYEE (get by ID)");
        
        
        // We return the FIRST element of the query
        return returnList.get(0);
    }
    
    
    
    
    /** Adds a new Employee to the database
     * 
     * @param first_name his First name
     * @param last_name his Last name
     * @param home_pho his Home phone
     * @param mob_pho his Mobile phone
     * @param work_pho his Work phone
     * @param email his Email
     * 
     * @return the new Employee
     */
    public EmployeeApi POST(String first_name, String last_name, String home_pho, String mob_pho, String work_pho, String email){
        return new EmployeeApi(first_name, last_name, home_pho, mob_pho, work_pho, email);
    }
    
    
    
    
    /** Modifies a given Employee from the database
     * 
     * @param id ID of the Employee we want to modify
     * @param first_name new First name
     * @param last_name new Last name
     * @param home_pho new Home phone
     * @param mob_pho new Mobile phone
     * @param work_pho new Work phone
     * @param email new Email
     */
    public void PUT(int id, String first_name, String last_name, String home_pho, String mob_pho, String work_pho, String email)
    {
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
        
    }
    
    
}