/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.UsuarioBean;
import aplicacion.modelo.dominio.Cliente;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ivan
 */
@ManagedBean
@SessionScoped
public class UsuarioFormBean implements Serializable{
    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;
    private List<Usuario> listadoUsuario;
    private Usuario usuario;
    private Usuario unUsuario;
    private Integer DNI; 
    private int cod = 4;

    /**
     * Creates a new instance of UsuarioFormBean
     */
    public UsuarioFormBean() {
        usuario = new Usuario();
        listadoUsuario = new ArrayList();
    }

    public UsuarioFormBean(UsuarioBean usuarioBean, List<Usuario> listadoUsuario, Usuario usuario) {
        this.usuarioBean = usuarioBean;
        this.listadoUsuario = listadoUsuario;
        this.usuario = usuario;
    }
    
    public List<Usuario> obtenerListaUsuariosActivos(){
       return listadoUsuario = usuarioBean.obtenerListado();
    }
    
    public UsuarioFormBean(Usuario usuario) {
        this.usuario = usuario;
    }

    public String agregarUsuario(){
        String resultado = null;
        try{ /*intenta*/
        usuario.setCodigo(cod);
        setCod(cod+1);
        usuario.setEstado(Boolean.TRUE);
        usuario.setTipoUsuario("cliente");
        usuario.setClientes(new Cliente(DNI));
        usuarioBean.agregarUsuario(usuario);
        resultado = "login?faces-redirect=true";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("SE AGREGÓ CON EXITO AL USUARIO"));
        }
        catch(Exception e){ 
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"OCURRIÓ UN PROBLEMA","!");
             FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }
        
        usuario = new Usuario();
        DNI = null;
        return resultado;
    }
    
    public void agregarUsuarioAdministrador(){
        try{
        usuario.setClientes(new Cliente(DNI));    
        usuario.setCodigo(cod);
        setCod(cod+1);
        usuario.setEstado(Boolean.TRUE);
        usuarioBean.agregarUsuario(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sea creado el Usuario"));
        }
        catch(Exception e){ 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al crear usuario"));
        }
        usuario = new Usuario();
        DNI = null;
    }
    
    public void establecerUsuario(Usuario otroUsuario){
        unUsuario = otroUsuario;
    }
    
    public void eliminarUsuario(){
        usuarioBean.eliminarUsuario(unUsuario);
        FacesMessage msg = new FacesMessage("Usuario Eliminado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        unUsuario = new Usuario();
    }
    
    public void modificarUsuario(){
        usuarioBean.modificarUsuario(unUsuario);
        FacesMessage msg = new FacesMessage("Usuario Modificado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        unUsuario = new Usuario();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the usuarioBean
     */
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    /**
     * @param usuarioBean the usuarioBean to set
     */
    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public List<Usuario> getListadoUsuario() {
        return listadoUsuario;
    }

    public void setListadoUsuario(List<Usuario> listadoUsuario) {
        this.listadoUsuario = listadoUsuario;
    }

    public Integer getDNI() {
        return DNI;
    }

    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }
    
}
