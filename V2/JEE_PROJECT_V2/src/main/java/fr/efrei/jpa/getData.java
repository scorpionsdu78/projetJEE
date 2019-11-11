/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.jpa;

import fr.efrei.API.EmployeeApi;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author francois
 */
@Stateless
public class getData {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    EntityManager em;
    EntityManagerFactory m;
    
    public List<EmployeeApi> GET(){
        
        m = Persistence.createEntityManagerFactory("se.m1_JEE_PROJECT_V2_war_1.0PU");
        
        em = m.createEntityManager();
        
        TypedQuery<EmployeeApi> q = em.createNamedQuery("EmployeeApi.findAll", EmployeeApi.class);
        
        return q.getResultList();
    }
    
    
    public EmployeeApi GET(int id){
        
        m = Persistence.createEntityManagerFactory("se.m1_JEE_PROJECT_V2_war_1.0PU");
        
        em = m.createEntityManager();
        
        TypedQuery<EmployeeApi> q = em.createNamedQuery("EmployeeApi.findById", EmployeeApi.class);
        
        return q.getResultList().get(0);
    }
    
    
    public void PUT(int id, String last_name, String first_name, String home_pho, String mob_pho, String work_pho, String email, int idadd, String street, String postal, String city){
        EmployeeApi employee = GET(id);
        
        if(last_name != null){
            employee.setLast_name(last_name);
        }
        
        if(first_name != null){
            employee.setLast_name(first_name);
        }
        
        if(home_pho != null){
            employee.setLast_name(home_pho);
        }
        
        if(mob_pho != null){
            employee.setLast_name(mob_pho);
        }
        
        if(work_pho != null){
            employee.setLast_name(work_pho);
        }
        
        if(email != null){
            employee.setLast_name(email);
        }
        
        SB_Adress sb_adress = new SB_Adress();
        sb_adress.PUT(idadd, street, postal, city);
    }    
    
    
}
