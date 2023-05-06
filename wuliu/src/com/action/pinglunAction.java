// 
// 
// 

package com.action;

import javax.servlet.http.HttpServletRequest;
import com.util.Pagination;
import org.apache.struts2.ServletActionContext;
import java.util.Map;
import com.model.TPinglun;
import com.dao.TPinglunDAO;
import java.util.List;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionSupport;

public class pinglunAction extends ActionSupport
{
    private int id;
    private String xinwenID;
    private String pinglunneirong;
    private String pinglunren;
    private String pingfen;
    private String biao;
    private String addtime;
    private String message;
    private String path;
    private ResultSet rs;
    private List list;
    private TPinglunDAO pinglunDAO;
    
    public String pinglunAdd() {
        final TPinglun pinglun = new TPinglun();
        pinglun.setXinwenID(this.xinwenID);
        pinglun.setPinglunneirong(this.pinglunneirong);
        pinglun.setPinglunren(this.pinglunren);
        pinglun.setPingfen(this.pingfen);
        pinglun.setBiao(this.biao);
        pinglun.setAddtime(this.addtime);
        this.pinglunDAO.save(pinglun);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "<script>javascript:alert('\u64cd\u4f5c\u6210\u529f\uff01'); parent.location=parent.location; </script>");
        return "msg";
    }
    
    public String pinglunList() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        final int hsgpagesize = 20;
        String sql = "from TPinglun where 1=1 ";
        if (this.xinwenID != null) {
            sql = String.valueOf(sql) + " and xinwenID like '%" + this.xinwenID.trim() + "%'";
        }
        if (this.pinglunneirong != null) {
            sql = String.valueOf(sql) + " and pinglunneirong like '%" + this.pinglunneirong.trim() + "%'";
        }
        if (this.pinglunren != null) {
            sql = String.valueOf(sql) + " and pinglunren like '%" + this.pinglunren.trim() + "%'";
        }
        if (this.pingfen != null) {
            sql = String.valueOf(sql) + " and pingfen like '%" + this.pingfen.trim() + "%'";
        }
        if (this.biao != null) {
            sql = String.valueOf(sql) + " and biao like '%" + this.biao.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        final List pinglunList = this.pinglunDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * hsgpagesize;
        final int toIndex = Math.min(fromIndex + hsgpagesize, pinglunList.size());
        final List pinglunList2 = pinglunList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(hsgpagesize);
        p.setTotle(pinglunList.size());
        p.setData(pinglunList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String pinglunDel() {
        final String sql = "delete from TPinglun where id=?";
        final Object[] o = { this.id };
        this.pinglunDAO.getHibernateTemplate().bulkUpdate(sql, o);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String pinglunPre() {
        final TPinglun pinglun = this.pinglunDAO.findById(this.id);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("pinglun", pinglun);
        return "success";
    }
    
    public String pinglunUpdt() {
        final TPinglun pinglun = this.pinglunDAO.findById(this.id);
        pinglun.setXinwenID(this.xinwenID);
        pinglun.setPinglunneirong(this.pinglunneirong);
        pinglun.setPinglunren(this.pinglunren);
        pinglun.setPingfen(this.pingfen);
        pinglun.setBiao(this.biao);
        this.pinglunDAO.attachDirty(pinglun);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
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
    
    public TPinglunDAO getPinglunDAO() {
        return this.pinglunDAO;
    }
    
    public void setPinglunDAO(final TPinglunDAO pinglunDAO) {
        this.pinglunDAO = pinglunDAO;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getMessage() {
        return this.message;
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
}
