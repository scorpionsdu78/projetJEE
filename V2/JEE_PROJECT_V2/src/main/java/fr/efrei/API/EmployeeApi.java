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
 * @author francois
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeApi.findAll", query = "SELECT e FROM EmployeeApi e")
    , @NamedQuery(name = "EmployeeApi.findById", query = "SELECT e FROM EmployeeApi e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeApi.findByFirstName", query = "SELECT e FROM EmployeeApi e WHERE e.first_name = :first_name")
    , @NamedQuery(name = "EmployeeApi.findByLastName", query = "SELECT e FROM EmployeeApi e WHERE e.last_name = :last_name")
    , @NamedQuery(name = "EmployeeApi.findByHomePhone", query = "SELECT e FROM EmployeeApi e WHERE e.home_phone = :home_phone")
    , @NamedQuery(name = "EmployeeApi.findByCellPhone", query = "SELECT e FROM EmployeeApi e WHERE e.cell_phone = :cell_phone")
    , @NamedQuery(name = "EmployeeApi.findByWorkPhone", query = "SELECT e FROM EmployeeApi e WHERE e.work_phone = :work_phone")
    , @NamedQuery(name = "EmployeeApi.findByEMail", query = "SELECT e FROM EmployeeApi e WHERE e.email = :email")
    , @NamedQuery(name = "EmployeeApi.findByRue", query = "SELECT e FROM EmployeeApi e WHERE e.rue = :rue")
    , @NamedQuery(name = "EmployeeApi.findByCodePostal", query = "SELECT e FROM EmployeeApi e WHERE e.code_postal = :code_postal")
    , @NamedQuery(name = "EmployeeApi.findByVille", query = "SELECT e FROM EmployeeApi e WHERE e.ville = :ville")})
public class EmployeeApi implements Serializable {

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

    public EmployeeApi() {
    }

    public EmployeeApi(Integer id) {
        this.id = id;
    }

    public EmployeeApi(Integer id, String first_name, String last_name, String home_phone, String rue, String code_postal, String ville) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.home_phone = home_phone;
        this.rue = rue;
        this.code_postal = code_postal;
        this.ville = ville;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getHomePhone() {
        return home_phone;
    }

    public void setHomePhone(String home_phone) {
        this.home_phone = home_phone;
    }

    public String getCellPhone() {
        return cell_phone;
    }

    public void setCellPhone(String cell_phone) {
        this.cell_phone = cell_phone;
    }

    public String getWorkPhone() {
        return work_phone;
    }

    public void setWorkPhone(String work_phone) {
        this.work_phone = work_phone;
    }

    public String getEMail() {
        return email;
    }

    public void setEMail(String email) {
        this.email = email;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return code_postal;
    }

    public void setCodePostal(String code_postal) {
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
        return "fr.efrei.API.EmployeeApi[ id=" + id + " ]";
    }
    
}
