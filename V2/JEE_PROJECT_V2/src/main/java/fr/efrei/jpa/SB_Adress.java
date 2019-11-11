/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.jpa;

import fr.efrei.API.AdressApi;
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
 * @author Wikiful
 */
@Stateless
public class SB_Adress {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    EntityManager em;
    
    public List<AdressApi> GET(){
        
        TypedQuery<AdressApi> q = em.createNamedQuery("AdressApi.findAll", AdressApi.class);
        
        return (ArrayList)q.getResultList();
    }
    
    
    public AdressApi GET(int id){
        
        TypedQuery<AdressApi> q = em.createNamedQuery("AdressApi.findById", AdressApi.class);
        
        return q.getResultList().get(0);
    }
    
    
    public AdressApi POST(String street, String postal, String city, int id_employee){
        return new AdressApi(street, postal, city, id_employee);
    }
    
    
    public void PUT(int id, String street, String postal, String city){
        AdressApi adress = GET(id);
        
        if(street != null)
            adress.setRue(street);

        
        if(postal != null)
            adress.setCode_postal(postal);

        
        if(city != null)
            adress.setVille(city);

    }
}
