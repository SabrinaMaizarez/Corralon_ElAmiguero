/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Producto;
import java.util.List;

/**
 *
 * @author fliaMaizarez
 */
public interface IProductoDAO {
    void agregarProducto(Producto unProducto);
    void eliminarProducto(Producto unProducto);
    void modificarProducto(Producto unProducto);
    List<Producto> obtenerListaProducto();
    Producto consultarProducto(Integer cod);
}
