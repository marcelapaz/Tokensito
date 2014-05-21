/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Citacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camilo
 */
@Local
public interface CitacionFacadeLocal {

    void create(Citacion citacion);

    void edit(Citacion citacion);

    void remove(Citacion citacion);

    Citacion find(Object id);

    List<Citacion> findAll();

    List<Citacion> findRange(int[] range);

    int count();
    
}
