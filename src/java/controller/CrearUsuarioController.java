/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import model.UsuarioService;
import pojos.Mensaje;
import pojos.Usuario;


@Named(value = "crearUsuarioController")
@ViewScoped
public class CrearUsuarioController implements Serializable{

    
    @EJB
    private UsuarioService usuarioService;
    
    public CrearUsuarioController() {
    }
    
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Mensaje> listaMensajes;
    

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Mensaje> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(ArrayList<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }
    
    
    
    @PostConstruct
    public void init(){
        listaUsuarios=new ArrayList<Usuario>();
        listaUsuarios.addAll(usuarioService.listar());
        listaMensajes=new ArrayList<Mensaje>();
        //listaMensajes.addAll(listaUsuarios.get(0).getMensajeSet1());
        //System.out.println(listaMensajes.size());
        
    }
    
    
}
