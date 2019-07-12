/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IModopagoDAO;
import aplicacion.dao.imp.ModopagoDAOImp;
import aplicacion.modelo.dominio.Modopago;
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
public class ModopagoBean implements Serializable{
    private IModopagoDAO modoPagoDao;
    private Modopago modoPago;
    private Integer cuotas = 0;
    private Double interes;
    /**
     * Creates a new instance of ModopagoBean
     */
    public ModopagoBean() {
        modoPagoDao = new ModopagoDAOImp();
        modoPago = new Modopago();
    }

    public ModopagoBean(IModopagoDAO modoPagoDao, Modopago modoPago, Double interes) {
        this.modoPagoDao = modoPagoDao;
        this.modoPago = modoPago;
        this.interes = interes;
    }
    
    public List<Modopago> tiposModoPago(){
       return modoPagoDao.obtenerListaModoPago();
    }
    
    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public Modopago getModoPago() {
        return modoPago;
    }

    public void setModoPago(Modopago modoPago) {
        this.modoPago = modoPago;
    }

    public Integer getCuotas() {
        return cuotas;
    }

    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }

    public IModopagoDAO getModoPagoDao() {
        return modoPagoDao;
    }

    public void setModoPagoDao(IModopagoDAO modoPagoDao) {
        this.modoPagoDao = modoPagoDao;
    }
    
}
