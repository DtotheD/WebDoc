/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.CL_Symptom;

/**
 *
 * @author DEKREDAV
 *
 * Bean zum Auslesen aller Symptome Nutzt die Query Symptom.findAll der
 * Entity-Klasse CL_Symptom zum Auslesen aller Symptome
 */
@Stateless(name = "CL_Symptom_Bean")
@LocalBean
public class CL_Symptom_Bean {

    @PersistenceContext
    private EntityManager io_em;

    /**
     * 
     * @return
     * Liest alle Symptome aus der Datenbank aus.
     */
    public List<CL_Symptom> im_getAllSymptoms() {
        
        //Datenbankzugriff über Query "Symptom.findAll" ohne Parameter
        List<CL_Symptom> roles = io_em.createNamedQuery("Symptom.findAll", CL_Symptom.class).getResultList();
        return roles;
    }
}
