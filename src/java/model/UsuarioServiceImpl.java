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
        
        /*List<Usuario> lista=new ArrayList<Usuario>();
        Short u=1;
        lista.add(new Usuario("ssss", "abc", u, "hshs", "sjfs", "sdfs"));
        return lista;
       
        */
        
        return usuarioDao.listar();
    }
    
    
}
