/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author DEKREDAV
 */
@Entity
public class CL_Empfehlung implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iv_id;

    private String iv_text;

    public CL_Empfehlung() {
    }

    public CL_Empfehlung(String iv_text) {
        this.iv_text = iv_text;
    }

    public Long getIv_id() {
        return iv_id;
    }

    public String getIv_text() {
        return iv_text;
    }

    public void setIv_id(Long iv_id) {
        this.iv_id = iv_id;
    }

    public void setIv_text(String iv_text) {
        this.iv_text = iv_text;
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
        if (!(object instanceof CL_Empfehlung)) {
            return false;
        }
        CL_Empfehlung other = (CL_Empfehlung) object;
        if ((this.iv_id == null && other.iv_id != null) || (this.iv_id != null && !this.iv_id.equals(other.iv_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CL_Empfehlung[ id=" + iv_id + " ]";
    }

}
