package fr.efrei.jeeproject;

import java.util.ArrayList;


/** This Class is the representation of an Employee
 *
 * @author Eddy
 */
public class Employee
{
    private String first_name;
    private String last_name;
    private String home_phone;
    private String cell_phone;
    private String work_phone;
    private String email;
    private ArrayList<Adress> adresses;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }

    public String getCell_phone() {
        return cell_phone;
    }

    public void setCell_phone(String cell_phone) {
        this.cell_phone = cell_phone;
    }

    public String getWork_phone() {
        return work_phone;
    }

    public void setWork_phone(String work_phone) {
        this.work_phone = work_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setAdresses(ArrayList<Adress> _adress){
        this.adresses = _adress;
    }
    
}
