/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Eleve;
import java.util.List;

/**
 *
 * @author Rabab
 */
public interface etudiantDAO {
    public void saveOrUpdateEtudiant(Eleve user);
    public void deleteEtudiant(String userId);
    public List<Eleve> listEtudiant();
    public Eleve listEtudiantById(String userId);  
    public List<Eleve> listEtudiantByF(String userId);
}
