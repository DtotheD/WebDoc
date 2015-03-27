/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.CL_Empfehlung;
import model.CL_Symptom;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import model.CL_Bewertetes_Symptom;
import model.CL_Krankheit;

/**
 *
 * @author DEDEUTIZ
 */
public class CL_Krankheit_Akt_WertTest {

    public CL_Krankheit_Akt_WertTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of im_cal_akt_wert method, of class CL_Krankheit_Akt_Wert.
     * Test auf alle getroffenen Symptome
     */
    @Test
    public void testIm_cal_akt_wert_1() {
        System.out.println("im_cal_akt_wert_1");
                
        //Erstellen der benötigten Objekte
        
        //Symptome
        CL_Symptom lo_symptom_1 = new CL_Symptom("Husten");
        CL_Symptom lo_symptom_2 = new CL_Symptom("Fieber");
        CL_Symptom lo_symptom_3 = new CL_Symptom("Kopfschmerzen");
        CL_Symptom lo_symptom_4 = new CL_Symptom("Halsschmerzen");
        CL_Symptom lo_symptom_7 = new CL_Symptom("laufende Nase");
        CL_Symptom lo_symptom_8 = new CL_Symptom("Gliederschmerzen");

        //Empfehlung
        CL_Empfehlung lo_empfhelung_1 = new CL_Empfehlung("Gehen Sie zum Arzt!");
        
        //Bewertete Symptome
        //Husten
        CL_Bewertetes_Symptom lo_husten_9 = new CL_Bewertetes_Symptom(lo_symptom_1, 9);

        //Fieber
        CL_Bewertetes_Symptom lo_fieber_9 = new CL_Bewertetes_Symptom(lo_symptom_2, 9);

        //Kopfschmerzen
        CL_Bewertetes_Symptom lo_kopfschmerzen_8 = new CL_Bewertetes_Symptom(lo_symptom_3, 8);
        
        //Halsschmerzen
        CL_Bewertetes_Symptom lo_halsschmerzen_7 = new CL_Bewertetes_Symptom(lo_symptom_4, 7);

        //laufende Nase
        CL_Bewertetes_Symptom lo_nase_8 = new CL_Bewertetes_Symptom(lo_symptom_7, 8);

        //Gliederschmerzen
        CL_Bewertetes_Symptom lo_glieder_7 = new CL_Bewertetes_Symptom(lo_symptom_8, 7);

        //Grippe
        CL_Krankheit lo_grippe = new CL_Krankheit("Hier kommt die Beschreibung", lo_empfhelung_1, 120,"Grippe");
        lo_grippe.addSymptom(lo_husten_9);
        lo_grippe.addSymptom(lo_kopfschmerzen_8);
        lo_grippe.addSymptom(lo_halsschmerzen_7);
        lo_grippe.addSymptom(lo_nase_8);
        lo_grippe.addSymptom(lo_glieder_7);
        lo_grippe.addSymptom(lo_fieber_9);
        
        //Gewählte Symptome

        ArrayList<CL_Bewertetes_Symptom> lo_gewaehlte_symptome = new ArrayList<>();

        lo_gewaehlte_symptome.add(lo_husten_9);
        lo_gewaehlte_symptome.add(lo_kopfschmerzen_8);
        lo_gewaehlte_symptome.add(lo_halsschmerzen_7);
        lo_gewaehlte_symptome.add(lo_nase_8);
        lo_gewaehlte_symptome.add(lo_glieder_7);
        lo_gewaehlte_symptome.add(lo_fieber_9);

        CL_Krankheit_Akt_Wahr lo_akt_wert_krankheit = new CL_Krankheit_Akt_Wahr(lo_gewaehlte_symptome, lo_grippe);
      
        CL_Krankheit_Akt_Wahr instance = lo_akt_wert_krankheit;
        
        double expResult = 0.9;
        
        double result = instance.im_cal_akt_wahr(lo_gewaehlte_symptome);
        
        assertEquals(expResult, result, 0.0);
       
    }
    
    
     /**
     * Test of im_cal_akt_wert method, of class CL_Krankheit_Akt_Wert.
     * Test auf ein getroffenes Symptom
     */
    @Test
    public void testIm_cal_akt_wert_2() {
        System.out.println("im_cal_akt_wert_2");
                
        //Erstellen der benötigten Objekte
        
        //Symptome
        CL_Symptom lo_symptom_1 = new CL_Symptom("Husten");
        CL_Symptom lo_symptom_2 = new CL_Symptom("Fieber");
        CL_Symptom lo_symptom_3 = new CL_Symptom("Kopfschmerzen");
        CL_Symptom lo_symptom_4 = new CL_Symptom("Halsschmerzen");
        CL_Symptom lo_symptom_7 = new CL_Symptom("laufende Nase");
        CL_Symptom lo_symptom_8 = new CL_Symptom("Gliederschmerzen");

        //Empfehlung
        CL_Empfehlung lo_empfhelung_1 = new CL_Empfehlung("Gehen Sie zum Arzt!");
        
        //Bewertete Symptome
        //Husten
        CL_Bewertetes_Symptom lo_husten_9 = new CL_Bewertetes_Symptom(lo_symptom_1, 9);

        //Kopfschmerzen
        CL_Bewertetes_Symptom lo_kopfschmerzen_8 = new CL_Bewertetes_Symptom(lo_symptom_3, 8);
        
        //Halsschmerzen
        CL_Bewertetes_Symptom lo_halsschmerzen_7 = new CL_Bewertetes_Symptom(lo_symptom_4, 7);

        //Grippe
        CL_Krankheit lo_erkaeltung = new CL_Krankheit("Hier kommt die Beschreibung", lo_empfhelung_1, 54, "Erkältung");
        lo_erkaeltung.addSymptom(lo_husten_9);
        lo_erkaeltung.addSymptom(lo_kopfschmerzen_8);
        lo_erkaeltung.addSymptom(lo_halsschmerzen_7);
               
        //Gewählte Symptome

        ArrayList<CL_Bewertetes_Symptom> lo_gewaehlte_symptome = new ArrayList<>();

        lo_gewaehlte_symptome.add(lo_kopfschmerzen_8);

        CL_Krankheit_Akt_Wahr lo_akt_wert_krankheit = new CL_Krankheit_Akt_Wahr(lo_gewaehlte_symptome, lo_erkaeltung);
      
        CL_Krankheit_Akt_Wahr instance = lo_akt_wert_krankheit;
        
        double expResult = 0.33;
        
        double result = instance.im_cal_akt_wahr(lo_gewaehlte_symptome);
        
        assertEquals(expResult, result, 0.1);
       
    }
    
