/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.ICategoriaDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Categoria;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author fliaMaizarez
 */
public class CategoriaDAOImp implements ICategoriaDAO{

    @Override
    public void agregarCategoria(Categoria unaCategoria) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaCategoria);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarCategoria(Categoria unaCategoria) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(unaCategoria);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarCategoria(Categoria unaCategoria) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaCategoria);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Categoria> obtenerListaCategoria() {
        List<Categoria> listado = new ArrayList();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Categoria.class);
        listado = criteria.list();
        session.getTransaction().commit();
        session.close();
        return listado;
    }
}
