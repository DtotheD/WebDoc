/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.CL_Krankheit;
import model.CL_Symptom;

/**
 *
 * @author DEKREDAV
 */
public class CL_Krankheit_Akt_Wert {
    
    private CL_Krankheit io_krankheit;
    private int iv_akt_wert;
    
    public CL_Krankheit_Akt_Wert(List<CL_Symptom> po_gewaehlte_Symptome, CL_Krankheit po_krankheit, int i){
        io_krankheit = po_krankheit;
        //Akt_wert wird über gewählte Symptome und KRankheit errechnet
        iv_akt_wert = i;
    }

    public CL_Krankheit getIo_krankheit() {
        return io_krankheit;
    }

    public int getIv_akt_wert() {
        return iv_akt_wert;
    }

    public void setIo_krankheit(CL_Krankheit io_krankheit) {
        this.io_krankheit = io_krankheit;
    }

    public void setIv_akt_wert(int iv_akt_wert) {
        this.iv_akt_wert = iv_akt_wert;
    }
    
    
    
}
