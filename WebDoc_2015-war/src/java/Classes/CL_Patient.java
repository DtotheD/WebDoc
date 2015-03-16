/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import model.CL_Symptom;

/**
 *
 * @author DEKREDAV
 */
public class CL_Patient {
    
    private int iv_groesse;
    private int iv_alter;
    private int iv_gewicht;
    private double iv_bmi;
    private int iv_weiblich; // 0 keine Angabe, 1 weiblich 2 männlich
    private ArrayList<CL_Symptom> io_symptome;
    private boolean iv_pers_rel;
    
    public CL_Patient(int pv_groesse, int pv_alter, int pv_gewicht, int pv_weiblich){
        
        //falls Eingaben leer sind, sind persnönliche EIngaben nicht relevant
        if (pv_groesse == 0 || pv_alter == 0 || pv_gewicht == 0 || pv_weiblich == 0 ){
            iv_pers_rel = false;
        }
        else{
        //falls Eingaben relevant sind, wird bmi_berechnet
            iv_pers_rel = true;
            iv_bmi = sm_berrechne_bmi(pv_groesse, pv_gewicht);
        }
        io_symptome = new ArrayList<CL_Symptom>();
    }
    
    public String im_neues_symptom(CL_Symptom po_symptom){
        if (!io_symptome.contains(po_symptom))
        {
           if (io_symptome.size() < 10){
            io_symptome.add(po_symptom);
            return "Symptom erfolgreich hinzugefügt";
        }
        else
            return "Es können nicht mehr Symptome eingegeben werden"; 
        }
        else
            return "Symptom bereits vorhanden";
        
    }
    
    //berrechnet bmi
    static double sm_berrechne_bmi(int pv_groeße, int pv_gewicht){
        
        return (pv_gewicht / ((pv_groeße / 100)*(pv_groeße / 100)));     
    }
    
    //prüft ob Eingaben plausibel sind
    static boolean sm_ist_data_plausibel(int pv_groesse, int pv_gewicht,int pv_alter){
        
        boolean back = true;
        
        if (pv_groesse > 250 || pv_groesse< 50)
            back = false;
        
        if (pv_gewicht > 400 || pv_gewicht< 1)
            back = false;
        
        if (pv_alter > 120 || pv_alter < 1)
            back = false;
        
        return back;
    }

    
    // ab hier getter und setter
    public int getIv_groesse() {
        return iv_groesse;
    }

    public int getIv_alter() {
        return iv_alter;
    }

    public int getIv_gewicht() {
        return iv_gewicht;
    }

    public double getIv_bmi() {
        return iv_bmi;
    }

    public int getIv_weiblich() {
        return iv_weiblich;
    }

    public ArrayList<CL_Symptom> getIo_symptome() {
        return io_symptome;
    }

    public boolean isIv_pers_rel() {
        return iv_pers_rel;
    }

    public void setIv_groesse(int iv_groesse) {
        this.iv_groesse = iv_groesse;
    }

    public void setIv_alter(int iv_alter) {
        this.iv_alter = iv_alter;
    }

    public void setIv_gewicht(int iv_gewicht) {
        this.iv_gewicht = iv_gewicht;
    }

    public void setIv_bmi(double iv_bmi) {
        this.iv_bmi = iv_bmi;
    }

    public void setIv_weiblich(int iv_weiblich) {
        this.iv_weiblich = iv_weiblich;
    }

    public void setIo_symptome(ArrayList<CL_Symptom> io_symptome) {
        this.io_symptome = io_symptome;
    }

    public void setIv_pers_rel(boolean iv_pers_rel) {
        this.iv_pers_rel = iv_pers_rel;
    }
    
    
    
}
