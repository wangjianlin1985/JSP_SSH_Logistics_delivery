// 
// 
// 

package com.model;

import java.io.Serializable;

public class TYouqinglianjie implements Serializable
{
    private Integer id;
    private String wangzhanmingcheng;
    private String wangzhi;
    private String addtime;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getWangzhanmingcheng() {
        return this.wangzhanmingcheng;
    }
    
    public void setWangzhanmingcheng(final String wangzhanmingcheng) {
        this.wangzhanmingcheng = wangzhanmingcheng;
    }
    
    public String getWangzhi() {
        return this.wangzhi;
    }
    
    public void setWangzhi(final String wangzhi) {
        this.wangzhi = wangzhi;
    }
    
    public String getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(final String addtime) {
        this.addtime = addtime;
    }
}
