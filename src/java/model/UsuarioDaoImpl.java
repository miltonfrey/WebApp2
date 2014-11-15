
package model;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojos.Usuario;


@Named(value = "usuarioDaoImpl")
@RequestScoped
public class UsuarioDaoImpl implements UsuarioDao{

    
    @PersistenceContext(unitName = "WebApp2PU")
    private EntityManager entityManager;
    
    @Override
    public List<Usuario> listar(){
        
        return entityManager.createNamedQuery("Usuario.findAll").getResultList();
        
    }
    
    
    public UsuarioDaoImpl() {
    }
    
    
    
}
