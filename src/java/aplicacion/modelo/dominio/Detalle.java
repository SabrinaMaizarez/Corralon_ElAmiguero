package aplicacion.modelo.dominio;
// Generated 07/07/2019 10:04:55 by Hibernate Tools 4.3.1

import aplicacion.modelo.dominio.Producto;




/**
 * Detalle generated by hbm2java
 */
public class Detalle  implements java.io.Serializable {


     private int iddetalle;
     private Factura factura;
     private Producto productos;
     private Integer cantidad;
     private String precioProdCant;

    public Detalle() {
    }

	
    public Detalle(int iddetalle, Factura factura, Producto productos) {
        this.iddetalle = iddetalle;
        this.factura = factura;
        this.productos = productos;
    }
    public Detalle(int iddetalle, Factura factura, Producto productos, Integer cantidad, String precioProdCant) {
       this.iddetalle = iddetalle;
       this.factura = factura;
       this.productos = productos;
       this.cantidad = cantidad;
       this.precioProdCant = precioProdCant;
    }
   
    public int getIddetalle() {
        return this.iddetalle;
    }
    
    public void setIddetalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public Producto getProductos() {
        return this.productos;
    }
    
    public void setProductos(Producto productos) {
        this.productos = productos;
    }
    public Integer getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public String getPrecioProdCant() {
        return this.precioProdCant;
    }
    
    public void setPrecioProdCant(String precioProdCant) {
        this.precioProdCant = precioProdCant;
    }




}

