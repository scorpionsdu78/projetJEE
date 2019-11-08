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
@Table(name = "adress")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adress.findAll", query = "SELECT a FROM Adress a")
    , @NamedQuery(name = "Adress.findById", query = "SELECT a FROM Adress a WHERE a.id = :id")
    , @NamedQuery(name = "Adress.findByRue", query = "SELECT a FROM Adress a WHERE a.rue = :rue")
    , @NamedQuery(name = "Adress.findByCodePostal", query = "SELECT a FROM Adress a WHERE a.codePostal = :codePostal")
    , @NamedQuery(name = "Adress.findByVille", query = "SELECT a FROM Adress a WHERE a.ville = :ville")
    , @NamedQuery(name = "Adress.findByComplement", query = "SELECT a FROM Adress a WHERE a.complement = :complement")
    , @NamedQuery(name = "Adress.findByBatiment", query = "SELECT a FROM Adress a WHERE a.batiment = :batiment")
    , @NamedQuery(name = "Adress.findByIdEmployee", query = "SELECT a FROM Adress a WHERE a.idEmployee = :idEmployee")})
public class Adress implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_employee")
    private int idEmployee;

    public Adress() {
    }

    public Adress(Integer id) {
        this.id = id;
    }

    public Adress(Integer id, String rue, String codePostal, String ville, int idEmployee) {
        this.id = id;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.idEmployee = idEmployee;
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

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
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

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
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
        if (!(object instanceof Adress)) {
            return false;
        }
        Adress other = (Adress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.efrei.API.Adress[ id=" + id + " ]";
    }
    
}
