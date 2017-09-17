package com.coderslab.dao;

import com.coderslab.entity.Users;
import com.coderslab.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsersDao {

    public List<Users> getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;

        try {
            t = session.beginTransaction();
            List<Users> list = session.createQuery("from Users").list();
            t = session.getTransaction();
            t.commit();
            return list;
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            session.close();
        }

        return null;
    }

    public Users getUsers(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        Users u = null;
        try {
            t = session.beginTransaction();
            u = (Users) session.get(Users.class, id);
            t = session.getTransaction();
            t.commit();
            return u;
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            session.close();
        }

        return null;
    }

    public boolean saveUsers(Users users) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.save(users);
            t = session.getTransaction();
            t.commit();
            return true;
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            session.close();
        }

        return false;
    }

    public boolean updateUsers(Users users) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.update(users);
            t = session.getTransaction();
            t.commit();
            return true;
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            session.close();
        }

        return false;
    }

    public boolean deleteUsers(Users users) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.delete(users);
            t = session.getTransaction();
            t.commit();
            return true;
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            session.close();
        }

        return false;
    }

}
