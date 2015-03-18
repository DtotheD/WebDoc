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
            @NamedQuery(name = "Bewertetes_Symptom.findBySymptomList", query = "SELECT r FROM CL_Bewertetes_Symptom r")
        })

public class CL_Bewertetes_Symptom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iv_id;
    @ManyToOne
    private CL_Symptom io_symptom;
    private int iv_wert;
    @ManyToMany(mappedBy = "symptome")
    private List<CL_Krankheit> io_CL_Krankheits;

    public CL_Bewertetes_Symptom() {
    }

    public CL_Bewertetes_Symptom(CL_Symptom io_symptom, int iv_wert, List<CL_Krankheit> io_CL_Krankheits) {
        this.io_symptom = io_symptom;
        this.iv_wert = iv_wert;
        this.io_CL_Krankheits = io_CL_Krankheits;
    }

    public Long getIv_id() {
        return iv_id;
    }

    public CL_Symptom getIo_symptom() {
        return io_symptom;
    }

    public int getIv_wert() {
        return iv_wert;
    }

    public List<CL_Krankheit> getIo_CL_Krankheits() {
        return io_CL_Krankheits;
    }

    public void setIv_id(Long iv_id) {
        this.iv_id = iv_id;
    }

    public void setIo_symptom(CL_Symptom io_symptom) {
        this.io_symptom = io_symptom;
    }

    public void setIv_wert(int iv_wert) {
        this.iv_wert = iv_wert;
    }

    public void setIo_CL_Krankheits(List<CL_Krankheit> io_CL_Krankheits) {
        this.io_CL_Krankheits = io_CL_Krankheits;
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
        if (!(object instanceof CL_Bewertetes_Symptom)) {
            return false;
        }
        CL_Bewertetes_Symptom other = (CL_Bewertetes_Symptom) object;
        if ((this.iv_id == null && other.iv_id != null) || (this.iv_id != null && !this.iv_id.equals(other.iv_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CL_Bewertetes_Symptom[ id=" + iv_id + " ]";
    }

}