    /**
     * Test of im_cal_akt_wert method, of class CL_Krankheit_Akt_Wert.
     * Test auf kein getroffenes Symptom
     */
    @Test
    public void testIm_cal_akt_wert_3() {
        System.out.println("im_cal_akt_wert_3");
        
        
        //Erstellen der benötigten Objekte
        
        //Symptome
        CL_Symptom lo_symptom_1 = new CL_Symptom("Husten");
        CL_Symptom lo_symptom_2 = new CL_Symptom("Fieber");
        CL_Symptom lo_symptom_3 = new CL_Symptom("Kopfschmerzen");
        CL_Symptom lo_symptom_4 = new CL_Symptom("Halsschmerzen");
        CL_Symptom lo_symptom_7 = new CL_Symptom("laufende Nase");
        CL_Symptom lo_symptom_8 = new CL_Symptom("Gliederschmerzen");

        //Empfehlung
        CL_Empfehlung lo_empfhelung_1 = new CL_Empfehlung("Gehen Sie zum Arzt!");
        
        //Bewertete Symptome
        //Husten
        CL_Bewertetes_Symptom lo_husten_9 = new CL_Bewertetes_Symptom(lo_symptom_1, 9);

        //Kopfschmerzen
        CL_Bewertetes_Symptom lo_kopfschmerzen_8 = new CL_Bewertetes_Symptom(lo_symptom_3, 8);
        
        //Halsschmerzen
        CL_Bewertetes_Symptom lo_halsschmerzen_7 = new CL_Bewertetes_Symptom(lo_symptom_4, 7);

        //Grippe
        CL_Krankheit lo_grippe = new CL_Krankheit("Hier kommt die Beschreibung", lo_empfhelung_1, 120, "Erkältung");
        lo_grippe.addSymptom(lo_husten_9);
        lo_grippe.addSymptom(lo_kopfschmerzen_8);
        lo_grippe.addSymptom(lo_halsschmerzen_7);
                
        //Gewählte Symptome

        ArrayList<CL_Bewertetes_Symptom> lo_gewaehlte_symptome = new ArrayList<>();

        CL_Krankheit_Akt_Wahr lo_akt_wert_krankheit = new CL_Krankheit_Akt_Wahr(lo_gewaehlte_symptome, lo_grippe);
      
        CL_Krankheit_Akt_Wahr instance = lo_akt_wert_krankheit;
        
        double expResult = 0.0;
        
        double result = instance.im_cal_akt_wahr(lo_gewaehlte_symptome);
        
        assertEquals(expResult, result, 0.0);
       
    }
    
