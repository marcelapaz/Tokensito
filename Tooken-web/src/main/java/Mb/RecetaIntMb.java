/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mb;

import entity.Clinicalrecords;
import entity.Farmaco;
import entity.FfFarmaco;
import entity.FormaFarmaceutica;
import entity.Patients;
import entity.Prevision;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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




@ManagedBean
@RequestScoped
public class RecetaIntMb {
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
    
    
    String txt;
    String edad;
    String nombre;
    String domicilio;
    String ciudad;
    String fecha;
    String ficha;
    String prevision;
    Date date;
    String busca;
    String buscaFarmaco;
    List<String> formaFarm;
    
    
    
    
    
    
    public RecetaIntMb() {
        
    }
    
    
    public List<String> complete(String query) {
        List<String> results = new ArrayList<String>();
        List<Patients> lista = patientsFacade.findAll();
        
        for (int i = 0; i < lista.size(); i++) {
           String rut=lista.get(i).getRut();
           
         if(rut.startsWith(query)){
                System.out.println(rut);
               results.add(rut);
          }
            
            
        }
         
        return results;
    }
    
    public List<String> complete2(String query) {
        List<String> results = new ArrayList<String>();
        List<Farmaco> lista = farmacoFacade.findAll();
        
        for (int i = 0; i < lista.size(); i++) {
           String nombre=lista.get(i).getNombrefarmaco();
           
         if(nombre.startsWith(query)){
                System.out.println(nombre);
               results.add(nombre);
          }
            
            
        }
         
        return results;
    }
    
    
    
    public void mostrarEdad(){
        String rut = getBusca();
        
        
        Patients persona = patientsFacade.find(rut);
        System.out.println("direccion: "+persona.getDateOfBirth().toString());
        String datoPersona =persona.getDateOfBirth().toString();
        this.edad=datoPersona;
    }
   
    public void mostrarForma(){
        System.out.println("nada: "+ getBuscaFarmaco());
        System.out.println("lala: "+buscaFarmaco);
        List<Farmaco> farmaco = farmacoFacade.findNombre(buscaFarmaco);
        
        //System.out.println(farmaco.getNombrefarmaco());
        List<String> results = new ArrayList<String>();
        System.out.println("tamano: "+farmaco);
        
       
        
        
        
        //List<FfFarmaco> listaff = ffFarmacoFacade.findId(farmaco.get(0).getFarmacoid().toString());
        //System.out.println("fff: "+listaff);
        
        /*System.out.println(listaff.get(0).getFormafarmaceuticaid());
        
        
        
        for(int i=0;i<listaff.size();i++){
            FormaFarmaceutica listaFormFarm=formaFarmaceuticaFacade.find(listaff.get(i).getFormafarmaceuticaid());
            results.add(listaFormFarm.getNombreFf());
        */
        
        results.add("parecetamol1");
        results.add("parecetamol2");
        results.add("parecetamol3");
        results.add("parecetamol4");
        
         this.formaFarm=results;
    }
    
    public void mostrarNombre(){
        String rut = getBusca();
        
        
        Patients persona = patientsFacade.find(rut);        
        String datoPersona =persona.getFirstName();
        String datoPersona2 =persona.getLastName();
        String datoPersona3 =persona.getLastName2();
        this.nombre=datoPersona+" "+datoPersona2+" "+datoPersona3;
    }
    
    public void mostrarFecha(){
        
        Calendar fecha2=new GregorianCalendar();
        
        
        this.fecha=fecha2.get(Calendar.DAY_OF_MONTH)+"/"+fecha2.get(Calendar.MONTH)+"/"+fecha2.get(Calendar.YEAR);
    }
    
    public void mostrarDomicilio(){
        String rut = getBusca();
        this.txt=rut;
        System.out.println("ruuuuuuuuuut: "+rut);
     
        Patients persona = patientsFacade.find(rut);
        if (persona == null) {
            System.out.print("persona no encontrada");
            this.domicilio = "";
            return;
        }
        System.out.println("direccion: "+persona.getAddress());
        String datoPersona = persona.getAddress();
       
        this.domicilio=datoPersona;
    }
    
   public void mostrarFicha(){
        String rut = getBusca();
        List<Patients> lista = patientsFacade.findAll(); 
        Patients pasiente=new Patients();
        System.out.println("shiiiiiit");
        for (int i = 0; i < lista.size(); i++) {
            if(rut.equals(lista.get(i).getRut()))
                pasiente = lista.get(i);
        }
        List<Clinicalrecords> listaClinical= clinicalrecordsFacade.findRut(pasiente);
        System.out.println("hoooolaaaaa");
        System.out.println("ficha: "+listaClinical.get(0).getCrecid().toString());
        this.ficha=listaClinical.get(0).getCrecid().toString();
        
        
      
    }
   
   public void mostrarPrevision(){
        String rut = getBusca();
        List<Patients> lista = patientsFacade.findAll(); 
        Patients pasiente=new Patients();
        Prevision prev = new Prevision();
        for (int i = 0; i < lista.size(); i++) {
            if(rut.equals(lista.get(i).getRut())){
                pasiente = lista.get(i);
                prev = pasiente.getPrevisionid();
            }
        }
      //  List<Prevision> listaPrevision= previsionFacade.findID(pasiente);
     
        this.prevision=prev.getType();
       
        
      
    }
   
    

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getEdad() {
        
        return edad;
    }

    public void setEdad(String edad) {
        
        
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

 
    public void botonAct(){
        
        FacesContext context = FacesContext.getCurrentInstance();
         
        if(busca=="" || busca==null){
            context.addMessage(null, new FacesMessage("Successful", "RUN invalido" ));
        }
        else{
        
            mostrarDomicilio();

            mostrarEdad();

            mostrarFecha();

            mostrarNombre();

            mostrarFicha();

            mostrarPrevision();



            context.addMessage(null, new FacesMessage("Successful", "RUN encontrado" ));
        }
    }
    
    
    
    public void botonAct2(){
        
        mostrarEdad();
        mostrarFecha();
        mostrarNombre();
        mostrarFicha();
        
    }
    
    public void botonAct3(){
        
        mostrarNombre();
        mostrarPrevision();
        
        
        
    }

    public String getPrevision() {
        return prevision;
    }

    public void setPrevision(String prevision) {
        this.prevision = prevision;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public String getBuscaFarmaco() {
        return buscaFarmaco;
    }

    public void setBuscaFarmaco(String buscaFarmaco) {
        this.buscaFarmaco = buscaFarmaco;
    }

    public List<String> getFormaFarm() {
        return formaFarm;
    }

    public void setFormaFarm(List<String> formaFarm) {
        this.formaFarm = formaFarm;
    }

    
  
    
}
