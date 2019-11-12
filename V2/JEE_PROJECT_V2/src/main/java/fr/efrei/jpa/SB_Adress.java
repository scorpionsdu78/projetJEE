/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.jpa;

import fr.efrei.API.AdressApi;
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
public class SB_Adress
{
    @PersistenceContext
    private static EntityManager em;
    private static EntityManagerFactory emf;
    
    /** GET all the Adresses from the Database
     * 
     * @return all the Adresses from the Database
     */
    public static List<AdressApi> GET()
    {    
        // We manage our Entity Managers
        emf = Persistence.createEntityManagerFactory("se.m1_JEE_PROJECT_V2_war_1.0PU");
        em = emf.createEntityManager();
        
        
        // We do our SQL query
        TypedQuery q = em.createNamedQuery("AdressApi.findAll", AdressApi.class);
        
        
        // We initialize a list at null, then fill it with the query's results
        List<AdressApi> returnList = null;
        returnList = q.getResultList();
        
        
        // If the list is empty, display an error message
        if(returnList == null)
            System.out.println("ERROR IN SB_ADRESS (get all)");
        
        
        // Return the list
        return returnList;
    }
    
    
    
    
    /** Get  the Adress from the database corresponding to a given ID
     * 
     * @param id ID of the Adress we search
     * @return The Adress from the database corresponding to a given ID
     */
    public static AdressApi GET(int id)
    {
        // We manage our Entity Managers
        emf = Persistence.createEntityManagerFactory("se.m1_JEE_PROJECT_V2_war_1.0PU");
        em = emf.createEntityManager();
        
        
        // We do our SQL query
        TypedQuery<AdressApi> q = em.createNamedQuery("AdressApi.findById", AdressApi.class);
        q.setParameter("id", id);
        
        
        // We initialize a list at null, then fill it with the query's results
        List<AdressApi> returnList = null;
        returnList = q.getResultList();
        
        
        // If the list is empty, display an error message
        if(returnList == null)
            System.out.println("ERROR IN SB_ADRESS (get by ID)");
        
        
        // We return the FIRST element of the query
        return returnList.get(0);
    }
    
    
    
    
    /** Adds a new Adress to the database
     * 
     * @param street his Street
     * @param postal his Postal Code
     * @param city his City
     * @param id_employee the Employee's ID
     * @return The new Adress
     */
    public static AdressApi POST(String street, String postal, String city, int id_employee){
        return new AdressApi(street, postal, city, id_employee);
    }
    
    
    
    
    /** Modifies a given Adress from the database
     * 
     * @param id new ID
     * @param street new Street
     * @param postal new Postal Code
     * @param city new City
     */
    public static void PUT(int id, String street, String postal, String city)
    {
        AdressApi adress = GET(id);
        
        if(street != null)
            adress.setRue(street);

        
        if(postal != null)
            adress.setCode_postal(postal);

        
        if(city != null)
            adress.setVille(city);

    }
    
    
    
        
    /** DELETE the Employee from the database corresponding to a given ID
     * 
     * @param id ID of the Employee we search
     */
    public static void DELETE(int id)
    {
        AdressApi adress = GET(id);
        
        em.remove(adress);
    }
}
