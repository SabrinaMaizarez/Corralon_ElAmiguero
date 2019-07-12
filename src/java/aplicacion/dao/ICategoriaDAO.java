/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Categoria;
import java.util.List;

/**
 *
 * @author fliaMaizarez
 */
public interface ICategoriaDAO {
    void agregarCategoria(Categoria unaCategoria);
    void eliminarCategoria(Categoria unaCategoria);
    void modificarCategoria(Categoria unaCategoria);
    List<Categoria> obtenerListaCategoria();
}
