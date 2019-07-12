/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.CategoriaBean;
import aplicacion.bean.ProductoBean;
import aplicacion.modelo.dominio.Categoria;
import aplicacion.modelo.dominio.Producto;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author ignal
 */
@ManagedBean
@SessionScoped
public class ProductoFormBean implements Serializable {
    @ManagedProperty(value = "#{productoBean}")
    private ProductoBean productoBean;
    @ManagedProperty(value = "#{categoriaBean}")
    private CategoriaBean categoriaBean;
    private Producto producto;
    private Producto unProducto;
    private Integer cod = 12;
    private List<Producto> listadoProducto;
    private List<Categoria> listadoCategoria;
    private transient UploadedFile archivo = null;
    
    /**
     * Creates a new instance of ProductoFormBean
     */
    public ProductoFormBean() {
        producto = new Producto();
        listadoProducto =  new ArrayList();
        listadoCategoria = new ArrayList();
    }

    public ProductoFormBean(ProductoBean productoBean, CategoriaBean categoriaBean, Producto producto, Producto unProducto, List<Producto> listadoProducto, List<Categoria> listadoCategoria) {
        this.productoBean = productoBean;
        this.categoriaBean = categoriaBean;
        this.producto = producto;
        this.unProducto = unProducto;
        this.listadoProducto = listadoProducto;
        this.listadoCategoria = listadoCategoria;
    }
    
    public List<Producto> obtenerListadoProducto(){
       return listadoProducto = productoBean.obtenerListaProducto();
    }
    
    public List<Categoria> obtenerListaCategoria(){
       return listadoCategoria = categoriaBean.obtenerListaCategoria();
    }

    public void agregarProducto(){
        /*try{
        producto.setCodProducto(cod);
        setCod(cod+1);
        producto.setEstado(Boolean.TRUE);
        productoBean.agregarProducto(producto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sea creado el Producto"));
        }
        catch(Exception e){ 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al crear Producto"));
        }
        producto = new Producto();*/
        
        if(getArchivo() != null){
            byte[] contents = getArchivo().getContents();
            getProducto().setFoto(contents);
        } else {
            getProducto().setFoto(null);
        }
        try{
        producto.setCodProducto(cod);
        setCod(cod + 1);
        producto.setEstado(Boolean.TRUE);
        productoBean.agregarProducto(producto);
        FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"PRODUCTO AGREGA2 CON EXITO",":)");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }
        catch (Exception e) {
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"No se agrego el producto","");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }
        setUnProducto(new Producto());
    }
    
    public void establecerProducto(Producto otroProducto){
        unProducto = otroProducto;
    }
    
    public void eliminarProducto(){
        unProducto.setEstado(Boolean.FALSE);
        productoBean.modificarProducto(unProducto);
        FacesMessage msg = new FacesMessage("Producto Eliminado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        unProducto = new Producto();
    }
    
    public void modificarProducto(){
        productoBean.modificarProducto(unProducto);
        FacesMessage msg = new FacesMessage("Producto Modificado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        unProducto = new Producto();
    }
    
    public StreamedContent getFotoProducto() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        if(context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE){
            return new DefaultStreamedContent();
        } else {
            String codigo = context.getExternalContext().getRequestParameterMap().get("cod");
            Producto producto = getProductoBean().consultarProducto(Integer.parseInt(codigo));
            if(producto.getFoto() == null){
                return null;
            } else {
                return new DefaultStreamedContent(new ByteArrayInputStream(producto.getFoto()));
            }
        }
    }
    
    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getUnProducto() {
        return unProducto;
    }

    public void setUnProducto(Producto unProducto) {
        this.unProducto = unProducto;
    }

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }

    public ProductoBean getProductoBean() {
        return productoBean;
    }

    public void setProductoBean(ProductoBean productoBean) {
        this.productoBean = productoBean;
    }

    public CategoriaBean getCategoriaBean() {
        return categoriaBean;
    }

    public void setCategoriaBean(CategoriaBean categoriaBean) {
        this.categoriaBean = categoriaBean;
    }

    public List<Producto> getListadoProducto() {
        return listadoProducto;
    }

    public void setListadoProducto(List<Producto> listadoProducto) {
        this.listadoProducto = listadoProducto;
    }

    public List<Categoria> getListadoCategoria() {
        return listadoCategoria;
    }

    public void setListadoCategoria(List<Categoria> listadoCategoria) {
        this.listadoCategoria = listadoCategoria;
    }
    /**
//     * @param fotoPro the fotoPro to set
//     */
//    public void setFotoPro(byte[] fotoPro) {
//        this.fotoPro = fotoPro;
//    }
//    
}
