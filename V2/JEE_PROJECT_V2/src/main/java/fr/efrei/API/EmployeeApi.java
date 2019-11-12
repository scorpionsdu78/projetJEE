/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.API;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hugues
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id")
    , @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName")
    , @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName")
    , @NamedQuery(name = "Employee.findByHomePhone", query = "SELECT e FROM Employee e WHERE e.homePhone = :homePhone")
    , @NamedQuery(name = "Employee.findByCellPhone", query = "SELECT e FROM Employee e WHERE e.cellPhone = :cellPhone")
    , @NamedQuery(name = "Employee.findByWorkPhone", query = "SELECT e FROM Employee e WHERE e.workPhone = :workPhone")
    , @NamedQuery(name = "Employee.findByEMail", query = "SELECT e FROM Employee e WHERE e.eMail = :eMail")
    , @NamedQuery(name = "Employee.findByRue", query = "SELECT e FROM Employee e WHERE e.rue = :rue")
    , @NamedQuery(name = "Employee.findByCodePostal", query = "SELECT e FROM Employee e WHERE e.codePostal = :codePostal")
    , @NamedQuery(name = "Employee.findByVille", query = "SELECT e FROM Employee e WHERE e.ville = :ville")
    , @NamedQuery(name = "Employee.findByComplement", query = "SELECT e FROM Employee e WHERE e.complement = :complement")
    , @NamedQuery(name = "Employee.findByBatiment", query = "SELECT e FROM Employee e WHERE e.batiment = :batiment")})
public class EmployeeApi implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "first_name")
    private String first_name;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name")
    private String last_name;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "home_phone")
    private String home_phone;
    
    @Size(max = 45)
    @Column(name = "cell_phone")
    private String cell_phone;
    
    @Size(max = 45)
    @Column(name = "work_phone")
    private String work_phone;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "e_mail")
    private String email;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rue")
    private String rue;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code_postal")
    private String code_postal;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ville")
    private String ville;
    

    public EmployeeApi()
    {
    }
    
    public EmployeeApi(String first_name, String last_name, String home_phone, String cell_phone, String work_phone, String email, String street, String postal, String city) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.home_phone = home_phone;
        this.cell_phone = cell_phone;
        this.work_phone = work_phone;
        this.rue = street;
        this.code_postal = postal;
        this.ville = work_phone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String firstName) {
        this.first_name = firstName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String lastName) {
        this.last_name = lastName;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public void setHome_phone(String homePhone) {
        this.home_phone = homePhone;
    }

    public String getCell_phone() {
        return cell_phone;
    }

    public void setCell_phone(String cellPhone) {
        this.cell_phone = cellPhone;
    }

    public String getWork_phone() {
        return work_phone;
    }

    public void setWork_phone(String workPhone) {
        this.work_phone = workPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String eMail) {
        this.email = eMail;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeApi)) {
            return false;
        }
        EmployeeApi other = (EmployeeApi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.efrei.API.Employee[ id=" + id + " ]";
    }
    
}