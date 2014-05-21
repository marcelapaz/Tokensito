/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Professionals;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camilo
 */
@Local
public interface ProfessionalsFacadeLocal {

    void create(Professionals professionals);

    void edit(Professionals professionals);

    void remove(Professionals professionals);

    Professionals find(Object id);

    List<Professionals> findAll();

    List<Professionals> findRange(int[] range);

    int count();
    
}
