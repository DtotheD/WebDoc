
package model;

import java.io.Serializable;
import java.util.ArrayList;
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
 * 
 */

@Entity
@NamedQueries(
{
   @NamedQuery(name = "CL_Bewertetes_Symptom.findBySymptomList", query = "SELECT r FROM CL_Bewertetes_Symptom r WHERE r.io_symptom IN :p_Symptome ")
})
public class CL_Bewertetes_Symptom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iv_id;
    @ManyToOne
    private CL_Symptom io_symptom; 
    private int iv_wert;
    
    @ManyToMany
    private List<CL_Krankheit> io_krankheiten;

    public CL_Bewertetes_Symptom(CL_Symptom po_symptom, int pv_wert) {
        this.io_symptom = po_symptom;
        this.iv_wert = pv_wert;
        this.io_krankheiten = new ArrayList<>();
    }
    
    public void addKrankheit(CL_Krankheit po_krankheit) {
      if (!getIo_krankheiten().contains(po_krankheit)) {
          getIo_krankheiten().add(po_krankheit);
      }
      if (!po_krankheit.getIo_symptome().contains(this)) {
          po_krankheit.getIo_symptome().add(this);
      }
    }
    
    public CL_Bewertetes_Symptom() {
    }

    public Long getIv_id() {
        return iv_id;
    }

    public CL_Symptom getIo_Symptom() {
        return io_symptom;
    }

    public int getIv_wert() {
        return iv_wert;
    }

    public List<CL_Krankheit> getIo_krankheiten() {
        return io_krankheiten;
    }

    public void setIv_id(Long iv_id) {
        this.iv_id = iv_id;
    }

    public void setSymptom(CL_Symptom symptom) {
        this.io_symptom = symptom;
    }

    public void setIv_wert(int iv_wert) {
        this.iv_wert = iv_wert;
    }

    public void setIo_krankheiten(List<CL_Krankheit> io_krankheiten) {
        this.io_krankheiten = io_krankheiten;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iv_id != null ? iv_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
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
