/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    private ArrayList<String> io_beschreibung;
    private String iv_name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private ArrayList<CL_Bewertetes_Symptom> io_symptome;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private ArrayList<CL_Empfehlung> io_empfehlungen;

    private int iv_max_wert;

    public CL_Krankheit() {
    }

    public CL_Krankheit(String pv_beschreibung, CL_Empfehlung po_empfehlung, int pv_max_wert) {
        
        io_beschreibung = new ArrayList<>();
        io_beschreibung.add(pv_beschreibung);
        this.io_symptome = new ArrayList<>();
        this.iv_max_wert = pv_max_wert;
        this.io_empfehlungen = new ArrayList<>();
    }

    public CL_Krankheit(String pv_beschreibung, CL_Empfehlung po_empfehlung, int pv_max_wert, String pv_name) {
        io_beschreibung = new ArrayList<>();
        io_beschreibung.add(pv_beschreibung);
        this.iv_name = pv_name;
        this.iv_max_wert = pv_max_wert;
        this.io_symptome = new ArrayList<>();
        this.io_empfehlungen = new ArrayList<>();
        addEmpfehlung(po_empfehlung);
    }

    public CL_Krankheit( int pv_max_wert, String pv_name) {
        io_beschreibung = new ArrayList<>();;
        this.iv_name = pv_name;
        this.iv_max_wert = pv_max_wert;
        this.io_symptome = new ArrayList<>();
        this.io_empfehlungen = new ArrayList<>();
    }

    public void addSymptom(CL_Bewertetes_Symptom po_symptom) {
        if (!getIo_symptome().contains(po_symptom)) {
            getIo_symptome().add(po_symptom);
        }
        if (!po_symptom.getIo_krankheiten().contains(this)) {
            po_symptom.getIo_krankheiten().add(this);
        }
    }

    public void addEmpfehlung(CL_Empfehlung po_empfehlung) {
        if (!getIo_empfehlungen().contains(po_empfehlung)) {
            getIo_empfehlungen().add(po_empfehlung);
        }
        if (!po_empfehlung.getIo_krankheiten().contains(this)) {
            po_empfehlung.getIo_krankheiten().add(this);
        }
    }

    public String getIv_name() {
        return iv_name;
    }

    public void setIv_name(String iv_name) {
        this.iv_name = iv_name;
    }

    public ArrayList<CL_Empfehlung> getIo_empfehlungen() {
        return io_empfehlungen;
    }

    public void setIo_empfehlungen(ArrayList<CL_Empfehlung> io_empfehlungen) {
        this.io_empfehlungen = io_empfehlungen;
    }

    public Long getIv_id() {
        return iv_id;
    }

    public ArrayList<String> getIo_beschreibung() {
        return io_beschreibung;
    }

    public void setIo_beschreibung(ArrayList<String> io_beschreibung) {
        this.io_beschreibung = io_beschreibung;
    }
    
    public void addBeschreibung(String pv_beschreibung) {
        io_beschreibung.add(pv_beschreibung);
    }

    public ArrayList<CL_Bewertetes_Symptom> getIo_symptome() {
        return io_symptome;
    }

    public int getIv_max_wert() {
        return iv_max_wert;
    }

    public void setIv_id(Long iv_id) {
        this.iv_id = iv_id;
    }
 
    public void setIo_symptome(ArrayList<CL_Bewertetes_Symptom> io_symptome) {
        this.io_symptome = io_symptome;
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
