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
    private String firstName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name")
    private String lastName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "home_phone")
    private String homePhone;
    
    @Size(max = 45)
    @Column(name = "cell_phone")
    private String cellPhone;
    
    @Size(max = 45)
    @Column(name = "work_phone")
    private String workPhone;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "e_mail")
    private String eMail;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rue")
    private String rue;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code_postal")
    private String codePostal;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ville")
    private String ville;
    
    @Size(max = 45)
    @Column(name = "complement")
    private String complement;
    
    @Size(max = 45)
    @Column(name = "batiment")
    private String batiment;

    public EmployeeApi()
    {
    }

    public EmployeeApi(String firstName, String lastName, String homePhone, String cellPhone, String workPhone, String eMail, String rue, String codePostal, String ville)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.cellPhone = cellPhone;
        this.workPhone = workPhone;
        this.eMail = eMail;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String firstName) {
        this.firstName = firstName;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String lastName) {
        this.lastName = lastName;
    }

    public String getHome_phone() {
        return homePhone;
    }

    public void setHome_phone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCell_phone() {
        return cellPhone;
    }

    public void setCell_phone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getWork_phone() {
        return workPhone;
    }

    public void setWork_phone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getEmail() {
        return eMail;
    }

    public void setEmail(String eMail) {
        this.eMail = eMail;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCode_postal() {
        return codePostal;
    }

    public void setCode_postal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getBatiment() {
        return batiment;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
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
