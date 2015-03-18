/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author DEKREDAV
 */
@Entity
public class CL_Empfehlung {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iv_id;
    
    private String iv_text;
    
}
