/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mb;

import entity.Clinicalrecords;
import entity.Patients;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import session.ClinicalrecordsFacadeLocal;
import session.FarmacoFacadeLocal;
import session.FfFarmacoFacadeLocal;
import session.FormaFarmaceuticaFacadeLocal;
import session.PatientsFacadeLocal;
import session.PrevisionFacadeLocal;

/**
 *
 * @author camilo
 */
@ManagedBean(name = "recetaexternaMb")
@RequestScoped
public class RecetaExternaMb {

    
    @EJB
    private FormaFarmaceuticaFacadeLocal formaFarmaceuticaFacade;
    @EJB
    private FfFarmacoFacadeLocal ffFarmacoFacade;
    @EJB
    private FarmacoFacadeLocal farmacoFacade;

    @EJB
    private PrevisionFacadeLocal previsionFacade;

    @EJB
    private ClinicalrecordsFacadeLocal clinicalrecordsFacade;
    @EJB
    private PatientsFacadeLocal patientsFacade;

    int ano;
    int mes;
    int dia;
    String nombreDoc;
    String apellidoDoc;
    String runDoc;
    String nombre;
    String runPac;
    String edad;
    String ficha;
    String text;
    String busca;
    String fecha;
    String txt;
    String domicilio;

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public RecetaExternaMb() {
    }

    public int getAno() {
        Calendar fecha = new GregorianCalendar();
        ano = fecha.get(Calendar.YEAR);
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        Calendar fecha = new GregorianCalendar();
        mes = fecha.get(Calendar.MONTH);
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        Calendar fecha = new GregorianCalendar();
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getNombreDoc() {

        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public String getRunDoc() {

        return runDoc;
    }

    public void setRunDoc(String runDoc) {
        this.runDoc = runDoc;
    }

    public String getRunPac() {

        return runPac;
    }

    public void setRunPac(String runPac) {
        this.runPac = runPac;
    }

    public String getEdad() {

        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFicha() {

        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public String getApellidoDoc() {
        return apellidoDoc;
    }

    public void setApellidoDoc(String apellidoDoc) {
        this.apellidoDoc = apellidoDoc;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void truco() {
        System.out.println(text);

    }

   
    
    public void mostrarDomicilio() {
        String rut = getBusca();
        this.txt = rut;
        System.out.println("ruuuuuuuuuut: " + rut);

        Patients persona = patientsFacade.find(rut);
        if (persona == null) {
            System.out.print("persona no encontrada");
            this.domicilio = "";
            return;
        }
        System.out.println("direccion: " + persona.getAddress());
        String datoPersona = persona.getAddress();

        this.domicilio = datoPersona;
    }

    public void mostrarEdad() {
        String rut = getBusca();

        Patients persona = patientsFacade.find(rut);
        System.out.println("direccion: " + persona.getDateOfBirth().toString());
        String datoPersona = persona.getDateOfBirth().toString();
        this.edad = datoPersona;
    }

    public void mostrarNombre() {
        String rut = getBusca();

        Patients persona = patientsFacade.find(rut);
        String datoPersona = persona.getFirstName();
        String datoPersona2 = persona.getLastName();
        String datoPersona3 = persona.getLastName2();
        this.nombre = datoPersona + " " + datoPersona2 + " " + datoPersona3;
    }

    public void mostrarFecha() {

        Calendar fecha2 = new GregorianCalendar();

        this.fecha = fecha2.get(Calendar.DAY_OF_MONTH) + "/" + fecha2.get(Calendar.MONTH) + "/" + fecha2.get(Calendar.YEAR);
    }

    public void mostrarFicha() {
        String rut = getBusca();
        List<Patients> lista = patientsFacade.findAll();
        Patients pasiente = new Patients();
        System.out.println("shiiiiiit");
        for (int i = 0; i < lista.size(); i++) {
            if (rut.equals(lista.get(i).getRut())) {
                pasiente = lista.get(i);
            }
        }
        List<Clinicalrecords> listaClinical = clinicalrecordsFacade.findRut(pasiente);
        System.out.println("hoooolaaaaa");
        System.out.println("ficha: " + listaClinical.get(0).getCrecid().toString());
        this.ficha = listaClinical.get(0).getCrecid().toString();

    }
    
 

    public void botonAct() {

        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("entre boton");
        
        if("".equals(busca) || busca==null){
            context.addMessage(null, new FacesMessage("ERROR", "Debe ingresar un RUN obligatoriamente" ));
        }
        else{
            try{
            System.out.println("rut valido");
            mostrarDomicilio();
            mostrarEdad();
            mostrarFecha();
            mostrarNombre();
            mostrarFicha();
            context.addMessage(null, new FacesMessage("Successful", "Datos obtenidos")); 
            }catch(NullPointerException e){
                context.addMessage(null, new FacesMessage("ERROR", "RUN no encontrado" ));
            }
            
        }
       
    }
        
        
        
    

    public List<String> complete(String query) {
        List<String> results = new ArrayList<String>();
        List<Patients> lista = patientsFacade.findAll();

        for (int i = 0; i < lista.size(); i++) {
            String rut = lista.get(i).getRut();

            if (rut.startsWith(query)) {
                System.out.println(rut);
                results.add(rut);
            }

        }

        return results;
    }

}
