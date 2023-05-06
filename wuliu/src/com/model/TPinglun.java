// 
// 
// 

package com.model;

import java.io.Serializable;

public class TPinglun implements Serializable
{
    private Integer id;
    private String xinwenID;
    private String pinglunneirong;
    private String pinglunren;
    private String pingfen;
    private String biao;
    private String addtime;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getXinwenID() {
        return this.xinwenID;
    }
    
    public void setXinwenID(final String xinwenID) {
        this.xinwenID = xinwenID;
    }
    
    public String getPinglunneirong() {
        return this.pinglunneirong;
    }
    
    public void setPinglunneirong(final String pinglunneirong) {
        this.pinglunneirong = pinglunneirong;
    }
    
    public String getPinglunren() {
        return this.pinglunren;
    }
    
    public void setPinglunren(final String pinglunren) {
        this.pinglunren = pinglunren;
    }
    
    public String getPingfen() {
        return this.pingfen;
    }
    
    public void setPingfen(final String pingfen) {
        this.pingfen = pingfen;
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
