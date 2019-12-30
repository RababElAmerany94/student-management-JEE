/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import DAO.etudiantDAOImpl;
import DAO.filiereDAO;
import DAO.filiereDAOImpl;
import Entities.Eleve;
import Entities.Filieres;
import Entities.Users;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Rabab
 */

public class etudiantAction {
    
    private String idEleve;
    private Filieres filieres;
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private Date dateNaissance;
    private String lieuNaissance;
    private List<Eleve> EtudiantList = new ArrayList<Eleve>();
    private etudiantDAOImpl EtudiantDAO = new etudiantDAOImpl();    
    private filiereDAOImpl filiereDAO = new filiereDAOImpl();
    private List<Filieres> FilieresList = new ArrayList<Filieres>();
    
    public String saveOrUpdate(){
        HttpServletRequest request ;
        request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        Eleve user = new Eleve();
        user.setIdEleve(idEleve);
        user.setNom(nom);
        user.setPrenom(prenom);
        //Date d =new SimpleDateFormat("dd/MM/yyyy").parse(dateNaissance);
        Filieres f=filiereDAO.listFiliereById(request.getParameter("filieres"));
        user.setFilieres(f);
        user.setEmail(email);
        user.setTel(tel);
        user.setLieuNaissance(lieuNaissance);
        Date d;
        try {
            d = new SimpleDateFormat("yyyy-dd-MM").parse(request.getParameter("dateNaissance"));            
            user.setDateNaissance(d);
        } catch (ParseException ex) {
            Logger.getLogger(etudiantAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        EtudiantDAO.saveOrUpdateEtudiant(user);
        System.out.println("hello save");
        EtudiantList = EtudiantDAO.listEtudiantByF(request.getParameter("code"));
        return SUCCESS;
    }
//    public String list(){
//        EtudiantList = EtudiantDAO.listEtudiant();
//        System.out.println("list"+EtudiantList.size());
//        return SUCCESS;
//    }
    public String listf(){
        HttpServletRequest request ;
        request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        EtudiantList = EtudiantDAO.listEtudiantByF(request.getParameter("code"));
        System.out.println("listfiliereaction   "+EtudiantList.size()+EtudiantList.toString());
        return SUCCESS;
    }
    public String delete(){
        HttpServletRequest request ;
        request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        EtudiantDAO.deleteEtudiant(request.getParameter("idEleve"));
        EtudiantList = EtudiantDAO.listEtudiantByF(request.getParameter("code"));
        return SUCCESS;
    }
    public String edit(){
        HttpServletRequest request ;
        request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        Eleve user = EtudiantDAO.listEtudiantById(request.getParameter("idEleve"));
        Filieres f =filiereDAO.listFiliereById(request.getParameter("code"));
        System.out.println("code+ideleve"+f.getCode()+"///////"+user.getIdEleve());
        if(user!= null && f!=null)
            return SUCCESS;
        return ERROR;
    }

    public String getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(String idEleve) {
        this.idEleve = idEleve;
    }

    public Filieres getFilieres() {
        return filieres;
    }

    public void setFilieres(Filieres filieres) {
        this.filieres = filieres;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
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

    public filiereDAOImpl getFiliereDAO() {
        return filiereDAO;
    }

    public void setFiliereDAO(filiereDAOImpl filiereDAO) {
        this.filiereDAO = filiereDAO;
    }

    public List<Filieres> getFilieresList() {
        return FilieresList;
    }

    public void setFilieresList(List<Filieres> FilieresList) {
        this.FilieresList = FilieresList;
    }
    
    
}
