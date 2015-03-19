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
import model.CL_Bewertetes_Symptom;
import model.CL_Empfehlung;
import model.CL_Krankheit;
import model.CL_Symptom;

/**
 *
 * @author DEDEUTIZ
 */
@Stateless(name = "CL_Create_DB_Data_Bean")
@LocalBean
public class CL_Create_DB_Data_Bean {

    @PersistenceContext
    private EntityManager io_em;

    public void im_create_db() {

        io_em.setFlushMode(FlushModeType.AUTO);

        CL_Symptom lo_symptom_1 = new CL_Symptom("Husten");
        CL_Symptom lo_symptom_2 = new CL_Symptom("Fieber");
        CL_Symptom lo_symptom_3 = new CL_Symptom("Kopfschmerzen");
        CL_Symptom lo_symptom_4 = new CL_Symptom("Halsschmerzen");
        CL_Symptom lo_symptom_5 = new CL_Symptom("Bauchschmerzen");
        CL_Symptom lo_symptom_6 = new CL_Symptom("Durchfall");
        CL_Symptom lo_symptom_7 = new CL_Symptom("laufende Nase");
        CL_Symptom lo_symptom_8 = new CL_Symptom("Gliederschmerzen");
        CL_Symptom lo_symptom_9 = new CL_Symptom("Haarausfall");
        CL_Symptom lo_symptom_10 = new CL_Symptom("Gewichtsverlust");
        
        io_em.persist(lo_symptom_1);
        io_em.persist(lo_symptom_2);
        io_em.persist(lo_symptom_3);
        io_em.persist(lo_symptom_4);
        io_em.persist(lo_symptom_5);
        io_em.persist(lo_symptom_6);
        io_em.persist(lo_symptom_7);
        io_em.persist(lo_symptom_8);
        io_em.persist(lo_symptom_9);
        io_em.persist(lo_symptom_10);

        CL_Empfehlung lo_empfhelung_1 = new CL_Empfehlung("Gehen Sie zum Arzt!");
        CL_Empfehlung lo_empfhelung_2 = new CL_Empfehlung("Ruhen Sie sich aus!");
        
        io_em.persist(lo_empfhelung_1);
        io_em.persist(lo_empfhelung_2);
        
        io_em.flush();

        //Husten
        CL_Bewertetes_Symptom lo_husten_9 = new CL_Bewertetes_Symptom(lo_symptom_1, 9, null);
        CL_Bewertetes_Symptom lo_husten_8 = new CL_Bewertetes_Symptom(lo_symptom_1, 8, null);

        //Fieber
        CL_Bewertetes_Symptom lo_fieber_9 = new CL_Bewertetes_Symptom(lo_symptom_2, 9, null);

        //Kopfschmerzen
        CL_Bewertetes_Symptom lo_kopfschmerzen_8 = new CL_Bewertetes_Symptom(lo_symptom_3, 8, null);
        CL_Bewertetes_Symptom lo_kopfschmerzen_7 = new CL_Bewertetes_Symptom(lo_symptom_3, 7, null);

        //Halsschmerzen
        CL_Bewertetes_Symptom lo_halsschmerzen_7 = new CL_Bewertetes_Symptom(lo_symptom_4, 7, null);

        //Bauchschmerzen
        CL_Bewertetes_Symptom lo_bauchschmerzen_9 = new CL_Bewertetes_Symptom(lo_symptom_5, 9, null);
        CL_Bewertetes_Symptom lo_bauchschmerzen_2 = new CL_Bewertetes_Symptom(lo_symptom_5, 2, null);

        //Durchfall
        CL_Bewertetes_Symptom lo_durchfall_9 = new CL_Bewertetes_Symptom(lo_symptom_6, 9, null);

        //laufende Nase
        CL_Bewertetes_Symptom lo_nase_8 = new CL_Bewertetes_Symptom(lo_symptom_7, 8, null);

        //Gliederschmerzen
        CL_Bewertetes_Symptom lo_glieder_7 = new CL_Bewertetes_Symptom(lo_symptom_8, 7, null);
        CL_Bewertetes_Symptom lo_glieder_4 = new CL_Bewertetes_Symptom(lo_symptom_8, 4, null);

        //Haarausfall
        CL_Bewertetes_Symptom lo_haar_7 = new CL_Bewertetes_Symptom(lo_symptom_9, 7, null);

        //Gewichtsverlust
        CL_Bewertetes_Symptom lo_gewicht_10 = new CL_Bewertetes_Symptom(lo_symptom_10, 10, null);
        CL_Bewertetes_Symptom lo_gewicht_2 = new CL_Bewertetes_Symptom(lo_symptom_10, 2, null);
        
        io_em.persist(lo_husten_9);
        io_em.persist(lo_husten_8);
        io_em.persist(lo_kopfschmerzen_8);
        io_em.persist(lo_kopfschmerzen_7);
        io_em.persist(lo_fieber_9);
        io_em.persist(lo_halsschmerzen_7);
        io_em.persist(lo_bauchschmerzen_9);
        io_em.persist(lo_bauchschmerzen_2);
        io_em.persist(lo_durchfall_9);
        io_em.persist(lo_nase_8);
        io_em.persist(lo_glieder_7);
        io_em.persist(lo_glieder_4);
        io_em.persist(lo_haar_7);
        io_em.persist(lo_gewicht_10);
        io_em.persist(lo_gewicht_2);
        
//        Grippe
//        ArrayList<CL_Bewertetes_Symptom> lo_list_grippe = new ArrayList<>();
//        lo_list_grippe.add(lo_husten_9);
//        lo_list_grippe.add(lo_kopfschmerzen_8);
//        lo_list_grippe.add(lo_fieber_9);
//        lo_list_grippe.add(lo_halsschmerzen_7);
//        lo_list_grippe.add(lo_nase_8);
//        lo_list_grippe.add(lo_glieder_7);
//
//        CL_Krankheit lo_grippe = new CL_Krankheit("Hier kommt die Beschreibung", lo_empfhelung_1, 120);
//   
//        
//        io_em.persist(lo_grippe);
        io_em.flush();
        
//
//        //Erkältung
//        ArrayList<CL_Bewertetes_Symptom> lo_list_erkaeltung = new ArrayList<>();
//        lo_list_erkaeltung.add(lo_husten_8);
//        lo_list_erkaeltung.add(lo_kopfschmerzen_7);
//        lo_list_erkaeltung.add(lo_fieber_9);
//        lo_list_erkaeltung.add(lo_halsschmerzen_7);
//        lo_list_erkaeltung.add(lo_nase_8);
//        lo_list_erkaeltung.add(lo_glieder_4);
//
//        CL_Krankheit lo_erkaeltung = new CL_Krankheit("Hier kommt die Beschreibung", lo_empfhelung_2, 120, lo_list_erkaeltung);
//
//        //Schilddrüsenüberfunktion
//        ArrayList<CL_Bewertetes_Symptom> lo_list_schild = new ArrayList<>();
//        lo_list_schild.add(lo_bauchschmerzen_2);
//        lo_list_schild.add(lo_durchfall_9);
//        lo_list_schild.add(lo_haar_7);
//        lo_list_schild.add(lo_gewicht_10);
//
//        CL_Krankheit lo_schild = new CL_Krankheit("Hier kommt die Beschreibung", lo_empfhelung_1, 80, lo_list_schild);
//
//        //Reizdarm
//        ArrayList<CL_Bewertetes_Symptom> lo_list_reiz = new ArrayList<>();
//        lo_list_reiz.add(lo_bauchschmerzen_9);
//        lo_list_reiz.add(lo_durchfall_9);
//        lo_list_reiz.add(lo_gewicht_2);
//
//        CL_Krankheit lo_reiz = new CL_Krankheit("Hier kommt die Beschreibung", lo_empfhelung_2, 60, lo_list_reiz);
//
//        io_em.persist(lo_reiz);
//        io_em.persist(lo_schild);
//        io_em.persist(lo_erkaeltung);
//        

        io_em.flush();

    }

}
