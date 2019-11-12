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
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author francois
 */
@Stateless
public class SB_Employee
{
    
    @PersistenceContext(unitName="se.m1_JEE_PROJECT_V2_war_1.0PU")
    private EntityManager em;

  
    
    /** Get all the Employees from the Database
     * 
     * @return all the Employees from the Database
     */
    public List<EmployeeApi> Get()
    {       
        // We do our SQL query
        TypedQuery<EmployeeApi> q = em.createNamedQuery("EmployeeApi.findAll", EmployeeApi.class);
        
        
        // We initialize a list at null, then fill it with the query's results
        List<EmployeeApi> returnList = returnList = q.getResultList();
        
        
        // If the list is empty, display an error message
        if(returnList.isEmpty())
            System.out.println("ERROR IN SB_EMPLOYEE (get all)");
        
        
        // Return the list
        return returnList;
    }
    
    
    
        
    /** Get  the Employee from the database corresponding to a given ID
     * 
     * @param id ID of the Employee we search
     * @return The Employee from the database corresponding to a given ID
     */
    public EmployeeApi Get(int id)
    {
        
        // We initialize a list at null, then fill it with the query's results
        EmployeeApi returnEmployee = em.find(EmployeeApi.class, id);   
        
        
        // If the list is empty, display an error message
        if(returnEmployee == null)
            System.out.println("ERROR IN SB_EMPLOYEE (get by ID)");
        
        
        // We return the FIRST element of the query
        return returnEmployee;
    }
    
    
    
    
    /** Adds a new Employee to the database
     * 
     * @param first_name his First name
     * @param last_name his Last name
     * @param home_pho his Home phone
     * @param mob_pho his Mobile phone
     * @param work_pho his Work phone
     * @param email his Email
     * @param rue his Street
     * @param codePostal his Postal Code
     * @param ville his City
     * @return 
     */
    public Integer Post(String first_name, String last_name, String home_pho, String mob_pho, String work_pho, String email, String rue, String codePostal, String ville)
    {
        EmployeeApi employee = new EmployeeApi(first_name, last_name, home_pho, mob_pho, work_pho, email, rue, codePostal, ville);
        em.persist(employee);
        
        employee = em.merge(employee);
        em.flush();
        
        
        System.out.println("EMPLOYEE POST : HERE3");
        System.out.println("EMPLOYEE POST : " + employee.getId());
        
        
        return  employee.getId();
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
     * @param street new Street
     * @param postal new Postal Code
     * @param city new City
     */
    public void Put(int id, String first_name, String last_name, String home_pho, String mob_pho, String work_pho, String email, String street, String postal, String city)
    {
        EmployeeApi employee = Get(id);
        
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
        
        if(street != null)
            employee.setRue(street);
        
        if(postal != null)
            employee.setCode_postal(postal);
        
        if(city != null)
            employee.setVille(city);
    }
    
    
    
    
    public void Delete(int id)
    {
        EmployeeApi emp = em.find(EmployeeApi.class, id);  
        
        em.remove(emp);        
    }
}