     /**
     * Test of im_cal_akt_wert method, of class CL_Krankheit_Akt_Wert.
     * Test auf mehr ausgewählte Symptome als die Krankheit besitzt
     */
    @Test
    public void testIm_cal_akt_wert_4() {
        System.out.println("im_cal_akt_wert_4");
                
        //Erstellen der benötigten Objekte
        
        //Symptome
        CL_Symptom lo_symptom_1 = new CL_Symptom("Husten");
        CL_Symptom lo_symptom_2 = new CL_Symptom("Fieber");
        CL_Symptom lo_symptom_3 = new CL_Symptom("Kopfschmerzen");
        CL_Symptom lo_symptom_4 = new CL_Symptom("Halsschmerzen");
        CL_Symptom lo_symptom_7 = new CL_Symptom("laufende Nase");
        CL_Symptom lo_symptom_8 = new CL_Symptom("Gliederschmerzen");

        //Empfehlung
        CL_Empfehlung lo_empfhelung_1 = new CL_Empfehlung("Gehen Sie zum Arzt!");
        
        //Bewertete Symptome
        //Husten
        CL_Bewertetes_Symptom lo_husten_9 = new CL_Bewertetes_Symptom(lo_symptom_1, 9);

        //Kopfschmerzen
        CL_Bewertetes_Symptom lo_kopfschmerzen_8 = new CL_Bewertetes_Symptom(lo_symptom_3, 8);
        
        //Halsschmerzen
        CL_Bewertetes_Symptom lo_halsschmerzen_7 = new CL_Bewertetes_Symptom(lo_symptom_4, 7);

        //Grippe
        CL_Krankheit lo_grippe = new CL_Krankheit("Hier kommt die Beschreibung", lo_empfhelung_1, 120, "leichte Erkältung");
        lo_grippe.addSymptom(lo_kopfschmerzen_8);
        lo_grippe.addSymptom(lo_halsschmerzen_7);
                
        //Gewählte Symptome

        ArrayList<CL_Bewertetes_Symptom> lo_gewaehlte_symptome = new ArrayList<>();

        lo_gewaehlte_symptome.add(lo_husten_9);
        lo_gewaehlte_symptome.add(lo_kopfschmerzen_8);
        lo_gewaehlte_symptome.add(lo_halsschmerzen_7);

        CL_Krankheit_Akt_Wahr lo_akt_wert_krankheit = new CL_Krankheit_Akt_Wahr(lo_gewaehlte_symptome, lo_grippe);
      
        CL_Krankheit_Akt_Wahr instance = lo_akt_wert_krankheit;
        
        double expResult = 0.45;
        
        double result = instance.im_cal_akt_wahr(lo_gewaehlte_symptome);
        
        assertEquals(expResult, result, 0.0);
       
    }
    
    

}
