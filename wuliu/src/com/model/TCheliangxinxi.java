// 
// 
// 

package com.model;

import java.io.Serializable;

public class TCheliangxinxi implements Serializable
{
    private Integer id;
    private String chepaihao;
    private String jiashiyuan;
    private String zhuangtai;
    private String beizhu;
    private String addtime;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getChepaihao() {
        return this.chepaihao;
    }
    
    public void setChepaihao(final String chepaihao) {
        this.chepaihao = chepaihao;
    }
    
    public String getJiashiyuan() {
        return this.jiashiyuan;
    }
    
    public void setJiashiyuan(final String jiashiyuan) {
        this.jiashiyuan = jiashiyuan;
    }
    
    public String getZhuangtai() {
        return this.zhuangtai;
    }
    
    public void setZhuangtai(final String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }
    
    public String getBeizhu() {
        return this.beizhu;
    }
    
    public void setBeizhu(final String beizhu) {
        this.beizhu = beizhu;
    }
    
    public String getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(final String addtime) {
        this.addtime = addtime;
    }
}
