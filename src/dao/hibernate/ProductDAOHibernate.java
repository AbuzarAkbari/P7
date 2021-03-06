package dao.hibernate;

import domain.OVChipkaart;
import domain.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOHibernate {
    private Session session;
    private OVChipkaartDAO ovChipkaartDAO;

    public void setOvChipkaartDAO(OVChipkaartDAO ovChipkaartDAO) {
        this.ovChipkaartDAO = ovChipkaartDAO;
    }

    public void setSession(Session session) {
        if (this.session == null) {
            this.session = session;
        }
    }

    private Transaction getTransaction() {
        Transaction transaction = session.getTransaction();
        try {
            if (!transaction.isActive()) {
                transaction = session.beginTransaction();
            }
        } catch(Exception err) {
            System.out.println(err.getMessage());
        }

        return transaction;
    }

    @Override
    public boolean save( Product product) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();

            return true;
        } catch (HibernateException hex) {
            System.out.println(hex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update( Product product) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();

            return true;
        } catch (HibernateException hex) {
            System.out.println(hex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void delete( Product product ) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();

        } catch (HibernateException hex) {
            System.out.println(hex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Product> findAll() {
        String hql = "FROM Product";
        Query query = session.createQuery(hql);
        List results = query.list();

        return results;
    }

    public Product findById(int id) {
        String hql = "FROM Product AS A WHERE A.id = :ID";
        Query query = session.createQuery(hql);
        query.setParameter("ID",id);
        List results = query.list();

        if (results.size() == 0) {
            return null;
        }

        return (Product) results.get(0);
    }
}

}
