/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Farmaco;
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
public class FarmacoFacade extends AbstractFacade<Farmaco> implements FarmacoFacadeLocal {
    @PersistenceContext(unitName = "com.mycompany_Tooken-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FarmacoFacade() {
        super(Farmaco.class);
    }
    
  
    @Override
        public List<Farmaco> findNombre(String entrada) {
        Query q=em.createNamedQuery("Farmaco.findByNombrefarmaco").setParameter("nombrefarmaco", entrada);
        return q.getResultList();
        
    }
    
}
