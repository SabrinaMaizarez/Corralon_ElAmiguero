/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.CategoriaBean;
import aplicacion.modelo.dominio.Categoria;
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
public class CategoriaFormBean implements Serializable{
    @ManagedProperty(value = "#{categoriaBean}")
    private CategoriaBean categoriaBean;
    private Categoria categoria;
    private Categoria unaCategoria;
    private Integer idCategoria = 6;
    private List<Categoria> listadoCategoria;
    /**
     * Creates a new instance of CategoriaFormBean
     */
    public CategoriaFormBean() {
        categoria = new Categoria();
        listadoCategoria = new ArrayList();
    }

    public CategoriaFormBean(CategoriaBean categoriaBean, Categoria categoria, Categoria unaCategoria, Integer idCategoria, List<Categoria> listadoCategoria) {
        this.categoriaBean = categoriaBean;
        this.categoria = categoria;
        this.unaCategoria = unaCategoria;
        this.idCategoria = idCategoria;
        this.listadoCategoria = listadoCategoria;
    }
    
    public void agregarCategoria(){
        try{
        categoria.setIdcategoria(idCategoria);
        setIdCategoria(idCategoria+1);
        categoriaBean.agregarCategoria(categoria);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sea creado la Categoria"));
        }
        catch(Exception e){ 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al crear Cartegoria"));
        }
    }

    public List<Categoria> obtenerListaCategoria(){
       return listadoCategoria = categoriaBean.obtenerListaCategoria();
    }
    
    public void establecerCategoria(Categoria otraCategoria){
        unaCategoria = otraCategoria;
    }
    
    public void eliminarCategoria(){
        categoriaBean.eliminarCategoria(unaCategoria);
        FacesMessage msg = new FacesMessage("Categoria Eliminada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        unaCategoria = new Categoria();
    }
    
    public void modificarCategoria(){
        categoriaBean.modificarCategoria(unaCategoria);
        FacesMessage msg = new FacesMessage("Categoria modificada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        unaCategoria = new Categoria();
    }
    
    public List<Categoria> getListadoCategoria() {
        return listadoCategoria;
    }

    public void setListadoCategoria(List<Categoria> listadoCategoria) {
        this.listadoCategoria = listadoCategoria;
    }

    public CategoriaBean getCategoriaBean() {
        return categoriaBean;
    }

    public void setCategoriaBean(CategoriaBean categoriaBean) {
        this.categoriaBean = categoriaBean;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getUnaCategoria() {
        return unaCategoria;
    }

    public void setUnaCategoria(Categoria unaCategoria) {
        this.unaCategoria = unaCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
}
