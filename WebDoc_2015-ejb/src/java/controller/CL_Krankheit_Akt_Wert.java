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
import model.CL_Symptom;

/**
 *
 * @author DEKREDAV
 */
public class CL_Krankheit_Akt_Wert implements Comparable<CL_Krankheit_Akt_Wert> {
    
    private CL_Krankheit io_krankheit;
    private double iv_akt_wert;
    
    public CL_Krankheit_Akt_Wert(List<CL_Symptom> po_gewaehlte_Symptome, CL_Krankheit po_krankheit, double i){
        io_krankheit = po_krankheit;
        //Akt_wert wird über gewählte Symptome und KRankheit errechnet
        iv_akt_wert = i;
       
    }
    
    public CL_Krankheit_Akt_Wert(List<CL_Bewertetes_Symptom> po_gewaehlte_Symptome, CL_Krankheit po_krankheit){
        io_krankheit = po_krankheit;
        iv_akt_wert = im_cal_akt_wert(po_gewaehlte_Symptome);
    }
    
    /**
     *
     * @param po_gewaehlte_Symptome
     * @return
     */
    public double im_cal_akt_wert(List<CL_Bewertetes_Symptom> po_gewaehlte_Symptome){
        
        iv_akt_wert = 0.0 ;
        //Symptome zu Krankheit holen
        ArrayList<CL_Bewertetes_Symptom> lo_symptome_list = io_krankheit.getIo_symptome();
        //Alle gewählten Symptome durchlaufen
        for(CL_Bewertetes_Symptom lo_symptom : po_gewaehlte_Symptome ){
            //Falls gewähltes Symptom ein Symptom der Krankheit ist            
            if (lo_symptome_list.contains(lo_symptom)){  
                //Wert um 10 für getroffenes Symptom plus Wert des Symptoms erhöhen
                iv_akt_wert = iv_akt_wert + 10 + lo_symptom.getIv_wert();
            }
        }                    
        //  Berechnung durchführen - Tizian
        //aktueller Wert durch max Wert = Wahrscheinlcihkeit
        return iv_akt_wert / io_krankheit.getIv_max_wert();
    }

    public CL_Krankheit getIo_krankheit() {
        return io_krankheit;
    }

    public double getIv_akt_wert() {
        return iv_akt_wert;
    }
    
    public String getIv_akt_wert_string(){
        DecimalFormat lo = new DecimalFormat("#.##");
        return lo.format(iv_akt_wert * 100);
    }

    public void setIo_krankheit(CL_Krankheit io_krankheit) {
        this.io_krankheit = io_krankheit;
    }

    public void setIv_akt_wert(double iv_akt_wert) {
        this.iv_akt_wert = iv_akt_wert;
    }
    
    @Override
    public int compareTo(CL_Krankheit_Akt_Wert po_krankheit_akt_wert){
        
        if(po_krankheit_akt_wert.getIv_akt_wert() == this.iv_akt_wert)
            return 0;
        else if(po_krankheit_akt_wert.getIv_akt_wert() < this.iv_akt_wert)
            return - 1;
        else
            return 1;
    }
    
    
    
}
