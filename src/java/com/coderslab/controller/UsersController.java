package com.coderslab.controller;

import com.coderslab.dao.UsersDao;
import com.coderslab.entity.Users;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class UsersController extends ActionSupport{
    
    private Users users = new Users();
    private UsersDao usersDao = new UsersDao();
    private List<Users> listUsers;
    private String sm = "";
    private String em = "";

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public List<Users> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<Users> listUsers) {
        this.listUsers = listUsers;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }

    @Override
    public String execute() throws Exception {
        this.listUsers = usersDao.getAllUsers();
        return SUCCESS;
    }
    
    
    public String saveOrUpdateUser(){
        if(users.getId() != null){
            users.setId(users.getId());
        }
        
        users.setName(users.getName());
        users.setGender(users.getGender());
        users.setCountry(users.getCountry());
        users.setAboutYou(users.getAboutYou());
        users.setMailingList(users.isMailingList());
        
        System.out.println("===========" + users.toString());
        
        boolean status;
        if(users.getId() == null){
            status = usersDao.saveUsers(users);
        }else{
            status = usersDao.updateUsers(users);
        }
        
        if(status){
            setSm("User Info saved or update successfull");
            return SUCCESS;
        }else{
            setEm("User Info not saved or update");
            return "input";
        }
        
        
        
    }
    
    public String editUser(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        int id = Integer.parseInt(request.getParameter("id"));
        
        Users u = usersDao.getUsers(id);
        
        users.setId(u.getId());
        users.setName(u.getName());
        users.setGender(u.getGender());
        users.setCountry(u.getCountry());
        users.setAboutYou(u.getAboutYou());
        users.setMailingList(u.isMailingList());
        System.out.println("============" + users.toString());
        this.listUsers = usersDao.getAllUsers();
        
        
        return SUCCESS;
        
    }
    
    public String deleteUser(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        int id = Integer.parseInt(request.getParameter("id"));
        
        Users u = usersDao.getUsers(id);
        
        usersDao.deleteUsers(u);
        
        return SUCCESS;
    }
    
    
    
    
}
