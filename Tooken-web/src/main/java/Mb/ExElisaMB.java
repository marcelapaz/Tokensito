/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mb;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Holiwi-PC
 */
@Named(value = "exElisaMB")
@Dependent
public class ExElisaMB {

    /**
     * Creates a new instance of ExElisaMB
     */
    
    String tipo;
    public ExElisaMB() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
