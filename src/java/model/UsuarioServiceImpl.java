package model;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import pojos.Usuario;


@Stateless
public class UsuarioServiceImpl implements UsuarioService{

    @Inject
    private UsuarioDao usuarioDao;

    
    
    
    
    
    @Override
    public List<Usuario> listar(){
       
        
        return usuarioDao.listar();
    }
    
    
}
