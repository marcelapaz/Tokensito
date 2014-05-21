/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.FormaFarmaceutica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camilo
 */
@Local
public interface FormaFarmaceuticaFacadeLocal {

    void create(FormaFarmaceutica formaFarmaceutica);

    void edit(FormaFarmaceutica formaFarmaceutica);

    void remove(FormaFarmaceutica formaFarmaceutica);

    FormaFarmaceutica find(Object id);

    List<FormaFarmaceutica> findAll();

    List<FormaFarmaceutica> findRange(int[] range);

    int count();
    
}
