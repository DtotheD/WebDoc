/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
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
 * @author DEKREDAV 18.03.2015 Beschreibung: Diese Bean übernimmt die Auswahl
 * der zu den Symptomen passenden Krankheiten mit ihrer aktuellen
 * Wahrscheinlichkeit
 */
@Stateless
@LocalBean
public class CL_Hole_Krankheiten_Bean {

    @PersistenceContext
    private EntityManager io_em;

    /**
     * 
     * @param po_gewaehlte_Symptome
     * @return
     * 
     * * 1. Anhand der gewählten Symptome die Bewerteten-Symptom Objekte auslesen.
     * 2. Passende Krankheiten anhand der bewerteten Symtome auslesen
     * 3. Krankheit_Akt_Wahr-Objekte erzeugen. Diese errechnen zu einer mit-
     * gegebenen Krankheit und den gewählten Symptomen im Konstruktor die 
     * aktuelle Wahrscheinlichkeit der Krankheit.
     * 4.Sortierung nach aktueller Wahrscheinlichkeit
     */
    public List<CL_Krankheit_Akt_Wahr> im_get_passende_Krankheiten(List<CL_Symptom> po_gewaehlte_Symptome) {

        //Alle bewerteten Symptome zu den gewählten Symptomen auslesen über private Methode
        List<CL_Bewertetes_Symptom> lo_passende_Symptome = im_get_passende_Symptome(po_gewaehlte_Symptome);
        
        //Liste der bereits errechneten Krankheiten
        ArrayList<CL_Krankheit> lo_krankheiten = new ArrayList<>();
        
        //Liste der Krankheiten mit ihrer aktuellen Wahrscheinlichkeit
        //Diese wird zurückgegeben
        ArrayList<CL_Krankheit_Akt_Wahr> lo_krankheit_akt_wahr = new ArrayList<>();

        //Für jedes bewertete Symptom alle Krankheiten auslesen
        for (CL_Bewertetes_Symptom lo_bewertete_symptome : lo_passende_Symptome) {
            //Für jede Krankheiten:
            for (CL_Krankheit lo_krankheit : lo_bewertete_symptome.getIo_krankheiten()) {
                //Prüfen ob Kranheit schon bearbeitet wurde
                if (!lo_krankheiten.contains(lo_krankheit)) {
                    //Falls Krankheit noch nicht bearbeitet wurde wird sie der
                    //Liste der bereits verarbeiteten Krankheiten hinzugefügt
                    lo_krankheiten.add(lo_krankheit);
                    //Erstellung eines Krankheit_Akt_Wahr-Objektes, das im
                    //Konstruktor die aktuelle Wahrscheinlichkeit errechnet
                    lo_krankheit_akt_wahr.add(new CL_Krankheit_Akt_Wahr(lo_passende_Symptome, lo_krankheit));
                }
            }
        }
        //Sortierung
        Collections.sort(lo_krankheit_akt_wahr);
        //Rückgabe
        return lo_krankheit_akt_wahr;
    }

    /**
     *
     * @param po_gewaehlte_Symptome
     * @return
     * 
     * gekapselter Datenbankzugriff
     * gibt zu den gewählten Symptomen eine Liste aus bewerteten Symptomen
     * zurück.
     */
    private List<CL_Bewertetes_Symptom> im_get_passende_Symptome(List<CL_Symptom> po_gewaehlte_Symptome) {
        
        //Datenbankzugriff über Query "CL_Bewertetes_Symptom.findBySymptomList" mit den gewählten Symptomen
        TypedQuery<CL_Bewertetes_Symptom> io_back = io_em.createNamedQuery("CL_Bewertetes_Symptom.findBySymptomList", CL_Bewertetes_Symptom.class)
                .setParameter("p_Symptome", po_gewaehlte_Symptome);

        return io_back.getResultList();
    }
}
