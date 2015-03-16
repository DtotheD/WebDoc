/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import model.CL_Symptom;

/**
 *
 * @author DEKREDAV
 */
@Stateless(name = "CL_Symptom_Bean")
public class CL_Symptom_Bean implements IN_Symptom_Bean {
    
    @PersistenceContext
    private EntityManager io_em;
    
    @Override
    public CL_Symptom im_create_Symptom(String pv_name){
        
        io_em.setFlushMode(FlushModeType.AUTO);
        CL_Symptom lo_symptom = new CL_Symptom(pv_name);
        io_em.persist(lo_symptom);
        lo_symptom = io_em.merge(lo_symptom);
        io_em.flush();
        return lo_symptom;
        
    }
    
    public List<CL_Symptom> im_getAllSymptoms(){
        
        List<CL_Symptom> roles = io_em.createNamedQuery("Symptom.findAll", CL_Symptom.class).getResultList();
        return roles;
        
    }
    
}
