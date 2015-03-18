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

/**
 *
 * @author DEKREDAV
 */
@Entity
public class CL_Krankheit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iv_id;
    private String iv_beschreibung;
    @ManyToMany
    private ArrayList<CL_Bewertetes_Symptom> io_symptome;
    @ManyToOne
    private CL_Empfehlung io_empfehlung;
    private int iv_max_wert;

    public CL_Krankheit() {
    }

    public CL_Krankheit(String iv_beschreibung, CL_Empfehlung empfehlung, int iv_max_wert) {
        this.iv_beschreibung = iv_beschreibung;
        this.io_empfehlung = empfehlung;
        this.iv_max_wert = iv_max_wert;
    }

    public Long getIv_id() {
        return iv_id;
    }

    public String getIv_beschreibung() {
        return iv_beschreibung;
    }

    public ArrayList<CL_Bewertetes_Symptom> getIo_symptome() {
        return io_symptome;
    }

    public CL_Empfehlung getIo_empfehlung() {
        return io_empfehlung;
    }

    public int getIv_max_wert() {
        return iv_max_wert;
    }

    public void setIv_id(Long iv_id) {
        this.iv_id = iv_id;
    }

    public void setIv_beschreibung(String iv_beschreibung) {
        this.iv_beschreibung = iv_beschreibung;
    }

    public void setIo_symptome(ArrayList<CL_Bewertetes_Symptom> io_symptome) {
        this.io_symptome = io_symptome;
    }

    public void setIo_empfehlung(CL_Empfehlung io_empfehlung) {
        this.io_empfehlung = io_empfehlung;
    }

    public void setIv_max_wert(int iv_max_wert) {
        this.iv_max_wert = iv_max_wert;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iv_id != null ? iv_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CL_Krankheit)) {
            return false;
        }
        CL_Krankheit other = (CL_Krankheit) object;
        if ((this.iv_id == null && other.iv_id != null) || (this.iv_id != null && !this.iv_id.equals(other.iv_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CL_Krankheit[ id=" + iv_id + " ]";
    }
}
