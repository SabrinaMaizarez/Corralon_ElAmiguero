/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author fliaMaizarez
 */
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {
    private IUsuarioDAO usuarioDao;
    
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
        usuarioDao = new UsuarioDAOImp();
    }
    
    public UsuarioBean(Usuario usuario, IUsuarioDAO usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
    
    public void agregarUsuario(Usuario user){
      usuarioDao.agregarUsuario(user);
    }
    
    public void eliminarUsuario(Usuario user){
      usuarioDao.eliminarUsuario(user);
    }
    
    public void modificarUsuario(Usuario user){
      usuarioDao.modificar(user);
    }
    
    public List<Usuario> obtenerListado(){
       return usuarioDao.obtenerListaUsuariosActivos();
    }
    
    public IUsuarioDAO getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(IUsuarioDAO usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
    
}
