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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author francois
 */
@Entity
@Table(name = "adress")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdressApi.findAll", query = "SELECT a FROM AdressApi a")
    , @NamedQuery(name = "AdressApi.findById", query = "SELECT a FROM AdressApi a WHERE a.id = :id")
    , @NamedQuery(name = "AdressApi.findById_employee", query = "SELECT a FROM AdressApi a WHERE a.id_employee = :id_employee")})
public class AdressApi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
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
    
    @Size(max = 45)
    @Column(name = "complement")
    private String complement;
    
    @Size(max = 45)
    @Column(name = "batiment")
    private String batiment;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_employee")
    private int id_employee;
    

    public AdressApi() {
    }
    public AdressApi(Integer id) {
        this.id = id;
    }

    public AdressApi(String rue, String code_postal, String ville, int id_employee) {
        this.rue = rue;
        this.code_postal = code_postal;
        this.ville = ville;
        this.id_employee = id_employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
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
        if (!(object instanceof AdressApi)) {
            return false;
        }
        AdressApi other = (AdressApi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.efrei.API.AdressApi[ id=" + id + " ]";
    }
    
}