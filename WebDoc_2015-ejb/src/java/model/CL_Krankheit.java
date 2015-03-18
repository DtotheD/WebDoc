/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
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
   @NamedQuery(name = "Krankheit.findAll", query = "SELECT r FROM CL_Krankheit r")
})
public class CL_Krankheit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int max_wert;
    private String iv_beschreibung;
    @ManyToOne
    private CL_Empfehlung empfehlung;
    @ManyToMany
    private ArrayList<CL_Bewertetes_Symptom> symptome;
    
    public CL_Krankheit() {
    
    }
    
    public CL_Krankheit(String name, int max_wert, CL_Empfehlung empfehlung, ArrayList<CL_Bewertetes_Symptom> symptome, String pv_beschreibung) {
        this.name = name;
        this.max_wert = max_wert;
        this.empfehlung = empfehlung;
        this.symptome = symptome;
        iv_beschreibung = pv_beschreibung;
    }

    public void setIv_beschreibung(String iv_beschreibung) {
        this.iv_beschreibung = iv_beschreibung;
    }

    public String getIv_beschreibung() {
        return iv_beschreibung;
    }
    
    public CL_Empfehlung getEmpfehlung() {
        return empfehlung;
    }

    public void setEmpfehlung(CL_Empfehlung empfehlung) {
        this.empfehlung = empfehlung;
    }
    
    public String getName() {
        return name;
    }

    public int getMax_wert() {
        return max_wert;
    }

    public ArrayList<CL_Bewertetes_Symptom> getSymptome() {
        return symptome;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMax_wert(int max_wert) {
        this.max_wert = max_wert;
    }

    public void setSymptome(ArrayList<CL_Bewertetes_Symptom> symptome) {
        this.symptome = symptome;
    }
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof CL_Krankheit)) {
            return false;
        }
        CL_Krankheit other = (CL_Krankheit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CL_Krankheit[ id=" + id + " ]";
    }
    
}
