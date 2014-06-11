/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author jaco
 */
@Named(value = "microMb")
@RequestScoped
public class MicroMb {

    private String[] selectedBio;
    private String[] selectedCito;
    private String[] selectedCito1;
    private String[] selectedCito2;
    private String[] selectedCito3;
    private List<String> exam;
    private List<String> examCito;
    private List<String> examCito1;
    private List<String> examCito2;
    private List<String> examCito3;
    private String description;
    
    @PostConstruct
    public void init() {
        
        exam = new ArrayList<String>();
        examCito = new ArrayList<String>();
        examCito1 = new ArrayList<String>();
        examCito2 = new ArrayList<String>();
        examCito3 = new ArrayList<String>();
        
         
        exam.add("Gram");
        exam.add("Examen directo fresco");
        exam.add("Antibiograma");
        exam.add("Cultivo corriente");
        exam.add("Cultivo anaerobio");
        exam.add("Cultivo hongos");
        exam.add("Hermocultivo aerobio I");
        exam.add("Hermocultivo aerobio II");
        exam.add("Hermocultivo aerobio");
        exam.add("Hermocultivo cateter");
        exam.add("Hermocultivo hongos");
        exam.add("Punta de cateter");
        exam.add("Liquido cavidad esteril en vial");
        exam.add("Urocultivo(incluye antibiograma)");
        exam.add("Coprocultivo");
        examCito.add("Cultivo corriente 1");
        examCito.add("Cultivo corriente 2");
        examCito1.add("Cultivo corriente 1");
        examCito1.add("Cultivo corriente 2");
        examCito2.add("Frasco hermocultivo");
        examCito2.add("Cultivo corriente");
        examCito3.add("Cultivo corriente 1");
        examCito3.add("Cultivo corriente 2");
        examCito3.add("Flujo vaginal (incluye Ex. directo, Gram, Trichonomas, c.corriente, c.hongos)");
        examCito3.add("Secrecion uretral");
        examCito3.add("C. Neisseria gonorrhoeae");
        examCito3.add("Portacion Streptococcus Grupo B embarazadas (vaginorectal)");
        examCito3.add("Cultivo deposiciones Clostridium difficille");
        examCito3.add("Toxina C. difficille en deposiciones");
        examCito3.add("Hisopado recral para busqueda ERV");
        examCito3.add("Tinta china");
        examCito3.add("Test ureasa");
        
        

    }

    public String[] getSelectedBio() {
        return selectedBio;
    }

    public void setSelectedBio(String[] selectedBio) {
        this.selectedBio = selectedBio;
    }

    public String[] getSelectedCito() {
        return selectedCito;
    }

    public void setSelectedCito(String[] selectedCito) {
        this.selectedCito = selectedCito;
    }

    public List<String> getExam() {
        return exam;
    }

    public void setExam(List<String> exam) {
        this.exam = exam;
    }

    public List<String> getExamCito() {
        return examCito;
    }

    public void setExamCito(List<String> examCito) {
        this.examCito = examCito;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getSelectedCito1() {
        return selectedCito1;
    }

    public void setSelectedCito1(String[] selectedCito1) {
        this.selectedCito1 = selectedCito1;
    }

    public String[] getSelectedCito2() {
        return selectedCito2;
    }

    public void setSelectedCito2(String[] selectedCito2) {
        this.selectedCito2 = selectedCito2;
    }

    public String[] getSelectedCito3() {
        return selectedCito3;
    }

    public void setSelectedCito3(String[] selectedCito3) {
        this.selectedCito3 = selectedCito3;
    }

    public List<String> getExamCito1() {
        return examCito1;
    }

    public void setExamCito1(List<String> examCito1) {
        this.examCito1 = examCito1;
    }

    public List<String> getExamCito2() {
        return examCito2;
    }

    public void setExamCito2(List<String> examCito2) {
        this.examCito2 = examCito2;
    }

    public List<String> getExamCito3() {
        return examCito3;
    }

    public void setExamCito3(List<String> examCito3) {
        this.examCito3 = examCito3;
    }
    
    
    
}
