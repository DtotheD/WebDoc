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
     */
    @Test
    public void testIm_cal_akt_wert() {
        System.out.println("im_cal_akt_wert");
        CL_Symptom lo_symptom_1 = new CL_Symptom("Husten");
        CL_Symptom lo_symptom_2 = new CL_Symptom("Fieber");
        CL_Symptom lo_symptom_3 = new CL_Symptom("Kopfschmerzen");
        CL_Symptom lo_symptom_4 = new CL_Symptom("Halsschmerzen");
        CL_Symptom lo_symptom_7 = new CL_Symptom("laufende Nase");
        CL_Symptom lo_symptom_8 = new CL_Symptom("Gliederschmerzen");


        CL_Empfehlung lo_empfhelung_1 = new CL_Empfehlung("Gehen Sie zum Arzt!");

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
        CL_Krankheit lo_grippe = new CL_Krankheit("Hier kommt die Beschreibung", lo_empfhelung_1, 120);
        lo_grippe.addSymptom(lo_husten_9);
        lo_grippe.addSymptom(lo_kopfschmerzen_8);
        lo_grippe.addSymptom(lo_halsschmerzen_7);
        lo_grippe.addSymptom(lo_nase_8);
        lo_grippe.addSymptom(lo_glieder_7);
        lo_grippe.addSymptom(lo_fieber_9);

        ArrayList<CL_Bewertetes_Symptom> lo_gewaehlte_symptome = new ArrayList<>();

        lo_gewaehlte_symptome.add(lo_husten_9);
        lo_gewaehlte_symptome.add(lo_kopfschmerzen_8);
        lo_gewaehlte_symptome.add(lo_halsschmerzen_7);
        lo_gewaehlte_symptome.add(lo_nase_8);
        lo_gewaehlte_symptome.add(lo_glieder_7);
        lo_gewaehlte_symptome.add(lo_fieber_9);

        CL_Krankheit_Akt_Wert lo_akt_wert_krankheit = new CL_Krankheit_Akt_Wert(lo_gewaehlte_symptome, lo_grippe);
      
        CL_Krankheit_Akt_Wert instance = lo_akt_wert_krankheit;
        
        double expResult = 0.9;
        
        double result = instance.im_cal_akt_wert(lo_gewaehlte_symptome);
        
        assertEquals(expResult, result, 0.0);
       
    }

//    /**
//     * Test of getIo_krankheit method, of class CL_Krankheit_Akt_Wert.
//     */
//    @Test
//    public void testGetIo_krankheit() {
//        System.out.println("getIo_krankheit");
//        CL_Krankheit_Akt_Wert instance = null;
//        CL_Krankheit expResult = null;
//        CL_Krankheit result = instance.getIo_krankheit();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getIv_akt_wert method, of class CL_Krankheit_Akt_Wert.
//     */
//    @Test
//    public void testGetIv_akt_wert() {
//        System.out.println("getIv_akt_wert");
//        CL_Krankheit_Akt_Wert instance = null;
//        double expResult = 0.0;
//        double result = instance.getIv_akt_wert();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setIo_krankheit method, of class CL_Krankheit_Akt_Wert.
//     */
//    @Test
//    public void testSetIo_krankheit() {
//        System.out.println("setIo_krankheit");
//        CL_Krankheit io_krankheit = null;
//        CL_Krankheit_Akt_Wert instance = null;
//        instance.setIo_krankheit(io_krankheit);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setIv_akt_wert method, of class CL_Krankheit_Akt_Wert.
//     */
//    @Test
//    public void testSetIv_akt_wert() {
//        System.out.println("setIv_akt_wert");
//        double iv_akt_wert = 0.0;
//        CL_Krankheit_Akt_Wert instance = null;
//        instance.setIv_akt_wert(iv_akt_wert);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of compareTo method, of class CL_Krankheit_Akt_Wert.
//     */
//    @Test
//    public void testCompareTo() {
//        System.out.println("compareTo");
//        CL_Krankheit_Akt_Wert po_krankheit_akt_wert = null;
//        CL_Krankheit_Akt_Wert instance = null;
//        int expResult = 0;
//        int result = instance.compareTo(po_krankheit_akt_wert);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
