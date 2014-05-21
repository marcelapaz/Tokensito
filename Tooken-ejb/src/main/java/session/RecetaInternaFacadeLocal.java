/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.RecetaInterna;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camilo
 */
@Local
public interface RecetaInternaFacadeLocal {

    void create(RecetaInterna recetaInterna);

    void edit(RecetaInterna recetaInterna);

    void remove(RecetaInterna recetaInterna);

    RecetaInterna find(Object id);

    List<RecetaInterna> findAll();

    List<RecetaInterna> findRange(int[] range);

    int count();
    
}
