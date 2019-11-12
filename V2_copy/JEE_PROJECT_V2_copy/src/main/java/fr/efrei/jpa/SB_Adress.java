/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.jpa;

import fr.efrei.API.AdressApi;
import fr.efrei.API.EmployeeApi;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Wikiful
 */
@Stateless
public class SB_Adress
{
    
    @PersistenceContext(unitName="se.m1_JEE_PROJECT_V2_war_1.0PU")
    private EntityManager em;
    
    
    /** Get all the Adresses from the Database
     * 
     * @return all the Adresses from the Database
     */
    public List<AdressApi> Get()
    {         
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
    public AdressApi Get(int id)
    {
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
     * @return The id of the new Adress
     */
    public Integer Post(String street, String postal, String city, int id_employee){        
        System.out.println("ADRESS POST : HERE1");
        AdressApi adress = new AdressApi(street, postal, city, id_employee);     
        System.out.println("ADRESS POST : HERE2");
        em.persist(adress);  
        
        EmployeeApi employee_parent = em.find(EmployeeApi.class, id_employee);
        employee_parent = em.merge(employee_parent);     
        
        em.flush();
        
        System.out.println("ADRESS POST : HERE3");     
        System.out.println("ADRESS POST : " + adress.getId());
        
        
        return adress.getId();
    }
    
    
    
    
    /** Modifies a given Adress from the database
     * 
     * @param id new ID
     * @param street new Street
     * @param postal new Postal Code
     * @param city new City
     */
    public void Put(int id, String street, String postal, String city)
    {
        AdressApi adress = Get(id);
        
        if(street != null)
            adress.setRue(street);
        
        if(postal != null)
            adress.setCode_postal(postal);
        
        if(city != null)
            adress.setVille(city);
    }
    
    
    
        
    /** Delete the Employee from the database corresponding to a given ID
     * 
     * @param id ID of the Employee we search
     */
    public void Delete(int id)
    {
        AdressApi adress = Get(id);
        
        em.remove(adress);
    }
}
