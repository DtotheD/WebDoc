/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import model.CL_Symptom;

/**
 *
 * @author DEKREDAV
 */
@Local
public interface IN_Symptom_Bean {
    
    public CL_Symptom im_create_Symptom(String pv_name);
    
    public List im_getAllSymptoms();
    
}
