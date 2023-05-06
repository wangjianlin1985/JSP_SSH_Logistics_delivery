// 
// 
// 

package com.action;

import com.util.Pagesize;
import javax.servlet.http.HttpServletRequest;
import com.util.Pagination;
import org.apache.struts2.ServletActionContext;
import java.util.Map;
import com.model.TShoucangjilu;
import com.dao.TShoucangjiluDAO;
import java.util.List;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionSupport;

public class shoucangjiluAction extends ActionSupport
{
    private int id;
    private String username;
    private String xwid;
    private String ziduan;
    private String biao;
    private String addtime;
    private String message;
    private String path;
    private ResultSet rs;
    private List list;
    private TShoucangjiluDAO shoucangjiluDAO;
    
    public String shoucangjiluAdd() {
        final TShoucangjilu shoucangjilu = new TShoucangjilu();
        shoucangjilu.setUsername(this.username);
        shoucangjilu.setXwid(this.xwid);
        shoucangjilu.setZiduan(this.ziduan);
        shoucangjilu.setBiao(this.biao);
        shoucangjilu.setAddtime(this.addtime);
        this.shoucangjiluDAO.save(shoucangjilu);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "<script>javascript:alert('\u64cd\u4f5c\u6210\u529f\uff01');history.back();</script>");
        return "msg";
    }
    
    public String shoucangjiluList() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        final int hsgpagesize = 20;
        String sql = "from TShoucangjilu where 1=1 ";
        if (this.username != null) {
            sql = String.valueOf(sql) + " and username like '%" + this.username.trim() + "%'";
        }
        if (this.xwid != null) {
            sql = String.valueOf(sql) + " and xwid like '%" + this.xwid.trim() + "%'";
        }
        if (this.ziduan != null) {
            sql = String.valueOf(sql) + " and ziduan like '%" + this.ziduan.trim() + "%'";
        }
        if (this.biao != null) {
            sql = String.valueOf(sql) + " and biao like '%" + this.biao.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        final List shoucangjiluList = this.shoucangjiluDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * hsgpagesize;
        final int toIndex = Math.min(fromIndex + hsgpagesize, shoucangjiluList.size());
        final List shoucangjiluList2 = shoucangjiluList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(hsgpagesize);
        p.setTotle(shoucangjiluList.size());
        p.setData(shoucangjiluList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String shoucangjiluList2() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        String sql = "from TShoucangjilu where username='" + (String)request.getSession().getAttribute("username") + "' ";
        if (this.username != null) {
            sql = String.valueOf(sql) + " and username like '%" + this.username.trim() + "%'";
        }
        if (this.xwid != null) {
            sql = String.valueOf(sql) + " and xwid like '%" + this.xwid.trim() + "%'";
        }
        if (this.ziduan != null) {
            sql = String.valueOf(sql) + " and ziduan like '%" + this.ziduan.trim() + "%'";
        }
        if (this.biao != null) {
            sql = String.valueOf(sql) + " and biao like '%" + this.biao.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        final List shoucangjiluList = this.shoucangjiluDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * Pagesize.size;
        final int toIndex = Math.min(fromIndex + Pagesize.size, shoucangjiluList.size());
        final List shoucangjiluList2 = shoucangjiluList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(Pagesize.size);
        p.setTotle(shoucangjiluList.size());
        p.setData(shoucangjiluList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String shoucangjiluDel() {
        final String sql = "delete from TShoucangjilu where id=?";
        final Object[] o = { this.id };
        this.shoucangjiluDAO.getHibernateTemplate().bulkUpdate(sql, o);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String shoucangjiluPre() {
        final TShoucangjilu shoucangjilu = this.shoucangjiluDAO.findById(this.id);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("shoucangjilu", shoucangjilu);
        return "success";
    }
    
    public String shoucangjiluUpdt() {
        final TShoucangjilu shoucangjilu = this.shoucangjiluDAO.findById(this.id);
        shoucangjilu.setUsername(this.username);
        shoucangjilu.setXwid(this.xwid);
        shoucangjilu.setZiduan(this.ziduan);
        shoucangjilu.setBiao(this.biao);
        this.shoucangjiluDAO.attachDirty(shoucangjilu);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
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
    
    public TShoucangjiluDAO getShoucangjiluDAO() {
        return this.shoucangjiluDAO;
    }
    
    public void setShoucangjiluDAO(final TShoucangjiluDAO shoucangjiluDAO) {
        this.shoucangjiluDAO = shoucangjiluDAO;
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
