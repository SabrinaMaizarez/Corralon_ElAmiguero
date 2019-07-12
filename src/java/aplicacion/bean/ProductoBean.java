/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IProductoDAO;
import aplicacion.dao.imp.ProductoDAOImp;
import aplicacion.modelo.dominio.Producto;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ignal
 */
@ManagedBean
@SessionScoped
public class ProductoBean implements Serializable{
    private IProductoDAO productoDao;

    public ProductoBean() {
        productoDao = new ProductoDAOImp();
    }

    public ProductoBean(IProductoDAO productoDao) {
        this.productoDao = productoDao;
    }
    
    public void agregarProducto(Producto producto){
      productoDao.agregarProducto(producto);
    }
    
    public void eliminarProducto(Producto producto){
      productoDao.eliminarProducto(producto);
    }
    
    public void modificarProducto(Producto producto){
      productoDao.modificarProducto(producto);
    }
    
    public Producto consultarProducto(Integer codProducto){
        return getProductoDao().consultarProducto(codProducto);
    }
    
    public List<Producto> obtenerListaProducto(){
       return productoDao.obtenerListaProducto();
    }

    public IProductoDAO getProductoDao() {
        return productoDao;
    }

    public void setProductoDao(IProductoDAO productoDao) {
        this.productoDao = productoDao;
    }
}
