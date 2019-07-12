/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.IModopagoDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Modopago;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author fliaMaizarez
 */
public class ModopagoDAOImp implements IModopagoDAO{

    @Override
    public List<Modopago> obtenerListaModoPago() {
        List<Modopago> listado = new ArrayList();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Modopago.class);
        listado = criteria.list();
        session.getTransaction().commit();
        session.close();
        return listado;
    }
    
}
