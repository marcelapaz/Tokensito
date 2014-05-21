/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Farmaco;
import entity.FfFarmaco;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author camilo
 */
@Stateless
public class FfFarmacoFacade extends AbstractFacade<FfFarmaco> implements FfFarmacoFacadeLocal {
    @PersistenceContext(unitName = "com.mycompany_Tooken-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FfFarmacoFacade() {
        super(FfFarmaco.class);
    }
    
    @Override
    public List<FfFarmaco> findId(String idfarmaco) {
        Query q=em.createNamedQuery("FfFarmaco.findByFarmacoId").setParameter("farmacoId", idfarmaco);
        return q.getResultList();
    }
}
