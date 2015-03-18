/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import zwischenspeicher.CL_Bewertetes_Symptom;
import zwischenspeicher.CL_Empfehlung;
import zwischenspeicher.CL_Krankheit;
import model.CL_Symptom;

/**
 *
 * @author DEKREDAV
 */
@Stateless
@LocalBean
public class CL_Krankheit_Bean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    private EntityManager io_em;
    
    public CL_Krankheit im_create_Krankheit(String pv_name, int pv_max_wert, CL_Empfehlung po_empfehlung, ArrayList<CL_Bewertetes_Symptom> po_symptome, String pv_beschreibung){
        
        io_em.setFlushMode(FlushModeType.AUTO);
        CL_Krankheit lo_krankheit = new CL_Krankheit(pv_name, pv_max_wert, po_empfehlung, po_symptome, pv_beschreibung);
        io_em.persist(lo_krankheit);
        lo_krankheit = io_em.merge(lo_krankheit);
        io_em.flush();
        return lo_krankheit;
        
    }
}
