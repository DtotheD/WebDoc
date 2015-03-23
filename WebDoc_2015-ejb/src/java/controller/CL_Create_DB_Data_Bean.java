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
        CL_Empfehlung lo_empfhelung_3 = new CL_Empfehlung("Nehmen Sie viel Flüssigkeit zu sich!");
        CL_Empfehlung lo_empfhelung_4 = new CL_Empfehlung("Vermeiden Sie stark gewürzte Gerichte!");
        CL_Empfehlung lo_empfhelung_5 = new CL_Empfehlung("Trinken Sie Kräutertee!");
        CL_Empfehlung lo_empfhelung_6 = new CL_Empfehlung("Vermeiden Sie Konatk mit anderen Menschem um diese nicht anzustecken!");

        io_em.persist(lo_empfhelung_1);
        io_em.persist(lo_empfhelung_2);
        io_em.persist(lo_empfhelung_3);
        io_em.persist(lo_empfhelung_4);
        io_em.persist(lo_empfhelung_5);
        io_em.persist(lo_empfhelung_6);

        io_em.flush();

        //Husten
        CL_Bewertetes_Symptom lo_husten_9 = new CL_Bewertetes_Symptom(lo_symptom_1, 9);
        CL_Bewertetes_Symptom lo_husten_8 = new CL_Bewertetes_Symptom(lo_symptom_1, 8);

        //Fieber
        CL_Bewertetes_Symptom lo_fieber_9 = new CL_Bewertetes_Symptom(lo_symptom_2, 9);

        //Kopfschmerzen
        CL_Bewertetes_Symptom lo_kopfschmerzen_8 = new CL_Bewertetes_Symptom(lo_symptom_3, 8);
        CL_Bewertetes_Symptom lo_kopfschmerzen_7 = new CL_Bewertetes_Symptom(lo_symptom_3, 7);

        //Halsschmerzen
        CL_Bewertetes_Symptom lo_halsschmerzen_7 = new CL_Bewertetes_Symptom(lo_symptom_4, 7);

        //Bauchschmerzen
        CL_Bewertetes_Symptom lo_bauchschmerzen_9 = new CL_Bewertetes_Symptom(lo_symptom_5, 9);
        CL_Bewertetes_Symptom lo_bauchschmerzen_2 = new CL_Bewertetes_Symptom(lo_symptom_5, 2);

        //Durchfall
        CL_Bewertetes_Symptom lo_durchfall_9 = new CL_Bewertetes_Symptom(lo_symptom_6, 9);

        //laufende Nase
        CL_Bewertetes_Symptom lo_nase_8 = new CL_Bewertetes_Symptom(lo_symptom_7, 8);

        //Gliederschmerzen
        CL_Bewertetes_Symptom lo_glieder_7 = new CL_Bewertetes_Symptom(lo_symptom_8, 7);
        CL_Bewertetes_Symptom lo_glieder_4 = new CL_Bewertetes_Symptom(lo_symptom_8, 4);

        //Haarausfall
        CL_Bewertetes_Symptom lo_haar_7 = new CL_Bewertetes_Symptom(lo_symptom_9, 7);

        //Gewichtsverlust
        CL_Bewertetes_Symptom lo_gewicht_10 = new CL_Bewertetes_Symptom(lo_symptom_10, 10);
        CL_Bewertetes_Symptom lo_gewicht_2 = new CL_Bewertetes_Symptom(lo_symptom_10, 2);

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
        CL_Krankheit lo_grippe = new CL_Krankheit(120, "Grippe");
        lo_grippe.addSymptom(lo_husten_9);
        lo_grippe.addSymptom(lo_kopfschmerzen_8);
        lo_grippe.addSymptom(lo_halsschmerzen_7);
        lo_grippe.addSymptom(lo_nase_8);
        lo_grippe.addSymptom(lo_glieder_7);
        lo_grippe.addSymptom(lo_fieber_9);

        lo_grippe.addBeschreibung("Die Influenza, auch „echte“ Grippe oder Virusgrippe genannt, ist eine durch Viren aus den Gattungen Influenzavirus A oder B ausgelöste Infektionskrankheit bei Menschen.");
        lo_grippe.addBeschreibung("Alltagssprachlich wird die Bezeichnung Grippe häufig auch für grippale Infekte verwendet, bei denen es sich um verschiedene andere, in der Regel deutlich harmloser verlaufende Virusinfektionen handelt.");

        lo_grippe.addEmpfehlung(lo_empfhelung_1);
        lo_grippe.addEmpfehlung(lo_empfhelung_2);
        lo_grippe.addEmpfehlung(lo_empfhelung_3);
        lo_grippe.addEmpfehlung(lo_empfhelung_5);
        lo_grippe.addEmpfehlung(lo_empfhelung_6);
        lo_grippe.addEmpfehlung(lo_empfhelung_5);
        lo_grippe.addEmpfehlung(lo_empfhelung_6);

        io_em.persist(lo_grippe);

        //Erkältung
        CL_Krankheit lo_erkaeltung = new CL_Krankheit(120, "Erkältung");

        lo_erkaeltung.addSymptom(lo_husten_8);
        lo_erkaeltung.addSymptom(lo_kopfschmerzen_7);
        lo_erkaeltung.addSymptom(lo_fieber_9);
        lo_erkaeltung.addSymptom(lo_halsschmerzen_7);
        lo_erkaeltung.addSymptom(lo_nase_8);
        lo_erkaeltung.addSymptom(lo_glieder_4);

        lo_erkaeltung.addBeschreibung("Erkältung (österreichisch auch Verkühlung) und grippaler Infekt sind alltagssprachliche, medizinisch nicht scharf definierte Bezeichnungen für eine akute Infektionskrankheit der Schleimhaut von Nase (einschließlich der Nebenhöhlen), Hals oder Bronchien. Die Infektionskrankheit wird überwiegend von sehr unterschiedlichen Viren, manchmal zusätzlich auch von Bakterien verursacht (Sekundärinfektion, in diesem Zusammenhang auch Superinfektion genannt).");
        lo_erkaeltung.addBeschreibung("Die häufigsten Erkältungsviren gehören zu den Virusgattungen der Rhino-, Entero- und Mastadenoviren oder den Familien der Corona- und Paramyxoviridae.");
        
        lo_erkaeltung.addEmpfehlung(lo_empfhelung_2);
        lo_erkaeltung.addEmpfehlung(lo_empfhelung_3);
        lo_erkaeltung.addEmpfehlung(lo_empfhelung_5);

        //Schilddrüsenüberfunktion
        CL_Krankheit lo_schild = new CL_Krankheit(80, "Schilddrüsenüberfunktion");

        lo_schild.addSymptom(lo_bauchschmerzen_2);
        lo_schild.addSymptom(lo_durchfall_9);
        lo_schild.addSymptom(lo_haar_7);
        lo_schild.addSymptom(lo_gewicht_10);

        lo_schild.addBeschreibung("Die Hyperthyreose ist eine krankhafte Überfunktion der Schilddrüse, die sich in einer übermäßigen Produktion von Schilddrüsenhormonen äußert, so dass im Organismus ein entsprechendes Überangebot entsteht.");
        
        lo_schild.addEmpfehlung(lo_empfhelung_1);

        //Reizdarm
        CL_Krankheit lo_reiz = new CL_Krankheit(60, "Reizdarmsyndrom");

        lo_reiz.addSymptom(lo_bauchschmerzen_9);
        lo_reiz.addSymptom(lo_durchfall_9);
        lo_reiz.addSymptom(lo_gewicht_2);

        lo_reiz.addBeschreibung("In der Medizin (Gastroenterologie) bezeichnet der Begriff Reizdarmsyndrom (RDS) eine Gruppe funktioneller Darmerkrankungen, die eine hohe Prävalenz (Krankheitshäufigkeit in der Bevölkerung) haben und bis zu 50 % der Besuche beim Spezialisten ausmachen.");
        lo_reiz.addBeschreibung("Das Reizdarmsyndrom kann Symptome aller möglichen Darmerkrankungen nachahmen, ist jedoch, wenn diese Erkrankungen ausgeschlossen sind, ungefährlich.");
       
        lo_reiz.addEmpfehlung(lo_empfhelung_1);
        lo_reiz.addEmpfehlung(lo_empfhelung_2);
        lo_reiz.addEmpfehlung(lo_empfhelung_3);
        lo_reiz.addEmpfehlung(lo_empfhelung_4);

        io_em.persist(lo_reiz);
        io_em.persist(lo_schild);
        io_em.persist(lo_erkaeltung);

        io_em.flush();

    }

}
