/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import model.CL_Bewertetes_Symptom;
import model.CL_Krankheit;

/**
 *
 * @author DEKREDAV
 * 
 * Objekte dieser Klasse speichern eine Krankheit mit ihrer aktuellen Wahrscheinlichkeit,
 * die im Konstruktor, anhand der mitgegebenen Symptome berechnet wird.
 * 
 * Es wird das Interface comparable implementiert um Listen dieser Klasse direkt nach
 * ihrer Wahrscheinlichkeit zu sortieren ohne die Sortierung explizit zu implementieren.
 */
public class CL_Krankheit_Akt_Wahr implements Comparable<CL_Krankheit_Akt_Wahr> {
    
    //Referenz auf Krankheit-Objekt
    private CL_Krankheit io_krankheit;
    //Aktuelle Wahrscheinlichkeit als dezimaler Wert
    private double iv_akt_wahrscheinlichkeit;
    
    //Setzt Krankheit und errechnet direkt die aktuelle Wahrscheinlichkeit, anhand der mitgegebenen Symptome
    public CL_Krankheit_Akt_Wahr(List<CL_Bewertetes_Symptom> po_gewaehlte_Symptome, CL_Krankheit po_krankheit){
        io_krankheit = po_krankheit;
        iv_akt_wahrscheinlichkeit = im_cal_akt_wahr(po_gewaehlte_Symptome);
    }
    
    /**
     *
     * @param po_gewaehlte_Symptome
     * @return
     */
    public final double im_cal_akt_wahr(List<CL_Bewertetes_Symptom> po_gewaehlte_Symptome){
        
        double lv_akt_wahrscheinlichkeit = 0.0 ;
        //Symptome zu Krankheit holen
        ArrayList<CL_Bewertetes_Symptom> lo_symptome_list = io_krankheit.getIo_symptome();
        //Alle gewählten Symptome durchlaufen
        for(CL_Bewertetes_Symptom lo_symptom : po_gewaehlte_Symptome ){
            //Falls gewähltes Symptom ein Symptom der Krankheit ist            
            if (lo_symptome_list.contains(lo_symptom)){  
                //Wert um 10 für getroffenes Symptom plus Wert des Symptoms erhöhen
                lv_akt_wahrscheinlichkeit = lv_akt_wahrscheinlichkeit + 10 + lo_symptom.getIv_wert();
            }
        }                    
        //aktueller Wert durch max Wert = Wahrscheinlcihkeit
        return lv_akt_wahrscheinlichkeit / io_krankheit.getIv_max_wert();
    }
    
    /**
     * 
     * @return 
     * wandelt zur Ausgabe der Wahescheinlichkeit, diese in einen prozentualen
     * Wert ohne Nachkommastellen um und gibt diesen als String aus
     */
    public String getIv_akt_wahr_string(){
        DecimalFormat lo = new DecimalFormat("#");
        return lo.format(iv_akt_wahrscheinlichkeit * 100);
    }
    
    /**
     * 
     * @param po_krankheit_akt_wert
     * @return
     * Überschreibt die Methode compareTo, sodass die Objekte dieser Klasse
     * anhand ihrer Wahrscheinlichkeit verglichen werden
     */
    @Override
    public int compareTo(CL_Krankheit_Akt_Wahr po_krankheit_akt_wert){
        
        //Die Werte sind gleich
        if(po_krankheit_akt_wert.getIv_akt_wahrscheinlichkeit() == this.iv_akt_wahrscheinlichkeit)
            return 0;
        //Der mitgegebene Wert ist kleiner, als der der aktuellen Instanz
        else if(po_krankheit_akt_wert.getIv_akt_wahrscheinlichkeit() < this.iv_akt_wahrscheinlichkeit)
            return - 1;
        //der mitgegebene Wert ist größer, als der der aktuellen Instanz
        else
            return 1;
    }

    //Getter
    public CL_Krankheit getIo_krankheit() {
        return io_krankheit;
    }

    public double getIv_akt_wahrscheinlichkeit() {
        return iv_akt_wahrscheinlichkeit;
    }

    //Setter
    public void setIo_krankheit(CL_Krankheit io_krankheit) {
        this.io_krankheit = io_krankheit;
    }

    public void setIv_akt_wahrscheinlichkeit(double iv_akt_wahrscheinlichkeit) {
        this.iv_akt_wahrscheinlichkeit = iv_akt_wahrscheinlichkeit;
    }    
}
