/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rabab
 */
public class userDAOImpl implements userDAO {
    Session S;
    Transaction Tx;

    public userDAOImpl() {
        S = NewHibernateUtil.getSessionFactory().openSession();
    }
    public Users FindById(String code){
        Users u = (Users)S.get(Users.class, code);
        return u;
    }
    public boolean isConnected(String login,String password){  
        System.out.println("hydao");
        Users user1 = FindById(login);
//        Users user1 = em.find(Users.class, login);
        System.out.println("hydao2");
        if(user1==null)
            return false;
        else if(user1.getLogin()==null&&user1.getPassword()==null){
            return false;
        }
        else if(user1.getLogin().equals(login) && user1.getPassword().equals(password)){
            return true;
        }
        else{
            return false;
        }
    }
}
