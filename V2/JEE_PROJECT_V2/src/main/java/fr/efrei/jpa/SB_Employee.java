/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.jpa;

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
public class SB_Employee {

    @PersistenceContext
    EntityManager em;
    EntityManagerFactory m;
    
    public List listEmployee(){
        List l=null;
        
        m = Persistence.createEntityManagerFactory("se.m1_JEE_PROJECT_V2_war_1.0PU");
        System.out.println("factory created");
        
        em = m.createEntityManager();
        System.out.println("entity manager created");
        
        Query q = em.createQuery("SELECT e FROM EmployeeApi e");
        System.out.println("query created");
        
        l = q.getResultList();
        System.out.println("result list getted");
        
        if(l == null){
            System.out.println("error");
        }
        
        return l;
    }
    
    
    
}
