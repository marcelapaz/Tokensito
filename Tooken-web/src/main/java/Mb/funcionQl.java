/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mb;

import entity.Clinicalrecords;
import entity.Dosis;
import entity.DosisFf;
import entity.Farmaco;
import entity.FfFarmaco;
import entity.FormaFarmaceutica;
import entity.Prescription;
import entity.Professionals;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import session.ClinicalrecordsFacadeLocal;
import session.DosisFacadeLocal;
import session.DosisFfFacadeLocal;
import session.FarmacoFacadeLocal;
import session.FfFarmacoFacadeLocal;
import session.FormaFarmaceuticaFacadeLocal;
import session.PrescriptionFacadeLocal;
import session.ProfessionalsFacadeLocal;

/**
 *
 * @author camilo
 */
@ManagedBean
@SessionScoped
public class funcionQl {

    @Inject
    LoginSessionMB session;
    

    @EJB
    private ClinicalrecordsFacadeLocal clinicalrecordsFacade;
    @EJB
    private ProfessionalsFacadeLocal professionalsFacade;
    @EJB
    private PrescriptionFacadeLocal prescriptionFacade;
    @EJB
    private DosisFfFacadeLocal dosisFfFacade;
    @EJB
    private FormaFarmaceuticaFacadeLocal formaFarmaceuticaFacade;
    @EJB
    private DosisFacadeLocal dosisFacade;
    @EJB
    private FfFarmacoFacadeLocal ffFarmacoFacade;
    @EJB
    private FarmacoFacadeLocal farmacoFacade;

    List<String> dosis;
    String dosis2;
    String buscaFarmaco;
    List<String> formaFarm;
    List<FormaFarmaceutica> aa;
    String ff;
    List<String> receta = new ArrayList<String>();
    String periodo;
    String unidades;
    List<datosReceta> recetaa = new ArrayList<datosReceta>();
    String verificar;
    String userPrint;
    String passPrint;
    String busca;
    public static int validacion;

    public funcionQl() {
    }

    public List<String> complete2(String query) {
        List<String> results = new ArrayList<String>();
        List<Farmaco> lista = farmacoFacade.findAll();

        for (int i = 0; i < lista.size(); i++) {
            String nombre = lista.get(i).getNombrefarmaco();

            if (nombre.startsWith(query)) {
                System.out.println(nombre);
                results.add(nombre);
            }

        }

        return results;
    }

    public void mostrarForma() {
        
        List<Farmaco> farmaco = farmacoFacade.findNombre(buscaFarmaco);

        //System.out.println(farmaco.getNombrefarmaco());
        List<String> results = new ArrayList<String>();
        List<FormaFarmaceutica> results2 = new ArrayList<FormaFarmaceutica>();
        

        List<FfFarmaco> listaff = ffFarmacoFacade.findFarmacoId(farmaco.get(0));
        
        //System.out.println("fff: "+listaff);

        for (int i = 0; i < listaff.size(); i++) {
            FormaFarmaceutica listaFormFarm = listaff.get(i).getFormafarmaceuticaid();
            results2.add(listaFormFarm);
            results.add(listaFormFarm.getNombreFf());

        }
        System.out.println(results);

        this.formaFarm = results;
        this.aa = results2;
    }

    public void mostrarDosis() {
        System.out.println("getff: " + getFf());
        System.out.println("ff: " + ff);
        List<FormaFarmaceutica> formaFarmaceutica = formaFarmaceuticaFacade.findNombreFF(ff);
       
        //System.out.println(farmaco.getNombrefarmaco());
        List<String> results = new ArrayList<String>();

        List<DosisFf> listaDosis = dosisFfFacade.findDosisId(formaFarmaceutica.get(0));
       

        for (int i = 0; i < listaDosis.size(); i++) {
            Dosis listadosis = listaDosis.get(i).getDosisid();
            results.add(listadosis.getCantidad() + " " + listadosis.getMedida());

        }
        System.out.println(results);

        this.dosis = results;

    }

   
/* EL "BUSCA" NO SE OBTIENE POR EL MOMENTO*/
    public void validarBotonGuardar() {
        System.out.println("----------->Entre a GUARDAR");
        
        FacesContext context = FacesContext.getCurrentInstance();
        /*boolean hayrut;
        try{
        if (busca.equals("") || busca == null) {
            hayrut=false;
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Debe ingresar un RUN obligatoriamente"));
        } else {
            hayrut = true;
        }
        }catch(NullPointerException e){
            hayrut=false;
        }
        System.out.println("hayrut:"+hayrut);
        System.out.println("validacion:"+validacion);
        if (hayrut && validacion == 1) {
            System.out.println("Guardar");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Datos Guardados"));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Para Guardar debe ingresar todos los campos solicitados"));
        }*/

    }

