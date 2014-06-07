/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.DosisFf;
import entity.FormaFarmaceutica;
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
public class DosisFfFacade extends AbstractFacade<DosisFf> implements DosisFfFacadeLocal {
    @PersistenceContext(unitName = "com.mycompany_Tooken-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DosisFfFacade() {
        super(DosisFf.class);
    }
    
   @Override
   public List<DosisFf> findDosisId(FormaFarmaceutica remedio) {
        Query q=em.createNamedQuery("DosisFf.findByFormaFarmaceuticaId").setParameter("ff", remedio);
        return q.getResultList();
    }
    
    
}
