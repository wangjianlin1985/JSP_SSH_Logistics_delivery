// 
// 
// 

package com.action;

import com.util.Pagesize;
import javax.servlet.http.HttpServletRequest;
import com.util.Pagination;
import org.apache.struts2.ServletActionContext;
import java.util.Map;
import com.model.TWoyaojijian;
import com.dao.TWoyaojijianDAO;
import java.util.List;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionSupport;

public class woyaojijianAction extends ActionSupport
{
    private int id;
    private String wangdianbianhao;
    private String wupinmingcheng;
    private String wupinzhongliang;
    private String mudedi;
    private String shoujianren;
    private String shoujiandianhua;
    private String beizhu;
    private String yonghuming;
    private String xingming;
    private String dianhua;
    private String dizhi;
    private String issh;
    private String addtime;
    private String message;
    private String path;
    private ResultSet rs;
    private List list;
    private TWoyaojijianDAO woyaojijianDAO;
    
    public String woyaojijianAdd() {
        final TWoyaojijian woyaojijian = new TWoyaojijian();
        woyaojijian.setWangdianbianhao(this.wangdianbianhao);
        woyaojijian.setWupinmingcheng(this.wupinmingcheng);
        woyaojijian.setWupinzhongliang(this.wupinzhongliang);
        woyaojijian.setMudedi(this.mudedi);
        woyaojijian.setShoujianren(this.shoujianren);
        woyaojijian.setShoujiandianhua(this.shoujiandianhua);
        woyaojijian.setBeizhu(this.beizhu);
        woyaojijian.setYonghuming(this.yonghuming);
        woyaojijian.setXingming(this.xingming);
        woyaojijian.setDianhua(this.dianhua);
        woyaojijian.setDizhi(this.dizhi);
        woyaojijian.setIssh("\u5426");
        woyaojijian.setAddtime(this.addtime);
        this.woyaojijianDAO.save(woyaojijian);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "<script>javascript:alert('\u64cd\u4f5c\u6210\u529f\uff01');history.back();</script>");
        return "msg";
    }
    
    public String woyaojijianList() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        final int hsgpagesize = 20;
        String sql = "from TWoyaojijian where 1=1 ";
        if (this.wangdianbianhao != null) {
            sql = String.valueOf(sql) + " and wangdianbianhao like '%" + this.wangdianbianhao.trim() + "%'";
        }
        if (this.wupinmingcheng != null) {
            sql = String.valueOf(sql) + " and wupinmingcheng like '%" + this.wupinmingcheng.trim() + "%'";
        }
        if (this.wupinzhongliang != null) {
            sql = String.valueOf(sql) + " and wupinzhongliang like '%" + this.wupinzhongliang.trim() + "%'";
        }
        if (this.mudedi != null) {
            sql = String.valueOf(sql) + " and mudedi like '%" + this.mudedi.trim() + "%'";
        }
        if (this.shoujianren != null) {
            sql = String.valueOf(sql) + " and shoujianren like '%" + this.shoujianren.trim() + "%'";
        }
        if (this.shoujiandianhua != null) {
            sql = String.valueOf(sql) + " and shoujiandianhua like '%" + this.shoujiandianhua.trim() + "%'";
        }
        if (this.beizhu != null) {
            sql = String.valueOf(sql) + " and beizhu like '%" + this.beizhu.trim() + "%'";
        }
        if (this.yonghuming != null) {
            sql = String.valueOf(sql) + " and yonghuming like '%" + this.yonghuming.trim() + "%'";
        }
        if (this.xingming != null) {
            sql = String.valueOf(sql) + " and xingming like '%" + this.xingming.trim() + "%'";
        }
        if (this.dianhua != null) {
            sql = String.valueOf(sql) + " and dianhua like '%" + this.dianhua.trim() + "%'";
        }
        if (this.dizhi != null) {
            sql = String.valueOf(sql) + " and dizhi like '%" + this.dizhi.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        final List woyaojijianList = this.woyaojijianDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * hsgpagesize;
        final int toIndex = Math.min(fromIndex + hsgpagesize, woyaojijianList.size());
        final List woyaojijianList2 = woyaojijianList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(hsgpagesize);
        p.setTotle(woyaojijianList.size());
        p.setData(woyaojijianList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String woyaojijianList2() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        String sql = "from TWoyaojijian where yonghuming='" + (String)request.getSession().getAttribute("username") + "' ";
        if (this.wangdianbianhao != null) {
            sql = String.valueOf(sql) + " and wangdianbianhao like '%" + this.wangdianbianhao.trim() + "%'";
        }
        if (this.wupinmingcheng != null) {
            sql = String.valueOf(sql) + " and wupinmingcheng like '%" + this.wupinmingcheng.trim() + "%'";
        }
        if (this.wupinzhongliang != null) {
            sql = String.valueOf(sql) + " and wupinzhongliang like '%" + this.wupinzhongliang.trim() + "%'";
        }
        if (this.mudedi != null) {
            sql = String.valueOf(sql) + " and mudedi like '%" + this.mudedi.trim() + "%'";
        }
        if (this.shoujianren != null) {
            sql = String.valueOf(sql) + " and shoujianren like '%" + this.shoujianren.trim() + "%'";
        }
        if (this.shoujiandianhua != null) {
            sql = String.valueOf(sql) + " and shoujiandianhua like '%" + this.shoujiandianhua.trim() + "%'";
        }
        if (this.beizhu != null) {
            sql = String.valueOf(sql) + " and beizhu like '%" + this.beizhu.trim() + "%'";
        }
        if (this.yonghuming != null) {
            sql = String.valueOf(sql) + " and yonghuming like '%" + this.yonghuming.trim() + "%'";
        }
        if (this.xingming != null) {
            sql = String.valueOf(sql) + " and xingming like '%" + this.xingming.trim() + "%'";
        }
        if (this.dianhua != null) {
            sql = String.valueOf(sql) + " and dianhua like '%" + this.dianhua.trim() + "%'";
        }
        if (this.dizhi != null) {
            sql = String.valueOf(sql) + " and dizhi like '%" + this.dizhi.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        final List woyaojijianList = this.woyaojijianDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * Pagesize.size;
        final int toIndex = Math.min(fromIndex + Pagesize.size, woyaojijianList.size());
        final List woyaojijianList2 = woyaojijianList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(Pagesize.size);
        p.setTotle(woyaojijianList.size());
        p.setData(woyaojijianList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String woyaojijianDel() {
        final String sql = "delete from TWoyaojijian where id=?";
        final Object[] o = { this.id };
        this.woyaojijianDAO.getHibernateTemplate().bulkUpdate(sql, o);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String woyaojijianIssh() {
        String sql = "";
        String tt = "\u5426";
        sql = "from TWoyaojijian where id=?";
        final Object[] o = { this.id };
        final List woyaojijianList = this.woyaojijianDAO.getHibernateTemplate().find(sql, o);
        if (woyaojijianList.size() != 0) {
            final TWoyaojijian woyaojijian = (TWoyaojijian) woyaojijianList.get(0);
            if(this.woyaojijianDAO.findById(woyaojijian.getId()).getIssh().equals("\u5426")) {
                tt = "\u662f";
            }
            else {
                tt = "\u5426";
            }
            sql = "update TWoyaojijian set issh=? where id=?";
            final Object[] con = { tt, this.id };
            this.woyaojijianDAO.getHibernateTemplate().bulkUpdate(sql, con);
        }
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "<script>javascript:alert('\u64cd\u4f5c\u6210\u529f');location.href='woyaojijianList.action';</script>");
        return "msg";
    }
    
    public String woyaojijianPre() {
        final TWoyaojijian woyaojijian = this.woyaojijianDAO.findById(this.id);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("woyaojijian", woyaojijian);
        return "success";
    }
    
    public String woyaojijianDetail() {
        final TWoyaojijian woyaojijian = this.woyaojijianDAO.findById(this.id);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("woyaojijian", woyaojijian);
        return "success";
    }
    
    public String woyaojijianUpdt() {
        final TWoyaojijian woyaojijian = this.woyaojijianDAO.findById(this.id);
        woyaojijian.setWangdianbianhao(this.wangdianbianhao);
        woyaojijian.setWupinmingcheng(this.wupinmingcheng);
        woyaojijian.setWupinzhongliang(this.wupinzhongliang);
        woyaojijian.setMudedi(this.mudedi);
        woyaojijian.setShoujianren(this.shoujianren);
        woyaojijian.setShoujiandianhua(this.shoujiandianhua);
        woyaojijian.setBeizhu(this.beizhu);
        woyaojijian.setYonghuming(this.yonghuming);
        woyaojijian.setXingming(this.xingming);
        woyaojijian.setDianhua(this.dianhua);
        woyaojijian.setDizhi(this.dizhi);
        this.woyaojijianDAO.attachDirty(woyaojijian);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String getWangdianbianhao() {
        return this.wangdianbianhao;
    }
    
    public void setWangdianbianhao(final String wangdianbianhao) {
        this.wangdianbianhao = wangdianbianhao;
    }
    
    public String getWupinmingcheng() {
        return this.wupinmingcheng;
    }
    
    public void setWupinmingcheng(final String wupinmingcheng) {
        this.wupinmingcheng = wupinmingcheng;
    }
    
    public String getWupinzhongliang() {
        return this.wupinzhongliang;
    }
    
    public void setWupinzhongliang(final String wupinzhongliang) {
        this.wupinzhongliang = wupinzhongliang;
    }
    
    public String getMudedi() {
        return this.mudedi;
    }
    
    public void setMudedi(final String mudedi) {
        this.mudedi = mudedi;
    }
    
    public String getShoujianren() {
        return this.shoujianren;
    }
    
    public void setShoujianren(final String shoujianren) {
        this.shoujianren = shoujianren;
    }
    
    public String getShoujiandianhua() {
        return this.shoujiandianhua;
    }
    
    public void setShoujiandianhua(final String shoujiandianhua) {
        this.shoujiandianhua = shoujiandianhua;
    }
    
    public String getBeizhu() {
        return this.beizhu;
    }
    
    public void setBeizhu(final String beizhu) {
        this.beizhu = beizhu;
    }
    
    public String getYonghuming() {
        return this.yonghuming;
    }
    
    public void setYonghuming(final String yonghuming) {
        this.yonghuming = yonghuming;
    }
    
    public String getXingming() {
        return this.xingming;
    }
    
    public void setXingming(final String xingming) {
        this.xingming = xingming;
    }
    
    public String getDianhua() {
        return this.dianhua;
    }
    
    public void setDianhua(final String dianhua) {
        this.dianhua = dianhua;
    }
    
    public String getDizhi() {
        return this.dizhi;
    }
    
    public void setDizhi(final String dizhi) {
        this.dizhi = dizhi;
    }
    
    public String getIssh() {
        return this.issh;
    }
    
    public void setIssh(final String issh) {
        this.issh = issh;
    }
    
    public String getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(final String addtime) {
        this.addtime = addtime;
    }
    
    public TWoyaojijianDAO getWoyaojijianDAO() {
        return this.woyaojijianDAO;
    }
    
    public void setWoyaojijianDAO(final TWoyaojijianDAO woyaojijianDAO) {
        this.woyaojijianDAO = woyaojijianDAO;
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
