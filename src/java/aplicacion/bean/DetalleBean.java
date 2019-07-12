/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IDetalleDAO;
import aplicacion.dao.imp.DetalleDAOImp;
import aplicacion.modelo.dominio.Detalle;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ivan
 */
@ManagedBean
@SessionScoped
public class DetalleBean implements Serializable{
    private IDetalleDAO detalleDao;
    /**
     * Creates a new instance of DetalleBean
     */
    public DetalleBean() {
        detalleDao = new DetalleDAOImp();
    }
    
    public void agregarDetalle(Detalle detalle){
      detalleDao.agregarDetalle(detalle);
    }
    
    public DetalleBean(IDetalleDAO detalleDao) {
        this.detalleDao = detalleDao;
    }

    public IDetalleDAO getDetalleDao() {
        return detalleDao;
    }

    public void setDetalleDao(IDetalleDAO detalleDao) {
        this.detalleDao = detalleDao;
    }
}
