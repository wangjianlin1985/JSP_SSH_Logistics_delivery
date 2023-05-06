// 
// 
// 

package com.action;

import java.util.List;
import org.apache.struts2.ServletActionContext;
import java.util.Map;
import com.model.TAllusers;
import com.dao.TAllusersDAO;
import com.opensymphony.xwork2.ActionSupport;

public class allusersAction extends ActionSupport
{
    private int id;
    private String username;
    private String pwd;
    private String cx;
    private String message;
    private String path;
    private String addtime;
    private int index;
    private TAllusersDAO allusersDAO;
    
    public allusersAction() {
        this.index = 1;
    }
    
    public String allusersAdd() {
        final TAllusers allusers = new TAllusers();
        allusers.setUsername(this.username);
        allusers.setPwd(this.pwd);
        allusers.setCx("\u666e\u901a\u7ba1\u7406\u5458");
        allusers.setAddtime(this.addtime);
        this.allusersDAO.save(allusers);
        this.setMessage("\u64cd\u4f5c\u6210\u529f");
        this.setPath("allusersList.action");
        return "succeed";
    }
    
    public String allusersList() {
        final List allusersList = this.allusersDAO.findAll();
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("allusersList", allusersList);
        return "success";
    }
    
    public String allusersDel() {
        this.allusersDAO.delete(this.allusersDAO.findById(this.id));
        this.setMessage("\u5220\u9664\u6210\u529f");
        this.setPath("allusersList.action");
        return "succeed";
    }
    
    public TAllusersDAO getAllusersDAO() {
        return this.allusersDAO;
    }
    
    public void setAllusersDAO(final TAllusersDAO allusersDAO) {
        this.allusersDAO = allusersDAO;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public void setIndex(final int index) {
        this.index = index;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public String getPath() {
        return this.path;
    }
    
    public void setPath(final String path) {
        this.path = path;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public String getPwd() {
        return this.pwd;
    }
    
    public void setPwd(final String pwd) {
        this.pwd = pwd;
    }
    
    public String getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(final String addtime) {
        this.addtime = addtime;
    }
}
