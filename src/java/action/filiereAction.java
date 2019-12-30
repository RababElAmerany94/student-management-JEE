/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import DAO.etudiantDAOImpl;
import DAO.filiereDAOImpl;
import Entities.Eleve;
import Entities.Filieres;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Rabab
 */
public class filiereAction {
    
    private String code;
    private String nom;
    private List<Filieres> FilieresList = new ArrayList<Filieres>();
    private filiereDAOImpl filiereDAO = new filiereDAOImpl();
     private List<Eleve> EtudiantList = new ArrayList<Eleve>();
    private etudiantDAOImpl EtudiantDAO = new etudiantDAOImpl();
    
    public String saveOrUpdate(){
        Filieres user = new Filieres(code,nom);
        System.out.println("hy save ici"+user.getCode()+"lala"+user.getNom());
        filiereDAO.saveOrUpdateFiliere(user);
        return SUCCESS;
    }
    public String list(){
        HttpServletRequest request ;
        request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        System.out.print("hy");
        FilieresList = filiereDAO.listFiliere();
        System.out.print(FilieresList.size());
    //    EtudiantList = EtudiantDAO.listEtudiantByF(request.getParameter("code"));
      //  System.out.println(EtudiantList.size()+"////////"+FilieresList.size());
        return SUCCESS;
    
    }
    
    public String delete(){
        HttpServletRequest request ;
        request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        filiereDAO.deleteFiliere(request.getParameter("code"));
        System.out.println("hy ici delete");
        return SUCCESS;
    }
    public String edit(){
        HttpServletRequest request ;
        request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        Filieres user = filiereDAO.listFiliereById(request.getParameter("code"));
        System.out.println("hy ici edit1"+user.getCode());
        if(user!= null)
            return SUCCESS;
        return ERROR;
    }

    public filiereAction() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public List<Filieres> getFilieresList() {
        return FilieresList;
    }

    public void setFilieresList(List<Filieres> FilieresList) {
        this.FilieresList = FilieresList;
    }

    public filiereDAOImpl getFiliereDAO() {
        return filiereDAO;
    }

    public void setFiliereDAO(filiereDAOImpl filiereDAO) {
        this.filiereDAO = filiereDAO;
    }

    public List<Eleve> getEtudiantList() {
        return EtudiantList;
    }

    public void setEtudiantList(List<Eleve> EtudiantList) {
        this.EtudiantList = EtudiantList;
    }

    public etudiantDAOImpl getEtudiantDAO() {
        return EtudiantDAO;
    }

    public void setEtudiantDAO(etudiantDAOImpl EtudiantDAO) {
        this.EtudiantDAO = EtudiantDAO;
    }
    
}
