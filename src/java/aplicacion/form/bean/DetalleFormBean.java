/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.DetalleBean;
import aplicacion.bean.ModopagoBean;
import aplicacion.modelo.dominio.Detalle;
import aplicacion.modelo.dominio.Factura;
import aplicacion.modelo.dominio.Modopago;
import aplicacion.modelo.dominio.Producto;
import aplicacion.modelo.dominio.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class DetalleFormBean implements Serializable{
    @ManagedProperty(value = "#{modopagoBean}")
    private ModopagoBean modoPagoBean;
    @ManagedProperty(value = "#{detalleBean}")
    private DetalleBean detalleBean;
    private Detalle detalle;
    private Detalle unDetalle;
    private Producto unProducto;
    private Modopago modoPago;
    private Factura factura;
    private Integer idDetalle = 1;
    private Integer cantidad = 0;
    private Double precioTotal;
    private List<Detalle> listaDetalle;
    private List<Producto> productosSeleccionados;
    private List<Modopago> listadoModopago;
    
    /**
     * Creates a new instance of DetalleFormBean
     */
    public DetalleFormBean() {
        detalle = new Detalle();
        unDetalle = new Detalle();
        unProducto = new Producto();
        modoPago = new Modopago();
        factura = new Factura();
        listaDetalle = new ArrayList();
        productosSeleccionados = new ArrayList();
        listadoModopago = new ArrayList();
    }

    public DetalleFormBean(ModopagoBean modoPagoBean, DetalleBean detalleBean, Detalle detalle, Detalle unDetalle, Producto unProducto, Modopago modoPago, Factura factura, Double precioTotal, List<Detalle> listaDetalle, List<Producto> productosSeleccionados, List<Modopago> listadoModopago) {
        this.modoPagoBean = modoPagoBean;
        this.detalleBean = detalleBean;
        this.detalle = detalle;
        this.unDetalle = unDetalle;
        this.unProducto = unProducto;
        this.modoPago = modoPago;
        this.factura = factura;
        this.precioTotal = precioTotal;
        this.listaDetalle = listaDetalle;
        this.productosSeleccionados = productosSeleccionados;
        this.listadoModopago = listadoModopago;
    }
    
    public List<Modopago> tiposModoPago(){
       return listadoModopago = modoPagoBean.tiposModoPago();
    }
    
    public void establecerDetalle(Detalle otroDetalle){
        unDetalle = new Detalle();
    }
    
    public void establecerProducto(Producto otroProducto){
        unProducto = otroProducto;
    }
    
    public void agregarDetalle(){
        try{
        detalle.setIddetalle(idDetalle);
        setIdDetalle(idDetalle+1);
        detalleBean.agregarDetalle(detalle);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sea creado el detalle"));
        }
        catch(Exception e){ 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al crear el detalle"));
        }
    }
    
    public void agregarCarrito(){
        try{
        productosSeleccionados.add(unProducto);
        FacesMessage msg = new FacesMessage("Agregado al carrito");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al agregar al carrito"));
        }
        unProducto = new Producto();
    }
    
    public String comprar(){
        String resultado = null;
        resultado = "compraProductos?faces-redirect=true";
        return resultado;
    }
    public String confcompra(){
        String resultado = null;
        resultado = "ticket?faces-redirect=true";
        return resultado;
    }
    
    public void confirmarCompra(Producto unProducto){
        detalle = new Detalle();
        detalle.setProductos(unProducto);
        detalle.setCantidad(cantidad);
        precioTotal = (getCantidad() * unProducto.getPrecio());
        detalle.setPrecioProdCant(precioTotal.toString());
        getListaDetalle().add(detalle);
    }

    public double precioTotal(Producto unProducto){
        double precioTotal = 0;
        if(cantidad == 0){
        precioTotal = 1;
        }
        else { 
            for(int i = 0; i<listaDetalle.size();i++){
                precioTotal = precioTotal + listaDetalle.get(i).getProductos().getPrecio();
            }
        }
        return precioTotal;
    }

    public double Calculo (Producto unProducto){
        double total = 0;
        if(cantidad == 0){
            total = 1;
        }
        else{
        total = (unProducto.getPrecio() * cantidad);
        }
        return total;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }  

    public List<Detalle> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<Detalle> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public List<Producto> getProductosSeleccionados() {
        return productosSeleccionados;
    }

    public void setProductosSeleccionados(List<Producto> productosSeleccionados) {
        this.productosSeleccionados = productosSeleccionados;
    }

    public Detalle getUnDetalle() {
        return unDetalle;
    }

    public void setUnDetalle(Detalle unDetalle) {
        this.unDetalle = unDetalle;
    }

    public Producto getUnProducto() {
        return unProducto;
    }

    public void setUnProducto(Producto unProducto) {
        this.unProducto = unProducto;
    }

    public Modopago getModoPago() {
        return modoPago;
    }

    public void setModoPago(Modopago modoPago) {
        this.modoPago = modoPago;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public ModopagoBean getModoPagoBean() {
        return modoPagoBean;
    }

    public void setModoPagoBean(ModopagoBean modoPagoBean) {
        this.modoPagoBean = modoPagoBean;
    }

    public List<Modopago> getListadoModopago() {
        return listadoModopago;
    }

    public void setListadoModopago(List<Modopago> listadoModopago) {
        this.listadoModopago = listadoModopago;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public DetalleBean getDetalleBean() {
        return detalleBean;
    }

    public void setDetalleBean(DetalleBean detalleBean) {
        this.detalleBean = detalleBean;
    }
    
}
