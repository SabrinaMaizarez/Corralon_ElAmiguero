/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.IDetalleDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Detalle;
import org.hibernate.Session;

/**
 *
 * @author fliaMaizarez
 */
public class DetalleDAOImp implements IDetalleDAO{

    @Override
    public void agregarDetalle(Detalle unDetalle) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unDetalle);
        session.getTransaction().commit();
        session.close();
    }
    
}
