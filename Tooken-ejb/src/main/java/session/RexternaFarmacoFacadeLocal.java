/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.RexternaFarmaco;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camilo
 */
@Local
public interface RexternaFarmacoFacadeLocal {

    void create(RexternaFarmaco rexternaFarmaco);

    void edit(RexternaFarmaco rexternaFarmaco);

    void remove(RexternaFarmaco rexternaFarmaco);

    RexternaFarmaco find(Object id);

    List<RexternaFarmaco> findAll();

    List<RexternaFarmaco> findRange(int[] range);

    int count();
    
}
