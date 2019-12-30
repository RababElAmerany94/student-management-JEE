/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Filieres;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rabab
 */
public class filiereDAOImpl implements filiereDAO {
    Session S;
    Transaction Tx;

    public filiereDAOImpl() {
        S = NewHibernateUtil.getSessionFactory().openSession();
    }
    
    @Override
    public void saveOrUpdateFiliere(Filieres user) {
        try {
            Tx = S.beginTransaction();
            System.out.println("hy sve");
            S.saveOrUpdate(user);
            Tx.commit();
        } catch (Exception e) {
            Tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFiliere(String code) {
        try {
            Tx = S.beginTransaction();
            Filieres f = (Filieres) S.get(Filieres.class, code);
            S.delete(f);
            System.out.println("  hy ici delete dao "+f.getCode());
            Tx.commit();
        } catch (Exception e) {
            Tx.rollback();
            e.printStackTrace();
        } 
//        Tx=S.beginTransaction();         
//        System.out.println("delete filiere1");
//        Query Req=S.createQuery("delete from Filieres f where f.code =:i");
//        System.out.println("delete filiere2");
//        Req.setParameter("i",code);
//        int result = Req.executeUpdate();
//        System.out.println("Rows affected :"+result);
//        Tx.commit();
//        //factory.getCurrentSession().getTransaction().commit();
//        System.out.println("bien delete");
    }

    @Override
    public List<Filieres> listFiliere() {       
        List<Filieres> courses = null;
        System.out.println("fgd"); 
        try {
            courses = S.createQuery("from Filieres").list();
            System.out.println(courses.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses; 
    }

    @Override
    public Filieres listFiliereById(String userId) {
         Filieres user = null;
        try {
            user = (Filieres) S.get(Filieres.class, userId);
            System.out.println(user.getCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
}
