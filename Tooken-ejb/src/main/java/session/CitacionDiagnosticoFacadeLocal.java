/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.CitacionDiagnostico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camilo
 */
@Local
public interface CitacionDiagnosticoFacadeLocal {

    void create(CitacionDiagnostico citacionDiagnostico);

    void edit(CitacionDiagnostico citacionDiagnostico);

    void remove(CitacionDiagnostico citacionDiagnostico);

    CitacionDiagnostico find(Object id);

    List<CitacionDiagnostico> findAll();

    List<CitacionDiagnostico> findRange(int[] range);

    int count();
    
}
