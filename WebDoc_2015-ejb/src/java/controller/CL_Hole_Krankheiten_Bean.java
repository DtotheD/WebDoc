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
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.CL_Bewertetes_Symptom;
import model.CL_Symptom;
import model.CL_Krankheit;

/**
 *
 * @author DEKREDAV
 */
@Stateless
@LocalBean
public class CL_Hole_Krankheiten_Bean {
    
     @PersistenceContext
    private EntityManager io_em;
     
     public List<CL_Krankheit_Akt_Wert> im_get_passende_Krankheiten(List<CL_Symptom> po_gewaehlte_Symptome){
         
         List<CL_Bewertetes_Symptom> lo_passende_Symptome = im_get_passende_Symptome(po_gewaehlte_Symptome);
         
         ArrayList<CL_Krankheit> lo_krankheiten = new ArrayList<>();
         
         for(CL_Bewertetes_Symptom lo_bewertete_symptome : lo_passende_Symptome){
             
             for (CL_Krankheit lo_krankheit: lo_bewertete_symptome.getIo_CL_Krankheits())
                 
                 if (!lo_krankheiten.contains(lo_krankheit)){
                     lo_krankheiten.add(lo_krankheit);
                 }
         }
         return null;
     }

    public List<CL_Bewertetes_Symptom> im_get_passende_Symptome(List<CL_Symptom> po_gewaehlte_Symptome) {

        TypedQuery<CL_Bewertetes_Symptom> io_back = io_em.createNamedQuery("Bewertetes_Symptom.findBySymptomList", CL_Bewertetes_Symptom.class)
                .setParameter("p_Symptome", po_gewaehlte_Symptome);

        return io_back.getResultList();
    }
   
}
