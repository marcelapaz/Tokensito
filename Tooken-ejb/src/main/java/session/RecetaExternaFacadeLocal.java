/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.RecetaExterna;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camilo
 */
@Local
public interface RecetaExternaFacadeLocal {

    void create(RecetaExterna recetaExterna);

    void edit(RecetaExterna recetaExterna);

    void remove(RecetaExterna recetaExterna);

    RecetaExterna find(Object id);

    List<RecetaExterna> findAll();

    List<RecetaExterna> findRange(int[] range);

    int count();
    
}
