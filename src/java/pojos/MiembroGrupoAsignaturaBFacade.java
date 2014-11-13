/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cba
 */
@Stateless
public class MiembroGrupoAsignaturaBFacade extends AbstractFacade<MiembroGrupoAsignaturaB> {
    @PersistenceContext(unitName = "WebApp2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MiembroGrupoAsignaturaBFacade() {
        super(MiembroGrupoAsignaturaB.class);
    }
    
}
