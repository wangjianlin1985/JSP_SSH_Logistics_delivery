// 
// 
// 

package com.action;

import java.util.List;
import org.apache.struts2.ServletActionContext;
import java.util.Map;
import com.dao.TYouqinglianjieDAO;
import com.dao.TYonghuzhuceDAO;
import com.dao.TXinwentongzhiDAO;
import com.opensymphony.xwork2.ActionSupport;

public class indexAction extends ActionSupport
{
    private TXinwentongzhiDAO xinwentongzhiDAO;
    private TYonghuzhuceDAO yonghuzhuceDAO;
    private TYouqinglianjieDAO youqinglianjieDAO;
    
    public String index() {
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        String sql = "from TXinwentongzhi where leibie='\u7ad9\u5185\u65b0\u95fb' order by id desc";
        List xinwentongzhiznxwList = this.xinwentongzhiDAO.getHibernateTemplate().find(sql);
        if (xinwentongzhiznxwList.size() > 7) {
            xinwentongzhiznxwList = xinwentongzhiznxwList.subList(0, 7);
        }
        request.put("xinwentongzhiznxwList", xinwentongzhiznxwList);
        sql = "from TXinwentongzhi where leibie='\u901a\u77e5\u516c\u544a' order by id desc";
        List xinwentongzhitzggList = this.xinwentongzhiDAO.getHibernateTemplate().find(sql);
        if (xinwentongzhitzggList.size() > 8) {
            xinwentongzhitzggList = xinwentongzhitzggList.subList(0, 8);
        }
        request.put("xinwentongzhitzggList", xinwentongzhitzggList);
        sql = "from TXinwentongzhi where leibie='\u70ed\u95e8\u8d44\u8baf' order by id desc";
        List xinwentongzhirmzxList = this.xinwentongzhiDAO.getHibernateTemplate().find(sql);
        if (xinwentongzhirmzxList.size() > 8) {
            xinwentongzhirmzxList = xinwentongzhirmzxList.subList(0, 8);
        }
        request.put("xinwentongzhirmzxList", xinwentongzhirmzxList);
        sql = "from TXinwentongzhi where shouyetupian<>'' and shouyetupian like '%.jpg' order by id desc";
        List xinwentongzhisybhtList = this.xinwentongzhiDAO.getHibernateTemplate().find(sql);
        if (xinwentongzhisybhtList.size() > 5) {
            xinwentongzhisybhtList = xinwentongzhisybhtList.subList(0, 5);
        }
        request.put("xinwentongzhisybhtList", xinwentongzhisybhtList);
        sql = "from TYonghuzhuce where 1=1 order by id desc";
        List yonghuzhucehyfcList = this.yonghuzhuceDAO.getHibernateTemplate().find(sql);
        if (yonghuzhucehyfcList.size() > 4) {
            yonghuzhucehyfcList = yonghuzhucehyfcList.subList(0, 4);
        }
        request.put("yonghuzhucehyfcList", yonghuzhucehyfcList);
        return "success";
    }
    
    public TXinwentongzhiDAO getXinwentongzhiDAO() {
        return this.xinwentongzhiDAO;
    }
    
    public void setXinwentongzhiDAO(final TXinwentongzhiDAO xinwentongzhiDAO) {
        this.xinwentongzhiDAO = xinwentongzhiDAO;
    }
    
    public TYonghuzhuceDAO getYonghuzhuceDAO() {
        return this.yonghuzhuceDAO;
    }
    
    public void setYonghuzhuceDAO(final TYonghuzhuceDAO yonghuzhuceDAO) {
        this.yonghuzhuceDAO = yonghuzhuceDAO;
    }
    
    public TYouqinglianjieDAO getYouqinglianjieDAO() {
        return this.youqinglianjieDAO;
    }
    
    public void setYouqinglianjieDAO(final TYouqinglianjieDAO youqinglianjieDAO) {
        this.youqinglianjieDAO = youqinglianjieDAO;
    }
}
