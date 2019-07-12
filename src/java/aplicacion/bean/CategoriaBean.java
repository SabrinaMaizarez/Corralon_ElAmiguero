/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.ICategoriaDAO;
import aplicacion.dao.imp.CategoriaDAOImp;
import aplicacion.modelo.dominio.Categoria;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ivan
 */
@ManagedBean
@SessionScoped
public class CategoriaBean implements Serializable{
    private ICategoriaDAO categoriaDao;

    /**
     * Creates a new instance of CategoriaBean
     */
    public CategoriaBean() {
        categoriaDao = new CategoriaDAOImp();
    }

    public CategoriaBean(ICategoriaDAO categoriaDao) {
        this.categoriaDao = categoriaDao;
    }
    
    public void agregarCategoria(Categoria categoria){
      categoriaDao.agregarCategoria(categoria);
    }
    
    public void eliminarCategoria(Categoria categoria){
      categoriaDao.eliminarCategoria(categoria);
    }
    
    public void modificarCategoria(Categoria categoria){
      categoriaDao.modificarCategoria(categoria);
    }
    
    public List<Categoria> obtenerListaCategoria(){
       return categoriaDao.obtenerListaCategoria();
    }

    public ICategoriaDAO getCategoriaDao() {
        return categoriaDao;
    }

    public void setCategoriaDao(ICategoriaDAO categoriaDao) {
        this.categoriaDao = categoriaDao;
    }
}
