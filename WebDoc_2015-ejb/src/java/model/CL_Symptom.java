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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author DEKREDAV
 * 
 * Entität Symptom 
 * Jedes Smptom hat einen Namen
 * Symptome werden für bewertete Symptome benötigt
 * 
 * Symptome bestehen aus einem Namen und einer automatisch generierten ID
 * Sie werden in der Entität Bewertetes_Symptom genutzt um einer Krankheit ein
 * Symptom mit bestimmter Bewertung zuzuweisen
 */

@Entity
@NamedQueries(
{
    //Für den Zugriff auf alle Symptome
   @NamedQuery(name = "Symptom.findAll", query = "SELECT r FROM CL_Symptom r")
})

public class CL_Symptom implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iv_id;
    
    private String iv_name;
    
    public CL_Symptom(){
        
    }
    
    //Standardmethoden: Getter, Setter, equals, hashCode, toString
    public CL_Symptom(String pv_name){
        iv_name = pv_name;
    }

    public Long getIv_id() {
        return iv_id;
    }

    public String getIv_name() {
        return iv_name;
    }

    public void setIv_id(Long iv_id) {
        this.iv_id = iv_id;
    }

    public void setIv_name(String iv_name) {
        this.iv_name = iv_name;
    }
    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (iv_id != null ? iv_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof CL_Symptom)) {
            return false;
        }
        CL_Symptom other = (CL_Symptom) object;
        if ((this.iv_id == null && other.iv_id != null) || (this.iv_id != null && !this.iv_id.equals(other.iv_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "model.Symptom[ id=" + iv_id + " name= " + iv_name + " ]";
    }
}
