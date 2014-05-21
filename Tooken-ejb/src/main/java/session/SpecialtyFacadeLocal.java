/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Specialty;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camilo
 */
@Local
public interface SpecialtyFacadeLocal {

    void create(Specialty specialty);

    void edit(Specialty specialty);

    void remove(Specialty specialty);

    Specialty find(Object id);

    List<Specialty> findAll();

    List<Specialty> findRange(int[] range);

    int count();
    
}
