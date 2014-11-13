
package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "bean1")
@ViewScoped
public class bean1 implements Serializable{

    private ArrayList<Mensaje> listaMensajes=new ArrayList<Mensaje>();
    
    @EJB
    private UsuarioFacade usuarioFacade;
    public bean1() {
    }

    @PostConstruct
    public void init(){
        ArrayList<Usuario> aux=new ArrayList<Usuario>();
        aux.addAll(usuarioFacade.findAll());
        Set s=aux.get(0).getMensajeSet();
        listaMensajes.addAll(s);
    }
    
    public ArrayList<Mensaje> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(ArrayList<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    
    
    
    
}
