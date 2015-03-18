/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import model.CL_Bewertetes_Symptom;
import model.CL_Empfehlung;
import model.CL_Krankheit;
import model.CL_Symptom;

/**
 *
 * @author DEKREDAV
 */
@Stateless
@LocalBean
public class CL_Bewertetes_Symptom_Bean {

    @PersistenceContext
    private EntityManager io_em;
    
    public CL_Bewertetes_Symptom im_create_Krankheit(CL_Symptom po_symptom, int pv_wert, List<CL_Krankheit> po_krankheiten){
        
        io_em.setFlushMode(FlushModeType.AUTO);
        CL_Bewertetes_Symptom lo_bewertetes_symptom = new CL_Bewertetes_Symptom(po_symptom, pv_wert /* ,po_krankheiten*/);
        io_em.persist(lo_bewertetes_symptom);
        lo_bewertetes_symptom = io_em.merge(lo_bewertetes_symptom);
        io_em.flush();
        return lo_bewertetes_symptom;   
    }
}