    public void validarBotonMas() {
        FacesContext context = FacesContext.getCurrentInstance();

        //hayRut(context);
        if (periodo == null || periodo == "" || periodo.equals("") || dosis == null || dosis.equals("")
                || formaFarm == null || formaFarm.equals("") || ff == null || ff.equals("") || buscaFarmaco == null
                || buscaFarmaco.equals("") || dosis2 == null || dosis2.equals("") || unidades == null || unidades.equals("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Ingrese todos los campos de Medicamentos, luego pulse el botón ''Más'"));
            validacion = 0;
        } else {
            try {
                int p = Integer.parseInt(periodo);
                int u = Integer.parseInt(unidades);
                if (p >= 1 && u >= 1) {
                    datosReceta objeto = new datosReceta(buscaFarmaco, ff, dosis2, periodo, unidades);
                    recetaa.add(objeto);
                    validacion = 1;
                    this.buscaFarmaco = "";
                    this.formaFarm.clear();
                    this.dosis.clear();
                    this.periodo = "";
                    this.unidades = "";
                    

                } else {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Periodo y unidades exigen números mayores ó igual a 1"));
                    validacion = 0;
                }

            } catch (NumberFormatException nfe) {
                validacion = 0;
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Periodo y unidades exige datos numéricos"));
            }
        }

    }

    public void eliminarReceta(String clave) {

        for (int i = 0; i < recetaa.size(); i++) {
            if (recetaa.get(i).id.equals(clave)) {
                recetaa.remove(i);
            }
        }
    }

    public void guardarReceta() {
        Prescription receta = new Prescription();
        Professionals doctor = new Professionals();
        Clinicalrecords clin = new Clinicalrecords();
        clin = clinicalrecordsFacade.find(1);
        doctor = professionalsFacade.find("19");
        receta.setDescription("description");
        receta.setRut(doctor);
        receta.setCrecid(clin);
        Calendar fecha2 = new GregorianCalendar();
        fecha2.setWeekDate(1, 2, 1);

        prescriptionFacade.create(receta);

    }

    public void comparar() {
        System.out.println("entre a comparar" + session.getRut() + " " + session.getContrasena());

        if (session.getRut().equals(userPrint) && session.getContrasena().equals(passPrint)) {
            verificar = "Si";
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario Invalido", "Verificar usuario o contraseña"));
            verificar = "No";
        }

    }

    public String getVerificar() {
        return verificar;
    }

    public void setVerificar(String verificar) {
        this.verificar = verificar;
    }

    public String getUserPrint() {
        return userPrint;
    }

    public void setUserPrint(String userPrint) {
        this.userPrint = userPrint;
    }

    public String getPassPrint() {
        return passPrint;
    }

    public void setPassPrint(String passPrint) {
        this.passPrint = passPrint;
    }

    public List<String> getDosis() {
        return dosis;
    }

    public void setDosis(List<String> dosis) {
        this.dosis = dosis;
    }

    public String getDosis2() {
        return dosis2;
    }

    public void setDosis2(String dosis2) {
        this.dosis2 = dosis2;
    }

    public String getBuscaFarmaco() {
        return buscaFarmaco;
    }

    public void setBuscaFarmaco(String buscafarmaco) {
        this.buscaFarmaco = buscafarmaco;
    }

    public List<String> getFormaFarm() {
        return formaFarm;
    }

    public void setFormaFarm(List<String> formaFarm) {
        this.formaFarm = formaFarm;
    }

    public String getFf() {
        return ff;
    }

    public void setFf(String ff) {
        this.ff = ff;
    }

    public void clear() {
        ff = null;
    }

    public List<FormaFarmaceutica> getAa() {
        return aa;
    }

    public void setAa(List<FormaFarmaceutica> aa) {
        this.aa = aa;
    }

    public List<String> getReceta() {
        return receta;
    }

    public void setReceta(List<String> receta) {
        this.receta = receta;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public List<datosReceta> getRecetaa() {
        return recetaa;
    }

    public void setRecetaa(List<datosReceta> recetaa) {
        this.recetaa = recetaa;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

}
