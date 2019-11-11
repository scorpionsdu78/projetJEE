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
import javax.persistence.Query;

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
    
    public List GET()
    {   
        // We manage our Entity Managers
        emf = Persistence.createEntityManagerFactory("se.m1_JEE_PROJECT_V2_war_1.0PU");
        em = emf.createEntityManager();
        
        
        // We do our SQL query
        Query q = em.createNamedQuery("EmployeeApi.findAll", EmployeeApi.class);
        
        
        // We initialize a list at null, then fill it with the query's results
        List returnList = null;
        returnList = q.getResultList();
        
        
        // If the list is empty, display an error message
        if(returnList == null)
            System.out.println("ERROR IN SB_EMPLOYEE");
        
        
        // Return the list
        return returnList;
    }
}