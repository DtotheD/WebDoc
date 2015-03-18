/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zwischenspeicher;

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
import model.CL_Symptom;

/**
 *
 * @author DEZAPTHO
 */

@NamedQueries(
        {
            @NamedQuery(name = "Bewertetes_Symptom.findBySymptomList", query = "SELECT r FROM CL_Bewertetes_Symptom r WHERE r.symptom IN (:po_Symptome) ")
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
    private List<CL_Krankheit> CL_Krankheits;

    public CL_Bewertetes_Symptom() {
    }

    public CL_Bewertetes_Symptom(CL_Symptom io_symptom, int iv_wert) {
        this.symptom = io_symptom;
        this.wert = iv_wert;
        this.CL_Krankheits = CL_Krankheits;
    }

    public Long getId() {
        return id;
    }

    public CL_Symptom getSymptom() {
        return symptom;
    }

    public int getWert() {
        return wert;
    }

    public List<CL_Krankheit> getCL_Krankheits() {
        return CL_Krankheits;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSymptom(CL_Symptom io_symptom) {
        this.symptom = io_symptom;
    }

    public void setIv_wert(int iv_wert) {
        this.wert = iv_wert;
    }

    public void setCL_Krankheits(List<CL_Krankheit> io_CL_Krankheits) {
        this.CL_Krankheits = io_CL_Krankheits;
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
