// 
// 
// 

package com.model;

import java.io.Serializable;

public class TShoucangjilu implements Serializable
{
    private Integer id;
    private String username;
    private String xwid;
    private String ziduan;
    private String biao;
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
    
    public String getXwid() {
        return this.xwid;
    }
    
    public void setXwid(final String xwid) {
        this.xwid = xwid;
    }
    
    public String getZiduan() {
        return this.ziduan;
    }
    
    public void setZiduan(final String ziduan) {
        this.ziduan = ziduan;
    }
    
    public String getBiao() {
        return this.biao;
    }
    
    public void setBiao(final String biao) {
        this.biao = biao;
    }
    
    public String getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(final String addtime) {
        this.addtime = addtime;
    }
}
