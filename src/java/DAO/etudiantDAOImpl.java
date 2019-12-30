/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Eleve;
import Entities.Filieres;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rabab
 */
public class etudiantDAOImpl implements etudiantDAO{
    Session S;
    Transaction Tx;
    
    public etudiantDAOImpl() {
        S = NewHibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void saveOrUpdateEtudiant(Eleve user) {
         try {
            Tx = S.beginTransaction();
            S.saveOrUpdate(user);
            Tx.commit();
             System.out.println("savedao");
        } catch (Exception e) {
            Tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEtudiant(String userId) {
        try {
            Tx = S.beginTransaction();
            Eleve user = (Eleve) S.get(Eleve.class, userId);
            S.delete(user);
            Tx.commit();
        } catch (Exception e) {
            Tx.rollback();
            e.printStackTrace();
        }    }

    @Override
    public List<Eleve> listEtudiant() {
        List<Eleve> courses = null;
        try {
            courses = S.createQuery("from Eleve").list();
            System.out.println("daoEtud"+courses.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;   
    }
    @Override
    public Eleve listEtudiantById(String userId) {
        Eleve user = null;
        try {
            user = (Eleve) S.get(Eleve.class, userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public List<Eleve> listEtudiantByF(String code) {
        List<Eleve> courses =null;
        
        try {
            Filieres f= (Filieres) S.get(Filieres.class, code);
            courses = S.createQuery("from Eleve  e where e.filieres =:code").setParameter("code", f).list();
            System.out.println("hylistfiletu  "+courses.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }
    
}
