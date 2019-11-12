/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.API;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author francois
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeApi.findAll", query = "SELECT e FROM EmployeeApi e")
    , @NamedQuery(name = "EmployeeApi.findById", query = "SELECT e FROM EmployeeApi e WHERE e.id = :id")})
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
   
    
    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = false,
        fetch = FetchType.EAGER
    )
    @JoinColumn(name="id_employee", referencedColumnName="id")
    private List<AdressApi> adresses = new ArrayList<>(); 
    

    public EmployeeApi() {
    }

    public EmployeeApi(String first_name, String last_name, String home_phone, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.home_phone = home_phone;
        this.email = email;
    }
    
    public EmployeeApi(String first_name, String last_name, String home_phone, String cell_phone, String work_phone, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.home_phone = home_phone;
        this.cell_phone = cell_phone;
        this.work_phone = work_phone;
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

    public List<AdressApi> getAdresses() {
        return adresses;
    }

    public void setAdresses(ArrayList<AdressApi> adresses) {
        this.adresses = adresses;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeApi))
        {
            return false;
        }
        
        EmployeeApi other = (EmployeeApi) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "fr.efrei.API.EmployeeApi[ id=" + id + " ]";
    }
}
