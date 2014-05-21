/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Dosis;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camilo
 */
@Local
public interface DosisFacadeLocal {

    void create(Dosis dosis);

    void edit(Dosis dosis);

    void remove(Dosis dosis);

    Dosis find(Object id);

    List<Dosis> findAll();

    List<Dosis> findRange(int[] range);

    int count();
    
}
