/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Filieres;
import java.util.List;

/**
 *
 * @author Rabab
 */
public interface filiereDAO {
    public void saveOrUpdateFiliere(Filieres user);
    public void deleteFiliere(String userId);
    public List<Filieres> listFiliere();
    public Filieres listFiliereById(String userId);
}
