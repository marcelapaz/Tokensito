/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mb;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author camilo
 */
@ManagedBean(name = "recetaexternaMb")
@RequestScoped
public class RecetaExternaMb {

    int ano;
    int mes;
    int dia;
    String nombreDoc;
    String runDoc;
    String nombrePac;
    String runPac;
    String edad;
    String ficha;
    
    
    public RecetaExternaMb() {
    }

    public int getAno() {
        Calendar fecha=new GregorianCalendar();
        ano=fecha.get(Calendar.YEAR);
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes(){ 
        Calendar fecha=new GregorianCalendar();
        mes=fecha.get(Calendar.MONTH);    
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        Calendar fecha=new GregorianCalendar();
        dia=fecha.get(Calendar.DAY_OF_MONTH);
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getNombreDoc() {
        nombreDoc="MarcePaz";
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public String getRunDoc() {
        runDoc="17488881-7";
        return runDoc;
    }

    public void setRunDoc(String runDoc) {
        this.runDoc = runDoc;
    }

    public String getNombrePac() {
        nombrePac="Juan Perez";
        return nombrePac;
    }

    public void setNombrePac(String nombrePac) {
        this.nombrePac = nombrePac;
    }

    public String getRunPac() {
        runPac="18339446-3";
        return runPac;
    }

    public void setRunPac(String runPac) {
        this.runPac = runPac;
    }

    public String getEdad() {
        edad="20";
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFicha() {
        ficha="13";
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }
    
}
