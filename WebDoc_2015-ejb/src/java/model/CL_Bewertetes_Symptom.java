/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author DEZAPTHO
 */
@Entity
@NamedQueries(
        {
            @NamedQuery(name = "Bewertetes_Symptom.findAll", query = "SELECT r FROM CL_Bewertetes_Symptom r")
        })

public class CL_Bewertetes_Symptom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private CL_Symptom symptom;
    private int wert;
    @ManyToMany(mappedBy = "symptome")
    private List<CL_Krankheit> cL_Krankheits;

    public CL_Bewertetes_Symptom() {
    }

    public CL_Bewertetes_Symptom(CL_Symptom symptom, int wert) {
        this.symptom = symptom;
        this.wert = wert;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CL_Symptom getSymptom() {
        return this.symptom;
    }

    public void setSymptom(CL_Symptom sympton) {
        this.symptom = symptom;
    }

    public int getWert() {
        return this.wert;
    }

    public void setWert(int wert) {
        this.wert = wert;
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
        if (!(object instanceof CL_Bewertetes_Symptom)) {
            return false;
        }
        CL_Bewertetes_Symptom other = (CL_Bewertetes_Symptom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CL_Bewertetes_Symptom[ id=" + id + " ]";
    }

}
