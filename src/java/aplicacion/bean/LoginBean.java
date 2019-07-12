/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author chelo
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
    private String nombreUs;
    private String passwUs;
    private UsuarioDAOImp UsuarioDAO;

    public LoginBean(){
       UsuarioDAO = new UsuarioDAOImp();
    }

    public LoginBean(String nombreUs, String passwUs, UsuarioDAOImp UsuarioDAO) {
        this.nombreUs = nombreUs;
        this.passwUs = passwUs;
        this.UsuarioDAO = UsuarioDAO;
    }
    
    public Usuario validarUsuario(String nombreUs, String passwUs) {
        return getUsuarioDAO().validarUsuario(nombreUs, passwUs);
    }
 
    /**
     * @return the nombreUs
     */
    public String getNombreUs() {
        return nombreUs;
    }

    /**
     * @param nombreUs the nombreUs to set
     */
    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    /**
     * @return the passwUs
     */
    public String getPasswUs() {
        return passwUs;
    }

    /**
     * @param passwUs the passwUs to set
     */
    public void setPasswUs(String passwUs) {
        this.passwUs = passwUs;
    }

    /**
     * @return the UsuarioDAO
     */
    public UsuarioDAOImp getUsuarioDAO() {
        return UsuarioDAO;
    }

    /**
     * @param UsuarioDAO the UsuarioDAO to set
     */
    public void setUsuarioDAO(UsuarioDAOImp UsuarioDAO) {
        this.UsuarioDAO = UsuarioDAO;
    }

    
}