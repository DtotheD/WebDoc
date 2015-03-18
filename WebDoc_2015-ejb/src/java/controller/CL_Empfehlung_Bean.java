/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import zwischenspeicher.CL_Empfehlung;

/**
 *
 * @author DEKREDAV
 */
@Stateless
@LocalBean
public class CL_Empfehlung_Bean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    private EntityManager io_em;
    
    public CL_Empfehlung im_create_Empfehlung(String pv_text){
        
        io_em.setFlushMode(FlushModeType.AUTO);
        CL_Empfehlung lo_empfehlung = new CL_Empfehlung(pv_text);
        io_em.persist(lo_empfehlung);
        lo_empfehlung = io_em.merge(lo_empfehlung);
        io_em.flush();
        return lo_empfehlung;
        
    }
    
    
}
