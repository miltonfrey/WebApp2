/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.ejb.Local;
import pojos.Usuario;

@Local
public interface UsuarioService {
    
    public List<Usuario> listar();
    
}
