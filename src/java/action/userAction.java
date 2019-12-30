/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import DAO.userDAOImpl;
import Entities.Users;
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
public class userAction {
    private String login;
    private String password;
    private String typeUser;
    private boolean access;
    private List<Users> userList = new ArrayList<Users>();
    private userDAOImpl userDAO = new userDAOImpl();

    public userAction() {
    }
    
      public String isConnected(){
        HttpServletRequest request ;
        request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        Users user = new Users(login,password);
        if(userDAO.isConnected(request.getParameter("login"),request.getParameter("password"))==true){
            return SUCCESS;}
        else 
            return ERROR;
    }
//    public String list(){
//        userList = userDAO.listUser();
//        return SUCCESS;
//    }
//    public String delete(){
//        HttpServletRequest request ;
//        request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
//        userDAO.deleteUser(request.getParameter("login"));
//        return SUCCESS;
//    }
//    public String edit(){
//        HttpServletRequest request ;
//        request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
//        Users user = userDAO.listUserById(request.getParameter("login"));
//        if(user!= null)
//            return SUCCESS;
//        return ERROR;
//    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public List<Users> getUserList() {
        return userList;
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }

    public userDAOImpl getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(userDAOImpl userDAO) {
        this.userDAO = userDAO;
    }
    
}
