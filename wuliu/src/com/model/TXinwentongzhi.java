// 
// 
// 

package com.model;

import java.io.Serializable;

public class TXinwentongzhi implements Serializable
{
    private Integer id;
    private String biaoti;
    private String leibie;
    private String neirong;
    private String shouyetupian;
    private String dianjilv;
    private String tianjiaren;
    private String addtime;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getBiaoti() {
        return this.biaoti;
    }
    
    public void setBiaoti(final String biaoti) {
        this.biaoti = biaoti;
    }
    
    public String getLeibie() {
        return this.leibie;
    }
    
    public void setLeibie(final String leibie) {
        this.leibie = leibie;
    }
    
    public String getNeirong() {
        return this.neirong;
    }
    
    public void setNeirong(final String neirong) {
        this.neirong = neirong;
    }
    
    public String getShouyetupian() {
        return this.shouyetupian;
    }
    
    public void setShouyetupian(final String shouyetupian) {
        this.shouyetupian = shouyetupian;
    }
    
    public String getDianjilv() {
        return this.dianjilv;
    }
    
    public void setDianjilv(final String dianjilv) {
        this.dianjilv = dianjilv;
    }
    
    public String getTianjiaren() {
        return this.tianjiaren;
    }
    
    public void setTianjiaren(final String tianjiaren) {
        this.tianjiaren = tianjiaren;
    }
    
    public String getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(final String addtime) {
        this.addtime = addtime;
    }
}
