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
public interface userDAO {
    public boolean isConnected(String login,String password);
}
