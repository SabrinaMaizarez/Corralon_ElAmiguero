/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.IProductoDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Producto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author fliaMaizarez
 */
public class ProductoDAOImp implements IProductoDAO {

    @Override
    public void agregarProducto(Producto unProducto) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unProducto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarProducto(Producto unProducto) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(unProducto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarProducto(Producto unProducto) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unProducto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Producto> obtenerListaProducto() {
        List<Producto> listado = new ArrayList();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("estado", true));
        listado = criteria.list();
        session.getTransaction().commit();
        session.close();
        return listado;
    }

    @Override
    public Producto consultarProducto(Integer codProducto) {
        List<Producto> listado = new ArrayList();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.like("codProducto", codProducto));
        listado = criteria.list();
        session.getTransaction().commit();
        session.close();
        return listado.get(0);
    }
}
