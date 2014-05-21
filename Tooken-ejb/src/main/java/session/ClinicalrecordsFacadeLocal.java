/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Clinicalrecords;
import entity.Patients;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camilo
 */
@Local
public interface ClinicalrecordsFacadeLocal {

    void create(Clinicalrecords clinicalrecords);

    void edit(Clinicalrecords clinicalrecords);

    void remove(Clinicalrecords clinicalrecords);

    Clinicalrecords find(Object id);

    List<Clinicalrecords> findAll();

    List<Clinicalrecords> findRange(int[] range);

    int count();
    public List<Clinicalrecords> findRut(Patients patient);
    
}
