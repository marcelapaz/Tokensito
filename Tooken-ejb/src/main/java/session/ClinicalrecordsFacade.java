/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Clinicalrecords;
import entity.Patients;
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
public class ClinicalrecordsFacade extends AbstractFacade<Clinicalrecords> implements ClinicalrecordsFacadeLocal {
    @PersistenceContext(unitName = "com.mycompany_Tooken-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClinicalrecordsFacade() {
        super(Clinicalrecords.class);
    }

    @Override
    public List<Clinicalrecords> findRut(Patients patient) {
        Query q=em.createNamedQuery("Clinicalrecords.findByRut").setParameter("rut", patient);
        return q.getResultList();
    }
    
}