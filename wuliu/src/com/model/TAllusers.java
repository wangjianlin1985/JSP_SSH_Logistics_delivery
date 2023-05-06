// 
// 
// 

package com.model;

import java.io.Serializable;

public class TAllusers implements Serializable
{
    private Integer id;
    private String username;
    private String pwd;
    private String cx;
    private String addtime;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
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
    
    public String getCx() {
        return this.cx;
    }
    
    public void setCx(final String cx) {
        this.cx = cx;
    }
    
    public String getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(final String addtime) {
        this.addtime = addtime;
    }
}
